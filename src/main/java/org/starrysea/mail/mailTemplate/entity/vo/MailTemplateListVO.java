package org.starrysea.mail.mailTemplate.entity.vo;

import lombok.Data;
import org.starrysea.mail.mailTemplate.entity.enums.MailDeleteStatus;
@Data
public class MailTemplateListVO {
    private Integer mailTemplateId;
    private String name;
}
