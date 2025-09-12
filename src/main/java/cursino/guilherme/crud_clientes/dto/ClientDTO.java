package cursino.guilherme.crud_clientes.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class ClientDTO {

    private Long id;
    @NotBlank(message = "Nome é um campo obrigatório")
    private String name;
    @NotBlank(message = "CPF é um campo obrigatório")
    private String cpf;
    @PositiveOrZero
    private Double income;
    @PastOrPresent(message = "A data de nascimento não pode ser uma data futura")
    private LocalDate birthdate;
    @PositiveOrZero
    private Integer children;

    public ClientDTO() {}

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthdate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthdate = birthdate;
        this.children = children;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}
