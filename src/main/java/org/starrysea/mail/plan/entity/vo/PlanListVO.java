package org.starrysea.mail.plan.entity.vo;

import lombok.Data;

import org.springframework.hateoas.RepresentationModel;

@Data
public class PlanListVO extends RepresentationModel {

    private Integer mailPlanId;
    private String name;
}
