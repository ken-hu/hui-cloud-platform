package com.hui.cloud.auth.oauth.service.impl;

import com.hui.cloud.auth.oauth.model.entity.ClientDetail;
import com.hui.cloud.auth.oauth.mapper.ClientDetailMapper;
import com.hui.cloud.auth.oauth.service.ClientDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * Oauth客户端表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@Service
public class ClientDetailServiceImpl extends ServiceImpl<ClientDetailMapper, ClientDetail> implements ClientDetailService {

    private ClientDetailMapper clientDetailMapper;

    @Autowired
    public ClientDetailServiceImpl(ClientDetailMapper clientDetailMapper) {
        this.clientDetailMapper = clientDetailMapper;
    }

    @Override
    public ClientDetail get(String clientId) {
        return clientDetailMapper.selectById(clientId);
    }
}
