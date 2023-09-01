package com.example.client.endpoint;

import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientRequest;
import com.example.client.exception.NotFoundException;

import java.util.List;

public interface ClientEndpoint {
    ClientDto create(ClientRequest request);

    ClientDto get(Long id) throws NotFoundException;

    List<ClientDto> getAll() throws NotFoundException;
}
