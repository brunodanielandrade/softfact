# SoftFact - Sistema de Gestão de Projetos Acadêmicos

## 👨🎓 Desenvolvido por
**Luís Gustavo Maia C. Santos & Bruno Daniel de Andrade Pereira**

---

## 📋 Sobre o Projeto

SoftFact é uma **API REST** desenvolvida em **Spring Boot** para gerenciamento de projetos acadêmicos, permitindo o controle completo de alunos, projetos, tarefas e tecnologias utilizadas no desenvolvimento.

## 🚀 Tecnologias

| Tecnologia | Versão | Finalidade |
|------------|--------|------------|
| Java | 21 | Linguagem principal |
| Spring Boot | 3.5.6 | Framework web |
| Spring Data JPA | - | Persistência de dados |
| PostgreSQL | - | Banco de dados |
| Maven | - | Gerenciamento de dependências |
| Lombok | - | Redução de código boilerplate |

## 📊 Arquitetura

### Entidades do Sistema
- 🎓 **Aluno** - Estudantes cadastrados
- 📁 **Projeto** - Projetos acadêmicos
- ✅ **Tarefa** - Atividades dos projetos
- 🛠️ **Stack** - Tecnologias utilizadas
- 🏆 **Certificado** - Certificações dos alunos

### Relacionamentos
```
Aluno ↔ Projeto (Many-to-Many)
Projeto ↔ Stack (Many-to-Many)
Projeto → Tarefa (One-to-Many)
Aluno → Tarefa (One-to-Many)
Aluno → Certificado (One-to-Many)
```

## ⚙️ Configuração

### Pré-requisitos
- ☕ Java 21+
- 🐘 PostgreSQL
- 📦 Maven

### Setup do Banco
```sql
CREATE DATABASE softfact_db;
```

### Configuração (`application.yml`)
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/softfact_db
    username: postgres
    password: adm
```

### Executar
```bash
mvn spring-boot:run
```

**🌐 API disponível em:** `http://localhost:8080`

---

# 📚 Endpoints da API

## 👥 Alunos

### `POST /alunos`
**Criar novo aluno no sistema**

![Criar Aluno](docs/images/criar-aluno.png)

### `GET /alunos`
**Listar todos os alunos cadastrados**

![Listar Alunos](docs/images/listar-alunos.png)

### `GET /alunos/{id}`
**Buscar aluno específico por ID**

![Buscar Aluno](docs/images/buscar-aluno.png)

### `PUT /alunos/{id}`
**Atualizar dados de um aluno**

![Atualizar Aluno](docs/images/atualizar-aluno.png)

### `DELETE /alunos/{id}`
**Remover aluno do sistema**

![Deletar Aluno](docs/images/deletar-aluno.png)

---

## 🛠️ Stacks

### `POST /stacks`
**Cadastrar nova tecnologia/stack**

![Criar Stack](docs/images/criar-stack.png)

### `GET /stacks`
**Listar todas as stacks disponíveis**

![Listar Stacks](docs/images/listar-stacks.png)

### `GET /stacks/{id}`
**Buscar stack específica por ID**

![Buscar Stack](docs/images/buscar-stack.png)

### `PUT /stacks/{id}`
**Atualizar informações de uma stack**

![Atualizar Stack](docs/images/atualizar-stack.png)

### `DELETE /stacks/{id}`
**Remover stack do sistema**

![Deletar Stack](docs/images/deletar-stack.png)

---

## 📁 Projetos

### `POST /projetos`
**Criar novo projeto acadêmico**

![Criar Projeto](docs/images/criar-projeto.png)

### `GET /projetos`
**Listar todos os projetos**

![Listar Projetos](docs/images/listar-projetos.png)

### `GET /projetos/{id}`
**Buscar projeto específico por ID**

![Buscar Projeto](docs/images/buscar-projeto.png)

### `PUT /projetos/{id}`
**Atualizar dados de um projeto**

![Atualizar Projeto](docs/images/atualizar-projeto.png)

### `DELETE /projetos/{id}`
**Remover projeto do sistema**

![Deletar Projeto](docs/images/deletar-projeto.png)

---

## ✅ Tarefas

### `POST /tarefas`
**Criar nova tarefa em um projeto**

![Criar Tarefa](docs/images/criar-tarefa.png)

### `GET /tarefas`
**Listar todas as tarefas**

![Listar Tarefas](docs/images/listar-tarefas.png)

### `GET /tarefas/{id}`
**Buscar tarefa específica por ID**

![Buscar Tarefa](docs/images/buscar-tarefa.png)

### `PUT /tarefas/{id}`
**Atualizar dados de uma tarefa**

![Atualizar Tarefa](docs/images/atualizar-tarefa.png)

### `DELETE /tarefas/{id}`
**Remover tarefa do sistema**

![Deletar Tarefa](docs/images/deletar-tarefa.png)

---

## 📋 Valores Aceitos

| Campo | Valores Possíveis |
|-------|-------------------|
| **Curso** | `CIENCIA_DA_COMPUTACAO`, `ENGENHARIA_DA_COMPUTACAO`, `SISTEMAS_DE_INFORMACAO`, `ANALISE_E_DESENVOLVIMENTO_DE_SISTEMAS`, `ENGENHARIA_DE_SOFTWARE` |
| **Período** | `P1`, `P2`, `P3`, `P4`, `P5`, `P6`, `P7`, `P8`, `P9`, `P10` |
| **Status Tarefa** | `PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`, `CANCELADA` |
| **Prioridade** | `BAIXA`, `MEDIA`, `ALTA`, `CRITICA` |
| **Status Projeto** | `PLANEJAMENTO`, `EM_DESENVOLVIMENTO`, `EM_TESTE`, `CONCLUIDO`, `CANCELADO` |

---

## 🧪 Como Testar

### 📦 Collection Postman
Importe o arquivo `SoftFact_API.postman_collection.json` no Postman para ter todos os endpoints pré-configurados.

### 🔄 Ordem de Teste Recomendada
1. 👥 **Alunos** → Criar pelo menos 2
2. 🛠️ **Stacks** → Criar pelo menos 2  
3. 📁 **Projetos** → Usar IDs dos alunos e stacks
4. ✅ **Tarefas** → Usar IDs do projeto e aluno
5. 🔄 **Atualizações e consultas**
6. 🗑️ **Exclusões**

---

## 🏗️ Arquitetura do Código

```
src/main/java/br/edu/uniesp/softfact/
├── 📋 application/     # DTOs e requests/responses
├── 🌐 boundaries/rest/ # Controllers REST
├── ⚙️ config/         # Configurações
├── 🎯 domain/         # Interfaces de serviços
├── 🏗️ infra/         # Implementações e entidades JPA
└── 🔧 shared/         # Enums e classes base
```

## ✅ Validações Implementadas

- 🔒 **Campos obrigatórios** com `@NotNull` e `@NotBlank`
- 📏 **Tamanhos limitados** conforme regras de negócio
- 📧 **Emails válidos** com `@Email`
- 🆔 **Unicidade** de email e matrícula
- 🔗 **Relacionamentos** validados

## 📊 Códigos de Resposta HTTP

| Código | Status | Descrição |
|--------|--------|-----------|
| `200` | ✅ OK | Operação realizada com sucesso |
| `201` | ✅ Created | Recurso criado com sucesso |
| `400` | ❌ Bad Request | Dados inválidos na requisição |
| `404` | ❌ Not Found | Recurso não encontrado |
| `500` | ❌ Internal Error | Erro interno do servidor |

---

## 🎓 Projeto Acadêmico

**Disciplina:** Backend Avançado - UNIESP  
**Objetivo:** Demonstrar implementação completa de API REST com Spring Boot e Integração a um Banco de Dados Relacional

### 🔧 Recursos Demonstrados
- ✅ Arquitetura em camadas
- ✅ Relacionamentos JPA complexos
- ✅ Validações robustas
- ✅ Tratamento de exceções
- ✅ Documentação completa

---