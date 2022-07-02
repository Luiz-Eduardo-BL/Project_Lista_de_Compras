package application;


import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import services.MsgException;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class Main extends Application {
	public static enum telas {
		menuInicial, 
		menuCliente, 
		menuRegistro
	}
	
	private static Scene sceneMenuInicial, sceneMenuCliente, sceneMenuRegistro;
	private static Stage primaryStage;
	
	public static void changeTela(telas menu) {
		switch(menu) {
		case menuInicial:
			primaryStage.setScene(sceneMenuInicial);
			break;
		case menuCliente:
			primaryStage.setScene(sceneMenuCliente);
			break;
		case menuRegistro:
			primaryStage.setScene(sceneMenuRegistro);
			break;
		default:
			primaryStage.setScene(sceneMenuInicial);
		}
	}
	
	@Override
	public void start(Stage stage) {
		try {
			primaryStage = stage;
			Parent parentMenuInicial = FXMLLoader.load(
					getClass().getResource("../view/MenuInicial.fxml"));
			Parent parentMenuCliente = FXMLLoader.load(
					getClass().getResource("../view/MenuCliente.fxml"));
			Parent parentMenuRegistro = FXMLLoader.load(
					getClass().getResource("../view/MenuRegistro.fxml"));			
			sceneMenuInicial = new Scene(parentMenuInicial, 600, 400);
			sceneMenuCliente = new Scene(parentMenuCliente, 600, 400);
			sceneMenuRegistro = new Scene(parentMenuRegistro, 600, 400);
			primaryStage.setTitle("Lista de compras");
			primaryStage.setResizable(false);
			primaryStage.setScene(sceneMenuInicial);
			primaryStage.show();
		}
		catch (MsgException me) {
            System.out.println(me.getMessage());
        }
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
