package com.hui.cloud.uc.mapper;

import com.hui.cloud.uc.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {

    @Select("select a.* from t_uc_sys_role a inner join t_uc_sys_user_role_rel b where a.role_id = b.role_id and b.user_id = #{userId}")
    HashSet<Role> selectByUserId(Long userId);

    @Select("select a.* from t_uc_sys_role a inner join t_uc_sys_role_group_rel b where a.role_id = b.role_id and b.group_id = #{group_id}")
    HashSet<Role> selectByGroupId(Long groupId);

    @Insert("insert into t_uc_sys_role_permission_rel (role_id,permission_id) values (#{roleId},#{permissionId})")
    int insertRolePermissionRel(Long roleId, Long permissionId);
}
