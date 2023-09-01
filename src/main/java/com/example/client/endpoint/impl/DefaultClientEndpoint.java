package com.example.client.endpoint.impl;

import com.example.client.domain.Client;
import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientRequest;
import com.example.client.endpoint.ClientEndpoint;
import com.example.client.exception.NotFoundException;
import com.example.client.mapper.ClientMapper;
import com.example.client.service.ClientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultClientEndpoint implements ClientEndpoint {
    ClientService clientService;
    ClientMapper clientMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ClientDto create(ClientRequest request) {

        Client client = clientMapper.create(request);
        clientService.saveOrUpdate(client);

        return clientMapper.toDto(client);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientDto get(Long id) throws NotFoundException {
        Client client = clientService.get(id);
        return clientMapper.toDto(client);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> getAll() throws NotFoundException {
        List<Client> clients = clientService.getAll();

        return clientMapper.toDto(clients);
    }
}
