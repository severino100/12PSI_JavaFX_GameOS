package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


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
			grid.setStyle("-fx-background-color: #330000;");
			primaryStage.setTitle("Games");
			
			//Username
			Label username = new Label("Username");
			username.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 18pt;");
			grid.add(username, 0, 0);
			TextField usernameField = new TextField("");
			grid.add(usernameField, 1, 0);
			//Password
			Label password = new Label("Password");
			password.setStyle("-fx-text-fill: #FFFFFF;-fx-font-size: 18pt;");
			grid.add(password, 0, 1);
			TextField passwordfield = new TextField();
			grid.add(passwordfield, 1, 1);
			
			
			
			Button btnOK = new Button("OK");
			btnOK.setStyle("-fx-font-size: 13pt;"
					+ "-fx-background-color: #090a0c,linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),"
					+ "linear-gradient(#20262b, #191d22),"
					+ "radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), "
					+ "rgba(255,255,255,0));"
					+ "-fx-background-radius: 5,4,3,5;"
					+ "-fx-background-insets: 0,1,2,0;"
					+ "-fx-text-fill: white;"
					+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
					+ "-fx-font-family: \"Arial\";"
					+ "-fx-text-fill: linear-gradient(white, #d0d0d0);"
					+ "-fx-font-size: 12px;"
					+ "-fx-padding: 10 20 10 20;"
					+ "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 );");
			//grid.add(, 0, 3);
			
			
			Button btnCancel = new Button("Cancel");
			btnCancel.setStyle("-fx-font-size: 13pt;"
					+ "-fx-background-color: #090a0c,linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),"
					+ "linear-gradient(#20262b, #191d22),"
					+ "radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), "
					+ "rgba(255,255,255,0));"
					+ "-fx-background-radius: 5,4,3,5;"
					+ "-fx-background-insets: 0,1,2,0;"
					+ "-fx-text-fill: white;"
					+ "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );"
					+ "-fx-font-family: \"Arial\";"
					+ "-fx-text-fill: linear-gradient(white, #d0d0d0);"
					+ "-fx-font-size: 12px;"
					+ "-fx-padding: 10 20 10 20;"
					+ "-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 );");
			//grid.add(btnCancel, 0, 3);
			
			
			HBox botoes = new HBox(20);
			grid.add(botoes, 0 ,3, 2, 3);
			
			botoes.getChildren().addAll(btnOK ,btnCancel); 
			botoes.setPadding(new Insets(5, 5, 5, 5));
			btnOK.setPadding(new Insets(5, 5, 5, 5));
			btnCancel.setPadding(new Insets(5, 5, 5, 5));
			btnOK.prefWidthProperty().set(23902398);
			btnCancel.prefWidthProperty().set(23902398);
			//btnOK.setText("olaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			botoes.setAlignment(Pos.CENTER);
			
			/*GridPane gridFuncionario = new GridPane();
			gridFuncionario.setHgap(10);
			gridFuncionario.setVgap(10);
			gridFuncionario.setPadding(new Insets(50, 50, 50, 50));
			gridFuncionario.setStyle("-fx-background-color: #336699;");*/
			
			
			
			
			Scene sceneLogin = new Scene(grid,420,200);
			
			
			btnOK.setOnAction(e -> {
				
				primaryStage.setScene(MenuOp.menuFunc());
				primaryStage.setTitle("Games");
				primaryStage.setHeight(500);
				primaryStage.setWidth(700);
				primaryStage.centerOnScreen();
				if(new String("ruben").equals(usernameField.getText()))
				{
					if(new String("1234").equals(passwordfield.getText()))
					{
						primaryStage.setScene(MenuOp.menuFunc());
				
					}
					else
					{
						MenuOp.alertBox("Atenção", "User ou Pass errados");
					}
				}
				else
				{
					if(SQL.verificarLogin(usernameField.getText(), passwordfield.getText()))
					{
						primaryStage.setScene(MenuOp.menuCliente());
					}
					else{
						MenuOp.alertBox("Atenção", "User ou Pass errados");
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
