package com.example.client.mapper.impl;

import com.example.client.domain.Client;
import com.example.client.domain.Contacts;
import com.example.client.dto.ContactsDto;
import com.example.client.dto.ContactsRequest;
import com.example.client.mapper.ContactsMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultContactsMapper implements ContactsMapper {
    @Override
    @Transactional(readOnly = true)
    public Contacts create(ContactsRequest request, Client client) {
        Contacts contacts = new Contacts();
        contacts.setEmail(request.getEmail());
        contacts.setPhoneNumber(request.getPhoneNumber());
        contacts.setClient(client);
        return contacts;
    }

    @Override
    @Transactional(readOnly = true)
    public ContactsDto toDto(Contacts contacts) {
        return ContactsDto.builder()
                .id(contacts.getId())
                .email(contacts.getEmail())
                .phoneNumber(contacts.getPhoneNumber())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ContactsDto> toDto(List<Contacts> contacts) {
        return contacts.stream().map(this::toDto).collect(Collectors.toList());
    }
}
