package com.chegy.hrserverplus.mapper;

import com.chegy.hrserverplus.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
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
public interface DepartmentMapper extends BaseMapper<Department> {

    @Select("select d1.* from department d1 where d1.`parentId`=#{pid} AND d1.enabled=true")
    @ResultMap("BaseResultMap")
    List<Department> getDepByPid(@Param("pid") long l);

    @Select("select * from department WHERE enabled=true")
    List<Department> getAllDeps();
}
