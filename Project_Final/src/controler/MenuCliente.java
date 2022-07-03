package controler;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuCliente {


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
    	Main.changeTela(telas.telaShowProdutos);
    }

    @FXML
    void btnClickRemoverProduto(ActionEvent event) {
    	Main.changeTela(telas.telaRmProduto);
    }
    
    @FXML
    void btnClickCancelarProdutos(ActionEvent event) {
    	Main.cliente.getListaDeCompras().cancelarCompra();
    }

}
