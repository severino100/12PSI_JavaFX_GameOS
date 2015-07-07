package application;

public class Cliente {
	
	private String nome;
	private String idade;
	private String email;
	private String nrTelemovel;
	private String username;
	private String password;
	


	public Cliente(String idade, String nome, String email, String nrTelemovel, String username, String password)
	{
		this.idade = idade;
		this.nome = nome;
		this.email = email;
		this.nrTelemovel = nrTelemovel;
		this.username = username;
		this.password = password;
				
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNrTelemovel() {
		return nrTelemovel;
	}

	public void setNrTelemovel(String nrTelemovel) {
		this.nrTelemovel = nrTelemovel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
