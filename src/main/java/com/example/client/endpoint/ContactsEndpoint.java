package com.example.client.endpoint;

import com.example.client.dto.ContactsDto;
import com.example.client.dto.ContactsRequest;
import com.example.client.exception.NotFoundException;

import java.util.List;

public interface ContactsEndpoint {
    ContactsDto create(Long clientId, ContactsRequest request) throws NotFoundException;

    ContactsDto get(Long id) throws NotFoundException;

    List<ContactsDto> getAll() throws NotFoundException;

    List<ContactsDto> getAllByClient(Long clientId) throws NotFoundException;
}
