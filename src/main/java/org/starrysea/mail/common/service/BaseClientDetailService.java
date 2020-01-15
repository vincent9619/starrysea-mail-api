package org.starrysea.mail.common.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.starrysea.mail.common.config.AuthorizationServerConfiguration;
import org.starrysea.mail.common.dao.MailAuthorizeMapper;
import org.starrysea.mail.common.entity.vo.MailAuthorizeDetailVO;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BaseClientDetailService implements ClientDetailsService {
   private AuthorizationServerConfiguration authorizationServerConfiguration = new AuthorizationServerConfiguration();

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        BaseClientDetails client = null;
        //这里可以改为查询数据库
        if ("client".equals(clientId)) {
            client = new BaseClientDetails();
            client.setClientId(clientId);
            //client.setClientSecret("{noop}123456");
            client.setClientSecret("{noop}"+authorizationServerConfiguration.getMailAuthorizeSecret(clientId));
            //client.setResourceIds(Arrays.asList("order"));
            client.setAuthorizedGrantTypes(Arrays.asList("authorization_code", "client_credentials", "refresh_token", "password", "implicit"));
            //不同的client可以通过 一个scope 对应 权限集
            client.setScope(Arrays.asList("all", "select"));
            client.setAuthorities(AuthorityUtils.createAuthorityList("admin_role"));
            client.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); //1天
            client.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(1)); //1天
            Set<String> uris = new HashSet<>();
            uris.add("http://localhost:10010");
            client.setRegisteredRedirectUri(uris);
        }
        if (client == null) {
            throw new NoSuchClientException("No client width requested id: " + clientId);
        }
        return client;
    }
}
