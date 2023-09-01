package com.example.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    @ApiModelProperty(name = "id")
    private Long id;

    @ApiModelProperty(name = "Имя")
    private String name;
}
