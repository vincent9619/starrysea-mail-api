package org.starrysea.mail.plan.entity.qo;

import lombok.Data;
import org.starrysea.mail.plan.entity.enums.PlanStatus;

import java.util.Date;

@Data
public class PlanListQO {

    private String name;
    private PlanStatus status;
    private Date createTime;
    private Date finishTime;
}
