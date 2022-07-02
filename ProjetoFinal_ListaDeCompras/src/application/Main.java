package application;


import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.stage.Stage;
import services.MsgException;
import javafx.scene.Scene;
import javafx.scene.Parent;
/* 
 * system inclusions
 */
import model.Cliente;


public class Main extends Application {
	public static Cliente cliente = new Cliente();
	public static enum telas {
		menuInicial, 
		menuCliente, 
		menuRegistro,
		addProduto,
		attProduto,
		rmProduto,
		showProdutos
	}
	
	private static Scene sceneMenuInicial, sceneMenuCliente, sceneMenuRegistro,
						 sceneAddProduto, sceneAttProduto, sceneRmProduto, sceneShowProdutos;
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
		case addProduto:
			primaryStage.setScene(sceneAddProduto);
			break;
		case attProduto:
			primaryStage.setScene(sceneAttProduto);
			break;
		case rmProduto:
			primaryStage.setScene(sceneRmProduto);
			break;
		case showProdutos:
			primaryStage.setScene(sceneShowProdutos);
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
			Parent parentAddProduto = FXMLLoader.load(
					getClass().getResource("../view/telasMenuCliente/AddProduto.fxml"));
			Parent parentAttProduto = FXMLLoader.load(
					getClass().getResource("../view/telasMenuCliente/AttProduto.fxml"));
			Parent parentRmProduto = FXMLLoader.load(
					getClass().getResource("../view/telasMenuCliente/RmProduto.fxml"));
			Parent parentShowProdutos = FXMLLoader.load(
					getClass().getResource("../view/telasMenuCliente/ShowProdutos.fxml"));
			
			
			sceneMenuInicial = new Scene(parentMenuInicial, 600, 400);
			sceneMenuCliente = new Scene(parentMenuCliente, 600, 400);
			sceneMenuRegistro = new Scene(parentMenuRegistro, 600, 400);
			sceneAddProduto = new Scene(parentAddProduto, 600, 400);
			sceneAttProduto = new Scene(parentAttProduto, 600, 400);
			sceneRmProduto = new Scene(parentRmProduto, 600, 400);
			sceneShowProdutos = new Scene(parentShowProdutos, 600, 400);
			
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
