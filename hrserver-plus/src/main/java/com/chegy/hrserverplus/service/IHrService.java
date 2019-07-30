package com.chegy.hrserverplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chegy.hrserverplus.entity.Hr;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chegy
 * @since 2019-07-18
 */
public interface IHrService extends IService<Hr> {

    Hr getHrById(Long hrId);

    int updateHrRoles(Long hrId, Long[] rids);
}
