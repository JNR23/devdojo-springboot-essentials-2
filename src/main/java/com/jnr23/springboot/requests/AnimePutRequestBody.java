package com.jnr23.springboot.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimePutRequestBody {

    private Long id;
    private String name;

}
