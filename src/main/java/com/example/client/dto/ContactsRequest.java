package com.example.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContactsRequest {

    @ApiModelProperty(notes = "Почта")
    private String email;

    @ApiModelProperty(notes = "Номер телефона")
    private String phoneNumber;
}
