package com.hui.cloud.uc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.entity.SysGroup;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 组表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
public interface SysGroupService extends IService<SysGroup> {

    /**
     * 分页查询用户组
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysGroup> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询用户所属用户组
     * @param userId
     * @return
     */
    HashSet<SysGroup> listByUserId(Long userId);

}
