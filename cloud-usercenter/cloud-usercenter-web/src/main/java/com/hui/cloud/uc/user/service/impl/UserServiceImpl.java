package com.hui.cloud.uc.user.service.impl;

import com.hui.cloud.uc.user.model.entity.User;
import com.hui.cloud.uc.user.mapper.UserMapper;
import com.hui.cloud.uc.user.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
