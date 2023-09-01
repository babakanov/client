package com.example.client.service.impl;

import com.example.client.domain.Client;
import com.example.client.repository.ClientRepository;
import com.example.client.service.ClientService;
import com.example.client.service.base.impl.DefaultCrudService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultClientService extends DefaultCrudService<Client, Long> implements ClientService {
    ClientRepository clientRepository;

    public DefaultClientService(
            @Qualifier("clientRepository") CrudRepository<Client, Long> crudRepository,
            ClientRepository clientRepository
    ) {
        super(crudRepository);
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }
}
