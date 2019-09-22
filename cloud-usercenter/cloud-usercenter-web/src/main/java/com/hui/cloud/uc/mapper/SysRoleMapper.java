package com.hui.cloud.uc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.cloud.uc.entity.SysRole;
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
 * @since 2019-09-19
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    @Select("select a.* from t_uc_sys_role a inner join t_uc_sys_user_role_rel b where a.role_id = b.role_id and b.user_id = #{userId}")
    HashSet<SysRole> selectByUserId(Long userId);

    @Select("select a.* from t_uc_sys_role a inner join t_uc_sys_role_group_rel b where a.role_id = b.role_id and b.group_id = #{group_id}")
    HashSet<SysRole> selectByGroupId(Long groupId);

    @Insert("insert into t_uc_sys_role_permission_rel (role_id,permission_id) values (#{roleId},#{permissionId})")
    int insertRolePermissionRel(Long roleId, Long permissionId);
}
