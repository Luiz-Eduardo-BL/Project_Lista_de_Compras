package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;

abstract class Usuario {
	protected String nome;
	protected String nomeUser;
	protected String senha;
	private boolean statusLogin = false;
	private String dataRegistro = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());;
	
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

	public String getDataRegistro() {
		return dataRegistro;
	}


}	
