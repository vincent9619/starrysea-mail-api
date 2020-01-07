package org.starrysea.mail.plan.entity.domain;

import lombok.Data;
import org.starrysea.mail.plan.entity.enums.PlanStatus;

import java.util.Date;

@Data
public class Plan {

    private Integer mailPlanId;
    private String name;
    private Integer templateId;
    private String creator;
    private Date createTime;
    private PlanStatus status;
    private String failReason;
    private Date finishTime;
}
