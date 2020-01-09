package org.starrysea.mail.plan.service;

import org.starrysea.mail.plan.entity.dto.AddPlanDTO;
import org.starrysea.mail.plan.entity.qo.PlanListQO;
import org.starrysea.mail.plan.entity.vo.PlanDetailVO;
import org.starrysea.mail.plan.entity.vo.PlanListVO;

import java.util.List;

public interface PlanService {

    void addPlan(AddPlanDTO addPlanDTO);

    List<PlanListVO> getAllPlan(PlanListQO planListQO);

    PlanDetailVO getPlan(Integer mailPlanId);
}
