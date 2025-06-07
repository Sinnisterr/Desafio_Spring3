package com.devsuperior.desafio3.services;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.entities.Client;
import com.devsuperior.desafio3.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();
        ClientDTO dto = new ClientDTO(client);
        return dto;
    }

    public List<ClientDTO> findAll() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(client -> new ClientDTO(client)).toList();

    }

    public ClientDTO insert(ClientDTO dto) {
        Client entity = new Client(null, dto.getName(), dto.getCpf(), dto.getIncome(),
                dto.getBirthDate(), dto.getChildren());
        entity = clientRepository.save(entity);
        return new ClientDTO(entity);
//        entity.setName(dto.getName());
//        entity.setCpf(dto.getCpf());
//        entity.setIncome(dto.getIncome());
//        entity.setBirthDate(dto.getBirthDate());
//        entity.setChildren(dto.getChildren());
//
//        entity = clientRepository.save(entity);
//
//        ClientDTO result = new ClientDTO(entity);
//        return result;
    }




}
