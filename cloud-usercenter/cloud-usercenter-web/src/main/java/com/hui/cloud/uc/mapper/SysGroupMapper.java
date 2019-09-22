package com.hui.cloud.uc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hui.cloud.uc.entity.SysGroup;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashSet;

/**
 * <p>
 * 组表 Mapper 接口
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@Repository
public interface SysGroupMapper extends BaseMapper<SysGroup> {
    @Select("select * from t_uc_sys_group a inner join t_uc_sys_user_group_rel b where a.group_id = b.group_id and b.user_id = #{userId} ")
    HashSet<SysGroup> listByUserId(Long userId);
}
