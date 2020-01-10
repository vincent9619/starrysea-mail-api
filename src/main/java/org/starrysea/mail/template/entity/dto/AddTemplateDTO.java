package org.starrysea.mail.template.entity.dto;

import lombok.Data;

import org.starrysea.mail.template.entity.domain.MailTemplate;
import org.starrysea.mail.template.entity.enums.MailDeleteStatus;
import java.util.Date;
@Data
public class AddTemplateDTO {
    private String name;
    private String path;
     public MailTemplate toDomain(){
         MailTemplate mailTemplate = new MailTemplate();
         mailTemplate.setName(name);
         mailTemplate.setPath(path);
         mailTemplate.setCreator("柚子大神");
         mailTemplate.setCreateTime(new Date());
         mailTemplate.setUseNum(0);
         mailTemplate.setMailDeleteStatus(MailDeleteStatus.NOT_DELETE);
         return mailTemplate;
    }

}
