package com.chegy.hrserverplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chegy.hrserverplus.entity.Employee;
import com.chegy.hrserverplus.mapper.EmployeeMapper;
import com.chegy.hrserverplus.mapper.EmpsalaryMapper;
import com.chegy.hrserverplus.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chegy
 * @since 2019-07-20
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmpService {

    @Autowired
    EmployeeMapper empMapper;

    @Autowired
    EmpsalaryMapper empsalaryMapper;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    SimpleDateFormat birthdayFormat = new SimpleDateFormat("yyyy-MM-dd");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public Long getMaxWorkID() {
        Long maxWorkID = empMapper.getMaxWorkID();
        return maxWorkID == null ? 0 : maxWorkID;
    }

    @Override
    public Page<Employee> getEmployeeByPage(Integer page, Integer size, String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope) {
//        int start = (page - 1) * size;
        Date startBeginDate = null;
        Date endBeginDate = null;
        if (beginDateScope != null && beginDateScope.contains(",")) {
            try {
                String[] split = beginDateScope.split(",");
                startBeginDate = birthdayFormat.parse(split[0]);
                endBeginDate = birthdayFormat.parse(split[1]);
            } catch (ParseException e) {
            }
        }
        Page<Employee> page1 = new Page<>(page,size);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
//        if(StringUtils.isNotBlank(keywords))
        wrapper.like(StringUtils.isNotBlank(keywords),"e.name",keywords);
        wrapper.eq(StringUtils.isNotBlank(engageForm),"e.engageForm",engageForm);
        wrapper.eq(politicId!=null,"e.politicId",politicId);
        wrapper.eq(nationId!=null,"e.nationId",nationId);
        wrapper.eq(posId!=null,"e.posId",posId);
        wrapper.eq(jobLevelId!=null,"e.jobLevelId",jobLevelId);
        wrapper.between((startBeginDate!=null && endBeginDate!=null),"e.beginDate",startBeginDate,endBeginDate);

        return page1.setRecords(empMapper.getEmployeeByPage(page1,wrapper));
    }

    @Override
    public Long getCountByKeywords(String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope) {
        return null;
    }

    ////要删除的外键置为空，然后删除
    @Override
    public boolean deleteEmpById(String ids) {
        if(StringUtils.isEmpty(ids)){
            return false;
        }
        //ids-->3,4,5,
        //分割字符串
        String[] sid = ids.split(",");
        List<Integer> list = new ArrayList<>();
        for(String s : sid){
            list.add(Integer.valueOf(s));
        }
        //更新外键置空，可以逐次手动批量更新
//        List<Employee> employees = new ArrayList<>();
//        if(list.size()>1){
//            employees = empMapper.selectBatchIds(list);
//
//        }else{
//            Employee employee = empMapper.selectById(list.get(0));
//            employees.add(employee);
//        }
//        for(Employee e : employees){
//            e.setDepartmentId(null);
//            e.setNationId(null);
//            e.setPosId(null);
//            e.setPoliticId(null);
//            e.setJobLevelId(null);
//            empMapper.updateById(e);
//        }
//        //empsalary
//        QueryWrapper<Empsalary> queryWrapper = new QueryWrapper<>();
////        Map<String,Integer> map = new HashMap<>();
////        queryWrapper.allEq(map);
//        queryWrapper.eq("eid",);
//        empsalaryMapper.updateById();

        //批量删除
        empMapper.deleteBatchIds(list);

        return true;
    }

    public static void main(String[] args) {
        String[] sid = "3,4,5,".split(",");
        for(String s : sid){
            System.out.println(s);
        }
        System.out.println(sid.length);
    }
}
