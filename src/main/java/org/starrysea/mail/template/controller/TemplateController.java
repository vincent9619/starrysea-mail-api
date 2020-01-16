package org.starrysea.mail.template.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.starrysea.mail.common.entity.dto.PageQueryInfo;
import org.starrysea.mail.common.entity.vo.ListDataWithPageInfo;
import org.starrysea.mail.common.util.PageQueryUtils;
import org.starrysea.mail.template.entity.dto.AddTemplateDTO;
import org.starrysea.mail.template.entity.dto.EditMailTemplateDTO;
import org.starrysea.mail.template.entity.qo.MailTemplateQO;
import org.starrysea.mail.template.entity.vo.MailTemplateDetailVO;
import org.starrysea.mail.template.entity.vo.MailTemplateListVO;
import org.starrysea.mail.template.service.TemplateService;

import javax.validation.Valid;

@RestController
@Api(value = "邮件模板", tags = "邮件模板")
@PreAuthorize("hasAnyAuthority('admin_role')")
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PutMapping("/template")
    @ApiOperation("添加邮件模板")
    public String addMailTemplate(@RequestBody @Valid AddTemplateDTO addTemplateDTO) {
        templateService.addMailTemplate(addTemplateDTO);
        return "添加邮件模板成功";
    }

    @GetMapping("/template")
    @ApiOperation("获取所有邮件模板")
    public ListDataWithPageInfo<MailTemplateListVO> getAllMailTemplate(PageQueryInfo pageQueryInfo, MailTemplateQO mailTemplateQO) {
        return PageQueryUtils.pageQuery(pageQueryInfo, () -> templateService.getAllMailTemplate(mailTemplateQO));
    }

    @GetMapping("/template/{mailTemplateId}")
    @ApiOperation("获取一个邮件模板的详细信息")
    public MailTemplateDetailVO getMailTemplate(@PathVariable("mailTemplateId") Integer mailTemplateId) {
        return templateService.getMailTemplate(mailTemplateId);
    }

    @PostMapping("/template/{mailTemplateId}")
    @ApiOperation("修改一个邮件模板")
    public String editMailTemplate( @PathVariable("mailTemplateId") Integer mailTemplateId, @RequestBody @Valid EditMailTemplateDTO editMailTemplateDTO) {
        editMailTemplateDTO.setMailTemplateId(mailTemplateId);
        templateService.editMailTemplate(editMailTemplateDTO);
        return "修改邮件模板成功";
    }

}
