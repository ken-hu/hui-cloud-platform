package com.hui.cloud.uc.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.user.model.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 通过用户名获取用户信息
     * @param userName
     * @return
     */
    SysUser getUserByName(String userName);

    /**
     * 分页查询用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<SysUser> listByPage(Integer pageNum, Integer pageSize);
}
