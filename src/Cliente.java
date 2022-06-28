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
	private float limiteCartao;
	private ListaDeCompras listaDeCompras = new ListaDeCompras();
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String cartaoCredito, String nomeUser, String senha){
		 this.nome = nome;
		 this.cpf = cpf;
		 this.cartaoCredito = cartaoCredito;
		 this.nomeUser = nomeUser;
		 this.senha = senha;		 
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
		this.limiteCartao = 1000;
		writeListCliente();
	}
	
	public Cliente login(String nomeUser, String senha) {
		List<Cliente> clientes = readList();
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
		if(limiteCartao < getListaDeCompras().getPrecoTotalLista()) 
			throw new MsgException("error: saldo insuficiente");
		else
			limiteCartao -= getListaDeCompras().getPrecoTotalLista();
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

  	public float getSaldoConta() {
		return limiteCartao;
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
		builder.append(limiteCartao);
		builder.append("]");
		return builder.toString();
	}
	
	private void writeListCliente() {
		try (
				FileWriter clienteFile = new FileWriter("clientesFile.txt", true);
				PrintWriter clienteWriter = new PrintWriter(clienteFile);
			)
		{   
			clienteWriter.print(String.format("%s;%s;%s;%s;%s;%s\n",  getNome(), 
					getCpf(), getCartaoCredito(), getNomeUser(), getSenha(), 
					Float.toString(limiteCartao)));
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
}
	
	public List<Cliente> readList() {
		List<Cliente> clientes = new ArrayList<Cliente>();
        // use try-with-resources to ensure file is closed safely
        try (
                /* create a FileReader object that handles the low-level 
                details of reading the list from the "Cars.txt" file */
                FileReader clientesFile = new FileReader("clientesFile.txt");
                /* now create a BufferedReader object to wrap around carFile
                this allows us to user high-level functions such as readLine */
                BufferedReader clienteStream = new BufferedReader(clientesFile);
            )
        {
           	// read the first line of the file
        	String aux = clienteStream.readLine();
            String userFields[] = aux != null? aux.split(";") : null;
            while(userFields != null) { // a null string indicates end of file
            	
            	clientes.add(new Cliente(userFields[0], userFields[1], 
            			userFields[2], userFields[3], userFields[4]));
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
