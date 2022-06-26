import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
	protected String cpf;
	private String cartaoCredito;
	private float saldoConta;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String nomeUser, String senha){
		 this.nome = nome;
		 this.nomeUser = nomeUser;
		 this.senha = senha;
	}
	
	public void registrar(String nomeUsuario, String senha, String nomeCliente, String cpf) {
			this.cpf = cpf;
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
	
	public List<Cliente> readList() {
		List<Cliente> clientes = new ArrayList<Cliente>();
        String nome;
        String nomeUser;
        String senha;
        //String dataRegistro;

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
            //dataRegistro = aux[3];
            while(userFields != null) { // a null string indicates end of file
            	nome = userFields[0];
                nomeUser = userFields[1];
                senha = userFields[2]; 
            	clientes.add(new Cliente(nome, nomeUser, senha));
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

  public String getCartaoCredito() {
		return cartaoCredito;
  }

  public float getSaldoConta() {
		return saldoConta;
  }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [cpf = ");
		builder.append(cpf);
		builder.append(", cartaoCredito = ");
		builder.append(cartaoCredito);
		builder.append(", saldoConta = ");
		builder.append(saldoConta);
		builder.append("]");
		return builder.toString();
	}
}
