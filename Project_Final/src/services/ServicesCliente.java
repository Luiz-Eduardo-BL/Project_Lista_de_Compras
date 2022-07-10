package services;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* 
 * system inclusions
 */
import model.Cliente;


public class ServicesCliente {
	
	public static boolean validaUser(String str) {
		if(str.equals("") || str.isEmpty())
			throw new MsgException("error: preencha todos os campos");
		else if(str.matches("[A-Z[a-z[0-9[[-._]]]]]*"))
    		return true;
    	else
    		throw new MsgException("error: nome de usuario invalido");
	}
	
	public static boolean validaSenha(String str) {
		if(str.equals("") || str.isEmpty())
			throw new MsgException("error: preencha todos os campos");
		if(str.matches("[A-Z[a-z[0-9[[-._]]]]]*"))
    		return true;
    	else
    		throw new MsgException("error: senha invalida");
	}
	
	public static boolean validaNome(String str) {
		if(str.equals("") || str.isEmpty())
			throw new MsgException("error: preencha todos os campos");
		else if(str.matches("[A-Z[a-z]]*"))
    		return true;
    	else
    		throw new MsgException("error: nome invalido");
	}
	
	public static boolean validaCpf(String str) {
		if(str.equals("") || str.isEmpty())
			throw new MsgException("error: preencha todos os campos");
		else if(str.matches("[0-9]*"))
    		return true;
    	else
    		throw new MsgException("error: CPF invalido");
	}
		
	public static String registrar(String nome, String cpf, 
			String nomeUser, String senha) {
		validaNome(nome);
		validaCpf(cpf);
		validaUser(nomeUser);
		validaSenha(senha);
		registerClienteInList(new Cliente(nome, cpf, nomeUser, senha));
		return "Cliente registrado com sucesso";
	}
	
	public static Cliente login(String nomeUser, String senha) {
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
	
	public static String efetuarPedido(Cliente cliente) {
		if(cliente.getListaDeCompras().getPrecoTotalLista() != 0) {
			registerCompraInList(cliente);
			return "Pedido efetuado com sucesso";
		}
		throw new MsgException("error: nenhum pedido no carrinho");
	}
	
	public static void registerClienteInList(Cliente cliente) {
		try (	FileWriter clienteFile = new FileWriter("arquivos/clientesFile.txt", true);
				PrintWriter clienteWriter = new PrintWriter(clienteFile);)
		{   
			clienteWriter.print(String.format("%s;%s;%s;%s\n", 
					cliente.getNome(), cliente.getCpf(), 
					cliente.getNomeUser(), cliente.getSenha()));
			
			List<Cliente> clientes = readListClientes();
			Collections.sort(clientes);
			writeListClientes(clientes);
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
	}
	
	public static void writeListClientes(List<Cliente> clientes) {
		try ( 	FileWriter clienteFile = new FileWriter("arquivos/clientesFile.txt");
				PrintWriter clienteWriter = new PrintWriter(clienteFile);)
		{   
			for (Cliente cliente : clientes) 
				clienteWriter.print(String.format("%s;%s;%s;%s\n",  
						cliente.getNome(), cliente.getCpf(),  
						cliente.getNomeUser(), cliente.getSenha()));
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
	}
	
	public static List<Cliente> readListClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
        try (
                FileReader clientesFile = new FileReader("arquivos/clientesFile.txt");
                BufferedReader clienteStream = new BufferedReader(clientesFile);
            )
        {
        	String aux = clienteStream.readLine();
            String userFields[] = aux != null? aux.split(";") : null;
            while(userFields != null) { // a null string indicates end of file
            	clientes.add(new Cliente(userFields[0], userFields[1],  
            							 userFields[2], userFields[3]));
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
	
	public static void registerCompraInList(Cliente cliente) {
		try (	FileWriter clienteFile = new FileWriter("arquivos/historicoDeComprasFile.txt", true);
				PrintWriter clienteWriter = new PrintWriter(clienteFile);)
		{  
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			StringBuilder sb = new StringBuilder();
			sb.append("----------------------------------------------------------------------------\n");
			sb.append("Data: " + dtf.format(LocalDateTime.now()) + "\n");
			sb.append("Cliente: " + cliente.getNome() + "\n");
			sb.append(cliente.getListaDeCompras() + "\n");
			sb.append("Valor total da compra: " + cliente.getListaDeCompras().getPrecoTotalLista()+ "\n");
			sb.append("----------------------------------------------------------------------------\n");
			clienteWriter.print(sb+"\n");
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
	}
}
