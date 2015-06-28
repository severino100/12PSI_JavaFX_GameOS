package application;

public class Encomendas {
	
	private String nome;
	private String preco;
	private String autor;
	


	public Encomendas(String preco, String nome, String autor)
	{
		this.preco = preco;
		this.nome = nome;
		this.autor = autor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
