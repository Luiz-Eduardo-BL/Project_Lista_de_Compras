package controler.controlerMenuCliente;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaRmProduto {

    @FXML
    private TextField textFieldNameProduct;

    @FXML
    void btnClickBack(ActionEvent event) {
    	Main.changeTela(telas.menuCliente);
    }

    @FXML
    void btnClickConfirm(ActionEvent event) {

    }

}
