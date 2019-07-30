package com.chegy.hrserverplus.service;

import com.chegy.hrserverplus.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chegy
 * @since 2019-07-18
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getAllMenu();

    List<Menu> getMenusByHrId();

    List<Menu> menuTree();

    List<Long> getMenusByRid(Long rid);
}
