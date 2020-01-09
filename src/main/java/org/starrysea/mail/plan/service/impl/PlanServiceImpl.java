package org.starrysea.mail.plan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.starrysea.mail.plan.dao.PlanMapper;
import org.starrysea.mail.plan.dao.PlanUserMapper;
import org.starrysea.mail.plan.entity.domain.Plan;
import org.starrysea.mail.plan.entity.dto.AddPlanDTO;
import org.starrysea.mail.plan.entity.qo.PlanListQO;
import org.starrysea.mail.plan.entity.vo.PlanDetailVO;
import org.starrysea.mail.plan.entity.vo.PlanListVO;
import org.starrysea.mail.plan.service.PlanService;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanMapper planMapper;

    @Autowired
    private PlanUserMapper planUserMapper;

    @Override
    @Transactional
    public void addPlan(AddPlanDTO addPlanDTO) {
        Plan plan = addPlanDTO.toDomain();
        planMapper.savePlan(plan);
        planUserMapper.savePlanUser(addPlanDTO.toDomainList(planUserMapper, plan.getMailPlanId()));
    }

    @Override
    public List<PlanListVO> getAllPlan(PlanListQO planListQO) {
        return planMapper.getAllPlan(planListQO);
    }

    @Override
    public PlanDetailVO getPlan(Integer mailPlanId) {
        PlanDetailVO planDetailVO = planMapper.getPlan(mailPlanId);
        planDetailVO.setPlanUserListVOList(planUserMapper.getAllPlanUser(mailPlanId));
        return planDetailVO;
    }
}
