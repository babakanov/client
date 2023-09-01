package com.example.client.service;

import com.example.client.domain.Client;
import com.example.client.service.base.CrudService;

import java.util.List;

public interface ClientService extends CrudService<Client, Long> {

    List<Client> getAll();
}
