package com.example.client.domain;

import com.example.client.domain.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "client")
public class Client extends BaseEntity {

    @NotNull
    private String name;
}
