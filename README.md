# StockFlow API

> 🇧🇷 [Português](#português) | 🇺🇸 [English](#english)

---

## Português

### O problema que isso resolve

Imagine o dono de uma pequena loja. Todo dia, um funcionário precisa contar o estoque manualmente, anotar em papel ou planilha, e torcer para não esquecer de repor um produto antes que acabe. Quando o estoque zera, a venda é perdida — e muitas vezes o dono só descobre horas depois.

**StockFlow API resolve isso.**

Cada vez que uma venda é registrada, o sistema automaticamente dá baixa no estoque. Quando um produto atinge o nível mínimo configurado, o dono recebe um **alerta por e-mail em tempo real** — sem precisar verificar nada manualmente.

### O que a API faz

- Cadastro de produtos com código, nome, preço e quantidade
- Registro de vendas com baixa automática no estoque
- Alerta por e-mail quando o estoque de um produto fica abaixo do mínimo
- Histórico completo de vendas
- Listagem de produtos com estoque baixo

### Tecnologias

- **Java 21** + **Spring Boot 3.2**
- **Spring Data JPA** + **Hibernate**
- **MySQL 8**
- **Spring Mail** (Gmail SMTP)
- **Docker** + **Docker Compose**

### Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/produtos` | Cadastra um produto |
| `GET` | `/produtos` | Lista todos os produtos |
| `GET` | `/produtos/{codigo}` | Busca produto pelo código |
| `GET` | `/produtos/estoque-baixo` | Lista produtos com estoque baixo |
| `POST` | `/vendas` | Registra uma venda |
| `GET` | `/vendas` | Lista histórico de vendas |

### Como rodar localmente

**Pré-requisitos:** Java 21, MySQL 8, Docker (opcional)

1. Clone o repositório
```bash
git clone https://github.com/seu-usuario/stockflow-api.git
cd stockflow-api/estoque
```

2. Copie o arquivo de configuração
```bash
cp application.properties.example src/main/resources/application.properties
```

3. Preencha suas credenciais no `application.properties`

4. Rode com Docker
```bash
docker-compose up --build
```

Ou rode direto pelo IntelliJ após configurar o `application.properties`.

### Exemplo de uso

**Cadastrar produto:**
```json
POST /produtos
{
  "nome": "Coca-Cola 2L",
  "codigo": "PROD-001",
  "quantidade": 10,
  "preco": 8.50
}
```

**Registrar venda:**
```json
POST /vendas
{
  "codigoProduto": "PROD-001",
  "quantidade": 3
}
```

Quando o estoque atingir o mínimo configurado, o sistema dispara automaticamente um e-mail de alerta para o responsável.

---

## English

### The problem this solves

Picture a small store owner. Every day, an employee manually counts inventory, writes it down on paper or a spreadsheet, and hopes they remember to restock before something runs out. When stock hits zero, a sale is lost — and often the owner only finds out hours later.

**StockFlow API solves this.**

Every time a sale is recorded, the system automatically decrements the stock. When a product reaches the configured minimum level, the owner receives a **real-time email alert** — no manual checking required.

### What the API does

- Product registration with code, name, price, and quantity
- Sale recording with automatic stock decrement
- Email alert when a product's stock falls below the minimum threshold
- Full sales history
- Low-stock product listing

### Tech Stack

- **Java 21** + **Spring Boot 3.2**
- **Spring Data JPA** + **Hibernate**
- **MySQL 8**
- **Spring Mail** (Gmail SMTP)
- **Docker** + **Docker Compose**

### Endpoints

| Method | Route | Description |
|--------|-------|-------------|
| `POST` | `/produtos` | Register a product |
| `GET` | `/produtos` | List all products |
| `GET` | `/produtos/{codigo}` | Find product by code |
| `GET` | `/produtos/estoque-baixo` | List low-stock products |
| `POST` | `/vendas` | Record a sale |
| `GET` | `/vendas` | List sales history |

### Running locally

**Requirements:** Java 21, MySQL 8, Docker (optional)

1. Clone the repository
```bash
git clone https://github.com/seu-usuario/stockflow-api.git
cd stockflow-api/estoque
```

2. Copy the configuration file
```bash
cp application.properties.example src/main/resources/application.properties
```

3. Fill in your credentials in `application.properties`

4. Run with Docker
```bash
docker-compose up --build
```

Or run directly from IntelliJ after configuring `application.properties`.

### Usage example

**Register a product:**
```json
POST /produtos
{
  "nome": "Coca-Cola 2L",
  "codigo": "PROD-001",
  "quantidade": 10,
  "preco": 8.50
}
```

**Record a sale:**
```json
POST /vendas
{
  "codigoProduto": "PROD-001",
  "quantidade": 3
}
```

When stock reaches the configured minimum, the system automatically fires an email alert to the responsible party.

---

Built with Java + Spring Boot. Dockerized and production-ready.