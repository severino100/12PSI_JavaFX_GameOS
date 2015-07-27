package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			//Login
			
			GridPane grid = new GridPane();
		    grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(50, 50, 50, 50));
			grid.setStyle("-fx-background-color: #336699;");
			
			
			//Username
			Label username = new Label("Username");
			username.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 18pt;");
			grid.add(username, 0, 1);
			TextField usernameField = new TextField("");
			grid.add(usernameField, 1, 1);
			//Password
			Label password = new Label("Password");
			password.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 18pt;");
			grid.add(password, 0, 2);
			TextField passwordfield = new TextField();
			grid.add(passwordfield, 1, 2);
			
			Button btnOK = new Button("OK");
			btnOK.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;;-fx-background-color: #00004C;");
			grid.add(btnOK, 2, 3);
			
			Button btnCancel = new Button("Cancel");
			btnCancel.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 13pt;;-fx-background-color: #00004C;");
			grid.add(btnCancel, 3, 3);
			
			/*GridPane gridFuncionario = new GridPane();
			gridFuncionario.setHgap(10);
			gridFuncionario.setVgap(10);
			gridFuncionario.setPadding(new Insets(50, 50, 50, 50));
			gridFuncionario.setStyle("-fx-background-color: #336699;");*/
			
			
			
			
			Scene sceneLogin = new Scene(grid,520,200);
			
			
			btnOK.setOnAction(e -> {
				
				primaryStage.setScene(MenuOp.menuFunc());
				
				
				if(new String("ruben").equals(usernameField.getText()))
				{
					if(new String("1234").equals(passwordfield.getText()))
					{
						primaryStage.setScene(MenuOp.menuFunc());
				
					}
					else
					{
						MenuOp.alertBox("ATENCAO", "User ou Pass errados");
					}
				}
				else
				{
					if(SQL.verificarLogin(usernameField.getText(), passwordfield.getText()))
					{
						primaryStage.setScene(MenuOp.menuCliente());
					}
					else{
						MenuOp.alertBox("ATENCAO", "User ou Pass errados");
					}
					/*
					if(new String("david").equals(usernameField.getText()))
					{
						if(new String("david").equals(passwordfield.getText()))
						{
					
						}
					}
					else{
						MenuOp.alertBox("ATENCAO", "User ou Pass errados");
					}*/
				}
				
				
			});

			
			
			sceneLogin.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(sceneLogin);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
