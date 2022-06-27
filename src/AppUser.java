import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppUser {
	private Cliente cliente = new Cliente();
	private static AppUser app = new AppUser();
	private static int operacao = -1;
	
	public void menuInicial() {
		if(cliente.verificarLogin())
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
		int operacao = 0;
		operacao = Integer.parseInt(receiveDate());

		switch (operacao) {
		case 0:
			System.out.println("Encerrando programa");
			break;
			
		case 1:
			System.out.println("Digite o nome do cliente: ");
			String nome = receiveDate();
			System.out.println("Digite o Id do usuario: ");
			String nomeUser = receiveDate();
			System.out.println("Digite a senha do cliente: ");			
			String senha = receiveDate();
			
			cliente.registrar(nome, nomeUser, senha);
			break;
			
		case 2:
			System.out.println("Digite o nome do usuario: ");	
			nomeUser = receiveDate();
			System.out.println("Digite a senha: ");				
			senha = receiveDate();
			cliente = cliente.login(nomeUser, senha);
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
		System.out.println("4. Efetuar");
		System.out.println("5. Cancelar");
		System.out.println("6. Pagar");
		System.out.println("-------------------------------------------------------------------------");
		selecionaOperacaoCliente();
	}
	
	public void selecionaOperacaoCliente() {		
		operacao = Integer.parseInt(receiveDate());
		switch (operacao) {
		case 0:
			cliente.logout();
			operacao = -1;
			break;
		//Apenas o esqueleto, metodo precisa ser implementado
		case 1:
			System.out.println("Digite produto que quer adicionar ao carrinho: ");
			String nomeProduto = receiveDate();			
			System.out.println("Digite a quantidade: ");
			String quantidade = receiveDate();
			//cliente.listaDeCompras.adicionarItem(nomeProduto, quantidade);
			break;		
		//Apenas o esqueleto, metodo precisa ser implementado
		case 2:
			System.out.println("Digite produto que quer remover do carrinho: ");
			nomeProduto = receiveDate();			
			//cliente.listaDeCompras.removerItem(nomeProduto);
			break;
		//Apenas o esqueleto, metodo precisa ser implementado	
		case 3:
			System.out.println("Digite o nome do produto que deseja atualizar a quantidade: ");
			nomeProduto = receiveDate();			
			System.out.println("Digite a quantidade que quer atualizar: ");
			quantidade = receiveDate();
			//cliente.listaDeCompras.atualizarQuantidadeItem(nomeProduto, quantidade);
			break;
		//Apenas o esqueleto, metodo precisa ser implementado	
		case 4:
			//cliente.listaDeCompras.efetuar();
			break;
		//Apenas o esqueleto, metodo precisa ser implementado	
		case 5:
			//cliente.listaDeCompras.cancelar();
			break;
		//Apenas o esqueleto, metodo precisa ser implementado	
		case 6:
			//cliente.listaDeCompras.pagar();
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
