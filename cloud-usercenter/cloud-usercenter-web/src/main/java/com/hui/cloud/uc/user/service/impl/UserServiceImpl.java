package com.hui.cloud.uc.user.service.impl;

import com.hui.cloud.uc.user.model.entity.User;
import com.hui.cloud.uc.user.repository.UserRepository;
import com.hui.cloud.uc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <b><code>UserServiceImpl</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 0:25.
 *
 * @author Hu-Weihui
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User get(Long userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }

    @Override
    public User getByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        return user;
    }

    @Override
    public Page<User> listByPage(Integer pageNum, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC,"createdTime");
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize,sort);
        Page<User> users = userRepository.findAll(pageRequest);
        return users;
    }
}
