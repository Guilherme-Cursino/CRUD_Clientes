package cursino.guilherme.crud_clientes.dto;

import java.time.LocalDate;

public class ClientDTO {
    private final Long id;
    private final String name;
    private final String cpf;
    private final Double income;
    private final LocalDate birthDate;
    private final Integer children;

    public ClientDTO(Long id, String name, String cpf, Double income, LocalDate birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

//    public ClientDTO(Client client) {
//        id = client.getId();
//        name =  client.getName();
//        cpf = client.getCpf();
//        income = client.getIncome();
//        birthDate = client.getBirthDate();
//        children = client.getChildren();
//    }

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
