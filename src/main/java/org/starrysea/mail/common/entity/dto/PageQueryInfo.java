package org.starrysea.mail.common.entity.dto;

import lombok.Data;

@Data
public class PageQueryInfo {

    private int pageSize;
    private int pageNum;
    private String sortField;
    private String sortType = "ASC";
}
