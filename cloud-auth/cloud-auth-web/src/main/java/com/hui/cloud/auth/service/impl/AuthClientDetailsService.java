package com.hui.cloud.auth.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Sets;
import com.hui.cloud.auth.service.bo.AuthClientDetail;
import com.hui.cloud.auth.entity.ClientDetail;
import com.hui.cloud.auth.service.ClientDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AuthClientDetailsService implements ClientDetailsService {

    private ClientDetailService clientDetailService;

    private ObjectMapper objectMapper;

    @Autowired
    public AuthClientDetailsService(ClientDetailService clientDetailService, ObjectMapper objectMapper) {
        this.clientDetailService = clientDetailService;
        this.objectMapper = objectMapper;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        ClientDetail clientDetail = clientDetailService.get(clientId);

        AuthClientDetail authClientDetail = new AuthClientDetail();
        BeanUtils.copyProperties(clientDetail,authClientDetail);

        Set resourceIds = filedToSet(clientDetail.getResourceIds());
        Set scope = filedToSet(clientDetail.getScope());
        Set authorizedGrantTypes = filedToSet(clientDetail.getAuthorizedGrantTypes());
        Set registeredRedirectUri = filedToSet(clientDetail.getWebServerRedirectUri());
        Set authorities = filedToSet(clientDetail.getAuthorities());
        Set autoApprovedScopes = filedToSet(clientDetail.getAutoapprove());

        authClientDetail.setResourceIds(resourceIds);
        authClientDetail.setScope(scope);
        authClientDetail.setAuthorizedGrantTypes(authorizedGrantTypes);
        authClientDetail.setRegisteredRedirectUri(registeredRedirectUri);
        authClientDetail.setAuthorities(authorities);
        authClientDetail.setAutoApprovedScopes(autoApprovedScopes);
        //TODO 还没写additionalInformation
        return authClientDetail;
    }

    private Set filedToSet(String field) {
        HashSet<String> filedSet = Sets.newHashSet(StringUtils.split(field, ","));
        return filedSet;
    }
}
