package com.chegy.hrserverplus.mapper;

import com.chegy.hrserverplus.entity.Joblevel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface JoblevelMapper extends BaseMapper<Joblevel> {

    @Select("select * from joblevel WHERE enabled=true")
    @ResultMap("BaseResultMap")
    List<Joblevel> getAllJobLevels();
}
