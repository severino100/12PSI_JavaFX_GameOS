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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	
	static TableView<Encomendas> tableEnc = new TableView<>();
	static ObservableList<Encomendas> listaEnc = FXCollections.observableArrayList();
	
	static TableView<Cliente> tableCliente = new TableView<>();
	static ObservableList<Cliente> listaCliente = FXCollections.observableArrayList();
	
	
	public static Scene menuFunc(){
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          fUNCIONARIO                        -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		//BorderPane funcionario = new BorderPane();
		
		Menu menuJogos =new Menu("_Jogos");
		
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----           fUNCIONARIO - jogo - create                       -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		
		
		MenuItem jogosAddFunc = new MenuItem("Adicionar Jogo");
		
		jogosAddFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Jogos, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Jogos, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			colunaNome.setMinWidth(550);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			
			//Coluna Numero
			
			colunaNumero.setMinWidth(560);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableAlunos.getColumns().addAll( colunaNumero,colunaNome);
			
			//Carregar a lista com dados
			tableAlunos.setItems( carregarListaAlunos() );
			
			//Campo Nª
			TextField txtNumAluno = new TextField();
			txtNumAluno.setPromptText("Preço");
			txtNumAluno.setMinWidth(300);
			//txtNumAluno.setMaxWidth(120);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Nome");
			txtNomeAluno.setMinWidth(300);
			//txtNomeAluno.setMaxWidth(120);
			
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
					SQL.criarJogo(novoJogo);
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
		
		
		
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                  fUNCIONARIO -  jogo - edit                 -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		
		
		
		
		MenuItem jogosEditFunc = new MenuItem("Alterar Jogo");
			
		jogosEditFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    
		    
		    TableColumn<Jogos, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Jogos, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			
			
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
			txtNumAluno.setMinWidth(300);
			//txtNumAluno.setMaxWidth(120);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Nome");
			txtNomeAluno.setMinWidth(300);
			//txtNomeAluno.setMaxWidth(120);
			
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
					try
				     {
						Jogos j = new Jogos(txtNumAluno.getText(),txtNomeAluno.getText());
				      //Cliente j = listaCliente.get(tableCliente.getSelectionModel().getSelectedIndex());
				      j.setNome(txtNomeAluno.getText());
				      j.setPreco(txtNumAluno.getText());
				      
				      SQL.alterJogo(j, listaAlunos.get(tableAlunos.getSelectionModel().getSelectedIndex()));
				      
				      listaAlunos.set(tableAlunos.getSelectionModel().getSelectedIndex(), j);
				      tableAlunos.setItems(listaAlunos);
				     }
				     catch(java.lang.ArrayIndexOutOfBoundsException erro)
				     {
				    	 MenuOp.alertBox("Erro", "Nao selecionou o objeto que quer alterar");
				     }
					try
				     {
				      Jogos j = listaAlunos.get(tableAlunos.getSelectionModel().getSelectedIndex());
				      j.setNome(txtNomeAluno.getText());
				      j.setPreco(txtNumAluno.getText());
				      listaAlunos.set(tableAlunos.getSelectionModel().getSelectedIndex(), j);
				      tableAlunos.setItems(listaAlunos);
				     }
				     catch(java.lang.ArrayIndexOutOfBoundsException erro)
				     {
				    	 MenuOp.alertBox("Erro", "Nao selecionou o objeto que quer alterar");
				     }
					/*
					Jogos novoJogo = new Jogos(
						txtNumAluno.getText(),
							txtNomeAluno.getText());
							//new ImageView(new Image("/images/setor.jpg"))
					
					//tableAlunos.getItems().add(novoJogo);
					tableAlunos.getSelectionModel().getSelectedItem().setNome(txtNomeAluno.getText());
					tableAlunos.getSelectionModel().getSelectedItem().setNome(txtNumAluno.getText());
					*/txtNumAluno.clear();
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
		
		
		
		
		
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          fUNCIONARIO - jogo - delete        -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		
		
		
		
		MenuItem jogosDeleteFunc = new MenuItem("Eliminar Jogo");		
		
		jogosDeleteFunc.setOnAction(e->{
			
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
			
		    TableColumn<Jogos, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Jogos, String> colunaNumero = new TableColumn<>("Preço(Euros)");
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
			
			Button btnDel = new Button("Apagar");
			btnDel.setOnAction(d -> {
				//Vamos apanhar o item selecionado e compara-lo com a lista de Alunos
				
				ObservableList<Jogos> alunoSelected, listaAlunos;
				listaAlunos = tableAlunos.getItems();
				alunoSelected = tableAlunos.getSelectionModel().getSelectedItems();
				SQL.deleteJogo(listaAlunos.get(tableAlunos.getSelectionModel().getSelectedIndex()));
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
			
			funcionario.setCenter(grid);
		});
		
		menuJogos.getItems().addAll(jogosAddFunc, jogosEditFunc, jogosDeleteFunc);
		
		
	
		
		
		
		Menu menuCliente = new Menu("C_liente");
		MenuItem addCliente = new MenuItem("Adicionar Cliente");
		
		addCliente.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Cliente, String> colunaIdade = new TableColumn<>("Idade");
			TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
			TableColumn<Cliente, String> colunaTele = new TableColumn<>("Nº Telemovel");
			TableColumn<Cliente, String> colunaUser = new TableColumn<>("username");
			TableColumn<Cliente, String> colunaPass = new TableColumn<>("password");
			
			colunaNome.setMinWidth(200);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaIdade.setMinWidth(100);	//Largura em pixeis da coluna
			colunaIdade.setCellValueFactory(new PropertyValueFactory<>("Idade"));
			//Coluna Numero
			
			colunaEmail.setMinWidth(200);
			colunaEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			
			colunaTele.setMinWidth(200);
			colunaTele.setCellValueFactory(new PropertyValueFactory<>("NrTelemovel"));
			
			colunaUser.setMinWidth(200);
			colunaUser.setCellValueFactory(new PropertyValueFactory<>("Username"));
			
			colunaPass.setMinWidth(200);
			colunaPass.setCellValueFactory(new PropertyValueFactory<>("Password"));
			
			//Associar as colunas à tabela
			tableCliente.getColumns().addAll( colunaNome,colunaIdade, colunaEmail, colunaTele, colunaUser, colunaPass );
			
			//Carregar a lista com dados
			tableCliente.setItems( carregarListaCliente() );
			
			//Campo Nª
			TextField txtNumAluno = new TextField();
			txtNumAluno.setPromptText("Nome");
			//txtNumAluno.setMinWidth(120);
			txtNumAluno.setMaxWidth(120);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Idade");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAluno.setMaxWidth(120);
			
			TextField txtNomeAutor = new TextField();
			txtNomeAutor.setPromptText("email");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAutor.setMaxWidth(200);
			
			TextField txtTele = new TextField();
			txtTele.setPromptText("Telemovel");
			//txtNomeAluno.setMinWidth(120);
			txtTele.setMaxWidth(170);
			
			TextField txtUser = new TextField();
			txtUser.setPromptText("User");
			//txtNomeAluno.setMinWidth(120);
			txtUser.setMaxWidth(120);
			
			TextField txtPass = new TextField();
			txtPass.setPromptText("Pass");
			//txtNomeAluno.setMinWidth(120);
			txtPass.setMaxWidth(150);
			
			
			//Botões para adicionar
			Button btnAdd = new Button("Criar");	//Botão Adicionar
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
					
					Cliente novoCliente = new Cliente(
							txtNomeAluno.getText(),
							txtNumAluno.getText(),
							txtNomeAutor.getText(),
							txtTele.getText(),
							txtUser.getText(),
							txtPass.getText());
							//new ImageView(new Image("/images/setor.jpg"))
					SQL.criarCliente(novoCliente);
					/*
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNomeAluno.getText());
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNumAluno.getText());
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNomeAutor.getText());*/
					tableCliente.getItems().add(novoCliente);
					
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno,txtNomeAutor,txtTele,txtUser,txtPass, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableCliente, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		MenuItem editClinete = new MenuItem("Alterar Cliente");
		
		editClinete.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Cliente, String> colunaIdade = new TableColumn<>("Idade");
			TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
			TableColumn<Cliente, String> colunaTele = new TableColumn<>("Nº Telemovel");
			TableColumn<Cliente, String> colunaUser = new TableColumn<>("username");
			TableColumn<Cliente, String> colunaPass = new TableColumn<>("password");
			
			colunaNome.setMinWidth(200);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaIdade.setMinWidth(100);	//Largura em pixeis da coluna
			colunaIdade.setCellValueFactory(new PropertyValueFactory<>("Idade"));
			//Coluna Numero
			
			colunaEmail.setMinWidth(200);
			colunaEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			
			colunaTele.setMinWidth(200);
			colunaTele.setCellValueFactory(new PropertyValueFactory<>("NrTelemovel"));
			
			colunaUser.setMinWidth(200);
			colunaUser.setCellValueFactory(new PropertyValueFactory<>("Username"));
			
			colunaPass.setMinWidth(200);
			colunaPass.setCellValueFactory(new PropertyValueFactory<>("Password"));
			
			//Associar as colunas à tabela
			tableCliente.getColumns().addAll( colunaNome,colunaIdade, colunaEmail, colunaTele, colunaUser, colunaPass );
			
			//Carregar a lista com dados
			tableCliente.setItems( carregarListaCliente() );
			
			//Campo Nª
			TextField txtNumAluno = new TextField();
			txtNumAluno.setPromptText("Nome");
			//txtNumAluno.setMinWidth(120);
			txtNumAluno.setMaxWidth(120);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Idade");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAluno.setMaxWidth(120);
			
			TextField txtNomeAutor = new TextField();
			txtNomeAutor.setPromptText("email");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAutor.setMaxWidth(200);
			
			TextField txtTele = new TextField();
			txtTele.setPromptText("Telemovel");
			//txtNomeAluno.setMinWidth(120);
			txtTele.setMaxWidth(170);
			
			TextField txtUser = new TextField();
			txtUser.setPromptText("User");
			//txtNomeAluno.setMinWidth(120);
			txtUser.setMaxWidth(120);
			
			TextField txtPass = new TextField();
			txtPass.setPromptText("Pass");
			//txtNomeAluno.setMinWidth(120);
			txtPass.setMaxWidth(150);
			
			
			//Botões para adicionar
			Button btnAdd = new Button("ALterar");	//Botão Adicionar
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
					
					try
				     {
						Cliente j = new Cliente(txtNumAluno.getText(),txtNomeAluno.getText(),txtNomeAutor.getText(),txtTele.getText(),txtUser.getText(),txtPass.getText());
				      //Cliente j = listaCliente.get(tableCliente.getSelectionModel().getSelectedIndex());
				      j.setNome(txtNumAluno.getText());
				      j.setIdade(txtNomeAluno.getText());
				      j.setEmail(txtNomeAutor.getText());
				      j.setNrTelemovel(txtTele.getText());
				      j.setUsername(txtUser.getText());
				      j.setPassword(txtPass.getText());
				      
				      SQL.alterCliente(j, listaCliente.get(tableCliente.getSelectionModel().getSelectedIndex()));
				      
				      listaCliente.set(tableCliente.getSelectionModel().getSelectedIndex(), j);
				      tableCliente.setItems(listaCliente);
				     }
				     catch(java.lang.ArrayIndexOutOfBoundsException erro)
				     {
				    	 MenuOp.alertBox("Erro", "Nao selecionou o objeto que quer alterar");
				     }
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno,txtNomeAutor,txtTele,txtUser,txtPass, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableCliente, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		MenuItem deleteCliente = new MenuItem("Eliminar Cliente");
		deleteCliente.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Cliente, String> colunaNome = new TableColumn<>("Nome");
			TableColumn<Cliente, String> colunaIdade = new TableColumn<>("Idade");
			TableColumn<Cliente, String> colunaEmail = new TableColumn<>("Email");
			TableColumn<Cliente, String> colunaTele = new TableColumn<>("Nº Telemovel");
			TableColumn<Cliente, String> colunaUser = new TableColumn<>("username");
			TableColumn<Cliente, String> colunaPass = new TableColumn<>("password");
			
			colunaNome.setMinWidth(200);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaIdade.setMinWidth(100);	//Largura em pixeis da coluna
			colunaIdade.setCellValueFactory(new PropertyValueFactory<>("Idade"));
			//Coluna Numero
			
			colunaEmail.setMinWidth(200);
			colunaEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
			
			colunaTele.setMinWidth(200);
			colunaTele.setCellValueFactory(new PropertyValueFactory<>("NrTelemovel"));
			
			colunaUser.setMinWidth(200);
			colunaUser.setCellValueFactory(new PropertyValueFactory<>("Username"));
			
			colunaPass.setMinWidth(200);
			colunaPass.setCellValueFactory(new PropertyValueFactory<>("Password"));
			
			//Associar as colunas à tabela
			tableCliente.getColumns().addAll( colunaNome,colunaIdade, colunaEmail, colunaTele, colunaUser, colunaPass );
			
			//Carregar a lista com dados
			tableCliente.setItems( carregarListaCliente() );
			
			
			//Botões para adicionar
			Button btnAdd = new Button("Eliminar");	//Botão Adicionar
			btnAdd.setOnAction(a -> {
				try
			     {
					ObservableList<Cliente> alunoSelected, listaAlunos;
					listaAlunos = tableCliente.getItems();
					alunoSelected = tableCliente.getSelectionModel().getSelectedItems();
					SQL.deleteCliente(listaCliente.get(tableCliente.getSelectionModel().getSelectedIndex()));
					alunoSelected.forEach(listaAlunos::remove);
			     }
			     catch(java.lang.ArrayIndexOutOfBoundsException erro)
			     {
			    	 MenuOp.alertBox("Erro", "Nao selecionou o objeto que quer alterar");
			     }
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableCliente, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		
		menuCliente.getItems().addAll(addCliente, editClinete, deleteCliente);
		
		
		
		
		
		
		
		
		
		
		Menu menuEncomendas = new Menu("E_ncomendas");
		MenuItem fazerEncFunc = new MenuItem("Fazer uma Encomenda");
		
		fazerEncFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Encomendas, String> colunaNome = new TableColumn<>("Nome do Jogo");
			TableColumn<Encomendas, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			TableColumn<Encomendas, String> colunaQuem = new TableColumn<>("Autor");
			
			
			colunaNome.setMinWidth(370);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaQuem.setMinWidth(370);	//Largura em pixeis da coluna
			colunaQuem.setCellValueFactory(new PropertyValueFactory<>("autor"));
			//Coluna Numero
			
			colunaNumero.setMinWidth(370);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableEnc.getColumns().addAll( colunaNome,colunaNumero, colunaQuem);
			
			//Carregar a lista com dados
			tableEnc.setItems( carregarListaEncomendas() );
			
			//Campo Nª
			TextField txtNumAluno = new TextField();
			txtNumAluno.setPromptText("Preço");
			//txtNumAluno.setMinWidth(330);
			txtNumAluno.setMaxWidth(310);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Nome");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAluno.setMaxWidth(310);
			
			TextField txtNomeAutor = new TextField();
			txtNomeAutor.setPromptText("Autor");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAutor.setMaxWidth(310);
			
			
			//Botões para adicionar
			Button btnAdd = new Button("Encomendar");	//Botão Adicionar
			btnAdd.setMaxWidth(275);
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
					
					Encomendas novoJogo = new Encomendas(
							txtNumAluno.getText(),
							txtNomeAluno.getText(),
							txtNomeAutor.getText());
							//new ImageView(new Image("/images/setor.jpg"))
					SQL.criarEnc(novoJogo);
					/*
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNomeAluno.getText());
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNumAluno.getText());
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNomeAutor.getText());*/
					tableEnc.getItems().add(novoJogo);
					
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno,txtNomeAutor, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableEnc, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		
		MenuItem alterarEncFunc = new MenuItem("Alterar uma Encomenda");
		
		alterarEncFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Encomendas, String> colunaNome = new TableColumn<>("Nome do Jogo");
			TableColumn<Encomendas, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			TableColumn<Encomendas, String> colunaQuem = new TableColumn<>("Autor");
			
			
			colunaNome.setMinWidth(370);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaQuem.setMinWidth(370);	//Largura em pixeis da coluna
			colunaQuem.setCellValueFactory(new PropertyValueFactory<>("autor"));
			//Coluna Numero
			
			colunaNumero.setMinWidth(370);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableEnc.getColumns().addAll( colunaNome,colunaNumero, colunaQuem);
			
			//Carregar a lista com dados
			tableEnc.setItems( carregarListaEncomendas() );
			
			//Campo Nª
			TextField txtNumAluno = new TextField();
			txtNumAluno.setPromptText("Preço");
			//txtNumAluno.setMinWidth(330);
			txtNumAluno.setMaxWidth(310);
			
			//Campo Nome
			TextField txtNomeAluno = new TextField();
			txtNomeAluno.setPromptText("Nome");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAluno.setMaxWidth(310);
			
			TextField txtNomeAutor = new TextField();
			txtNomeAutor.setPromptText("Autor");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAutor.setMaxWidth(310);
			
			
			//Botões para adicionar
			Button btnAdd = new Button("Encomendar");	//Botão Adicionar
			btnAdd.setMaxWidth(275);
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
					
					try
				     {
				      //Encomendas j = listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex());
					  Encomendas j = new Encomendas(txtNumAluno.getText(),txtNomeAluno.getText(),txtNomeAutor.getText());
				      j.setNome(txtNomeAluno.getText());
				      j.setPreco(txtNumAluno.getText());
				      j.setAutor(txtNomeAutor.getText());
				        
				      System.out.println(j.getNome() + " " +listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex()).getNome() );
				      SQL.alterEnc(j, listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex()));
				      listaEnc.set(tableEnc.getSelectionModel().getSelectedIndex(), j);
				      
				      tableEnc.setItems(listaEnc);
				      

				     }
				     catch(java.lang.ArrayIndexOutOfBoundsException erro)
				     {
				    	 erro.printStackTrace();
				    	 MenuOp.alertBox("Erro", "Nao selecionou o objeto que quer alterar");
				     }
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno,txtNomeAutor, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableEnc, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
		});
		
		MenuItem eliminarEncFunc = new MenuItem("Eliminar uma Encomenda");
		
		eliminarEncFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Encomendas, String> colunaNome = new TableColumn<>("Nome do Jogo");
			TableColumn<Encomendas, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			TableColumn<Encomendas, String> colunaQuem = new TableColumn<>("Autor");
			
			
			colunaNome.setMinWidth(370);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaQuem.setMinWidth(370);	//Largura em pixeis da coluna
			colunaQuem.setCellValueFactory(new PropertyValueFactory<>("autor"));
			//Coluna Numero
			
			colunaNumero.setMinWidth(370);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableEnc.getColumns().addAll( colunaNome,colunaNumero, colunaQuem);
			
			//Carregar a lista com dados
			tableEnc.setItems( carregarListaEncomendas() );
			
			
			//Botões para adicionar
			Button btnDel = new Button("Delete");	//Botão Adicionar
			btnDel.setMaxWidth(275);
			btnDel.setOnAction(d -> {
				//Vamos apanhar o item selecionado e compara-lo com a lista de Alunos
				
				ObservableList<Encomendas> alunoSelected, listaAlunos;
				listaAlunos = tableEnc.getItems();
				alunoSelected = tableEnc.getSelectionModel().getSelectedItems();
				SQL.deleteEnc(listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex()));
				alunoSelected.forEach(listaAlunos::remove);
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll( btnDel);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableEnc, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		
		menuEncomendas.getItems().addAll(fazerEncFunc, alterarEncFunc, eliminarEncFunc);
		
		//Passo 3
		
		MenuBar menuBar = new MenuBar();
		menuBar.setStyle("-fx-background-color: #803300;");
		menuBar.getMenus().addAll(menuJogos, menuCliente, menuEncomendas);
		
		
		
		Scene sceneFuncionario = new Scene(funcionario,1250,1000);
		funcionario.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;-fx-background-color: #1A0A00;");
		funcionario.setTop(menuBar);
		ImageView img = new ImageView();
		Image img2 = new Image("ruben.png");
		
		img.setImage(img2);
		
		funcionario.setCenter(img);

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

	public static Scene menuCliente(){
			
		/*----------------------------------------------------------------------
		 *----                                                             -----
		 *----                          CLIENTE                            -----
		 *----                                                             ----- 
		 *----------------------------------------------------------------------*/
		
		
		Menu menuEncomendas = new Menu("E_ncomendas");
		MenuItem fazerEncFunc = new MenuItem("Fazer uma Encomenda");
		
		fazerEncFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Encomendas, String> colunaNome = new TableColumn<>("Nome do Jogo");
			TableColumn<Encomendas, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			TableColumn<Encomendas, String> colunaQuem = new TableColumn<>("Autor");
			
			
			colunaNome.setMinWidth(200);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaQuem.setMinWidth(200);	//Largura em pixeis da coluna
			colunaQuem.setCellValueFactory(new PropertyValueFactory<>("autor"));
			//Coluna Numero
			
			colunaNumero.setMinWidth(200);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableEnc.getColumns().addAll( colunaNome,colunaNumero, colunaQuem);
			
			//Carregar a lista com dados
			tableEnc.setItems( carregarListaEncomendas() );
			
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
			
			TextField txtNomeAutor = new TextField();
			txtNomeAutor.setPromptText("Autor");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAutor.setMaxWidth(120);
			
			
			//Botões para adicionar
			Button btnAdd = new Button("Encomendar");	//Botão Adicionar
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
					
					Encomendas novoJogo = new Encomendas(
							txtNumAluno.getText(),
							txtNomeAluno.getText(),
							txtNomeAutor.getText());
							//new ImageView(new Image("/images/setor.jpg"))
					SQL.criarEnc(novoJogo);
					/*
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNomeAluno.getText());
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNumAluno.getText());
					tableEnc.getSelectionModel().getSelectedItem().setNome(txtNomeAutor.getText());*/
					tableEnc.getItems().add(novoJogo);
					
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno,txtNomeAutor, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableEnc, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		
		MenuItem alterarEncFunc = new MenuItem("Alterar uma Encomenda");
		
		alterarEncFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Encomendas, String> colunaNome = new TableColumn<>("Nome do Jogo");
			TableColumn<Encomendas, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			TableColumn<Encomendas, String> colunaQuem = new TableColumn<>("Autor");
			
			
			colunaNome.setMinWidth(200);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaQuem.setMinWidth(200);	//Largura em pixeis da coluna
			colunaQuem.setCellValueFactory(new PropertyValueFactory<>("autor"));
			//Coluna Numero
			
			colunaNumero.setMinWidth(200);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableEnc.getColumns().addAll( colunaNome,colunaNumero, colunaQuem);
			
			//Carregar a lista com dados
			tableEnc.setItems( carregarListaEncomendas() );
			
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
			
			TextField txtNomeAutor = new TextField();
			txtNomeAutor.setPromptText("Autor");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAutor.setMaxWidth(120);
			
			
			//Botões para adicionar
			Button btnAdd = new Button("Encomendar");	//Botão Adicionar
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
					
					try
				     {
				      //Encomendas j = listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex());
					  Encomendas j = new Encomendas(txtNumAluno.getText(),txtNomeAluno.getText(),txtNomeAutor.getText());
				      j.setNome(txtNomeAluno.getText());
				      j.setPreco(txtNumAluno.getText());
				      j.setAutor(txtNomeAutor.getText());
				        
				      System.out.println(j.getNome() + " " +listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex()).getNome() );
				      SQL.alterEnc(j, listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex()));
				      listaEnc.set(tableEnc.getSelectionModel().getSelectedIndex(), j);
				      
				      tableEnc.setItems(listaEnc);
				      

				     }
				     catch(java.lang.ArrayIndexOutOfBoundsException erro)
				     {
				    	 erro.printStackTrace();
				    	 MenuOp.alertBox("Erro", "Nao selecionou o objeto que quer alterar");
				     }
					txtNumAluno.clear();
					txtNomeAluno.clear();
				}
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll(txtNumAluno, txtNomeAluno,txtNomeAutor, btnAdd);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableEnc, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
		});
		
		MenuItem eliminarEncFunc = new MenuItem("Eliminar uma Encomenda");
		
		eliminarEncFunc.setOnAction(e->{
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
		    TableColumn<Encomendas, String> colunaNome = new TableColumn<>("Nome do Jogo");
			TableColumn<Encomendas, String> colunaNumero = new TableColumn<>("Preço(Euros)");
			TableColumn<Encomendas, String> colunaQuem = new TableColumn<>("Autor");
			
			
			colunaNome.setMinWidth(200);	//Largura em pixeis da coluna
			colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			//Nome do atributo, na ObservableList, onde vai ler os dados
			colunaQuem.setMinWidth(200);	//Largura em pixeis da coluna
			colunaQuem.setCellValueFactory(new PropertyValueFactory<>("autor"));
			//Coluna Numero
			
			colunaNumero.setMinWidth(200);
			colunaNumero.setCellValueFactory(new PropertyValueFactory<>("preco"));
			
			//Associar as colunas à tabela
			tableEnc.getColumns().addAll( colunaNome,colunaNumero, colunaQuem);
			
			//Carregar a lista com dados
			tableEnc.setItems( carregarListaEncomendas() );
			
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
			
			TextField txtNomeAutor = new TextField();
			txtNomeAutor.setPromptText("Autor");
			//txtNomeAluno.setMinWidth(120);
			txtNomeAutor.setMaxWidth(120);
			
			
			Button btnDel = new Button("Apagar");
			btnDel.setOnAction(d -> {
				//Vamos apanhar o item selecionado e compara-lo com a lista de Alunos
				
				ObservableList<Encomendas> alunoSelected, listaAlunos;
				listaAlunos = tableEnc.getItems();
				alunoSelected = tableEnc.getSelectionModel().getSelectedItems();
				SQL.deleteEnc(listaEnc.get(tableEnc.getSelectionModel().getSelectedIndex()));
				alunoSelected.forEach(listaAlunos::remove);
			});
			
			HBox layoutEdit = new HBox(10);
			layoutEdit.setPadding(new Insets(10, 10, 10, 10));
			layoutEdit.getChildren().addAll( btnDel);
			
			//Arranjar verticalmente a Table e a HBox layoutEdit
			VBox layoutSub = new VBox(10);
			layoutSub.getChildren().addAll(tableEnc, layoutEdit);
			
			
			grid.add(layoutEdit, 4, 6);
			grid.add(layoutSub, 4, 7);
			
			funcionario.setCenter(grid);
			
		});
		
		menuEncomendas.getItems().addAll(fazerEncFunc, alterarEncFunc, eliminarEncFunc);
		
		//Passo 3
		
		MenuBar menuBarCliente = new MenuBar();
		menuBarCliente.setStyle("-fx-background-color: #00001A;");
		menuBarCliente.getMenus().addAll(menuEncomendas);
		//cliente
		
		cliente.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;-fx-background-color: #00004C;");
		Scene sceneCliente = new Scene(cliente,1250,700);
		cliente.setTop(menuBarCliente);
		
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
			listaAlunos = SQL.dadosRecebe("SELECT * FROM `gestao de jogos` WHERE 1");
			return listaAlunos;
		}
		
		private static ObservableList<Encomendas> carregarListaEncomendas() {
			// TODO Auto-generated method stub
			
			listaEnc = SQL.dadosRecebeEnc("SELECT * FROM `encomendas` WHERE 1");
			return listaEnc;
		}
		
		private static ObservableList<Cliente> carregarListaCliente() {
			// TODO Auto-generated method stub
			
			listaCliente = SQL.dadosRecebeCliente("SELECT * FROM `gestao de clientes` WHERE 1");
			return listaCliente;
		}
}