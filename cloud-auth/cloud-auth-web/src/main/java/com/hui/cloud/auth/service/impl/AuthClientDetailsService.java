package com.hui.cloud.auth.service.impl;

import com.google.common.collect.Sets;
import com.hui.cloud.auth.entity.ClientDetail;
import com.hui.cloud.auth.service.ClientDetailService;
import com.hui.cloud.auth.service.bo.AuthClientDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * <b><code>AuthClientDetailsService</code></b>
 * <p/>
 * <p>
 * <p/>
 * <b>Creation Time:</b> 2019/9/19 18:02.
 *
 * @author Gary.Hu
 */
@Component
@Slf4j
public class AuthClientDetailsService implements ClientDetailsService {

    private ClientDetailService clientDetailService;


    @Autowired
    public AuthClientDetailsService(ClientDetailService clientDetailService) {
        this.clientDetailService = clientDetailService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetail clientDetail = clientDetailService.get(clientId);

        log.info(clientDetail.toString());

        if (null == clientDetail) {
            throw new ClientRegistrationException(clientId + "客户端不存在");
        }
        AuthClientDetail authClientDetail = new AuthClientDetail();
        BeanUtils.copyProperties(clientDetail, authClientDetail);

        log.info(authClientDetail.toString());

        Set resourceIds = filedToSet(clientDetail.getResourceIds());

        Set scope = filedToSet(clientDetail.getScope());
        Set authorizedGrantTypes = filedToSet(clientDetail.getAuthorizedGrantTypes());
        Set registeredRedirectUri = filedToSet(clientDetail.getWebServerRedirectUri());
        Set authorities = filedToSetA(clientDetail.getAuthorities());
        Set autoApprovedScopes = filedToSet(clientDetail.getAutoapprove());

        authClientDetail.setResourceIds(resourceIds);
        authClientDetail.setScope(scope);
        authClientDetail.setAuthorizedGrantTypes(authorizedGrantTypes);
        authClientDetail.setRegisteredRedirectUri(registeredRedirectUri);
        authClientDetail.setAuthorities(authorities);
        authClientDetail.setAutoApprovedScopes(autoApprovedScopes);
        //TODO 还没写additionalInformation
        log.info(authClientDetail.toString());
        return authClientDetail;
    }

    private Set filedToSet(String field) {
        if (!StringUtils.isEmpty(field) && field.contains(",")) {
            HashSet<String> filedSet = Sets.newHashSet(StringUtils.split(field, ","));
            return filedSet;
        }
        return Sets.newHashSet(field);
    }

    private Set filedToSetA(String field) {
        if (!StringUtils.isEmpty(field) && field.contains(",")) {
            HashSet<String> filedSet = Sets.newHashSet(StringUtils.split(field, ","));
            return filedSet;
        }
        return Sets.newHashSet(new SimpleGrantedAuthority(field));
    }
}
