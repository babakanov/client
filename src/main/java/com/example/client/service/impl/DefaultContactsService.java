package com.example.client.service.impl;

import com.example.client.domain.Client;
import com.example.client.domain.Contacts;
import com.example.client.repository.ContactsRepository;
import com.example.client.service.ContactsService;
import com.example.client.service.base.impl.DefaultCrudService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultContactsService extends DefaultCrudService<Contacts, Long> implements ContactsService {
    ContactsRepository contactsRepository;

    public DefaultContactsService(
            @Qualifier("contactsRepository") CrudRepository<Contacts, Long> crudRepository,
            ContactsRepository contactsRepository
    ) {
        super(crudRepository);
        this.contactsRepository = contactsRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contacts> getAll() {
        return contactsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Contacts> getByClient(Client client) {
        return contactsRepository.findAllByClient(client);
    }
}
