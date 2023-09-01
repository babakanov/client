package com.example.client.mapper.impl;

import com.example.client.domain.Client;
import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientRequest;
import com.example.client.exception.NotFoundException;
import com.example.client.mapper.ClientMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultClientMapper implements ClientMapper {

    @Override
    public Client create(ClientRequest request) {
        Client client = new Client();
        client.setName(request.getName());

        return client;
    }

    @Override
    public ClientDto toDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .build();
    }

    @Override
    public List<ClientDto> toDto(Collection<Client> clients) throws NotFoundException {

        return clients.stream().map(this::toDto).collect(Collectors.toList());
    }
}
