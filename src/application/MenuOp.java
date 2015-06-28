package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuOp {
	
	static boolean resposta;
	static BorderPane funcionario = new BorderPane();
	static BorderPane cliente = new BorderPane();
	static TableView<Jogos> tableAlunos = new TableView<>();
	static ObservableList<Jogos> listaAlunos = FXCollections.observableArrayList();
	
	public static Scene menuFunc(){
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          fUNCIONARIO                        -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		//BorderPane funcionario = new BorderPane();
		
		Menu menuJogos =new Menu("_Jogos");
		
		MenuItem jogosAddFunc = new MenuItem("Adicionar Jogo");
		
		jogosAddFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Jogos, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Jogos, String> colunaNumero = new TableColumn<>("Preço");
			colunaNome.setMinWidth(300);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			
			//Coluna Numero
			
			colunaNumero.setMinWidth(300);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableAlunos.getColumns().addAll( colunaNome,colunaNumero);
			
			//Carregar a lista com dados
			tableAlunos.setItems( carregarListaAlunos() );
			
			//Campo Nª
			TextField txtNumAluno = new TextField();
			txtNumAluno.setPromptText("Preço");
			txtNumAluno.setMinWidth(120);
			txtNumAluno.setMaxWidth(120);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Nome");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAluno.setMaxWidth(120);
			
			//Botões para adicionar
			Button btnAdd = new Button("Adicionar");	//Botão Adicionar
			btnAdd.setOnAction(a -> {
				/* Se um dos campos estiver vazio, emite msg
				 * Caso contrário, passa os dados para o método addAluno()*/
				
				if(txtNumAluno.getText().isEmpty() || txtNomeAluno.getText().isEmpty()) {
					MenuOp.alertBox("ERRO",  "Preencha os campos");
				}
				else {
					//TODO
					//Se txtNumAluno não é número => ERRO
					//Se txtNomeAluno não é texto => ERRO
					
					Jogos novoJogo = new Jogos(
						txtNumAluno.getText(),
							txtNomeAluno.getText());
							//new ImageView(new Image("/images/setor.jpg"))
					
					tableAlunos.getItems().add(novoJogo);
					
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableAlunos, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		
		
		
		
		
		
		
		
		
		MenuItem jogosEditFunc = new MenuItem("Alterar Jogo");
		
		
		
		
		
		jogosEditFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    
		    
		    TableColumn<Jogos, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Jogos, String> colunaNumero = new TableColumn<>("Preço");
			
			
			colunaNome.setMinWidth(300);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			
			//Coluna Numero
			
			colunaNumero.setMinWidth(300);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableAlunos.getColumns().addAll( colunaNome,colunaNumero);
			
			//Carregar a lista com dados
			tableAlunos.setItems( carregarListaAlunos() );
			
			//Campo Nª
			TextField txtNumAluno = new TextField();
			txtNumAluno.setPromptText("Preço");
			txtNumAluno.setMinWidth(120);
			txtNumAluno.setMaxWidth(120);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Nome");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAluno.setMaxWidth(120);
			
			//Botões para adicionar
			Button btnAdd = new Button("Alterar");	//Botão Adicionar
			btnAdd.setOnAction(a -> {
				/* Se um dos campos estiver vazio, emite msg
				 * Caso contrário, passa os dados para o método addAluno()*/
				
				if(txtNumAluno.getText().isEmpty() || txtNomeAluno.getText().isEmpty()) {
					MenuOp.alertBox("ERRO",  "Preencha os campos");
				}
				else {
					//TODO
					//Se txtNumAluno não é número => ERRO
					//Se txtNomeAluno não é texto => ERRO
					
					Jogos novoJogo = new Jogos(
						txtNumAluno.getText(),
							txtNomeAluno.getText());
							//new ImageView(new Image("/images/setor.jpg"))
					
					//tableAlunos.getItems().add(novoJogo);
					
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
				
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableAlunos, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			tableAlunos.setEditable(true);
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		MenuItem jogosDeleteFunc = new MenuItem("Eliminar Jogo");		
		
		jogosDeleteFunc.setOnAction(e->{
			BorderPane fdssf = new BorderPane();
			
			GridPane grid = new GridPane();
			fdssf.setCenter(grid);
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
			
		    TableColumn<Jogos, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Jogos, String> colunaNumero = new TableColumn<>("Preço");
			colunaNome.setMinWidth(300);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			
			//Coluna Numero
			
			colunaNumero.setMinWidth(100);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableAlunos.getColumns().addAll( colunaNome,colunaNumero);
			
			//Carregar a lista com dados
			tableAlunos.setItems( carregarListaAlunos() );
			
			//Campo Nª
			
			Button btnDel = new Button("Apagar");
			btnDel.setOnAction(d -> {
				//Vamos apanhar o item selecionado e compara-lo com a lista de Alunos
				
				ObservableList<Jogos> alunoSelected, listaAlunos;
				listaAlunos = tableAlunos.getItems();
				alunoSelected = tableAlunos.getSelectionModel().getSelectedItems();
				alunoSelected.forEach(listaAlunos::remove);
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll( btnDel);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableAlunos, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(fdssf);
		});
		
		menuJogos.getItems().addAll(jogosAddFunc, jogosEditFunc, jogosDeleteFunc);
		
		Menu menuCliente = new Menu("C_liente");
		MenuItem addCliente = new MenuItem("Adicionar Cliente");
		MenuItem editClinete = new MenuItem("Alterar Cliente");
		MenuItem deleteCliente = new MenuItem("Eliminar Cliente");
		
		menuCliente.getItems().addAll(addCliente, editClinete, deleteCliente);
		
		Menu menuEncomendas = new Menu("E_ncomendas");
		MenuItem fazerEncFunc = new MenuItem("Fazer uma Encomenda");
		MenuItem alterarEncFunc = new MenuItem("Alterar uma Encomenda");
		MenuItem eliminarEncFunc = new MenuItem("Eliminar uma Encomenda");
		
		menuEncomendas.getItems().addAll(fazerEncFunc, alterarEncFunc, eliminarEncFunc);
		
		Menu menuSaida = new Menu("S_air");
		MenuItem sairFunc = new MenuItem("Fechar Programa");
		MenuItem terminarSessaoFunc = new MenuItem("Terminar Sessão");
		
		menuSaida.getItems().addAll(sairFunc, terminarSessaoFunc);
		//Passo 3
		
		MenuBar menuBar = new MenuBar();
		menuBar.setStyle("-fx-background-color: #803300;");
		menuBar.getMenus().addAll(menuJogos, menuCliente, menuEncomendas, menuSaida);
		
		
		
		Scene sceneFuncionario = new Scene(funcionario,700,700);
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
		MenuItem terminarSessaoFunc = new MenuItem("Terminar Sessão");
		
		
		
		menuSaida.getItems().addAll(sairFunc, terminarSessaoFunc);
		
		//Passo 3
		
		MenuBar menuBarCliente = new MenuBar();
		menuBarCliente.setStyle("-fx-background-color: #00001A;");
		menuBarCliente.getMenus().addAll(menuConsultas, menuEncomenda, menuSaida);
		//cliente
		
		cliente.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;-fx-background-color: #00004C;");
		Scene sceneCliente = new Scene(cliente,700,700);
		cliente.setTop(menuBarCliente);
		
		terminarSessaoFunc.setOnAction(e ->{
			//Main
			
		});
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          Termina                            -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		return sceneCliente;
	}
	
	//ALERTBOX para a exercicio  05a ModalWindow_AlertBox
		public static void alertBox(String title, String msg){ //Static para nÃ£o ser instanciada
			
			Stage janela = new Stage();							//Cria uma window
			//janela.initModality(Modality.APPLICATION_MODAL);	//Define uma janela Modal
			janela.initModality(Modality.WINDOW_MODAL);	//Define uma janela Modal
			janela.setTitle(title); 							//Como tÃ­tulo, recebe a string do parametro
			janela.setMinWidth(200);							//Largura da janela
			
			Label mensagem = new Label(msg); 					//Cria a label para mostra
			Button btnClose = new Button("Fechar");				//Cria botÃ£o para fechar janela
			btnClose.setOnAction(e -> janela.close());			//AÃ§Ã£o fecha esta janela
			
			VBox layout = new VBox(10);							//Layout vertical com 10px entre cÃ©lulas
			layout.getChildren().addAll(mensagem, btnClose);	//Adiciona Label e Button ao layout
			layout.setAlignment(Pos.CENTER);					//Alinhar os cnteudos ao Centros
			
			Scene scene = new Scene(layout);					//Criar a Scene e associa o Layout
			janela.setScene(scene);								//Associa a Scena 
			janela.showAndWait();								//Executa e prende o controlo atÃ© ser fechada
			
			
		}
		
		public static boolean confirmationBox(String title, String msg){ //Static para nÃ£o ser instanciada
			
			Stage janela = new Stage();							//Cria uma window
			//janela.initModality(Modality.APPLICATION_MODAL);	//Define uma janela Modal
			janela.initModality(Modality.WINDOW_MODAL);	//Define uma janela Modal
			janela.setTitle(title); 							//Como tÃ­tulo, recebe a string do parametro
			janela.setMinWidth(200);							//Largura da janela
			
			Label mensagem = new Label(msg); 					//Cria a label para mostra
			Button btnTrue = new Button("Sim");				//Cria botÃ£o para fechar janela
			btnTrue.setOnAction(e -> {
				resposta = true;
				janela.close();			//AÃ§Ã£o fecha esta janela
			});
			Button btnFalse = new Button("NÃ£o");
			btnFalse.setOnAction(e -> {
				resposta = false;
				janela.close();			//AÃ§Ã£o fecha esta janela
			});
			
			VBox layout = new VBox(10);							//Layout vertical com 10px entre cÃ©lulas
			VBox layout1 = new VBox(10);
			layout.getChildren().addAll(mensagem, layout1);
			layout.setAlignment(Pos.CENTER);
			
			layout1.getChildren().addAll(btnTrue, btnFalse);
		
			
			Scene scene = new Scene(layout);					//Criar a Scene e associa o Layout
			janela.setScene(scene);								//Associa a Scena 
			janela.showAndWait();								//Executa e prende o controlo atÃ© ser fechada
			
			return resposta;
		}
		
		
		private static ObservableList<Jogos> carregarListaAlunos() {
			// TODO Auto-generated method stub
			
			//listaAlunos.add(new Aluno(0, "A.Ferraz", new ImageView(new Image("\images\setor.jpg"))));
			//listaAlunos.add(new Aluno(0, "A.Ferraz", new ImageView(new Image("/images/ventura.png"))));
			//listaAlunos.add(new Aluno(1, "Bruno", new ImageView(new Image("/images/bruno.jpg"))));
			/*listaAlunos.add(new Aluno(0, "A.Ferraz"));
			listaAlunos.add(new Aluno(1, "Bruno"));
			listaAlunos.add(new Aluno(2, "Catalin"));
			listaAlunos.add(new Aluno(3, "David"));
			listaAlunos.add(new Aluno(6, "Ventura"));
			listaAlunos.add(new Aluno(7, "Jorge"));
			listaAlunos.add(new Aluno(8, "Marcelo"));
			listaAlunos.add(new Aluno(9, "Mariana"));
			listaAlunos.add(new Aluno(10, "Patricia"));
			listaAlunos.add(new Aluno(11, "Ricardo"));
			listaAlunos.add(new Aluno(12, "Ruben"));
			listaAlunos.add(new Aluno(14, "Rui"));
			listaAlunos.add(new Aluno(15, "Samuel"));*/
			
			
			return listaAlunos;
		}
}
