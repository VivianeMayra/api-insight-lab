# API Courses

O projeto **API Insight-lab** é um serviço web RESTful desenvolvido com Spring Boot, projetado para gerenciar os fornecedores de determinada organização. Esta API fornece endpoints para criar, atualizar, recuperar e deletar fornecedores.

## Funcionalidades

- **Criar Fornecedores**: Adicionar novos fornecedores ao sistema.
- **Listar Fornecedores**: Recuperar todos os fornecedores ou filtrar por status.
- **Atualizar Fornecedor**: Modificar detalhes do fornecedor existente pelo id.
- **Deletar Fornecedor**: Remover fornecedor do sistema pelo id.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework utilizado para construir a API.
- **Hibernate**: ORM para interações com o banco de dados.
- **JPA**: API de Persistência Java para persistência de dados.
- **Lombok**: Reduz código boilerplate para classes modelo.
- **PostgreSQL**: Banco de dados utilizado para armazenar os dados dos cursos.
- **Docker**: Utilizado para criar e gerenciar o banco de dados PostgresSQL.

### Propriedades que um forcenedor deve ter:

- id : Identificador único de cada fornecedor
- name : Nome do fornecedor
- cnpj : Cadastro Nacional de Pessoa Jurídica válido
- address : Endereço do fornecedor
- phone: Telefone do fornecedor
- email : Email do fornecedor
- website: Site do fornecedor
- description: Descrição do fornecedor
- status: Status do fornecedor se ele está ativo (ACTIVE), inativo(INACTIVE) ou em análise(UNDER_ANALYSIS)
- createdAT : Data de criação de cada fornecedor no sistema
- updatedAT : Deve ser alterado para a data de quando o fornecedor for atualizado automaticamente

### Rotas:

- POST - /fornecedores/
- GET - /fornecedores/
- PUT - /fornecedores/:id
- DELETE - /fornecedores/:id
