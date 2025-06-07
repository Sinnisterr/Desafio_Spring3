package com.devsuperior.desafio3.controllers;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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


//    @GetMapping
//    public ResponseEntity<String> test() {
//        return ResponseEntity.ok("API funcionando! Data: " + LocalDate.now());
//    }

}
