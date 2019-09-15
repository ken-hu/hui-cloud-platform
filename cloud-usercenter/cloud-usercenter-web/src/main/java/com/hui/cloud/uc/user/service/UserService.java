package com.hui.cloud.uc.user.service;

import com.hui.cloud.uc.user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b><code>UserService</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/15 0:25.
 *
 * @author Hu-Weihui
 */
@Repository
public interface UserService {
    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    User get(Long userId);

    /**
     * 获通过用户名查询用户信息
     * @param userName
     * @return
     */
    User getByUserName(String userName);

    /**
     * 分页查询用户信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<User> listByPage(Integer pageNum, Integer pageSize);
}
