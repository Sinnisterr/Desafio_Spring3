# 🧑‍💼 Sistema de Gerenciamento de Clientes

Uma API REST completa para gerenciar clientes, desenvolvida em **Java + Spring Boot** como projeto de aprendizado
do curso da DevSuperior Professor Nelio Alves.

## 📋 Sobre o Projeto

Este é um sistema CRUD (Create, Read, Update, Delete) para gerenciamento de clientes, onde é possível:

- ✅ **Cadastrar** novos clientes
- ✅ **Listar** todos os clientes (com paginação)
- ✅ **Buscar** cliente por ID
- ✅ **Atualizar** dados de um cliente
- ✅ **Deletar** um cliente

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Data JPA** - Para acesso ao banco de dados
- **Spring Validation** - Para validação de dados
- **H2 Database** - Banco de dados em memória
- **Maven** - Gerenciador de dependências

## 📁 Estrutura do Projeto

```
src/main/java/
├── controllers/          # Controladores REST
│   ├── ClientController.java
│   └── handlers/
│       └── ControllerExceptionHandler.java
├── dto/                  # Objetos de transferência de dados
│   ├── ClientDTO.java
│   ├── CustomError.java
│   ├── ValidationError.java
│   └── FieldMessage.java
├── entities/             # Entidades JPA
│   └── Client.java
├── repositories/         # Interfaces de acesso aos dados
│   └── ClientRepository.java
├── services/            # Lógica de negócio
│   ├── ClientService.java
│   └── exceptions/
│       └── ResourceNotFoundException.java
└── config/              # Configurações
    └── WebConfig.java
```

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.6+

### Passos
1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/sistema-clientes.git
   cd sistema-clientes
   ```

2. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```

3. **Acesse a API:**
   - URL base: `http://localhost:8080`
   - Banco H2 Console: `http://localhost:8080/h2-console`

## 📊 Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/clients` | Lista todos os clientes (paginado) |
| `GET` | `/clients/{id}` | Busca cliente por ID |
| `POST` | `/clients` | Cadastra novo cliente |
| `PUT` | `/clients/{id}` | Atualiza cliente existente |
| `DELETE` | `/clients/{id}` | Remove cliente |

## 📝 Exemplo de Cliente (JSON)

```json
{
  "name": "João Silva",
  "cpf": "123.456.789-00",
  "income": 5000.00,
  "birthDate": "1990-05-15",
  "children": 2
}
```

## ✅ Validações Implementadas

- **Nome:** 3 a 80 caracteres, obrigatório
- **CPF:** Obrigatório
- **Renda:** Valor positivo, obrigatório
- **Data de Nascimento:** Obrigatória
- **Filhos:** Número não negativo

## 🔧 Funcionalidades Técnicas

### Tratamento de Erros
- **404** - Cliente não encontrado
- **422** - Dados inválidos (com detalhes dos campos)
- **500** - Erro interno do servidor

### Resposta de Erro (Exemplo)
```json
{
  "timestamp": "2025-06-09T15:30:00Z",
  "status": 422,
  "error": "Dados inválidos",
  "path": "/clients",
  "errors": [
    {
      "fieldName": "name",
      "message": "Nome precisa ter de 3 a 80 caracteres"
    }
  ]
}
```

### CORS Configurado
- Permite requisições de `localhost:5500` (para desenvolvimento frontend)

## 🎯 O que Aprendi

Este projeto me permitiu colocar em prática:

- **API REST** com Spring Boot
- **Arquitetura em camadas** (Controller → Service → Repository)
- **Validação de dados** com Bean Validation
- **Tratamento de exceções** personalizado
- **Paginação** de resultados
- **Configuração de CORS**
- **Padrões HTTP** (códigos de status, headers)
- **DTO Pattern** para transferência de dados

## 🤝 Como Contribuir

Este é um projeto de estudo, mas sugestões são bem-vindas!

1. Fork o projeto
2. Crie uma branch (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📫 Contato

- **LinkedIn:** (https://www.linkedin.com/in/willian-bruno-28924082/)
- **Email:** willianbruno@msn.com

---

⭐ **Gostou do projeto?** Deixe uma estrela no repositório!

> 💡 **Desenvolvido durante o curso:** Este projeto foi desenvolvido como parte dos meus estudos em programação Java e Spring Boot.
