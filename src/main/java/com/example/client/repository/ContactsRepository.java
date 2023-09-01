package com.example.client.repository;

import com.example.client.domain.Client;
import com.example.client.domain.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {
    List<Contacts> findAllByClient(Client client);
}
