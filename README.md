# API Beneficiários Ekan

## Requerimentos para rodar a API
#### É necessário fazer o download do Postgres e utilizar o PgAdmin para a persistência dos dados, é necessário criar um database antes que seja criada a tabela. A configuração para a conexão está no arquivo application.properties. 
Após realizar a conexão é necessário iniciar a aplicação para que o JPA crie as tabelas.

## Endpoints
#### http://localhost:8080/api/beneficiarios/listar
#### http://localhost:8080/api/beneficiarios/cadastrar
#### http://localhost:8080/api/beneficiarios/documentos/1352 <- id do beneficiário
#### http://localhost:8080/api/beneficiarios/atualizar/1152 <- id do beneficiário
#### http://localhost:8080/api/beneficiarios/excluir/1402 <- id do beneficiário

## URL para a documentação do Swagger
#### http://localhost:8080/swagger-ui/swagger-ui/index.html

## Exemplo de JSON para cadastar um beneficiário:
{
    "nome": "Caio",
    "telefone": "11956324511",
    "dataNascimento": "25/09/2000",
    "dadosSalvarDocumento": [
        {
            "tipoDocumento": "CPF",
            "descricao": "65743027796"
        },
        {
            "tipoDocumento": "RG",
            "descricao": "540053740"
        }
    ]   
}

![image](https://github.com/user-attachments/assets/1809c9bd-ef90-428e-8ce3-2edd15e7b88f)


## Querys
### Visualizar beneficiários e todos os seus documentos
SELECT b.beneficiario_id, b.nome, b.telefone, b.data_nascimento, d.documento_id, d.tipo_documento, d.descricao
FROM beneficiario b
LEFT JOIN documento d ON b.beneficiario_id = d.beneficiario_id;

### Visualizar todos os beneficiários
select * from beneficiario

### Visualizar todos os documentos
select * from documento

