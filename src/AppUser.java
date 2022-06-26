import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppUser {
	private Cliente cliente;
	private static AppUser app = new AppUser();
	
	public AppUser() {
		cliente = new Cliente();
	}
	
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
		}
	}
	
	public void menuCliente() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("\nMENU USUARIO\nDigite o n da operacao que deseja executar: ");
		System.out.println("0. Sair");
		System.out.println("1. Adicionar item");
		System.out.println("2. Remover item");
		System.out.println("3. Listar itens");
		System.out.println("4. Mostrar preço total");
		System.out.println("5. Conta do cliente");
		System.out.println("-------------------------------------------------------------------------");
		
	}
	
	public int selecionaOperacaoInicial() {
		int operacao = 0;

		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String opt = null;
		do {
			try {
				opt = stdin.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());

		operacao = Integer.parseInt(opt);

		switch (operacao) {
		case 0:
			System.out.println("Encerrando programa");
			break;
			
		case 1:
			System.out.println("Digite o nome do cliente: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String nome = opt + ";";
			
			System.out.println("Digite o Id do usuario: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String nomeUser = opt + ";";
			
			System.out.println("Digite a senha do cliente: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
			String senha = opt + ";";
			cliente.registrar(nome, nomeUser, senha);
			break;
			
		case 2:
			System.out.println("Digite o nome do usuario: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());	
			nomeUser = opt;
			System.out.println("Digite a senha: ");
			do {
				try {
					opt = stdin.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while (opt.equals("\n") || opt.equals("") || opt.isEmpty());
				
			senha = opt;
			cliente = cliente.login(nomeUser, senha);
			break;
			
		default:
			System.out.println("Operacao invalida, tente outra.");
			break;
		}
		return operacao;
	}
	
	public static void main(String[] args) {
		int operacaoInicial = -1;
		while(operacaoInicial != 0) {
			try {
				app.menuInicial();
				operacaoInicial = app.selecionaOperacaoInicial();
			} catch (MsgException me) {
	            System.out.println(me.getMessage());
	        }
		}
	}
}
