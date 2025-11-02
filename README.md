## | Mobilidade Sustentável Solução Semafórica | Projeto AEP

Este projeto é uma aplicação de backend em Java e Spring Boot desenvolvida para a AEP2Bimestre, com o objetivo de simular e gerenciar o tráfego de viadutos na cidade de Paiçandu.
O sistema implementa uma lógica de gerenciamento dinâmico que ajusta os intervalos de tempo dos semáforos com base na contagem de veículos em tempo real, persistindo relatórios de desempenho em um banco de dados MySQL para futuras análises.

## | Tecnologias Utilizadas
* **Java 17**
* **Spring Boot**
    * Spring Data JPA 
    * Spring Web
    * MySQL Driver
* **MySQL** |Banco de Dados Relacional
* **Hibernate** 
* **Maven** 

## | Arquitetura do Projeto
O projeto segue uma arquitetura Spring Boot padrão
* `/model`: Entidades JPA (`Viaduto`, `Semaforo`, `RegistroControle`).
* `/repository`: Interfaces `JpaRepository` para acesso ao banco.
* `/service`: Classe `GerenciadorSemaforoService` com a lógica de negócio.
* `/controller`: Classe `SimuladorController` que roda a simulação na inicialização (`CommandLineRunner`).

## | Como Executar 
1.  Verifique se o MySQL está rodando na porta `3306`.
2.  Crie um banco de dados chamado `CREATE DATABASE db_mobilidade_paicandu;`.
3.  Configure seu usuário e senha do MySQL no arquivo `src/main/resources/application.properties`.
4.  Rode a classe principal `TrafegosimulatorApplication.java` no IntelliJ IDEA.

## | Ao iniciar, a aplicação irá:
1.  Criar as tabelas automaticamente (`ddl-auto=update`).
2.  Popular o banco com 3 viadutos e 3 semáforos (se o banco estiver vazio).
3.  Executar uma simulação de teste com 3 cenários (fluxo alto, baixo e normal).
4.  Salvar os 3 resultados na tabela `SELECT * FROM db_mobilidade_paicandu.registro_controle;`.
