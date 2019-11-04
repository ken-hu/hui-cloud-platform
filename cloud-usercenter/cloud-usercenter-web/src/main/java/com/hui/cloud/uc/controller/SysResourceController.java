package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysResourceDTO;
import com.hui.cloud.uc.entity.SysResource;
import com.hui.cloud.uc.service.SysResourceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 资源表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@RestController
public class SysResourceController {

    private SysResourceService sysResourceService;

    @Autowired
    public SysResourceController(SysResourceService sysResourceService) {
        this.sysResourceService = sysResourceService;
    }


    /**
     * 创建OR更新Resource
     * @param sysResourceDTO
     * @return
     */
    @PostMapping(value = "/resource",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO saveResource(@RequestBody SysResourceDTO sysResourceDTO){
        SysResource sysResource = new SysResource();
        BeanUtils.copyProperties(sysResourceDTO, sysResource);
        sysResourceService.saveOrUpdate(sysResource);
        return ResponseVO.ok();
    }
}

