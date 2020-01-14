package org.starrysea.mail.plan.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.starrysea.mail.common.entity.dto.PageQueryInfo;
import org.starrysea.mail.common.entity.vo.ListDataWithPageInfo;
import org.starrysea.mail.common.util.PageQueryUtils;
import org.starrysea.mail.plan.entity.dto.AddPlanDTO;
import org.starrysea.mail.plan.entity.qo.PlanListQO;
import org.starrysea.mail.plan.entity.vo.PlanDetailVO;
import org.starrysea.mail.plan.entity.vo.PlanListVO;
import org.starrysea.mail.plan.service.PlanService;

import javax.validation.Valid;

@RestController
@Api(value = "推广计划", tags = "推广计划")
public class PlanController {

    @Autowired
    private PlanService planService;

    @PutMapping("/plan")
    @ApiOperation("添加推广计划")
    public String addPlan(@RequestBody @Valid AddPlanDTO addPlanDTO) {
        planService.addPlan(addPlanDTO);
        return "添加推广计划成功";
    }

    @GetMapping("/plan")
    @ApiOperation("获取所有推广计划")
    public ListDataWithPageInfo<PlanListVO> getAllPlan(PageQueryInfo pageQueryInfo, PlanListQO planListQO) {
        return PageQueryUtils.pageQuery(pageQueryInfo, () -> planService.getAllPlan(planListQO));
    }

    @GetMapping("/plan/{mailPlanId}")
    @ApiOperation("获取一个推广计划的详细信息")
    public PlanDetailVO getPlan(@PathVariable("mailPlanId") Integer mailPlanId) {
        return planService.getPlan(mailPlanId);
    }
}
