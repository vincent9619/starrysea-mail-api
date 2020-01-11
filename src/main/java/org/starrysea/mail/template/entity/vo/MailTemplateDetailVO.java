package org.starrysea.mail.template.entity.vo;

import lombok.Data;
import org.starrysea.mail.template.entity.enums.MailDeleteStatus;

import java.sql.Date;

@Data
public class MailTemplateDetailVO {
    private String name;
    private String path;
    private Integer useNum;
    //private MailDeleteStatus mailDeleteStatus;
    private String mailDeleteStatus;
    private String creator;
    private Date createTime;
}
