package com.chegy.hrserverplus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chegy.hrserverplus.common.RespBean;
import com.chegy.hrserverplus.entity.Employee;
import com.chegy.hrserverplus.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * Created by sang on 2018/1/12.
 */
@RestController
@RequestMapping("/employee/basic")
@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class EmpBasicController {
    @Autowired
    IEmpService empService;
    @Autowired
    IDepartmentService departmentService;
    @Autowired
    IPositionService positionService;
    @Autowired
    IJoblevelService jobLevelService;
    @Autowired
    ExecutorService executorService;
    @Autowired
    TemplateEngine templateEngine;
    @Autowired
    INationService iNationService;
    @Autowired
    IPoliticsService iPoliticsService;

    @RequestMapping(value = "/basicdata", method = RequestMethod.GET)
    public Map<String, Object> getAllNations() {
        Map<String, Object> map = new HashMap<>();
        map.put("nations", iNationService.list());
        map.put("politics",iPoliticsService.list());
        map.put("deps", departmentService.getDepByPid(-1L));
        map.put("positions", positionService.getAllPos());
        map.put("joblevels", jobLevelService.getAllJobLevels());
        map.put("workID", String.format("%08d", empService.getMaxWorkID() + 1));
        return map;
    }

    @RequestMapping("/maxWorkID")
    public String maxWorkID() {
        return String.format("%08d", empService.getMaxWorkID() + 1);
    }

    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public RespBean addEmp(Employee employee) {
        if (empService.save(employee)) {
//            List<Position> allPos = positionService.getAllPos();
//            for (Position allPo : allPos) {
//                if (allPo.getId() == employee.getPosId()) {
//                    employee.setPosName(allPo.getName());
//                }
//            }
//            executorService.execute(new EmailRunnable(employee,
//                    javaMailSender, templateEngine));
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public RespBean updateEmp(Employee employee) {
        if (empService.updateById(employee)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    public RespBean deleteEmpById(@PathVariable String ids) {
        //要删除的外键置为空，然后删除

        if (empService.deleteEmpById(ids)) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/emp", method = RequestMethod.GET)
    public Map<String, Object> getEmployeeByPage(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "") String keywords,
            Long politicId, Long nationId, Long posId,
            Long jobLevelId, String engageForm,
            Long departmentId, String beginDateScope) {
        Map<String, Object> map = new HashMap<>();
        Page<Employee> employeeByPage = empService.getEmployeeByPage(page, size,
                keywords,politicId, nationId, posId, jobLevelId, engageForm,
                departmentId, beginDateScope);
//        Long count = empService.getCountByKeywords(keywords, politicId, nationId,
//                posId,jobLevelId, engageForm, departmentId, beginDateScope);
        map.put("emps", employeeByPage.getRecords());
        map.put("count", employeeByPage.getTotal());
        return map;
    }

//    @RequestMapping(value = "/exportEmp", method = RequestMethod.GET)
//    public ResponseEntity<byte[]> exportEmp() {
//        return PoiUtils.exportEmp2Excel(empService.getAllEmployees());
//    }

//    @RequestMapping(value = "/importEmp", method = RequestMethod.POST)
//    public RespBean importEmp(MultipartFile file) {
//        List<Employee> emps = PoiUtils.importEmp2List(file,
//                iNationService.list(), iPoliticsService.list(),
//                departmentService.getAllDeps(), positionService.getAllPos(),
//                jobLevelService.getAllJobLevels());
//        //批量添加
//        if (empService.saveBatch(emps)) {
//            return RespBean.ok("导入成功!");
//        }
//        return RespBean.error("导入失败!");
//    }
}
