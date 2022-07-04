package controler.controlerMenuCliente;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import services.MsgException;
import services.ServicesAlerts;

public class TelaAddProduto {

    @FXML
    private TextField textFieldNameProduct;

    @FXML
    private TextField textFieldQuantidadeProduct;

    @FXML
    void btnClickConfirm(ActionEvent event) {
    	try {
    		Main.cliente.getListaDeCompras().adicionarItem(
    			textFieldNameProduct.getText(), 
    			Integer.parseInt(textFieldQuantidadeProduct.getText()));
    		ServicesAlerts.Alerts(AlertType.INFORMATION, "Success", null, "produto adicionado com sucesso");
    		Main.changeTela(telas.menuCliente);
    		}
    	catch(MsgException me) {
    		ServicesAlerts.Alerts(AlertType.ERROR, "Error", null, me.getMessage());
    	}
    }
    
   
    @FXML
    void btnClickBack(ActionEvent event) {
    	Main.changeTela(telas.menuCliente);
    }
    

}
