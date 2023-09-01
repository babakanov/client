package com.example.client.mapper;

import com.example.client.domain.Client;
import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientRequest;
import com.example.client.exception.NotFoundException;

import java.util.Collection;
import java.util.List;

public interface ClientMapper {
    Client create(ClientRequest request);

    ClientDto toDto(Client client);

    List<ClientDto> toDto(Collection<Client> clients) throws NotFoundException;
}
