import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        String nomeCliente = sc.nextLine();
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = sc.nextLine();
        System.out.println("Digite a quantidade do produto: ");
        int quantidade = sc.nextInt();
        System.out.println("Digite o Cartao de Credito: ");
        String cartaoCredito = sc.next();
        System.out.println("Digite o CPF: ");
        String cpf = sc.next();
        System.out.println("Digite o nome do usuario: ");
        String nomeUsuario = sc.next();
        System.out.println("Digite a senha: ");
        String senha = sc.next();

        // Criando o clientes
        Cliente cliente = new Cliente();
        cliente.setNome(nomeCliente);
        cliente.setNomeUser(nomeCliente);
        cliente.setSenha(nomeCliente);
        cliente.setCpf(nomeCliente);
        cliente.validaCartaoCredito(nomeCliente);
        cliente.validaCpf(nomeCliente);
        cliente.registrar(nomeCliente, nomeCliente, nomeCliente, nomeCliente);
        cliente.login(nomeCliente, nomeCliente);
        cliente.setStatusLogin(true);


        //mostrando o clientes
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Nome de usuario: " + cliente.getNomeUser());
        System.out.println("Senha: " + cliente.getSenha());
        System.out.println("CPF: " + cliente.getClass());
        System.out.println("Cartao de credito: " + cliente.getCartaoCredito());
        System.out.println("Saldo da conta: " + cliente.getSaldoConta());
        System.out.println("Status de login: " + cliente.isStatusLogin());


    }
}
