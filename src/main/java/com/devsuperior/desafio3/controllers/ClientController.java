package com.devsuperior.desafio3.controllers;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
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

    @PutMapping("/{id}")
    public ClientDTO update(@PathVariable Long id, @RequestBody ClientDTO dto) {
        ClientDTO result = clientService.update(id, dto);
        return result;
    }

   @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clientService.delete(id);
    }





//    @GetMapping
//    public ResponseEntity<String> test() {
//        return ResponseEntity.ok("API funcionando! Data: " + LocalDate.now());
//    }

}
