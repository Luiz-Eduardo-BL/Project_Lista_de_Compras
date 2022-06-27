import java.util.Date;

abstract class Usuario {
	protected String nome;
	protected String nomeUser;
	protected String senha;
	private boolean statusLogin = false;
	private Date dataRegistro;
	
	public Usuario() {

	}
	
	/*public void registrar(String nome, String nomeUsuario, String senha) {
		this.nome = nome;
		this.nomeUser = nomeUsuario;
		this.senha = senha;
		this.dataRegistro = new Date();
	}*/
	
	public boolean verificarLogin() {
		if(nomeUser.equals(nome) && senha.equals(senha)) {
			statusLogin = true;
			return true;
		}
		else{
			statusLogin = false;
			throw new MsgException("error: usuario ou senha incorreta");
		}
	}
	
	public boolean validaNome(String nome) {
		if(nome.matches("[A-Z[ ]]*"))
    		return true;
    	else
    		throw new MsgException("error: nome invalido");
	}
	
	public boolean validaUser(String nome) {
		if(nome.matches("[A-Z[a-z[0-9[[-._]]]]]*"))
    		return true;
    	else
    		throw new MsgException("error: nome de usuario invalido");
	}
	
	public void logout() {
		statusLogin = false;
	}

	public boolean validaSenha(String nome) {
		if(nome.matches("[A-Z[a-z[0-9[[-._]]]]]*"))
    		return true;
    	else
    		throw new MsgException("error: senha invalida");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeUser() {
		return nomeUser;
	}

	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isStatusLogin() {
		return statusLogin;
	}

	public void setStatusLogin(boolean statusLogin) {
		this.statusLogin = statusLogin;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}	
