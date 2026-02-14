# 📦 Sistema de Microserviços com Spring Cloud, RabbitMQ e Docker

## 📖 Sobre o Projeto

Este projeto implementa uma arquitetura baseada em **microserviços**,
utilizando **Spring Cloud**, **mensageria com RabbitMQ**, **service
discovery com Eureka**, **API Gateway**, **autenticação com Keycloak** e
**containerização com Docker**.

O sistema foi desenvolvido com fins educacionais e posteriormente
evoluído com melhorias estruturais e organizacionais.

------------------------------------------------------------------------

# 🏗️ Arquitetura do Sistema

O projeto segue o padrão de arquitetura distribuída com:

-   Service Discovery (Eureka Server)
-   API Gateway (Spring Cloud Gateway)
-   Microserviços independentes
-   Mensageria assíncrona com RabbitMQ
-   Autenticação e autorização com Keycloak
-   Containerização com Docker Compose

------------------------------------------------------------------------

# 🧱 Microserviços

  Serviço              Responsabilidade
  -------------------- ------------------------------------
  eurekaserver         Registro e descoberta de serviços
  msclientes           Gestão de clientes
  mscartoes            Gestão de cartões
  msavaliadorcredito   Avaliação de crédito
  mscloudgateway       Gateway de entrada das requisições
  rabbitmq             Broker de mensageria
  keycloak             Autenticação e autorização

------------------------------------------------------------------------

# 🧰 Tecnologias Utilizadas

## Backend

-   Java 17
-   Spring Boot
-   Spring Cloud
-   Spring Data JPA
-   Spring AMQP
-   Spring Security
-   Spring Cloud Gateway
-   Netflix Eureka

## Mensageria

-   RabbitMQ

## Segurança

-   Keycloak
-   OAuth2 / OpenID Connect

## Containerização

-   Docker
-   Docker Compose

## Build

-   Maven

------------------------------------------------------------------------

# 📂 Estrutura do Projeto

    curso-microservices-springcloud
    │
    ├── docker-compose.yml
    ├── keycloak/
    └── projeto-cursoms/
        ├── pom.xml
        ├── eurekaserver/
        ├── msclientes/
        ├── mscartoes/
        ├── msavaliadorcredito/
        └── mscloudgateway/

O projeto utiliza Maven multi-module, onde o pom.xml principal agrega
todos os microserviços.

------------------------------------------------------------------------

# 🚀 Como Executar o Projeto

## 🐳 Executando com Docker (Recomendado)

### 1️⃣ Pré-requisitos

-   Docker Desktop instalado
-   Docker Compose habilitado

### 2️⃣ Subir os serviços

``` bash
docker compose up --build -d
```

### 3️⃣ Verificar containers

``` bash
docker ps
```

### 4️⃣ Acessos

  Serviço    URL
  ---------- ------------------------
  Eureka     http://localhost:8761
  Gateway    http://localhost:8080
  RabbitMQ   http://localhost:15672
  Keycloak   http://localhost:8081

------------------------------------------------------------------------

## 💻 Executando Localmente (Sem Docker)

### 1️⃣ Subir RabbitMQ

``` bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10.5-management
```

### 2️⃣ Subir Keycloak

``` bash
docker run -d --name keycloak -p 8081:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:18.0.0 start-dev
```

### 3️⃣ Subir os microserviços

Ordem recomendada:

1.  eurekaserver
2.  msclientes
3.  mscartoes
4.  msavaliadorcredito
5.  mscloudgateway

Via Maven:

``` bash
mvn clean package
```

------------------------------------------------------------------------

# 🔄 Comunicação entre Serviços

## Comunicação síncrona

-   REST
-   Descoberta via Eureka
-   Gateway roteando requisições

## Comunicação assíncrona

-   RabbitMQ
-   Publicação e consumo de eventos

------------------------------------------------------------------------

# 🔐 Segurança

-   Autenticação via Keycloak
-   OAuth2 / JWT
-   Gateway validando tokens
-   Serviços protegidos por Resource Server

------------------------------------------------------------------------

# 📊 Observabilidade

Logs são exibidos via console:

``` bash
docker compose logs -f
```

------------------------------------------------------------------------

# 🛠️ Melhorias Futuras

-   Circuit Breaker (Resilience4j)
-   Centralização de logs (ELK / Loki)
-   Monitoramento com Prometheus + Grafana
-   Testes automatizados
-   Deploy em Kubernetes
-   Pipeline CI/CD

------------------------------------------------------------------------

# 🎓 Contexto Educacional

Projeto desenvolvido com base no curso: Domine Microserviços e
Mensageria com Spring Cloud e Docker (Udemy)

Posteriormente evoluído com melhorias estruturais e organizacionais.

------------------------------------------------------------------------

# 👨‍💻 Autor

Elton Riva\
Engenheiro de Software \| Arquitetura de Microsserviços \| Spring
Ecosystem
