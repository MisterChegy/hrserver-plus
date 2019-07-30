package com.chegy.hrserverplus.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chegy.hrserverplus.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chegy.hrserverplus.entity.Nation;
import com.chegy.hrserverplus.entity.PoliticsStatus;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chegy
 * @since 2019-07-20
 */
public interface IEmpService extends IService<Employee> {

    Long getMaxWorkID();

    Page<Employee> getEmployeeByPage(Integer page, Integer size, String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope);

    Long getCountByKeywords(String keywords, Long politicId, Long nationId, Long posId, Long jobLevelId, String engageForm, Long departmentId, String beginDateScope);

    boolean deleteEmpById(String ids);
}
