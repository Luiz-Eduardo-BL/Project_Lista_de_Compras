package application.appTerminal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 
 * system inclusions
 */
import model.Cliente;
import services.ServicesCliente;
import services.MsgException;

public class AppUser {
	private Cliente cliente = new Cliente();
	private static AppUser app = new AppUser();
	private static int operacao = -1;
	
	public void menuInicial() {
		if(cliente.isStatusLogin())
			menuCliente();
		else {
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("\nMENU USUARIO\nDigite o n da operacao que deseja executar: ");
			System.out.println("0. Sair");
			System.out.println("1. Registrar");
			System.out.println("2. Login");	
			System.out.println("-------------------------------------------------------------------------");
			selecionaOperacaoInicial();
		}
	}
	
	public int selecionaOperacaoInicial() {
		operacao = Integer.parseInt(receiveDate());

		switch (operacao) {
		case 0:
			System.out.println("Encerrando programa");
			break;
			
		case 1:
			System.out.println("Digite o nome do cliente: ");
			String nome = receiveDate();
			ServicesCliente.validaNome(nome);
			System.out.println("Digite o cpf do cliente: ");
			String cpf = receiveDate();
			ServicesCliente.validaCpf(cpf);
			System.out.println("Digite o user do cliente: ");
			String nomeUser = receiveDate();
			System.out.println("Digite a senha do cliente: ");			
			String senha = receiveDate();
			ServicesCliente.registrar(nome, cpf, nomeUser, senha);
			break;
			
		case 2:
			System.out.println("Digite o nome do usuario: ");	
			nomeUser = receiveDate();
			System.out.println("Digite a senha: ");				
			senha = receiveDate();
			cliente = ServicesCliente.login(nomeUser, senha);
			
			//cliente = cliente.login(nomeUser, senha);
			break;
			
		default:
			System.out.println("Operacao invalida, tente outra.");
			break;
		}
		return operacao;
	}
	
	public void menuCliente() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("\nMENU USUARIO\nDigite o n da operacao que deseja executar: ");
		System.out.println("0. Logout");
		System.out.println("1. Adicionar item");
		System.out.println("2. Remover item");
		System.out.println("3. Atualizar quantidade de um produto");
		System.out.println("4. Cancelar");
		System.out.println("5. Mostrar itens do carrinho");
		System.out.println("-------------------------------------------------------------------------");
		selecionaOperacaoCliente();
	}
	
	public void selecionaOperacaoCliente() {		
		operacao = Integer.parseInt(receiveDate());
		switch (operacao) {
		case 0:
			ServicesCliente.logout(cliente);
			operacao = -1;
			break;
		case 1:
			System.out.println("Digite produto que quer adicionar ao carrinho: ");
			String nomeProduto = receiveDate();			
			System.out.println("Digite a quantidade: ");
			int quantidade = Integer.parseInt(receiveDate());
			cliente.getListaDeCompras().adicionarItem(nomeProduto, quantidade);
			break;		
		case 2:
			System.out.println("Digite produto que quer remover do carrinho: ");
			nomeProduto = receiveDate();			
			cliente.getListaDeCompras().removerItem(nomeProduto);
			break;
		case 3:
			System.out.println("Digite o nome do produto que deseja atualizar a quantidade: ");
			nomeProduto = receiveDate();			
			System.out.println("Digite a quantidade que quer atualizar: ");
			quantidade = Integer.parseInt(receiveDate());
			cliente.getListaDeCompras().atualizarQuantidade(nomeProduto, quantidade);
			break;
		case 4:
			cliente.getListaDeCompras().cancelarCompra();
			break;
		case 5:
			System.out.println(cliente.getListaDeCompras().toString()); 
			break;
		case 6:
			System.out.println(ServicesCliente.efetuarPedido(cliente)); 
			break;	
		default:
			System.out.println("Operacao invalida, tente outra.");
			break;
		}
	}
	
	
	private String receiveDate() {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String opt = null;
		do {
			try {
				opt = stdin.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
		return opt;	
	}
	
	public static void main(String[] args) {
		
		while(operacao != 0) {
			try {
				app.menuInicial();
			} catch (MsgException me) {
	            System.out.println(me.getMessage());
	        }
		}
	}
}
