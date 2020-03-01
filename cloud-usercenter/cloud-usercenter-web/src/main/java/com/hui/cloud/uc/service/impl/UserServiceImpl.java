package com.hui.cloud.uc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hui.cloud.uc.entity.User;
import com.hui.cloud.uc.mapper.UserMapper;
import com.hui.cloud.uc.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    /**
     * 通过用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public User getUserByName(String userName) {
        LambdaQueryWrapper<User> queryWrapper =
                Wrappers.<User>lambdaQuery().eq(User::getUserName, userName);
        return userMapper.selectOne(queryWrapper);
    }

    /**
     * 分页查询用户
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<User> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        Page<User> page = new Page<>(pageNum, pageSize);
        List<User> sysUsers = userMapper.selectPage(page, queryWrapper).getRecords();
        return sysUsers;
    }

    /**
     * 用户绑定角色
     *
     * @param roleIds
     * @param userId
     */
    @Override
    public void bindRoles(List<Long> roleIds, Long userId) {
        roleIds.forEach(x -> userMapper.insertUserRoleRel(userId, x));
    }

    /**
     * 用户绑定组
     *
     * @param groupIds
     * @param userId
     */
    @Override
    public void bindGroups(List<Long> groupIds, Long userId) {
        groupIds.forEach(x -> userMapper.insertUserGroupRel(userId, x));
    }

}
