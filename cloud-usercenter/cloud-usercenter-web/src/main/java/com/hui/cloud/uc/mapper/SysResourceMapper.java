package com.hui.cloud.uc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.cloud.uc.entity.SysResource;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@Repository
public interface SysResourceMapper extends BaseMapper<SysResource> {

    @Select("select * from t_uc_sys_resource a inner join t_uc_sys_resource_permission_rel b where a.resource_id = b.permission_id and a.permission_id = #{permissionId}")
    HashSet<SysResource> listByPermissionId(Long permissionId);
}
