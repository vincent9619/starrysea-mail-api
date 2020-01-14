package org.starrysea.mail.plan.controller;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.QueryParameter;
import org.springframework.hateoas.mediatype.Affordances;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.starrysea.mail.common.entity.dto.PageQueryInfo;
import org.starrysea.mail.common.entity.vo.ListDataWithPageInfo;
import org.starrysea.mail.common.entity.vo.MailResponse;
import org.starrysea.mail.common.util.PageQueryUtils;
import org.starrysea.mail.plan.entity.dto.AddPlanDTO;
import org.starrysea.mail.plan.entity.qo.PlanListQO;
import org.starrysea.mail.plan.entity.vo.PlanDetailVO;
import org.starrysea.mail.plan.entity.vo.PlanListVO;
import org.starrysea.mail.plan.service.PlanService;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
//@Api(value = "推广计划", tags = "推广计划")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PutMapping("/plan")
//    @ApiOperation("添加推广计划")
    public MailResponse addPlan(@RequestBody @Valid AddPlanDTO addPlanDTO) {
        planService.addPlan(addPlanDTO);
        MailResponse mailResponse = MailResponse.of("添加推广计划成功");
        mailResponse.add(linkTo(methodOn(PlanController.class).addPlan(addPlanDTO)).withSelfRel());
        mailResponse.add(linkTo(methodOn(PlanController.class).getAllPlan(null, null)).withRel(IanaLinkRelations.COLLECTION));
        return mailResponse;
    }

    @GetMapping("/plan")
//    @ApiOperation("获取所有推广计划")
    public ListDataWithPageInfo<PlanListVO> getAllPlan(PageQueryInfo pageQueryInfo, PlanListQO planListQO) {
        ListDataWithPageInfo<PlanListVO> listVOListDataWithPageInfo = PageQueryUtils.pageQuery(pageQueryInfo, () -> planService.getAllPlan(planListQO));
        for (PlanListVO planListVO : listVOListDataWithPageInfo.getRows()) {
            planListVO.add(linkTo(methodOn(PlanController.class).getPlan(planListVO.getMailPlanId())).withRel(IanaLinkRelations.ITEM));
        }
        listVOListDataWithPageInfo.add(linkTo(methodOn(PlanController.class).getAllPlan(pageQueryInfo, planListQO)).withSelfRel());
        listVOListDataWithPageInfo.add(linkTo(methodOn(PlanController.class).addPlan(new AddPlanDTO())).withRel("create"));
        return listVOListDataWithPageInfo;
    }

    @GetMapping("/plan/{mailPlanId}")
//    @ApiOperation("获取一个推广计划的详细信息")
    public PlanDetailVO getPlan(@PathVariable("mailPlanId") Integer mailPlanId) {
        PlanDetailVO planDetailVO = planService.getPlan(mailPlanId);
        planDetailVO.add(linkTo(methodOn(PlanController.class).getPlan(mailPlanId)).withSelfRel());
        planDetailVO.add(linkTo(methodOn(PlanController.class).getAllPlan(null, null)).withRel(IanaLinkRelations.COLLECTION));
        return planDetailVO;
    }
}
