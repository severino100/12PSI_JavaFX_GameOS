package application;

import javafx.scene.image.ImageView;

public class Jogos {
	private String nome;
	private String preco;

	

	public Jogos(String preco, String nome)
	{
		this.preco = preco;
		this.nome = nome;
	}
	
	public void Jogos2(String preco, String nome)
	{
		this.preco = preco;
		this.nome = nome;
		
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

	
}
