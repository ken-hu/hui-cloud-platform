package com.hui.cloud.uc.mapper;

import com.hui.cloud.uc.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
 * @since 2020-02-23
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("select * from t_uc_sys_permission a inner join t_uc_role_permission_rel b where a.id = b.permission_id and a.role_id= #{roleId}")
    HashSet<Permission> selectByRoleId(Long roleId);

    @Insert("insert into t_uc_sys_resource_permission_rel (permission_id,resource_id) values (#{permissionId},#{resourceId})")
    int insertResourcePermissionRel(Long permissionId, Long resourceId);
}
