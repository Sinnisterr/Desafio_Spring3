package com.devsuperior.desafio3.dto;

import com.devsuperior.desafio3.entities.Client;

import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO {

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO() {

    }

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client client) {
        id = client.getId();
        name = client.getName();
        cpf = client.getCpf();
        income = client.getIncome();
        birthDate = client.getBirthDate();
        children = client.getChildren();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public Double getIncome() {
        return income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ClientDTO clientDTO = (ClientDTO) o;
        return Objects.equals(id, clientDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
