package org.starrysea.mail.plan.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.starrysea.mail.template.entity.domain.MailTemplate;
import org.starrysea.mail.template.entity.dto.AddTemplateDTO;
import org.starrysea.mail.template.entity.enums.MailDeleteStatus;
import org.starrysea.mail.template.entity.qo.MailTemplateQO;
import org.starrysea.mail.template.entity.vo.MailTemplateDetailVO;
import org.starrysea.mail.template.entity.vo.MailTemplateListVO;
import org.starrysea.mail.template.service.TemplateService;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TemplateServiceTests {
    @Autowired
    private TemplateService templateService;
    @Test
    public void addMailTemplate(){
        AddTemplateDTO addTemplateDTO = new AddTemplateDTO();
        addTemplateDTO.setName("千恋万花邮件模板2");
        addTemplateDTO.setPath("柚子社2");
        templateService.addMailTemplate(addTemplateDTO);
    }

    @Test
    public void getAllMailTemplate() {
        MailTemplateQO mailTemplateQO = new MailTemplateQO();
        mailTemplateQO.setName("千恋万花邮件模板");
        mailTemplateQO.setMailDeleteStatus(MailDeleteStatus.NOT_DELETE);
        mailTemplateQO.setCreateTime(new Date());
        mailTemplateQO.setUseNum(0);
        List<MailTemplateListVO> mailTemplateListVOList = templateService.getAllMailTemplate(mailTemplateQO);
        log.error(mailTemplateListVOList.toString());
    }

    @Test
    public void getMailTemplate(){
        MailTemplateDetailVO mailTemplateDetailVO = templateService.getMailTemplate(1);
        log.error(mailTemplateDetailVO.toString());

    }

    @Test
    public void rewriteMailTemplate(){
        MailTemplate mailTemplate = new MailTemplate();
        mailTemplate.setMailTemplateId(2);
        mailTemplate.setPath("新岛夕");
        templateService.editMailTemplate(mailTemplate);

    }

}
