package org.starrysea.mail.plan.dao;

import org.starrysea.mail.plan.entity.domain.PlanUser;
import org.starrysea.mail.plan.entity.vo.PlanUserListVO;

import java.util.List;

public interface PlanUserMapper {

    void savePlanUser(List<PlanUser> planUserList);

    List<PlanUserListVO> getAllPlanUser(Integer mailPlanId);

    List<String> getUserIdByEmail(List<String> emailList);
}
