package org.starrysea.mail.common.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class MailResponse<T> extends RepresentationModel {

    private T data;

    public static <T> MailResponse of(T data) {
        return new MailResponse<>(data);
    }
}
