package org.starrysea.mail.plan.entity.dto;

import lombok.Data;
import org.starrysea.mail.plan.dao.PlanUserMapper;
import org.starrysea.mail.plan.entity.domain.Plan;
import org.starrysea.mail.plan.entity.domain.PlanUser;
import org.starrysea.mail.plan.entity.enums.PlanStatus;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class AddPlanDTO {

    private String name;
    private Integer templateId;
    private List<String> emailList;

    public Plan toDomain() {
        Plan plan = new Plan();
        plan.setName(name);
        plan.setTemplateId(templateId);
        plan.setCreator("管理员");
        plan.setCreateTime(new Date());
        plan.setStatus(PlanStatus.NOT_RUN);
        return plan;
    }

    public List<PlanUser> toDomainList(PlanUserMapper planUserMapper, Integer mailPlanId) {
        return planUserMapper
                .getUserIdByEmail(emailList)
                .stream()
                .map(userId -> {
                    PlanUser planUser = new PlanUser();
                    planUser.setMailPlanId(mailPlanId);
                    planUser.setUserId(userId);
                    return planUser;
                })
                .collect(Collectors.toList());
    }
}
