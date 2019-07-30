package com.chegy.hrserverplus.service;

import com.chegy.hrserverplus.entity.Position;
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
public interface IPositionService extends IService<Position> {

    List<Position> getAllPos();
}
