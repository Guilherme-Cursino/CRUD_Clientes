# Desafio: CRUD de Clientes

Este projeto é um desafio de back-end do treinamento Java Spring Professional da DevSuperior, referente ao módulo de API REST, Camadas, CRUD, Exceções e Validações. O objetivo é desenvolver um CRUD completo de web services REST para gerenciar um recurso de clientes.

## Operações Implementadas

O projeto implementa as operações básicas de um CRUD:

*   **Busca paginada de recursos:** `GET /clients`
*   **Busca de recurso por ID:** `GET /clients/{id}`
*   **Inserir novo recurso:** `POST /clients`
*   **Atualizar recurso:** `PUT /clients/{id}`
*   **Deletar recurso:** `DELETE /clients/{id}`

## Tecnologias Utilizadas

*   **Spring Boot:** Framework para desenvolvimento de aplicações Java.
*   **Maven:** Gerenciador de dependências.
*   **Java:** Linguagem de programação.
*   **H2 Database:** Banco de dados em memória para ambiente de testes.

## Entidade `Client`

A entidade `Client` possui os seguintes atributos:

*   `id`: Long (Chave Primária)
*   `name`: String
*   `cpf`: String
*   `income`: Double
*   `birthDate`: LocalDate
*   `children`: Integer

## Seeding de Dados

O projeto realiza o *seed* de pelo menos 10 clientes com dados significativos para testes.

## Tratamento de Exceções

O projeto trata as seguintes exceções:

*   **ID não encontrado:** Retorna código 404 para operações de `GET por ID`, `PUT` e `DELETE` quando o cliente não existe.
*   **Erro de validação:** Retorna código 422 com mensagens customizadas para cada campo inválido. As regras de validação são:
    *   **Nome e CPF:** São campos obrigatórios.
    *   **Data de nascimento:** É um campo obrigatório e não pode ser uma data futura.

## Testes Manuais com Postman

As seguintes requisições podem ser testadas utilizando o Postman (ou ferramenta similar):

### Busca de cliente por ID

`GET /clients/1`

### Busca paginada de clientes

`GET /clients?page=0\&size=6\&sort=name`

### Inserção de novo cliente
```
POST /clients
Content-Type: application/json
{
"name": "Maria Silva",
"cpf": "12345678901",
"income": 6500.0,
"birthDate": "1994-07-20",
"children": 2
}
```
### Atualização de cliente
```
PUT /clients/1
Content-Type: application/json

{
"name": "Maria Silvaaa",
"cpf": "12345678901",
"income": 6500.0,
"birthDate": "1994-07-20",
"children": 2
}
```
### Deleção de cliente

`DELETE /clients/1`
