package org.starrysea.mail.common.entity.vo;

import lombok.Data;

@Data
public class MailAuthorizeDetailVO {
    private Integer mailAuthorizeId;
    private String clientId;
    private String clientSecret;
}
