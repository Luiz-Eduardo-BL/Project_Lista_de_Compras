package services;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/* 
 * system inclusions
 */
import model.Cliente;



public class ServicesCliente {
	
	public static boolean validaUser(String nome) {
		if(nome.matches("[A-Z[a-z[0-9[[-._]]]]]*"))
    		return true;
    	else
    		throw new MsgException("error: nome de usuario invalido");
	}
	
	public static boolean validaSenha(String nome) {
		if(nome.matches("[A-Z[a-z[0-9[[-._]]]]]*"))
    		return true;
    	else
    		throw new MsgException("error: senha invalida");
	}
	
	public static boolean validaNome(String str) {
		if(str.matches("[A-Z[a-z]]*"))
    		return true;
    	else
    		throw new MsgException("error: nome invalido");
	}
	
	public static boolean validaCpf(String str) {
		if(str.matches("[0-9]*"))
    		return true;
    	else
    		throw new MsgException("error: CPF invalido");
	}
	
	public static boolean validaCartaoCredito(String str) {
		if(str.matches("[0-9]*"))
    		return true;
    	else
    		throw new MsgException("error: Cartao de credito invalido");
	}
	
	public static String registrar(String nome, String cpf, String cartaoCredito, 
			String nomeUser, String senha) {
		registerClienteInList(new Cliente(nome, cpf, cartaoCredito, (float)1000.0, nomeUser, senha));
		return "Cliente registrado com sucesso";
	}
	
	public static Cliente login(String nomeUser, String senha) {
		//if(nomeUser)
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
		throw new MsgException("error: usuario incorreto");
		
	}
	
	public static void logout(Cliente cliente) {
		cliente.setStatusLogin(false);
	}
	
	public static String pagarCompra(Cliente cliente) {
		if(cliente.getLimiteDisponivelCartao() < cliente.getListaDeCompras().getPrecoTotalLista()) 
			throw new MsgException("error: saldo insuficiente");
		else {
			cliente.setLimiteDisponivelCartao(cliente.getListaDeCompras().getPrecoTotalLista()); 
			List<Cliente> clientes = readListClientes();
			for(Cliente clienteLista : clientes) {
				if(cliente.getNomeUser().equals(clienteLista.getNomeUser())) {
					clienteLista.setLimiteDisponivelCartao(cliente.getLimiteDisponivelCartao());					
					break;
				}
			}
			writeListClientes(clientes);
			return "Conta paga com sucesso";
		}
	}
	
	public static void registerClienteInList(Cliente cliente) {
		try (	FileWriter clienteFile = new FileWriter("src/arquivos/clientesFile.txt", true);
				PrintWriter clienteWriter = new PrintWriter(clienteFile);)
		{   
			clienteWriter.print(String.format("%s;%s;%s;%s;%s;%s\n", cliente.getNome(), 
					cliente.getCpf(), cliente.getCartaoCredito(), 
					Float.toString(cliente.getLimiteDisponivelCartao()),
					cliente.getNomeUser(), cliente.getSenha()));
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
	}
	
	public static void writeListClientes(List<Cliente> clientes) {
		try ( 	FileWriter clienteFile = new FileWriter("src/arquivos/clientesFile.txt");
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
	
	public static List<Cliente> readListClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
        try (
                FileReader clientesFile = new FileReader("src/arquivos/clientesFile.txt");
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
