package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import services.MsgException;
import services.ServicesCliente;
import services.ServicesAlerts;
/* 
 * system inclusions
 */
import application.Main;
import application.Main.telas;

public class MenuInicial {

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private Button bntRegister;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField textFieldUser;

    @FXML
    private TextField to;

    @FXML
    void btnClickLogin(ActionEvent event) throws MsgException {
    	try {
    		Main.cliente = ServicesCliente.login(textFieldUser.getText(), textFieldPassword.getText());
    		Main.changeTela(telas.menuCliente);
    	}
    	catch(MsgException me) {
    		ServicesAlerts.Alerts(AlertType.ERROR, "Error", null, me.getMessage());
    	}
    }

    @FXML
    void btnClickRegister(ActionEvent event) {
    	Main.changeTela(telas.menuRegistro);
    }

    @FXML
    void mostrarSenha(ActionEvent event) {
        textFieldPassword.setVisible(false);
        to.setText(textFieldPassword.getText());
    }

}
