package org.starrysea.mail.plan.dao;

import org.starrysea.mail.plan.entity.domain.Plan;
import org.starrysea.mail.plan.entity.qo.PlanListQO;
import org.starrysea.mail.plan.entity.vo.PlanDetailVO;
import org.starrysea.mail.plan.entity.vo.PlanListVO;

import java.util.List;

public interface PlanMapper {

    void savePlan(Plan plan);

    List<PlanListVO> getAllPlan(PlanListQO planListQO);

    PlanDetailVO getPlan(Integer mailPlanId);

    void updatePlanStatus(Plan plan);
}
