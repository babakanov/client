package com.example.client.controller;

import com.example.client.dto.ContactsDto;
import com.example.client.dto.ContactsRequest;
import com.example.client.endpoint.ContactsEndpoint;
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
@RequestMapping(Paths.CONTACTS)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContactsController {
    ContactsEndpoint endpoint;

    @PostMapping("/{clientId}")
    @ApiOperation("Добавить клиента")
    public ContactsDto create(
            @PathVariable Long clientId,
            @ApiParam(value = "ContactsRequest", required = true) @RequestBody ContactsRequest request
    ) throws NotFoundException {
        return endpoint.create(clientId, request);
    }

    @GetMapping("/{id}")
    @ApiOperation("Получить информацию о контакте")
    public ContactsDto get(@PathVariable Long id) throws NotFoundException {
        return endpoint.get(id);
    }

    @GetMapping("/all")
    @ApiOperation("Получить информацию о всех контактах")
    public List<ContactsDto> getAll() throws NotFoundException {
        return endpoint.getAll();
    }

    @GetMapping("/all-by-client/{clientId}")
    @ApiOperation("Получить информацию о контактах по клиенту")
    public List<ContactsDto> getAllByClient(@PathVariable Long clientId) throws NotFoundException {
        return endpoint.getAllByClient(clientId);
    }
}
