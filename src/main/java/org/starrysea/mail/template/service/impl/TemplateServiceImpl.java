package org.starrysea.mail.template.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starrysea.mail.template.dao.MailTemplateMapper;
import org.starrysea.mail.template.entity.domain.MailTemplate;
import org.starrysea.mail.template.entity.dto.AddTemplateDTO;
import org.starrysea.mail.template.entity.qo.MailTemplateQO;
import org.starrysea.mail.template.entity.vo.MailTemplateDetailVO;
import org.starrysea.mail.template.entity.vo.MailTemplateListVO;
import org.starrysea.mail.template.service.TemplateService;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private MailTemplateMapper mailTemplateMapper;


    @Override
    @Transactional
    public void addMailTemplate(AddTemplateDTO addTemplateDTO) {
        MailTemplate mailTemplate = addTemplateDTO.toDomain();
        mailTemplateMapper.saveMailTemplate(mailTemplate);
    }

    @Override
    public List<MailTemplateListVO> getAllMailTemplate(MailTemplateQO mailTemplateQO) {
        return mailTemplateMapper.getAllMailTemplate(mailTemplateQO);
    }

    @Override
    public MailTemplateDetailVO getMailTemplate(Integer mailTemplateId) {
        MailTemplateDetailVO mailTemplateDetailVO = mailTemplateMapper.getMailTemplate(mailTemplateId);
        return mailTemplateDetailVO;
    }

    @Override
    public void rewriteMailTemplate(MailTemplate mailTemplate) {
        mailTemplateMapper.updateMailTemplate(mailTemplate);
    }
}
