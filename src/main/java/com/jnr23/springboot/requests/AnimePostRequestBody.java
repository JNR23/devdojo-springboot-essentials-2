package com.jnr23.springboot.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class AnimePostRequestBody {

    @NotEmpty(message = "The anime name cannot be empty")
    private String name;

}
