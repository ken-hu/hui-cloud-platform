package com.hui.cloud.uc.user.service.impl;

import com.hui.cloud.uc.user.model.entity.Resource;
import com.hui.cloud.uc.user.mapper.ResourceMapper;
import com.hui.cloud.uc.user.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源表 服务实现类
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-18
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

    @Override
    public int deleteById(String resourceId) {
        return 0;
    }

    @Override
    public Resource addResource(Resource resource) {
        return null;
    }

    @Override
    public int updateResource(Resource resource) {
        return 0;
    }
}
