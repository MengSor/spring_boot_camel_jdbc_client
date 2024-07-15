package com.example.spring_boot_camel_jdbc_client.route;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public final class BeanResponse<T> {
    private boolean success ;
    private String massage;
    private int code;
    T data;

// ==============================
}
