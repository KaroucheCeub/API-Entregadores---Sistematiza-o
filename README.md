# API-Entregadores---Sistematiza-o
Controle de entregadores para o projeto de sistematização

## Instruções para colocar em operação

# Requisitos
- Java 17
- PostgreSQL
  - Database: Entregas
  - Username: postgres
  - Password: 2023

# Instalação
- Clone este projeto
- Importe para o Eclipse
- Atualize as bibliotecas com o Maven
- Inicialize

# Acesso
- Abra o um gerenciador de API, como o Postman

# Utilização

Para incluir um Entregaodor
	
	- URI: http://localhost:8080/entregadores
	
	- Método: POST
	
	- Formulário JSON: nome, capacidade, cpf
	
Para listar todos os entregadores
	
	- URI: http://localhost:8080/entregadores
	
	- Método: GET
	
Para mostrar apenas um entregador
	
	- URI: http://localhost:8080/entregadores/{id}
	
	- Método: GET
	
Para excluir um entregador
	
	- URI: http://localhost:8080/entregadores/{id}
	
	- Método: DELETE

Para alterar um entregador
	
	- URI: http://localhost:8080/entregadores/{id}
	
	- Método: PUT
	
	- Formulário JSON: nome, capacidade, cpf
