package com.example.client.service;

import com.example.client.domain.Client;
import com.example.client.domain.Contacts;
import com.example.client.service.base.CrudService;

import java.util.List;

public interface ContactsService extends CrudService<Contacts, Long> {
    List<Contacts> getAll();

    List<Contacts> getByClient(Client client);
}
