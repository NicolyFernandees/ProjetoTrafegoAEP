/* ProjetoAEP2Bimestre | Solução Semafórica | Comandos DDL (Estrutura) e DML (Dados Iniciais) */

---- DDL (Data Definition Language) - Comandos de Estrutura ----

---- Cria o banco de dados ----
CREATE DATABASE IF NOT EXISTS db_mobilidade_paicandu;

---- Seleciona o banco de dados para usar ----
USE db_mobilidade_paicandu;

---- Cria a tabela 'viaduto' ----
CREATE TABLE IF NOT EXISTS viaduto (
    id_viaduto BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    localizacao_geografica VARCHAR(255)
);

---- Cria a tabela 'semaforo' ----
CREATE TABLE IF NOT EXISTS semaforo (
    id_semaforo BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_viaduto BIGINT NOT NULL,
    tempo_abertura_padrao_seg INT NOT NULL,
    tempo_fechamento_padrao_seg INT NOT NULL,
    FOREIGN KEY (id_viaduto) REFERENCES viaduto(id_viaduto)
);

---- Cria a tabela 'registro_controle' ----
CREATE TABLE IF NOT EXISTS registro_controle (
    id_registro BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_semaforo BIGINT NOT NULL,
    data_hora_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    contagem_veiculos INT NOT NULL,
    tempo_abertura_aplicado_seg INT NOT NULL,
    FOREIGN KEY (id_semaforo) REFERENCES semaforo(id_semaforo)
);


---- DML (Data Manipulation Language) - Comandos de Dados Iniciais ---


/* Insere os dados iniciais (existentes) para o funcionamento da aplicação, como definido no SimuladorController.java. */

---- Insere os 3 viadutos ----
INSERT INTO viaduto (nome, localizacao_geografica) 
VALUES 
    ('Viaduto A - Centro', NULL),
    ('Viaduto B - Saída Norte', NULL),
    ('Viaduto C - Acesso Industrial', NULL);

----- Insere os 3 semáforos (assumindo que os viadutos são IDs 1, 2, e 3) ----
INSERT INTO semaforo (id_viaduto, tempo_abertura_padrao_seg, tempo_fechamento_padrao_seg) 
VALUES
    (1, 60, 45),
    (2, 60, 45),
    (3, 60, 45);
