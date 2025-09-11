package cursino.guilherme.crud_clientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class ClientDTO {

    private final Long id;
    @NotBlank(message = "Nome é um campo obrigatório")
    private final String name;
    @NotBlank(message = "CPF é um campo obrigatório")
    private final String cpf;
    @PositiveOrZero
    private final Double income;
    @PastOrPresent(message = "A data de nascimento não pode ser uma data futura")
    private final LocalDate birthDate;
    @PositiveOrZero
    private final Integer children;

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
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
}
