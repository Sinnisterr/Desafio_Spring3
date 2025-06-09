package com.devsuperior.desafio3.controllers;

import com.devsuperior.desafio3.dto.ClientDTO;
import com.devsuperior.desafio3.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
        ClientDTO dto = clientService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) {
        Page<ClientDTO> page = clientService.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto) {
        ClientDTO created = clientService.insert(dto);  // ← Service retorna com ID preenchido

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")  // ← Chave fechada corretamente
                .buildAndExpand(created.getId())  // ← Use created.getId() (já tem ID)
                .toUri();

        return ResponseEntity.created(uri).body(created);  // ← Use .created(uri)
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO dto) {
        ClientDTO result = clientService.update(id, dto);
        return ResponseEntity.ok(result);  // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();  // 204 No Content
    }




//    @GetMapping
//    public ResponseEntity<String> test() {
//        return ResponseEntity.ok("API funcionando! Data: " + LocalDate.now());
//    }

}
