package controler.controlerMenuCliente;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class TelaAttProduto {

    @FXML
    private TextField textFieldNameProduct;

    @FXML
    private TextField textFieldQuantidadeProduct;

    @FXML
    void btnClickBack(ActionEvent event) {
    	Main.changeTela(telas.menuCliente);
    }

    @FXML
    void btnClickConfirm(ActionEvent event) {

    }

}
