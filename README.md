# Project Lista de Compras

Trabalho Final da disciplina de POO desenvolvido por mim, [Luiz Eduardo](https://github.com/Luiz-Eduardo-BL) e [Hugo Santos](https://github.com/hugosantosbessa).

Nessa aplicação, o usuário poderá se registrar, passando o seu nome, cpf, um nome de usuário e senha, que será utilizado para fazer o login no sistema, essas informações serão armazenadas e lidas de um arquivo clientesFiles.txt, dentro do sistema o mesmo poderá criar sua lista de compras, adicionando itens, que serão lidos de um arquivo itensDeposito.txt,  dentro deste arquivo estarão todos os produtos (Itens) contendo seu respectivo número, nome e preço, o usuario tambem tera um desconto relacionado ao seu total de compras, a cada 100 R$ tera 10% de desconto, com um limite de 30% de desconto possível, será apresentado um valor total sem desconto e um com desconto para fins de comparação para o cliente.
Existem também as classes que se encontram na pasta Services, que são classes exclusivas para validação dos clientes, como a ServicesCliente, para alertas e para leitura e escrita das informações nos respectivos arquivos txt.

# Funcionalidades Atuais:

* ***Carrinho (Lista de compras)***

  1. ***Listar compras:*** Mostrará todas as compras adicionadas a lista, com informações como, nome, preço e quantidade;
  2. ***Adicionar item:*** Poderá adicionar itens à lista, passando o nome e a quantidade do produto, se o mesmo se encontrar no depósito;
  3. ***Remover item:*** Poderá remover algum ou todos os itens adicionados, passando seu nome;
  4. ***Atualizar quantidade:*** Poderá modificar a quantidade de itens, caso queira diminuir ou aumentar a quantidade de produtos ao invés de removê-los.
  
* ***Item***

  1. ***Calcular o preço total:*** Como cada item tem um preço unitário, caso seja selecionado mais de um item ou o mesmo item mais de uma vez, será calculado um preço total deste item com base em seu preço unitário;
  2. ***Calcular desconto:*** Como os(o) produtos(o) podem ter um preço maior que 100R$, será feito um cálculo de desconto em cima dos(o) mesmos(o);
  3. ***Calcular preço total com desconto:*** Caso os(o) produtos(o) estejam aptos a receber um desconto o preço total precisa ser atualizado com o cálculo do preço total anterior menos o desconto, tendo assim o preço final com o desconto.
  
* ***Usuário (Cliente)***

  1. ***Registrar:*** Caso o cliente não tenha cadastro, poderá cadastrar-se criando um usuário e senha, passando informações como nome, cpf, cartão de crédito, para que o sistema possa verificar a validade dos dados e colocá-lo no arquivo de clientes, dando acesso ao mesmo para fazer as compras;
  2. ***Logar:*** O cliente poderá fazer o login no sistema, para poder fazer as compras, utilizando-se do seu username e senha.

* ***Sistema (Alertas e validações)***

  1. ***Alertas:*** Caso haja algum erro, como login errado o sistema lançará uma notificação mostrando ao usuário o erro;
  2. ***Validações:*** O sistema fará as validações de nome, cpf, senha e as demais informações do usuário, caso ocorra algum erro, ele chamará a função de alerta.


## Diagrama UML
![](/out/diagrama/diagrama.png)

## Rodar arquivo Jar

Para rodar o arquivo `.Jar` utilize o codigo abaixo no terminal e na pasta onde se encontra o arquivo.

`
java --module-path (Caminho JavaFX)  --add-modules javafx.controls,javafx.base,javafx.fxml,javafx.graphics,javafx.media,javafx.web -jar (arquivo).jar
`

