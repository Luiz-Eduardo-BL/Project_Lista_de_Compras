import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
	private String cpf;
	private String cartaoCredito;
	private float limiteDisponivelCartao;
	private ListaDeCompras listaDeCompras = new ListaDeCompras();
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String cartaoCredito, 
			float limiteDisponivelCartao, String nomeUser, String senha){
		 this.nome = nome;
		 this.cpf = cpf;
		 this.cartaoCredito = cartaoCredito;
		 this.nomeUser = nomeUser;
		 this.senha = senha;
		 this.limiteDisponivelCartao = limiteDisponivelCartao;
	}
	
	public boolean validaCpf(String nome) {
		if(nome.matches("[0-9]*"))
    		return true;
    	else
    		throw new MsgException("error: CPF invalido");
	}
	
	public boolean validaCartaoCredito(String nome) {
		if(nome.matches("[0-9]*"))
    		return true;
    	else
    		throw new MsgException("error: Cartao de credito invalido");
	}

	public void registrar(String nome, String cpf, String cartaoCredito, 
			String nomeUser, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.cartaoCredito = cartaoCredito;			
		this.nomeUser = nomeUser;
		this.senha = senha;
		this.limiteDisponivelCartao = 1000;
		registerClienteInList();
	}
	
	public Cliente login(String nomeUser, String senha) {
		List<Cliente> clientes = readListClientes();
		for (Cliente cliente : clientes) { 
			if(cliente.getNomeUser().equals(nomeUser)) {
				if(senha.equals(cliente.getSenha())) {
					cliente.setStatusLogin(true);
					return cliente;
				}
				else
					throw new MsgException("error: senha incorreta");
			}
		}
		throw new MsgException("error: usuario incorreta");
		
	}



	public void pagarCompra() {
		if(limiteDisponivelCartao < getListaDeCompras().getPrecoTotalLista()) 
			throw new MsgException("error: saldo insuficiente");
		else {
			limiteDisponivelCartao -= getListaDeCompras().getPrecoTotalLista();
			List<Cliente> clientes = readListClientes();
			for (Cliente cliente : clientes) {
				if(getNomeUser().equals(cliente.getNomeUser())) {
					cliente.setLimiteDisponivelCartao(limiteDisponivelCartao);
					break;
				}
			}
			writeListClientes(clientes);
			
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}
	
	public void setLimiteDisponivelCartao(float limiteDisponivelCartao) {
		this.limiteDisponivelCartao = limiteDisponivelCartao;
	}
	
  	public float getLimiteDisponivelCartao() {
		return limiteDisponivelCartao;
  	}
  

  	public ListaDeCompras getListaDeCompras() {
		return listaDeCompras;
	}

	public void setListaDeCompras(ListaDeCompras listaDeCompras) {
		this.listaDeCompras = listaDeCompras;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [cpf = ");
		builder.append(cpf);
		builder.append(", cartaoCredito = ");
		builder.append(cartaoCredito);
		builder.append(", limiteCartao = ");
		builder.append(limiteDisponivelCartao);
		builder.append("]");
		return builder.toString();
	}
	
	private void registerClienteInList() {
		try (
				FileWriter clienteFile = new FileWriter("clientesFile.txt", true);
				PrintWriter clienteWriter = new PrintWriter(clienteFile);
			)
		{   
			clienteWriter.print(String.format("%s;%s;%s;%s;%s;%s\n",  getNome(), 
					getCpf(), getCartaoCredito(), Float.toString(limiteDisponivelCartao),
					getNomeUser(), getSenha()
					));
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
	}
	
	private void writeListClientes(List<Cliente> clientes) {
		try ( 	FileWriter clienteFile = new FileWriter("clientesFile.txt");
				PrintWriter clienteWriter = new PrintWriter(clienteFile);)
		{   
			for (Cliente cliente : clientes) 
				clienteWriter.print(String.format("%s;%s;%s;%s;%s;%s\n",  
						cliente.getNome(), cliente.getCpf(), cliente.getCartaoCredito(), 
						Float.toString(cliente.getLimiteDisponivelCartao()), 
						cliente.getNomeUser(), cliente.getSenha()));
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
	}
	
	public List<Cliente> readListClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
        try (
                FileReader clientesFile = new FileReader("clientesFile.txt");
                BufferedReader clienteStream = new BufferedReader(clientesFile);
            )
        {
        	String aux = clienteStream.readLine();
            String userFields[] = aux != null? aux.split(";") : null;
            while(userFields != null) { // a null string indicates end of file
            	clientes.add(new Cliente(userFields[0], userFields[1], 
            							 userFields[2], Float.parseFloat(userFields[3]), 
            							 userFields[4], userFields[5]));
            	aux = clienteStream.readLine();
            	userFields = aux != null? aux.split(";") : null;
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("\nerror: No file was read");
        }
        catch(IOException e) {
            System.out.println("\nerror: There was a problem reading the file");
        }
        
        return clientes;
    }
}
