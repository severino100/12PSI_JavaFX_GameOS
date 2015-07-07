package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



public class SQL {
	
	static private Connection conn = null;								// Objeto de Licação
	
	static String MYSQL_JDBC_DRIVER  = "com.mysql.jdbc.Driver";			// Connector para o MYSQL
	static String MYSQL_DB_URL = "jdbc:mysql://localhost/gameos";		// url e nome da bd em MYSQL
	static String MYSQL_DB_USER = "root";								// BD user name MYSQL
	static String MYSQL_DB_PASS = "123";								// BD password MYSQL
	
	static String SQLSERVER_JDBC_DRIVER  = "com.microsoft.sqlserver.jdbc.SQLServerDriver";		// Connector para o SQLSERVER
	static String SQLSERVER_DB_URL = "jdbc:sqlserver://LX\\SQLEXPRESS;database=Escola";			// url e nome da bd em SQLSERVER
	//static String SQLSERVER_DB_URL = "jdbc:sqlserver://LX\\SQLEXPRESS;database=Escola;integratedSecurity=true";	// url e nome da bd em SQLSERVER
	static String SQLSERVER_DB_USER = "sa";								// BD user name SQLSERVER
	static String SQLSERVER_DB_PASS = "123";							// BD password SQLSERVER
	
	static boolean msgON = true;										// Ativa Mensagens de controlo
	
	/* mySqlTeste()- Cria e testa uma ligação a um SGBD MYSQL.*/
	public static void mySqlTeste(){
		try{
			//Tenta ligar-se ao SGBD e à base de dados
			
			Class.forName(MYSQL_JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
			if(msgON){
				MenuOp.alertBox("layoutLeft", "Base dados aberta");
			}
		}
		catch(SQLException ex){							// Apanha Erro da connection ou DML
			MenuOp.alertBox("layoutLeft", "Erro na ligação");
		}
		catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
			MenuOp.alertBox("layoutLeft", "Erro no Driver");
		}
		catch(Exception ex){								// Apanha todas as restantes Exceções
			MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
			ex.printStackTrace();
		}
		finally{
			// Se ligação com sucesso, fecha-a
			shutdownConnection();			
		}
	}
	
	// Executa uma query à base de dados de um SGBD MySQL
	public static void mySqlQwery(String query){
		try{
			//Tenta ligar-se ao SGBD e à base de dados
			Class.forName(MYSQL_JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
			if(msgON){
				MenuOp.alertBox("layoutLeft", "Base dados aberta");
			}
		}
		catch(SQLException ex){							// Apanha Erro da connection ou DML
			MenuOp.alertBox("layoutLeft", "Erro na ligação");
		}
		catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
			MenuOp.alertBox("layoutLeft", "Erro no Driver");
		}
		catch(Exception ex){								// Apanha todas as restantes Exceções
			MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
			ex.printStackTrace();
		}
		finally{
			try{
				// Se ligação com sucesso, executa a query
				if(!query.isEmpty()){		// Se a query tiver comando sql
					String queryResult = "";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					while(rs.next()){
						queryResult += rs.getString(1)		// número da coluna na tabela
									+", "+rs.getString(2)	// 
									+", "+rs.getString(4)+"\n";
					}
					if(msgON){
						MenuOp.alertBox("DB", queryResult);
					}
				}		
				shutdownConnection();
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("Finally", "Erro na ligação");
				shutdownConnection();
			}				
		}
	}
	
	/* Executa uma query à base de dados de um SGBD MySQL, para verificar a existencia de uma PK
	 * Recebe a qwery
	 * Ddevolve 1 se encontrou e 0 se não.
	 */
	public static boolean mySqlQweryCheckPK(String query){
		boolean foundPK = false;		
		
		try{
			//Tenta ligar-se ao SGBD e à base de dados
			Class.forName(MYSQL_JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
			if(msgON){
				MenuOp.alertBox("layoutLeft", "Base dados aberta");
			}
		}
		catch(SQLException ex){							// Apanha Erro da connection ou DML
			MenuOp.alertBox("layoutLeft", "Erro na ligação");
		}
		catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
			MenuOp.alertBox("layoutLeft", "Erro no Driver");
		}
		catch(Exception ex){								// Apanha todas as restantes Exceções
			MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
			ex.printStackTrace();
		}
		finally{
			try{
				// Se ligação com sucesso, executa a query
				if(!query.isEmpty()){		// Se a query tiver comando sql
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					foundPK = rs.wasNull();
				}		
				shutdownConnection();						// fecha a ligação
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("Finally", "Erro na ligação");
				shutdownConnection();
			}				
		}
		return foundPK;
	}
	
	
	// Executa um insert ou update para SGBD MySql.
	public static void mySqlDml(String dml){
		try{
			//Tenta ligar-se ao SGBD e à base de dados
			Class.forName(MYSQL_JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
			if(msgON){
				MenuOp.alertBox("layoutLeft", "Base dados aberta");
			}
		}
		catch(SQLException ex){								// Apanha Erro da connection ou DML
			MenuOp.alertBox("layoutLeft", "Erro na ligação");
		}
		catch(ClassNotFoundException ex){					// Apanha Erro da Class.forName()
			MenuOp.alertBox("layoutLeft", "Erro no Driver");
		}
		catch(Exception ex){								// Apanha todas as restantes Exceções
			MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
			ex.printStackTrace();
		}
		finally{
			try{
				// Se ligação com sucesso, executa a dml
				if(!dml.isEmpty()){		// Se a dml tiver comando sql, executa-o
					
					Statement stmt = conn.createStatement();		// Cria um obj comando sql
					int dmlResult = stmt.executeUpdate(dml);		// Executa-o. Devolve o nº de registos tratados
					if (dmlResult > 0 && msgON){					// Devolve inteiro > 0 se ok
						MenuOp.alertBox("DB","Comando DML OK");		// 0 ou menor, se ERRO.
					}
					else{
						if(msgON){
							MenuOp.alertBox("DB","ERRO Comando DML");
						}
					}
				}		
				shutdownConnection();
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("Finally", "Erro na ligação");
				shutdownConnection();
			}				
		}
	}
	
	/*************************************************************************************************
	 * Métodos para carregamento das Listas de alimentação das TableViews. 
	 * São executados pelo botão EDITAR, eliminar, alterar ou eliminar de cada entidade
	 * Popular uma ObservableList com os dados da BD e desvolvemr à TableView
	 *************************************************************************************************/
    /*public static ObservableList<Aluno> carregaListaAlunos(){
    	
    	ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList();

    	/*TODO: Lista para preencher com os dados da tabela
    	 * 	Executa uma query à tabela Aluno e para cada registo, 
    	 * 		1 Extrai os 3 atributos: nProc, NAluno e nome
    	 *  	2 Adiciona à lista
    	 *  Devolve a lista à TableView para desenhar a lista de Alunos
    	 *

    	try{
			//Tenta ligar-se ao SGBD e à base de dados
			Class.forName(MYSQL_JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
			if(msgON){
				MenuOp.alertBox("carregaListaAlunos", "Base dados aberta");
			}
		}
		catch(SQLException ex){							// Apanha Erro da connection ou DML
			MenuOp.alertBox("carregaListaAlunos", "Erro na ligação");
			return null;
		}
		catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
			MenuOp.alertBox("carregaListaAlunos", "Erro no Driver");
			return null;
		}
		catch(Exception ex){								// Apanha todas as restantes Exceções
			MenuOp.alertBox("carregaListaAlunos", "Erro genérico na ligação");
			ex.printStackTrace();
			return null;
		}
		finally{
			try{
				// Se ligação com sucesso, executa a query
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from Aluno");
				
				// Para cada registo existente na Query rs,
				while(rs.next()){					
					Aluno a = new Aluno();			// Cria um novo aluno
					a.setNProc(rs.getInt(1));		// Copia o dado da coluna 1 (nProc) para a
					a.setNTurma(rs.getInt(2));		// Extrai o dado da colina 2 (NAluno) para a
					a.setNome(rs.getString(4));		// Extrai o dado da coluna 4 (Nome) para a
					listaAlunos.add(a);				// Adiciona-o à lista.
					
					//Alternativa: uma unica linha, usando o contrutor de Aluno
					//listaAlunos.add(new Aluno(rs.getInt(1), rs.getInt(2), rs.getString(4)));
				}
				if(msgON){
					MenuOp.alertBox("carregaListaAlunos", "Lista Construida");
				}
				shutdownConnection();
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("carregaListaAlunos", "Finally - Erro na ligação");
				shutdownConnection();
				return null;
			}	
		}
    	return listaAlunos;
    }
*/
	
	/*SHUTDOWNCONNECTION() - Fecha a ligação de BD*/
	public static void shutdownConnection(){
		try{
			if (conn != null) { conn.close();}	// apenas se estiver aberta
			if(msgON){
				MenuOp.alertBox("SQLshutDown", "Base dados fechada");
			}
		}
		catch(SQLException e){
			MenuOp.alertBox("SQLshutDown", "Erro no fecho da ligação à BD");
		}
		catch(Exception e){
			MenuOp.alertBox("SQLshutDown", "Erro genérico no fecho da ligação à BD");
		}
    }
	
	//INSERT INTO `gestao de jogos`(`codJogo`, `Cliente LoginnCliente`, `NomeJogo`, `Preco`) VALUES (NULL,1,"LOL","20")
	
	public static void criarJogo(Jogos jogo){
		
		String query = "INSERT INTO `gestao de jogos`(`codJogo`, `Cliente LoginnCliente`, `NomeJogo`, `Preco`) VALUES (NULL,1,"
				+ "\"" + jogo.getNome() + "\"," + jogo.getPreco() + ")";
		try{
			//Tenta ligar-se ao SGBD e à base de dados
			Class.forName(MYSQL_JDBC_DRIVER).newInstance();
			conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
			if(msgON){
				MenuOp.alertBox("layoutLeft", "Base dados aberta");
			}
		}
		catch(SQLException ex){							// Apanha Erro da connection ou DML
			MenuOp.alertBox("layoutLeft", "Erro na ligação");
		}
		catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
			MenuOp.alertBox("layoutLeft", "Erro no Driver");
		}
		catch(Exception ex){								// Apanha todas as restantes Exceções
			MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
			ex.printStackTrace();
		}
		finally{
			try{
				// Se ligação com sucesso, executa a query
				if(!query.isEmpty()){		// Se a query tiver comando sql
					Statement stmt = conn.createStatement();
					stmt.executeUpdate(query);

				}		
				shutdownConnection();
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("Finally", "Erro na ligação");
				ex.printStackTrace();
				shutdownConnection();
			}				
		}
		

    }
	
	// Executa uma query à base de dados de um SGBD MySQL
	//SELECT * FROM `gestao de jogos` WHERE 1
		public static ObservableList<Jogos> dadosRecebe(String query){
			ObservableList<Jogos> listaJogo = FXCollections.observableArrayList();
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while(rs.next()){
							Jogos temp = new Jogos(rs.getString(4),rs.getString(3));
							listaJogo.add(temp);
						}
					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					shutdownConnection();
				}				
			}
			return listaJogo;
		}
		
		//SELECT * FROM `gestao de clientes` WHERE 1
		public static ObservableList<Cliente> dadosRecebeCliente(String query){
			ObservableList<Cliente> listaEnc = FXCollections.observableArrayList();
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while(rs.next()){
							Cliente temp = new Cliente(rs.getString(3),rs.getString(2),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
							listaEnc.add(temp);
						}
					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					shutdownConnection();
				}				
			}
			return listaEnc;
		}
		public static ObservableList<Encomendas> dadosRecebeEnc(String query){
			ObservableList<Encomendas> listaEnc = FXCollections.observableArrayList();
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while(rs.next()){
							Encomendas temp = new Encomendas(rs.getString(4),rs.getString(2),rs.getString(5));
							listaEnc.add(temp);
						}
					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					shutdownConnection();
				}				
			}
			return listaEnc;
		}
		
		public static void criarEnc(Encomendas enc){
			
			String query = "INSERT INTO `encomendas`(`codEncomenda`, `Nome`, `Confirmacao`, `Preco`, `Autor`) VALUES (NULL,"
					+ "\"" + enc.getNome() + "\",NULL," + "\""+ enc.getPreco() + "\",\"" + enc.getAutor() + "\")";
			
			System.out.println(query);
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(query);

					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					ex.printStackTrace();
					shutdownConnection();
				}				
			}
			

	    }
		
		
		public static void alterEnc(Encomendas enc, Encomendas enc2){
			
			String query = "UPDATE `encomendas` SET `Nome`=" 
			+ "\"" + enc.getNome() +"\",`Preco`="+ enc.getPreco() 
			+ "," + "`Autor`= \""+ enc.getAutor()+ "\" WHERE "
					+ "Nome = \"" + enc2.getNome() +"\" AND Preco="+ enc2.getPreco() 
					+ " AND " + "Autor= \""+ enc2.getAutor() +"\"";
			
			System.out.println(query);
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(query);

					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					ex.printStackTrace();
					shutdownConnection();
				}				
			}
		}
		//DELETE FROM `encomendas` WHERE 1
		public static void deleteEnc(Encomendas enc){
			
			String query = "DELETE FROM `encomendas` WHERE "
					+ "Nome = \"" + enc.getNome() +"\" AND Preco="+ enc.getPreco() 
					+ " AND " + "Autor= \""+ enc.getAutor() +"\"";
			
			System.out.println(query);
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(query);

					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					ex.printStackTrace();
					shutdownConnection();
				}				
			}
	    }
		
		public static void criarCliente(Cliente cliente){
			
			String query = "INSERT INTO `gestao de clientes`(`codCliente`, `Nome`, `Idade`, `Email`, `NrTelemovel`, `Username`, `Password`) VALUES (NULL,"
					+ "\"" + cliente.getNome() 
					+ "\"," + cliente.getIdade()
					+ ",\"" + cliente.getEmail()
					+ "\"," + cliente.getNrTelemovel()
					+ ",\"" + cliente.getUsername()
					+ "\",\"" + cliente.getPassword() + "\");";
			
			System.out.println(query);
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(query);

					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					ex.printStackTrace();
					shutdownConnection();
				}				
			}
			

	    }
		public static void alterCliente(Cliente enc, Cliente enc2){
			
			String query = "UPDATE `gestao de clientes` SET `Nome`=\""
					+ enc.getNome() + "\",`Idade`="
					+ enc.getIdade() + ",`Email`=\""
					+ enc.getEmail() + "\",`NrTelemovel`=\""
					+ enc.getNrTelemovel() + "\",`Username`=\""
					+ enc.getUsername() + "\",`Password`=\""
					+ enc.getPassword() + "\" WHERE Nome=\""
					+ enc2.getNome() + "\" AND Idade="
					+ enc2.getIdade() + " AND Email=\""
					+ enc2.getEmail() + "\" AND NrTelemovel=\""
					+ enc2.getNrTelemovel() + "\" AND Username=\""
					+ enc2.getUsername() + "\" AND Password=\""
					+ enc2.getPassword() + "\"";
			
			System.out.println(query);
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(query);

					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					ex.printStackTrace();
					shutdownConnection();
				}				
			}
		}
		//DELETE FROM `encomendas` WHERE 1
		public static void deleteCliente(Cliente enc){
			
			String query = "DELETE FROM `gestao de clientes` WHERE Nome=\""
					+ enc.getNome() + "\" AND Idade="
					+ enc.getIdade() + " AND Email=\""
					+ enc.getEmail() + "\" AND NrTelemovel=\""
					+ enc.getNrTelemovel() + "\" AND Username=\""
					+ enc.getUsername() + "\" AND Password=\""
					+ enc.getPassword() + "\"";
			
			System.out.println(query);
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try{
					// Se ligação com sucesso, executa a query
					if(!query.isEmpty()){		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						stmt.executeUpdate(query);

					}		
					shutdownConnection();
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					ex.printStackTrace();
					shutdownConnection();
				}				
			}
	    }
		
		public static boolean verificarLogin (String username, String pass)
		{
			boolean aceite = false;
			String query = "SELECT * FROM `gestao de clientes` WHERE Username = \"" + username + "\"";
			
			try{
				//Tenta ligar-se ao SGBD e à base de dados
				Class.forName(MYSQL_JDBC_DRIVER).newInstance();
				conn = DriverManager.getConnection(MYSQL_DB_URL, MYSQL_DB_USER, MYSQL_DB_PASS );
				if(msgON){
					MenuOp.alertBox("layoutLeft", "Base dados aberta");
				}
			}
			catch(SQLException ex){							// Apanha Erro da connection ou DML
				MenuOp.alertBox("layoutLeft", "Erro na ligação");
			}
			catch(ClassNotFoundException ex){				// Apanha Erro da Class.forName()
				MenuOp.alertBox("layoutLeft", "Erro no Driver");
			}
			catch(Exception ex){								// Apanha todas as restantes Exceções
				MenuOp.alertBox("layoutLeft", "Erro genérico na ligação");
				ex.printStackTrace();
			}
			finally{
				try
				{
					if(!query.isEmpty())
					{		// Se a query tiver comando sql
						Statement stmt = conn.createStatement();
						ResultSet rs = stmt.executeQuery(query);
						while(rs.next()){
							if(pass.equals(rs.getString(7)))
							{
								aceite = true;
							}
						}
					}
				}
				catch(SQLException ex){							// Apanha Erro da connection ou DML
					MenuOp.alertBox("Finally", "Erro na ligação");
					ex.printStackTrace();
	
				}	
			}
			shutdownConnection();	
			return aceite;
		}
}
