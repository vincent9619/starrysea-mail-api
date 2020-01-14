package org.starrysea.mail.plan.entity.vo;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data
public class PlanDetailVO extends RepresentationModel {

    private String name;
    private String templateName;
    private String creator;
    private Date createTime;
    private String status;
    private String failReason;
    private Date finishTime;
    private List<PlanUserListVO> planUserListVOList;
}
