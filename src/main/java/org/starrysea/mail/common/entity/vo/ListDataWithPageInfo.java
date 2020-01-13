package org.starrysea.mail.common.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class ListDataWithPageInfo<T> {

    private long total;
    private List<T> rows;
}
