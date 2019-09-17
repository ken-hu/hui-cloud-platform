package com.hui.cloud.uc.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.uc.user.mapper.UserMapper;
import com.hui.cloud.uc.user.model.entity.User;
import com.hui.cloud.uc.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getByUserName(String userName) {
        LambdaQueryWrapper<User> queryWrapper = new QueryWrapper<User>().lambda().eq(User::getUserName, userName);
        return  userMapper.selectOne(queryWrapper);
    }

    @Override
    public User getByUserId(Long userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public int deleteByUserId(Long userId) {
        return userMapper.deleteById(userId);
    }

    @Override
    public List<User> selectAllByPage(Integer pageNum, Integer pageSize) {
        Page page = new Page(pageNum, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        List users = userMapper.selectPage(page, queryWrapper).getRecords();
        return users;
    }
}
