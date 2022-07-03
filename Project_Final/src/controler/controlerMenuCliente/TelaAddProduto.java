package controler.controlerMenuCliente;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaAddProduto {

    @FXML
    private TextField textFieldNameProduct;

    @FXML
    private TextField textFieldQuantidadeProduct;

    @FXML
    void btnClickConfirm(ActionEvent event) {
    	Main.cliente.getListaDeCompras().adicionarItem(
    			textFieldNameProduct.getText(), 
    			Integer.parseInt(textFieldQuantidadeProduct.getText()));
    }
    
   
    @FXML
    void btnClickBack(ActionEvent event) {
    	Main.changeTela(telas.menuCliente);
    }
    

}
