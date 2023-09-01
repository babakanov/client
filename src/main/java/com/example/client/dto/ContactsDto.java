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
public class ContactsDto {

    @ApiModelProperty(notes = "ID")
    private Long id;

    @ApiModelProperty(notes = "Почта")
    private String email;

    @ApiModelProperty(notes = "Номер телефона")
    private String phoneNumber;
}
