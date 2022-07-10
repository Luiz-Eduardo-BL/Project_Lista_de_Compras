package controler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
/* 
 * system inclusions
 */
import application.Main;
import application.Main.telas;
import model.Item;
import services.MsgException;
import services.ServicesAlerts;
import services.ServicesCliente;
import services.ServicesListeDeCompras;

public class MenuCliente {
	
    @FXML
    private Label labelValorTotalCompra;
    
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
    void btnClickRemoverProduto(ActionEvent event) {
    	Main.changeTela(telas.telaRmProduto);
    }
    
    @FXML
    void btnClickEfetuarPedidos(ActionEvent event) {
    	try {
    		String str = ServicesCliente.efetuarPedido(Main.cliente);
    		ServicesAlerts.Alerts(AlertType.INFORMATION, "Success", null, str);
    		Main.changeTela(telas.menuInicial);
    	}
    	catch(MsgException me) {
    		ServicesAlerts.Alerts(AlertType.ERROR, "Error", null, me.getMessage());
    	}
    	
    }
    
    @FXML
    void btnClickCancelarProdutos(ActionEvent event) {
    	Main.cliente.getListaDeCompras().cancelarCompra();
    }
    
    @FXML
    void menuItemMostrarProdutosCarrinho(ActionEvent event) {
    	try {
    		showTbProdutosCarrinho(Main.cliente.getListaDeCompras().getListaDeItens());
    		labelValorTotalCompra.setText(
    				String.valueOf(Main.cliente.getListaDeCompras().getPrecoTotalLista()));
    	}
    	catch(NullPointerException me) {
    		ServicesAlerts.Alerts(AlertType.ERROR, "Error", null, me.getMessage());
    	}
    }
    
    @FXML
    void menuItemMostrarProdutosDeposito(ActionEvent event) {
    	try {
    		showTbProdutosDeposito(ServicesListeDeCompras.readListItensDeposito());
    	}
    	catch(NullPointerException me) {
    		ServicesAlerts.Alerts(AlertType.ERROR, "Error", null, me.getMessage());
    	}
    }
    
    private void showTbProdutosCarrinho(List<Item> itens) {
    	ObservableList<Item> data = FXCollections.observableArrayList(itens);
    	
    	tcQuantityProduct.setVisible(true);
    	tcValorTotal.setVisible(true);
    	tcDiscount.setVisible(true);
    	
    	tcNameProduct.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tcQuantityProduct.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	tcUnitPrice.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
    	tcValorTotal.setCellValueFactory(new PropertyValueFactory<>("precoTotal"));
    	tcDiscount.setCellValueFactory(new PropertyValueFactory<>("desconto"));
   
    	tbViewProdutos.setItems(data);
    }
    
    private void showTbProdutosDeposito(List<Item> itens) {
    	ObservableList<Item> data = FXCollections.observableArrayList(itens);
    	
    	tcQuantityProduct.setVisible(false);
    	tcValorTotal.setVisible(false);
    	tcDiscount.setVisible(false);
    	tcNameProduct.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tcUnitPrice.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
   
    	tbViewProdutos.setItems(data);
    }

}
