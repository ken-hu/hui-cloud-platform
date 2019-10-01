package com.hui.cloud.auth.controller;


import com.hui.cloud.auth.entity.ClientDetail;
import com.hui.cloud.auth.service.ClientDetailService;
import com.hui.cloud.common.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * Oauth客户端表 前端控制器
 * </p>
 *
 * @author Gary.hu
 * @since 2019-09-19
 */
@RestController
@RequestMapping("/oauth/client-detail")
public class ClientDetailController {

    private ClientDetailService clientDetailService;

    @Autowired
    public ClientDetailController(ClientDetailService clientDetailService) {
        this.clientDetailService = clientDetailService;
    }

    /**
     * 客户端列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping(value = "/clients",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO listClients(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        List<ClientDetail> clientDetails = clientDetailService.listByPage(pageNum, pageSize);
        return ResponseVO.ok(clientDetails);
    }


    /**
     * 新增客户端
     * @return
     */
    @PutMapping(value = "/client",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO addClient(){
        return ResponseVO.ok();
    }


    /**
     * 更新客户端
     * @return
     */
    @PostMapping(value = "/client",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseVO updateClient(){
        return ResponseVO.ok();
    }

}

