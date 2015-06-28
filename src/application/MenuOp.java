package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuOp {
	
	static boolean resposta;
	
	
	public static Scene menuFunc(){
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          fUNCIONARIO                        -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		
		Menu menuJogos =new Menu("_Jogos");
		
		MenuItem jogosAddFunc = new MenuItem("Adicionar Jogo"));
		MenuItem jogosEditFunc = new MenuItem("Alterar Jogo"));
		MenuItem jogosDeleteFunc = new MenuItem("Eliminar Jogo"));
		
		
		
		Menu menuCliente = new Menu("C_liente");
		menuCliente.getItems().add(new MenuItem("Adicionar Cliente"));
		menuCliente.getItems().add(new MenuItem("Alterar Cliente"));
		menuCliente.getItems().add(new MenuItem("Eliminar Cliente"));
		
		
		
		Menu menuEncomendas = new Menu("E_ncomendas");
		MenuItem fazerEncFunc = new MenuItem("Fazer uma Encomenda");
		MenuItem alterarEncFunc = new MenuItem("Alterar uma Encomenda");
		MenuItem eliminarEncFunc = new MenuItem("Eliminar uma Encomenda");
		
		
		Menu menuSaidaFunc = new Menu("S_air");
		menuSaidaFunc.getItems().add(new MenuItem("Fechar Programa"));
		menuSaidaFunc.getItems().add(new MenuItem("Terminar Sess�o"));
		//Passo 3
		
		MenuBar menuBar = new MenuBar();
		menuBar.setStyle("-fx-background-color: #803300;");
		menuBar.getMenus().addAll(menuJogos, menuCliente, menuEncomendas, menuSaidaFunc);
		
		
		BorderPane funcionario = new BorderPane();
		Scene sceneFuncionario = new Scene(funcionario,520,200);
		funcionario.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;-fx-background-color: #1A0A00;");
		funcionario.setTop(menuBar);
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          Termina                            -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		return sceneFuncionario;
		
		
	}
	
	/*----------------------------------------------------------------------
	 *----                                                             -----
	 *----                    Funcionarios Opcoes                      -----
	 *----                                                             ----- 
	 *----------------------------------------------------------------------*/
//public static Scene menuOpFuncVenderJogo(){
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          fUNCIONARIO                        -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		
		/*if()
		
		
		BorderPane funcionario = new BorderPane();
		Scene sceneFuncionario = new Scene(funcionario,520,200);
		funcionario.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;-fx-background-color: #1A0A00;");
		funcionario.setTop(menuBar);*/
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          Termina                            -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		//return sceneFuncionario;
		
		
	//}
	public static Scene menuCliente(){
			
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          CLIENTE                            -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		
		Menu menuConsultas =new Menu("_Jogos");
		
		MenuItem jogoCompraFunc = new MenuItem("Comprar Jogo");			
		menuConsultas.getItems().add(jogoCompraFunc);
		
		Menu menuEncomenda = new Menu("E_ncomendas");
		
		MenuItem fazerEncFunc = new MenuItem("Fazer uma Encomenda");
		MenuItem alterarEncFunc = new MenuItem("Alterar uma Encomenda");
		MenuItem eliminarEncFunc = new MenuItem("Eliminar uma Encomenda");

		menuEncomenda.getItems().addAll(fazerEncFunc, alterarEncFunc, eliminarEncFunc);
		
		Menu menuSaida = new Menu("S_air");
		MenuItem sairFunc = new MenuItem("Fechar Programa");
		MenuItem terminarSessaoFunc = new MenuItem("Terminar Sess�o");
		
		menuSaida.getItems().addAll(sairFunc, terminarSessaoFunc);
		
		//Passo 3
		
		MenuBar menuBarCliente = new MenuBar();
		menuBarCliente.setStyle("-fx-background-color: #00001A;");
		menuBarCliente.getMenus().addAll(menuConsultas, menuEncomenda, menuSaida);
		//cliente
		BorderPane cliente = new BorderPane();
		cliente.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;-fx-background-color: #00004C;");
		Scene sceneCliente = new Scene(cliente,520,200);
		cliente.setTop(menuBarCliente);
		
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          Termina                            -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		return sceneCliente;
	}
	
	//ALERTBOX para a exercicio  05a ModalWindow_AlertBox
		public static void alertBox(String title, String msg){ //Static para não ser instanciada
			
			Stage janela = new Stage();							//Cria uma window
			//janela.initModality(Modality.APPLICATION_MODAL);	//Define uma janela Modal
			janela.initModality(Modality.WINDOW_MODAL);	//Define uma janela Modal
			janela.setTitle(title); 							//Como título, recebe a string do parametro
			janela.setMinWidth(200);							//Largura da janela
			
			Label mensagem = new Label(msg); 					//Cria a label para mostra
			Button btnClose = new Button("Fechar");				//Cria botão para fechar janela
			btnClose.setOnAction(e -> janela.close());			//Ação fecha esta janela
			
			VBox layout = new VBox(10);							//Layout vertical com 10px entre células
			layout.getChildren().addAll(mensagem, btnClose);	//Adiciona Label e Button ao layout
			layout.setAlignment(Pos.CENTER);					//Alinhar os cnteudos ao Centros
			
			Scene scene = new Scene(layout);					//Criar a Scene e associa o Layout
			janela.setScene(scene);								//Associa a Scena 
			janela.showAndWait();								//Executa e prende o controlo até ser fechada
			
			
		}
		
		public static boolean confirmationBox(String title, String msg){ //Static para não ser instanciada
			
			Stage janela = new Stage();							//Cria uma window
			//janela.initModality(Modality.APPLICATION_MODAL);	//Define uma janela Modal
			janela.initModality(Modality.WINDOW_MODAL);	//Define uma janela Modal
			janela.setTitle(title); 							//Como título, recebe a string do parametro
			janela.setMinWidth(200);							//Largura da janela
			
			Label mensagem = new Label(msg); 					//Cria a label para mostra
			Button btnTrue = new Button("Sim");				//Cria botão para fechar janela
			btnTrue.setOnAction(e -> {
				resposta = true;
				janela.close();			//Ação fecha esta janela
			});
			Button btnFalse = new Button("Não");
			btnFalse.setOnAction(e -> {
				resposta = false;
				janela.close();			//Ação fecha esta janela
			});
			
			VBox layout = new VBox(10);							//Layout vertical com 10px entre células
			VBox layout1 = new VBox(10);
			layout.getChildren().addAll(mensagem, layout1);
			layout.setAlignment(Pos.CENTER);
			
			layout1.getChildren().addAll(btnTrue, btnFalse);
		
			
			Scene scene = new Scene(layout);					//Criar a Scene e associa o Layout
			janela.setScene(scene);								//Associa a Scena 
			janela.showAndWait();								//Executa e prende o controlo até ser fechada
			
			return resposta;
		}

}
