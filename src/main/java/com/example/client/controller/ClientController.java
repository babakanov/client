package com.example.client.controller;

import com.example.client.dto.ClientDto;
import com.example.client.dto.ClientRequest;
import com.example.client.endpoint.ClientEndpoint;
import com.example.client.exception.NotFoundException;
import com.example.client.util.Paths;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Paths.CLIENT)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientController {
    ClientEndpoint clientEndpoint;

    @PostMapping
    @ApiOperation("Добавить клиента")
    public ClientDto create(@ApiParam("ClientRequest") @RequestBody ClientRequest request) throws NotFoundException {
        return clientEndpoint.create(request);
    }

    @GetMapping("/{id}")
    @ApiOperation("Получить информацию о клиенте")
    public ClientDto get(@PathVariable Long id) throws NotFoundException {
        return clientEndpoint.get(id);
    }

    @GetMapping("/all")
    @ApiOperation("Получить информацию о всех клиентах")
    public List<ClientDto> getAll() throws NotFoundException {
        return clientEndpoint.getAll();
    }
}
