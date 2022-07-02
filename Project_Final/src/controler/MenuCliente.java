package controler;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import services.ServicesCliente;
import services.ServicesListeDeCompras;

public class MenuCliente {


    @FXML
    void btnClickAdicionarProduto(ActionEvent event) {
    	Main.changeTela(telas.addProduto);
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
    
    @FXML
    void btnClickCancelarProdutos(ActionEvent event) {
    	Main.cliente.getListaDeCompras().cancelarCompra();
    }

}
