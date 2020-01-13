package org.starrysea.mail.plan.service;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.starrysea.mail.common.util.PageQueryUtils;
import org.starrysea.mail.common.entity.dto.PageQueryInfo;
import org.starrysea.mail.common.entity.vo.ListDataWithPageInfo;
import org.starrysea.mail.plan.entity.dto.AddPlanDTO;
import org.starrysea.mail.plan.entity.enums.PlanStatus;
import org.starrysea.mail.plan.entity.qo.PlanListQO;
import org.starrysea.mail.plan.entity.vo.PlanDetailVO;
import org.starrysea.mail.plan.entity.vo.PlanListVO;

import java.util.Arrays;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PlanServiceTests {

    @Autowired
    private PlanService planService;

    @Test
    public void addPlan() {
        AddPlanDTO addPlanDTO = new AddPlanDTO();
        addPlanDTO.setName("测试推广计划A");
        addPlanDTO.setTemplateId(1);
        addPlanDTO.setEmailList(Arrays.asList("kuma_loveliver@163.com"));
        planService.addPlan(addPlanDTO);
    }

    @Test
    public void getAllPlan() {
        PlanListQO planListQO = new PlanListQO();
        planListQO.setName("推广");
        planListQO.setStatus(PlanStatus.NOT_RUN);
        planListQO.setCreateTime(new Date());
        PageHelper.startPage(1, 1);
        PageQueryInfo pageQueryInfo = new PageQueryInfo();
        pageQueryInfo.setPageSize(1);
        pageQueryInfo.setPageNum(1);
        ListDataWithPageInfo<PlanListVO> planListVOList = PageQueryUtils.pageQuery(pageQueryInfo, () -> planService.getAllPlan(planListQO));
        log.error(planListVOList.toString());
    }

    @Test
    public void getPlan() {
        PlanDetailVO planDetailVO = planService.getPlan(7);
        log.error(planDetailVO.toString());
    }
}
