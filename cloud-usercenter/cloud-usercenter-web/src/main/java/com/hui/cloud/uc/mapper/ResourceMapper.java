package com.hui.cloud.uc.mapper;

import com.hui.cloud.uc.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
@Repository
public interface ResourceMapper extends BaseMapper<Resource> {
    @Select("select * from t_uc_sys_resource a inner join t_uc_sys_resource_permission_rel b where a.resource_id = b.permission_id and a.permission_id = #{permissionId}")
    HashSet<Resource> listByPermissionId(Long permissionId);
}
