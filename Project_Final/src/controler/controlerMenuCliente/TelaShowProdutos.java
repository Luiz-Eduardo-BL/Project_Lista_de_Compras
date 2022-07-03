package controler.controlerMenuCliente;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import services.ServicesCliente;

public class TelaShowProdutos {

    @FXML
    private Button btnAdicionarProduto;

    @FXML
    private Button btnAtualizarProduto;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnMostrarProdutos;

    @FXML
    private Button btnRemoverProduto;

    @FXML
    void btnClickAdicionarProduto(ActionEvent event) {

    }

    @FXML
    void btnClickAtualizarProduto(ActionEvent event) {

    }

    @FXML
    void btnClickLogout(ActionEvent event) {
    	Main.changeTela(telas.menuInicial);
    }

    @FXML
    void btnClickMostrarProdutos(ActionEvent event) {

    }

    @FXML
    void btnClickRemoverProduto(ActionEvent event) {

    }

}
