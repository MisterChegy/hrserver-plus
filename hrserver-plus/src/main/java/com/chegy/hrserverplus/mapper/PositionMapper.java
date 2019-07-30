package com.chegy.hrserverplus.mapper;

import com.chegy.hrserverplus.entity.Position;
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
public interface PositionMapper extends BaseMapper<Position> {

    @Select("SELECT * FROM position WHERE enabled=true ORDER BY id")
    List<Position> getAllPos();
}
