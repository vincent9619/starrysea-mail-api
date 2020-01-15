package org.starrysea.mail.common.entity.bo;

import org.springframework.security.core.GrantedAuthority;

public class SysGrantedAuthority implements GrantedAuthority {

    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }
}
