package com.chegy.hrserverplus.service.impl;

import com.chegy.hrserverplus.entity.Position;
import com.chegy.hrserverplus.mapper.PositionMapper;
import com.chegy.hrserverplus.service.IPositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements IPositionService {

    @Autowired
    PositionMapper positionMapper;

    @Override
    public List<Position> getAllPos() {
        return positionMapper.getAllPos();
    }
}
