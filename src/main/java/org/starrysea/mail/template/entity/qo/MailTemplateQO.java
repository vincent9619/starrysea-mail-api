package org.starrysea.mail.template.entity.qo;


import lombok.Data;
import org.starrysea.mail.template.entity.enums.MailDeleteStatus;

import java.sql.Date;

@Data
public class MailTemplateQO {

    private String name;
    private Integer useNum;
    private MailDeleteStatus mailDeleteStatus;
    private String creator;
    private Date createTime;
}
