package com.chegy.hrserverplus.service;

import com.chegy.hrserverplus.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chegy
 * @since 2019-07-20
 */
public interface IDepartmentService extends IService<Department> {

    List<Department> getDepByPid(long l);

    List<Department> getAllDeps();
}
