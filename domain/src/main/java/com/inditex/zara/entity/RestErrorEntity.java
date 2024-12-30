package com.inditex.zara.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RestErrorEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 4367595470616359588L;

    private final UUID id = UUID.randomUUID();
    private Integer status;
    private String description;

}
