package com.hui.cloud.uc.mapper;

import com.hui.cloud.uc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Insert("INSERT INTO t_uc_sys_user_group_rel(user_id, group_id) VALUES (#{userId},#{groupId})")
    int insertUserGroupRel(Long userId, Long groupId);

    @Insert("INSERT INTO t_uc_sys_user_role_rel(user_id, role_id) VALUES (#{userId},#{roleId})")
    int insertUserRoleRel(Long userId, Long roleId);
}
