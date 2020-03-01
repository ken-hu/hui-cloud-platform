package com.hui.cloud.uc.service;

import com.hui.cloud.uc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
public interface UserService extends IService<User> {

    /**
     * 通过用户名获取用户信息
     *
     * @param userName
     * @return
     */
    User getUserByName(String userName);

    /**
     * 分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 用户绑定角色
     *
     * @param roleIds
     * @param userId
     */
    void bindRoles(List<Long> roleIds, Long userId);

    /**
     * 用户绑定组
     *
     * @param groupIds
     * @param userId
     */
    void bindGroups(List<Long> groupIds, Long userId);
}
