package com.chegy.hrserverplus.service.impl;

import com.chegy.hrserverplus.entity.Department;
import com.chegy.hrserverplus.mapper.DepartmentMapper;
import com.chegy.hrserverplus.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chegy
 * @since 2019-07-20
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> getDepByPid(long l) {
        return departmentMapper.getDepByPid(l);
    }

    @Override
    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }
}
