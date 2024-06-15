# Projeto de Microservices com Spring Cloud e Spring Boot

Este projeto é baseado no curso que ensina a criar uma arquitetura completa de microservices utilizando os frameworks Spring Cloud e Spring Boot. O objetivo é fornecer um guia prático desde o entendimento da arquitetura até o deploy dos microserviços em containers Docker.

## Objetivos do Projeto

- Entender e implementar uma arquitetura completa de microservices
- Aprender a utilizar Service Discovery e API Gateway
- Implementar balanceamento de carga
- Desenvolver microservices com comunicação síncrona e assíncrona
- Configurar um serviço de mensageria com RabbitMQ
- Integrar um Authorization Server com Keycloak
- Criar imagens Docker personalizadas e containers a partir delas
- Configurar réplicas dos microservices

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Cloud**
- **RabbitMQ**
- **Keycloak**
- **Docker**

## Módulos do Projeto

### 1. Arquitetura de Microservices
Implementação de uma arquitetura completa de microservices, seguindo as melhores práticas.

### 2. Service Discovery
Utilização do Eureka Server para o registro e descoberta dos serviços.

### 3. API Gateway
Configuração de um API Gateway com Spring Cloud Gateway para roteamento de requisições.

### 4. Balanceamento de Carga
Implementação de balanceamento de carga utilizando o Spring Cloud LoadBalancer.

### 5. Desenvolvimento de Microservices
Criação de microservices individuais responsáveis por diferentes funcionalidades da aplicação.

### 6. Comunicação de Microservices
- **Síncrona**: Utilização de RESTful APIs para comunicação direta entre microservices.
- **Assíncrona**: Utilização de RabbitMQ para comunicação baseada em mensagens.

### 7. Serviço de Mensageria com RabbitMQ
Configuração e utilização do RabbitMQ como serviço de mensageria para comunicação assíncrona.

### 8. Authorization Server com Keycloak
Configuração do Keycloak para gerenciar autenticação e autorização dos microservices.

### 9. Desenvolvimento de Imagens Docker
Criação de imagens Docker personalizadas para os microservices.

### 10. Containers Docker
Criação de containers Docker a partir das imagens personalizadas e orquestração dos mesmos.

### 11. Réplicas dos Microservices
Configuração de réplicas dos microservices para escalabilidade e alta disponibilidade.
