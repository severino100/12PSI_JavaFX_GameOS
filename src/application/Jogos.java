package application;

import javafx.scene.image.ImageView;

public class Jogos {
	private String nome;
	private String preco;
	//private String autor;
	

	public Jogos(String preco, String nome)
	{
		this.preco = preco;
		this.nome = nome;
		//this.autor = autor;
	}
	
	public void Jogos(String preco, String nome)
	{
		this.preco = preco;
		this.nome = nome;
		//this.autor = autor;
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

	/*public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}*/
}
