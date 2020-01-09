package org.starrysea.mail.template.dao;


import org.starrysea.mail.template.entity.qo.MailTemplateQO;
import org.starrysea.mail.template.entity.vo.MailTemplateDetailVO;
import org.starrysea.mail.template.entity.vo.MailTemplateListVO;
import org.starrysea.mail.plan.entity.domain.Plan;

import java.util.List;

public interface MailTemplateMapper {
    void saveMailTemplate(Plan plan);

    List<MailTemplateListVO> getAllMailTemplate(MailTemplateQO mailTemplateQO);

    MailTemplateDetailVO getMailTemplate(Integer mailTemplateId);

    void updateMailDeleteStatus(Plan plan);
}
