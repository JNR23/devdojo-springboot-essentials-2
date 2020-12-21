package com.jnr23.springboot.requests;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnimePostRequestBody {

    @NotEmpty(message = "The anime name cannot be empty")
    private String name;

}
