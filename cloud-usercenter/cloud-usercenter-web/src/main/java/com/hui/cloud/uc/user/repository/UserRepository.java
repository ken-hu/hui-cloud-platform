package com.hui.cloud.uc.user.repository;

import com.hui.cloud.uc.user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

/**
 * <b><code>UserRepository</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/9/14 23:50.
 *
 * @author Hu-Weihui
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 通过用户名查询用户信息
     *
     * @param userName
     * @return
     */
    @Query("select u from User u where userName = ?1")
    User findByUserName(String userName);

}
