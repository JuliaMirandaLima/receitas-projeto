# 🍴 Caderno de Receitas

## 👥 Integrantes

- **Nome:** Julia Miranda Lima

---

## 📌 Tema

**Sistema de gerenciamento e busca de receitas culinárias.**

---

## 📝 Descrição do Sistema

O **Caderno de Receitas** é um sistema desenvolvido em **Java com Spring Boot** que permite ao usuário cadastrar, visualizar, editar e excluir receitas.

O sistema também possui uma funcionalidade de **busca de receitas utilizando uma API externa**, permitindo consultar receitas disponíveis na internet e visualizar informações como nome, categoria, origem, imagem, ingredientes e modo de preparo.

As receitas cadastradas pelo usuário são armazenadas em um banco de dados **MySQL**.

---

## ⚙️ Funcionalidades

O sistema possui as seguintes funcionalidades:

- 🔎 Buscar receitas utilizando uma API externa;
- ➕ Cadastrar novas receitas;
- 📖 Listar receitas cadastradas;
- ✏️ Editar receitas;
- 🗑️ Excluir receitas;
- 🖼️ Visualizar imagens das receitas obtidas pela API;
- 🥕 Visualizar ingredientes e modo de preparo;
- 💾 Armazenar as receitas cadastradas em banco de dados.

---

## 🌐 API Utilizada

A API utilizada no projeto é a **TheMealDB API**, uma API pública de receitas culinárias.

### Endereço da API

https://www.themealdb.com/api.php

### Endpoint utilizado

```text
https://www.themealdb.com/api/json/v1/1/search.php?s=NOME_DA_RECEITA
```

Por exemplo:

```text
https://www.themealdb.com/api/json/v1/1/search.php?s=Arrabiata
```

---

## 🔌 Funcionalidade implementada com a API

A **TheMealDB** é utilizada na funcionalidade de busca de receitas.

Quando o usuário informa o nome de uma receita no sistema, a aplicação realiza uma requisição para a API. Os dados recebidos são processados pelo sistema e apresentados em uma página própria.

As informações utilizadas da API são:

- Nome da receita;
- Categoria;
- Origem;
- Imagem;
- Ingredientes;
- Modo de preparo.

Dessa forma, a API não é utilizada apenas como uma consulta técnica: seus dados são apresentados diretamente na interface do sistema para auxiliar o usuário na busca por receitas.

---

## 🛠️ Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Thymeleaf**
- **HTML e CSS**
- **MySQL**
- **Maven**
- **TheMealDB API**

---

## 🏗️ Estrutura do Projeto

O projeto segue uma organização baseada no padrão **MVC (Model-View-Controller)**.

```text
src
└── main
    ├── java
    │   └── br.edu.ifpr.receitas
    │       ├── controller
    │       ├── model
    │       ├── repository
    │       ├── service
    │       └── ReceitasApplication.java
    │
    └── resources
        ├── static
        ├── templates
        │   ├── index.html
        │   ├── receitas.html
        │   ├── formulario.html
        │   └── busca.html
        │
        └── application.properties
```

### Organização das principais partes

**Controller:** responsável por receber as requisições e controlar o fluxo da aplicação.

**Model:** contém as classes que representam os dados utilizados pelo sistema.

**Repository:** responsável pela comunicação com o banco de dados utilizando Spring Data JPA.

**Service:** responsável pela comunicação com a API externa.

**Templates:** contém as páginas HTML utilizadas na interface do sistema.

---

## 💾 Banco de Dados

O sistema utiliza o **MySQL** para armazenar as receitas cadastradas pelo usuário.

A aplicação utiliza o **Spring Data JPA** para realizar as operações de persistência dos dados.

---

## ▶️ Como executar o projeto

### 1. Pré-requisitos

Para executar o projeto, é necessário ter instalado:

- Java;
- Maven;
- MySQL;
- Uma IDE ou editor de código compatível com Java.

### 2. Banco de dados

Crie um banco de dados MySQL chamado:

```text
receitas
```

Depois, configure as informações de acesso ao banco no arquivo:

```text
src/main/resources/application.properties
```

### 3. Executar a aplicação

Na pasta do projeto, execute:

```bash
./mvnw spring-boot:run
```

No Windows, também pode ser utilizado:

```bash
mvnw.cmd spring-boot:run
```

Após iniciar a aplicação, acesse:

```text
http://localhost:8080
```

---

## 📚 Objetivo do Projeto

O projeto foi desenvolvido com o objetivo de aplicar conceitos de **Programação Orientada a Objetos**, desenvolvimento web com **Spring Boot**, persistência de dados utilizando **JPA/MySQL** e integração com **API externa**.

---

## 📄 Documentação da API

A documentação oficial da API utilizada está disponível em:

https://www.themealdb.com/api.php

---

## 👩‍💻 Projeto acadêmico

Projeto desenvolvido para fins acadêmicos como parte da disciplina de **Programação Orientada a Objetos**.