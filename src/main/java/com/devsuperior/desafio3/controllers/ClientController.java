package com.devsuperior.desafio3.controllers;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) {
        ClientDTO dto = clientService.findById(id);
        return dto;
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        List<ClientDTO> dtos = clientService.findAll();
        return dtos;
    }

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO dto) {
        return clientService.insert(dto);
    }





//    @GetMapping
//    public ResponseEntity<String> test() {
//        return ResponseEntity.ok("API funcionando! Data: " + LocalDate.now());
//    }

}
