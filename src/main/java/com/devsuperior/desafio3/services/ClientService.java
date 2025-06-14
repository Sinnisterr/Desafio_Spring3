package com.devsuperior.desafio3.services;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.entities.Client;
import com.devsuperior.desafio3.repositories.ClientRepository;
import com.devsuperior.desafio3.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado com ID: " + id));
        return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> clients = clientRepository.findAll(pageable);
        return clients.map(client -> new ClientDTO(client));

    }

    @Transactional
    public ClientDTO insert(ClientDTO dto) {
//        Client entity = new Client(null, dto.getName(), dto.getCpf(), dto.getIncome(),
//                dto.getBirthDate(), dto.getChildren());
//        entity = clientRepository.save(entity);
//        return new ClientDTO(entity);
        Client entity = new Client();
        updateEntityDTO(entity, dto);
        return new ClientDTO(clientRepository.save(entity));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto) {
        Client entity = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado: " + id));
        updateEntityDTO(entity, dto);
        return new ClientDTO(clientRepository.save(entity));

    }

    @Transactional
    private void updateEntityDTO(Client entity, ClientDTO dto) {
        entity.setName(dto.getName());
        entity.setCpf(dto.getCpf());
        entity.setIncome(dto.getIncome());
        entity.setBirthDate(dto.getBirthDate());
        entity.setChildren(dto.getChildren());
    }

    @Transactional
    public void delete(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado ID: " + id));
        clientRepository.delete(client);
        }


    }

