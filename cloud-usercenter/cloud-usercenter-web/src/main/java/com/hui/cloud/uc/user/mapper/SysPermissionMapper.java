package com.hui.cloud.uc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.cloud.uc.user.model.entity.SysPermission;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 查询用户权限
     * @param userId
     * @return
     */
    @Select("select * from t_uc_sys_permission a inner join " +
            "t_uc_user_permission_ref b where a.id = b.permission_id and a.id= #{userId}")
    List<SysPermission> selectByUserId(Long userId);
}
