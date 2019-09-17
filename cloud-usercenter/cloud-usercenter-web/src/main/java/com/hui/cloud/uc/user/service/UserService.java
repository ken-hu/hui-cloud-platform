package com.hui.cloud.uc.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.uc.user.model.entity.User;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-18
 */
public interface UserService extends IService<User> {
    /**
     * 通过用户名查询
     * @param userName
     * @return
     */
    User getByUserName(String userName);

    /**
     * 通过用户ID查询
     * @param userId
     * @return
     */
    User getByUserId(Long userId);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    int deleteByUserId(Long userId);

    /**
     * 分页查询用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<User> selectAllByPage(Integer pageNum, Integer pageSize);
}
