package org.starrysea.mail.common.entity.vo;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
public class ListDataWithPageInfo<T> extends RepresentationModel {

    private long total;
    private List<T> rows;
}
