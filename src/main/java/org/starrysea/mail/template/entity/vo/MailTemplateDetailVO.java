package org.starrysea.mail.template.entity.vo;

import lombok.Data;


import java.sql.Date;

@Data
public class MailTemplateDetailVO {
    private String name;
    private String path;
    private Integer useNum;
    private String mailDeleteStatus;
    private String creator;
    private Date createTime;
}
