package com.devsuperior.desafio3.dto;

import com.devsuperior.desafio3.entities.Client;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.Objects;

public class ClientDTO {


    private Long id;

    @Size(min = 3, max =80, message = "Nome precisa ter de 3 a 80 caracteres")
    @NotBlank(message = "Campo Requerido")
    private String name;

    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotNull(message = "Renda é obrigatória")
    @Positive(message = "Renda deve ser positiva")
    private Double income;

    @NotNull(message = "Data de nascimento é obrigatória")
    private LocalDate birthDate;

    @Min(value = 0, message = "Número de filhos não pode ser negativo")
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
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
