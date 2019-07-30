package com.chegy.hrserverplus.common;

import com.chegy.hrserverplus.entity.Hr;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang on 2017/12/30.
 */
public class HrUtils {
    public static Hr getCurrentHr() {
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
