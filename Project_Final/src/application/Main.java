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
		telaAddProduto,
		telaAttProduto,
		telaRmProduto,
		telaShowProdutos
	}
	
	private static Scene sceneMenuInicial, sceneMenuCliente, sceneMenuRegistro,
						 sceneTelaAddProduto, sceneTelaAttProduto, sceneTelaRmProduto;
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
		case telaAddProduto:
			primaryStage.setScene(sceneTelaAddProduto);
			break;
		case telaAttProduto:
			primaryStage.setScene(sceneTelaAttProduto);
			break;
		case telaRmProduto:
			primaryStage.setScene(sceneTelaRmProduto);
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
					getClass().getResource("view/MenuInicial.fxml"));
			Parent parentMenuCliente = FXMLLoader.load(
					getClass().getResource("view/MenuCliente.fxml"));
			Parent parentMenuRegistro = FXMLLoader.load(
					getClass().getResource("view/MenuRegistro.fxml"));
			Parent parentTelaAddProduto = FXMLLoader.load(
					getClass().getResource("view/telasMenuCliente/TelaAddProduto.fxml"));
			Parent parentTelaAttProduto = FXMLLoader.load(
					getClass().getResource("view/telasMenuCliente/TelaAttProduto.fxml"));
			Parent parentTelaRmProduto = FXMLLoader.load(
					getClass().getResource("view/telasMenuCliente/TelaRmProduto.fxml"));

			
			
			sceneMenuInicial = new Scene(parentMenuInicial, 600, 400);
			sceneMenuCliente = new Scene(parentMenuCliente, 600, 400);
			sceneMenuRegistro = new Scene(parentMenuRegistro, 600, 400);
			sceneTelaAddProduto = new Scene(parentTelaAddProduto, 600, 400);
			sceneTelaAttProduto = new Scene(parentTelaAttProduto, 600, 400);
			sceneTelaRmProduto = new Scene(parentTelaRmProduto, 600, 400);
			
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
