package org.starrysea.mail.template.entity.domain;

import lombok.Data;
import org.starrysea.mail.template.entity.enums.MailDeleteStatus;

import java.util.Date;
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
