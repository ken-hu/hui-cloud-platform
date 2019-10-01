package com.hui.cloud.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hui.cloud.auth.entity.ClientDetail;

import java.util.List;

/**
 * <p>
 * Oauth客户端表 服务类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
public interface ClientDetailService extends IService<ClientDetail> {

    /**
     * 获取ClientDetail
     * @param clientId
     * @return
     */
    ClientDetail get(String clientId);

    /**
     * 分页查询客户端
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<ClientDetail> listByPage(Integer pageNum, Integer pageSize);
}
