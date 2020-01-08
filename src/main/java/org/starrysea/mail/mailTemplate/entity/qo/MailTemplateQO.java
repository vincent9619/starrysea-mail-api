package org.starrysea.mail.mailTemplate.entity.qo;


import lombok.Data;
import org.starrysea.mail.mailTemplate.entity.enums.MailDeleteStatus;

import java.sql.Date;

@Data
public class MailTemplateQO {

    private String name;
    private Integer useNum;
    private MailDeleteStatus mailDeleteStatus;
    private String creator;
    private Date createTime;
}
