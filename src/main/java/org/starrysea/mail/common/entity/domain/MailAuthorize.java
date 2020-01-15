package org.starrysea.mail.common.entity.domain;

import lombok.Data;

@Data
public class MailAuthorize {
    private Integer mailAuthorizeId;
    private String clientId;
    private String clientSecret;
}
