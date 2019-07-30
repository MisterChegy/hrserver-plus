package com.chegy.hrserverplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chegy.hrserverplus.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chegy
 * @since 2019-07-20
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Select("SELECT workID from employee where id=(select max(id) from employee)")
    Long getMaxWorkID();

    List<Employee> getEmployeeByPage(Page page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
