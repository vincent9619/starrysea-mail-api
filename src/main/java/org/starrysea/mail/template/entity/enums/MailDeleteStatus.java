package org.starrysea.mail.template.entity.enums;

public enum MailDeleteStatus {

    NOT_DELETE("0", "未删除"),
    IS_DELETE("1", "已删除");


    private String value;
    private String name;

    MailDeleteStatus(String value, String name) {
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
