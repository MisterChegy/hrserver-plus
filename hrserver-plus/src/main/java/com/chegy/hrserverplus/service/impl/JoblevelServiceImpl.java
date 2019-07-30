package com.chegy.hrserverplus.service.impl;

import com.chegy.hrserverplus.entity.Joblevel;
import com.chegy.hrserverplus.mapper.JoblevelMapper;
import com.chegy.hrserverplus.service.IJoblevelService;
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
public class JoblevelServiceImpl extends ServiceImpl<JoblevelMapper, Joblevel> implements IJoblevelService {

    @Autowired
    JoblevelMapper joblevelMapper;

    @Override
    public List<Joblevel> getAllJobLevels() {
        return joblevelMapper.getAllJobLevels();
    }
}
