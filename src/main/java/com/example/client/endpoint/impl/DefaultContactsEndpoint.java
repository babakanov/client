package com.example.client.endpoint.impl;

import com.example.client.domain.Client;
import com.example.client.domain.Contacts;
import com.example.client.dto.ContactsDto;
import com.example.client.dto.ContactsRequest;
import com.example.client.endpoint.ContactsEndpoint;
import com.example.client.exception.NotFoundException;
import com.example.client.mapper.ContactsMapper;
import com.example.client.service.ClientService;
import com.example.client.service.ContactsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultContactsEndpoint implements ContactsEndpoint {
    ContactsMapper contactsMapper;
    ContactsService contactsService;
    ClientService clientService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ContactsDto create(Long clientId, ContactsRequest request) throws NotFoundException {
        validate(request);
        Client client = clientService.get(clientId);
        Contacts contacts = contactsMapper.create(request, client);
        contactsService.saveOrUpdate(contacts);

        return contactsMapper.toDto(contacts);
    }

    @Override
    @Transactional(readOnly = true)
    public ContactsDto get(Long id) throws NotFoundException {
        Contacts contacts = contactsService.get(id);

        return contactsMapper.toDto(contacts);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactsDto> getAll() throws NotFoundException {
        List<Contacts> contacts = contactsService.getAll();

        return contactsMapper.toDto(contacts);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactsDto> getAllByClient(Long clientId) throws NotFoundException {
        Client client = clientService.get(clientId);
        List<Contacts> contacts = contactsService.getByClient(client);

        return contactsMapper.toDto(contacts);
    }

    private void validate(ContactsRequest request) {
        if ((Objects.isNull(request.getEmail()) || request.getEmail().isEmpty()) && (Objects.isNull(request.getPhoneNumber()) || request.getPhoneNumber().isEmpty()))
        throw new RuntimeException("Оба поля не должны быть пустыми");

    }
}
