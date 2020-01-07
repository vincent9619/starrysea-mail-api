package org.starrysea.mail.plan.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class PlanDetailVO {

    private String name;
    private String templateName;
    private String creator;
    private Date createTime;
    private String status;
    private String failReason;
    private Date finishTime;
}
