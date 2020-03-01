package com.hui.cloud.uc.service;

import com.hui.cloud.uc.entity.Group;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashSet;
import java.util.List;

/**
 * <p>
 * 组表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2020-02-23
 */
public interface GroupService extends IService<Group> {

    /**
     * 分页查询用户组
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Group> listByPage(Integer pageNum, Integer pageSize);

    /**
     * 查询用户所属用户组
     * @param userId
     * @return
     */
    HashSet<Group> listByUserId(Long userId);
}
