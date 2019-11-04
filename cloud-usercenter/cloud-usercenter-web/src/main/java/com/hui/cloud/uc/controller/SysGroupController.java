package com.hui.cloud.uc.controller;


import com.hui.cloud.common.model.ResponseVO;
import com.hui.cloud.uc.dto.SysGroupDTO;
import com.hui.cloud.uc.entity.SysGroup;
import com.hui.cloud.uc.service.SysGroupService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 组表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-20
 */
@RestController
public class SysGroupController {

    private SysGroupService sysGroupService;

    @Autowired
    public SysGroupController(SysGroupService sysGroupService) {
        this.sysGroupService = sysGroupService;
    }

    /**
     * 创建OR更新用户组
     * @param sysGroupDTO
     * @return
     */
    @PostMapping(value = "/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO saveGroup(@RequestBody SysGroupDTO sysGroupDTO) {
        SysGroup sysGroup = new SysGroup();
        BeanUtils.copyProperties(sysGroupDTO, sysGroup);
        sysGroupService.saveOrUpdate(sysGroup);
        return ResponseVO.ok();
    }

}

