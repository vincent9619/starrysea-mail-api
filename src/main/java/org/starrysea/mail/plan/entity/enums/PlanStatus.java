package org.starrysea.mail.plan.entity.enums;

public enum PlanStatus {

    NOT_RUN("0", "待运行"),
    RUNNING("1", "正在运行"),
    SUCCESS("2", "运行成功"),
    FAIL("3", "运行失败");

    private String value;
    private String name;

    PlanStatus(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
