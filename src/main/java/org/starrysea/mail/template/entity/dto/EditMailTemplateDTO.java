package org.starrysea.mail.template.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.starrysea.mail.template.entity.domain.MailTemplate;
import org.starrysea.mail.template.entity.enums.MailDeleteStatus;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class EditMailTemplateDTO {
    @JsonIgnore
    private Integer mailTemplateId;
    @NotBlank(message = "邮件模板的地址不能为空")
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
