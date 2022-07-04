package controler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
/* 
 * system inclusions
 */
import application.Main;
import application.Main.telas;
import model.Item;
import services.ServicesAlerts;

public class MenuCliente {

    @FXML
    private TableView<Item> tbViewProdutos;
    
    @FXML
    private TableColumn<Item, String> tcNameProduct;
    
    @FXML
    private TableColumn<Item, Integer> tcQuantityProduct;
    
    @FXML
    private TableColumn<Item, Float> tcDiscount,  
    								 tcUnitPrice,
    								 tcValorTotal;
	
    @FXML
    void btnClickAdicionarProduto(ActionEvent event) {
    	Main.changeTela(telas.telaAddProduto);
    }

    @FXML
    void btnClickAtualizarProduto(ActionEvent event) {
    	Main.changeTela(telas.telaAttProduto);
    }

    @FXML
    void btnClickLogout(ActionEvent event) {
    	Main.changeTela(telas.menuInicial);
    }

    @FXML
    void btnClickMostrarProdutos(ActionEvent event) {
    	try {
    		showTbProdutos(Main.cliente.getListaDeCompras().getListaDeItens());
    	}
    	catch(NullPointerException me) {
    		ServicesAlerts.Alerts(AlertType.ERROR, "Error", null, me.getMessage());
    	}
    }

    @FXML
    void btnClickRemoverProduto(ActionEvent event) {
    	Main.changeTela(telas.telaRmProduto);
    }
    
    @FXML
    void btnClickCancelarProdutos(ActionEvent event) {
    	Main.cliente.getListaDeCompras().cancelarCompra();
    }
    
    public void showTbProdutos(List<Item> itens) {
    	ObservableList<Item> data = FXCollections.observableArrayList(itens);
    	
    	tcNameProduct.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tcQuantityProduct.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	tcUnitPrice.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
    	tcValorTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
    	tcDiscount.setCellValueFactory(new PropertyValueFactory<>("desconto"));
    	
    	tbViewProdutos.setItems(data);
    }

}
