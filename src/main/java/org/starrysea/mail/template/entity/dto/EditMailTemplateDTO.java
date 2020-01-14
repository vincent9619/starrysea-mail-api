package org.starrysea.mail.template.entity.dto;

import lombok.Data;
import org.starrysea.mail.template.entity.domain.MailTemplate;
import org.starrysea.mail.template.entity.enums.MailDeleteStatus;


import java.util.Date;

@Data
public class EditMailTemplateDTO {
    private Integer mailTemplateId;
    private String path;

    public MailTemplate toDomain() {
        MailTemplate mailTemplate = new MailTemplate();
        mailTemplate.setUseNum(0);
        mailTemplate.setCreateTime(new Date());
        mailTemplate.setCreator("我");
        mailTemplate.setMailDeleteStatus(MailDeleteStatus.NOT_DELETE);
        mailTemplate.setMailTemplateId(mailTemplateId);
        mailTemplate.setPath(path);
        return mailTemplate;
    }

}
