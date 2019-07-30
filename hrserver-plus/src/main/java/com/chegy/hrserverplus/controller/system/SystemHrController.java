package com.chegy.hrserverplus.controller.system;

import com.chegy.hrserverplus.common.RespBean;
import com.chegy.hrserverplus.entity.Hr;
import com.chegy.hrserverplus.service.IHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sang on 2018/1/2.
 */
@RestController
@RequestMapping("/system/hr")
@CrossOrigin(origins = {"*"},allowCredentials = "true")
public class SystemHrController {
    @Autowired
    IHrService hrService;

    @Cacheable(value = "testCache")
    @GetMapping("/id/{hrId}")
    public Hr getHrById(@PathVariable Long hrId) {
        return hrService.getHrById(hrId);
    }

    @RequestMapping(value = "/{hrId}", method = RequestMethod.DELETE)
    public RespBean deleteHr(@PathVariable Long hrId) {
        if (hrService.removeById(hrId) == true) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public RespBean updateHr(Hr hr) {
        if (hrService.updateById(hr) == true) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @RequestMapping(value = "/roles", method = RequestMethod.PUT)
    public RespBean updateHrRoles(Long hrId, Long[] rids) {
        if (hrService.updateHrRoles(hrId, rids) == rids.length) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
//
//    @RequestMapping("/{keywords}")
//    public List<Hr> getHrsByKeywords(@PathVariable(required = false) String keywords) {
//        List<Hr> hrs = hrService.getHrsByKeywords(keywords);
//        return hrs;
//    }
//
//
//    @RequestMapping(value = "/hr/reg", method = RequestMethod.POST)
//    public RespBean hrReg(String username, String password) {
//        int i = hrService.hrReg(username, password);
//        if (i == 1) {
//            return RespBean.ok("注册成功!");
//        } else if (i == -1) {
//            return RespBean.error("用户名重复，注册失败!");
//        }
//        return RespBean.error("注册失败!");
//    }

}
