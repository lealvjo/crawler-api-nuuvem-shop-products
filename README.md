# API do Crawler Shop

Esta API é um exemplo acadêmico que permite realizar operações relacionadas a um Crawler Shop, incluindo a execução do crawler para obter informações da loja (https://www.nuuvem.com/) e a manipulação dos dados do modelo NuuvemShopModel. Ressaltamos que o crawler é utilizado neste projeto exclusivamente para fins acadêmicos e de demonstração.


## Endpoints

### Executar o Crawler

URL: /product/run-crawler
Método: GET
Descrição: Executa o crawler para obter informações das lojas e salva os dados no banco de dados.

### Adicionar uma nova produto

URL: /product/add
Método: POST
Descrição: Adiciona um novo produto ao banco de dados.
Corpo da Requisição:

        {
        "product_name": "Nome do Jogo",
        "product_link": "https://exemplo.com/jogo",
        "product_pht": "https://exemplo.com/imagem",
        "product_page": "1",
        "product_price": "R$ 99,00"
        }

### Obter todas as produto

URL: /product/all
Método: GET
Descrição: Retorna uma lista com todos os produtos cadastrados no banco de dados.

### Obter um produto pelo ID

URL: /product/get-by-id/{shopId}
Método: GET
Descrição: Retorna os dados de um produto específico com base no seu ID.

### Excluir um produto pelo ID

URL: /product/delete/{shopId}
Método: DELETE
Descrição: Exclui um produto específico com base no seu ID.

### Atualizar um produto pelo ID

URL: /product/update/{shopId}
Método: PUT
Descrição: Atualiza os dados de um produto específico com base no seu ID.
Corpo da Requisição:

        {
        "product_name": "Novo Nome do Jogo",
        "product_link": "https://exemplo.com",
        "product_pht": "https://exemplo.com/imagem.jpg",
        "product_page": "https://exemplo.com/pagina",
        "product_price": 19.99
        }

## Requisitos

Certifique-se de ter as seguintes dependências no seu ambiente de desenvolvimento:

- Java 8 ou superior
- Spring Boot 2.x
- Bibliotecas necessárias para execução da aplicação e dependências do Spring Framework

## Postman

Na pasta "docs" deste repositório, você encontrará um arquivo `crawler-api.postman_collection`. Esse arquivo contém uma coleção do Postman com exemplos de requisições para os endpoints da API.

Para importar o arquivo no Postman, siga as etapas abaixo:

1. Abra o Postman e clique em "Import".
2. Selecione a opção "Import From File" e escolha o arquivo `crawler-api.postman_collection.json` da pasta "docs".
3. A coleção será importada para o seu ambiente do Postman.
4. Agora você pode explorar e executar as requisições de exemplo diretamente no Postman.

Certifique-se de ajustar as informações, como URL base e dados da requisição, conforme necessário para o seu ambiente.

## Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novos recursos para esta API. Basta fazer um fork
deste repositório, realizar as alterações desejadas e enviar um pull request.

Espero que este README seja útil para entender e utilizar a API do Crawler Shop. Se tiver alguma dúvida, não hesite em
entrar em contato.

![](https://media.giphy.com/media/LHZyixOnHwDDy/giphy.gif)