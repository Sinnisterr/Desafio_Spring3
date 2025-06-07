package com.devsuperior.desafio3.services;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.entities.Client;
import com.devsuperior.desafio3.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).get();
        ClientDTO dto = new ClientDTO(client);
        return dto;
    }

    


}
