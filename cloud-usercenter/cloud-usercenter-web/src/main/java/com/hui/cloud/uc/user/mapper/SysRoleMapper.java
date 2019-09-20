package com.hui.cloud.uc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.cloud.uc.user.model.entity.SysRole;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Select("select a.* from t_uc_sys_role a inner join t_uc_sys_user_role_ref b where a.id = b.role_id and a.userId = #{userId}")
    List<SysRole> selectByUserId(Long userId);
}
