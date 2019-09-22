package com.hui.cloud.uc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.cloud.uc.user.model.entity.SysPermission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@Repository
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    @Select("select * from t_uc_sys_permission a inner join t_uc_user_permission_rel b where a.id = b.permission_id and a.user_id= #{userId}")
    HashSet<SysPermission> selectByUserId(Long userId);

    @Select("select * from t_uc_sys_permission a inner join t_uc_role_permission_rel b where a.id = b.permission_id and a.role_id= #{roleId}")
    HashSet<SysPermission> selectByRoleId(Long roleId);

    @Insert("insert into t_uc_sys_resource_permission_rel (permission_id,resource_id) values (#{permissionId},#{resourceId})")
    int insertResourcePermissionRel(Long permissionId, Long resourceId);
}
