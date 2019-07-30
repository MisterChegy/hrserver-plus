package com.chegy.hrserverplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chegy.hrserverplus.common.HrUtils;
import com.chegy.hrserverplus.entity.Hr;
import com.chegy.hrserverplus.mapper.HrMapper;
import com.chegy.hrserverplus.service.IHrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chegy
 * @since 2019-07-18
 */
@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, Hr> implements UserDetailsService, IHrService {

    @Autowired
    HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Hr hr = hrMapper.loadUserByUsername(s);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return hr;
    }

    public int hrReg(String username, String password) {
        //如果用户名存在，返回错误
        if (hrMapper.loadUserByUsername(username) != null) {
            return -1;
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(password);
        return hrMapper.hrReg(username, encode);
    }

    public List<Hr> getHrsByKeywords(String keywords) {
        return hrMapper.getHrsByKeywords(keywords);
    }

    public int updateHr(Hr hr) {
        return hrMapper.updateHr(hr);
    }

    public int updateHrRoles(Long hrId, Long[] rids) {
        int i = hrMapper.deleteRoleByHrId(hrId);
        return hrMapper.addRolesForHr(hrId, rids);
    }

    public Hr getHrById(Long hrId) {
        return hrMapper.getHrById(hrId);
    }

    public int deleteHr(Long hrId) {
        return hrMapper.deleteHr(hrId);
    }

    public List<Hr> getAllHrExceptAdmin() {
        return hrMapper.getAllHr(HrUtils.getCurrentHr().getId());
    }
    public List<Hr> getAllHr() {
        return hrMapper.getAllHr(null);
    }
}
