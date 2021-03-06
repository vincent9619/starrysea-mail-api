package org.starrysea.mail.template.service;

import org.starrysea.mail.template.entity.dto.AddTemplateDTO;
import org.starrysea.mail.template.entity.dto.EditMailTemplateDTO;
import org.starrysea.mail.template.entity.qo.MailTemplateQO;
import org.starrysea.mail.template.entity.vo.MailTemplateDetailVO;
import org.starrysea.mail.template.entity.vo.MailTemplateListVO;

import java.util.List;

public interface TemplateService {
    void addMailTemplate(AddTemplateDTO addTemplateDTO);

    List<MailTemplateListVO> getAllMailTemplate(MailTemplateQO mailTemplateQO);

    MailTemplateDetailVO getMailTemplate(Integer mailTemplateId);

    void editMailTemplate(EditMailTemplateDTO editMailTemplateDTO);


}
