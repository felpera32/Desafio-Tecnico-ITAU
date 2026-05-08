# Desafio Técnico Itaú

API REST desenvolvida com Java e Spring Boot para o desafio backend do Itaú. A aplicação recebe transações, armazena em memória e calcula estatísticas dos últimos 60 segundos.

---

## Visão Geral

- `POST /transacao`: cadastra uma nova transação
- `GET /estatistica`: retorna estatísticas das transações válidas dos últimos 60 segundos
- `DELETE /transacao`: limpa todas as transações em memória
- Dados mantidos apenas em memória, sem persistência em banco
- Swagger/OpenAPI disponível em `/swagger-ui/index.html`

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot 4
- Maven
- Lombok
- Spring Validation
- Springdoc OpenAPI
- JUnit
- SLF4J / Logback

---

## Requisitos

- Java 17 instalado
- Maven instalado (ou uso do wrapper `./mvnw`)
- Porta padrão: `8080`

---

## Endpoints

### Criar transação

`POST /transacao`

Request body:

```json
{
  "valor": 100.50,
  "dataHora": "2026-05-07T18:30:00.000-03:00"
}
```

Respostas esperadas:

- `201 Created`: transação aceita
- `422 Unprocessable Entity`: transação inválida (valor negativo, data futura, etc.)
- `400 Bad Request`: JSON inválido ou erro de validação

---

### Buscar estatísticas

`GET /estatistica`

Exemplo de resposta:

```json
{
  "count": 3,
  "sum": 350.75,
  "avg": 116.91,
  "min": 50.0,
  "max": 200.0
}
```

`count`: total de transações válidas nos últimos 60 segundos

---

### Remover transações

`DELETE /transacao`

Resposta esperada:

- `200 OK`: todas as transações em memória foram removidas

---

## Regras da aplicação

- Transações com data futura são rejeitadas
- Valores negativos não são aceitos
- Apenas transações dentro da janela configurada são usadas nas estatísticas
- Os dados são mantidos apenas em memória durante a execução
- A janela de estatísticas é configurada em `src/main/resources/application.yml`

---

## Configuração

O tempo de análise das estatísticas está em:

```yaml
estatistica:
  segundos: 60
```

---

## Estrutura do Projeto

```text
src/main/java/com/itautest/itautest
 ├── Configuration
 ├── Controllers
 ├── Docs
 ├── model
 ├── Repository
 ├── Service
 └── ItautestApplication.java
```

---

## Como executar

```bash
./mvnw spring-boot:run
```

Ou:

```bash
mvn spring-boot:run
```

A aplicação ficará disponível em `http://localhost:8080`.

---

## Testes

```bash
./mvnw test
```

---

## Documentação OpenAPI

Se o Spring estiver em execução, a documentação pode ser acessada em:

`http://localhost:8080/swagger-ui/index.html`



