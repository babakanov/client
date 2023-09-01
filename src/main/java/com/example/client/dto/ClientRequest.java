package com.example.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClientRequest {

    @NotNull
    @ApiModelProperty(notes = "Имя", required = true)
    private String name;
}
