package org.starrysea.mail.template.dao;


import org.starrysea.mail.template.entity.domain.MailTemplate;
import org.starrysea.mail.template.entity.domain.UpdateMailTemplate;
import org.starrysea.mail.template.entity.qo.MailTemplateQO;
import org.starrysea.mail.template.entity.vo.MailTemplateDetailVO;
import org.starrysea.mail.template.entity.vo.MailTemplateListVO;


import java.util.List;

public interface MailTemplateMapper {
    void saveMailTemplate(MailTemplate mailTemplate);

    List<MailTemplateListVO> getAllMailTemplate(MailTemplateQO mailTemplateQO);

    MailTemplateDetailVO getMailTemplate(Integer mailTemplateId);

    void updateMailTemplate(UpdateMailTemplate updateMailTemplate);
}
