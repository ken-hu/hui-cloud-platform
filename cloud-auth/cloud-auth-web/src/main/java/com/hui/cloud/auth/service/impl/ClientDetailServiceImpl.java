package com.hui.cloud.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hui.cloud.auth.entity.ClientDetail;
import com.hui.cloud.auth.mapper.ClientDetailMapper;
import com.hui.cloud.auth.service.ClientDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 分页查询客户端
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List<ClientDetail> listByPage(Integer pageNum, Integer pageSize) {
        QueryWrapper<ClientDetail> query = new QueryWrapper<ClientDetail>();
        Page<ClientDetail> page = new Page<>(pageNum, pageSize);
        List<ClientDetail> clientDetails = clientDetailMapper.selectPage(page, query).getRecords();
        return clientDetails;
    }
}
