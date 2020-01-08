package org.starrysea.mail.mailTemplate.entity.domain;

import lombok.Data;
import org.starrysea.mail.mailTemplate.entity.enums.MailDeleteStatus;

import java.sql.Date;
@Data
public class MailTemplate {
    private Integer mailTemplateId;
    private String name;
    private String path;
    private Integer useNum;
    private MailDeleteStatus mailDeleteStatus;
    private String creator;
    private Date createTime;
}
