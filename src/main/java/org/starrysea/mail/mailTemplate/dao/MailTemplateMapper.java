package org.starrysea.mail.mailTemplate.dao;


import org.starrysea.mail.mailTemplate.entity.qo.MailTemplateQO;
import org.starrysea.mail.mailTemplate.entity.vo.MailTemplateDetailVO;
import org.starrysea.mail.mailTemplate.entity.vo.MailTemplateListVO;
import org.starrysea.mail.plan.entity.domain.Plan;

import java.util.List;

public interface MailTemplateMapper {
    void saveMailTemplate(Plan plan);

    List<MailTemplateListVO> getAllMailTemplate(MailTemplateQO mailTemplateQO);

    MailTemplateDetailVO getMailTemplate(Integer mailTemplateId);

    void updateMailDeleteStatus(Plan plan);
}
