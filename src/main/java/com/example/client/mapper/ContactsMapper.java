package com.example.client.mapper;

import com.example.client.domain.Client;
import com.example.client.domain.Contacts;
import com.example.client.dto.ContactsDto;
import com.example.client.dto.ContactsRequest;

import java.util.List;

public interface ContactsMapper {
    Contacts create(ContactsRequest request, Client client);

    ContactsDto toDto(Contacts contacts);

    List<ContactsDto> toDto(List<Contacts> contacts);

}
