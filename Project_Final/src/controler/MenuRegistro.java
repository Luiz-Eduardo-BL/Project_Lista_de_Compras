package controler;

import application.Main;
import application.Main.telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
/* 
 * system inclusions
 */
import services.MsgException;
import services.ServicesAlerts;
import services.ServicesCliente;

public class MenuRegistro {
	private boolean toogleMostrarSenha = false;
	
    @FXML
    private TextField textFieldCpf;

    @FXML
    private TextField textFieldName;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldUser;

    @FXML
    private TextField to;

    @FXML
    void btnClickRegister(ActionEvent event) {
    	try {
    		ServicesCliente.registrar(
    				textFieldName.getText(),
    				textFieldCpf.getText(),
    				textFieldUser.getText(),
    				textFieldPassword.getText());
    		ServicesAlerts.Alerts(AlertType.INFORMATION, "Success", null, "successfully registered");
    		Main.changeTela(telas.menuInicial);
    	}
    	catch(MsgException me) {
    		ServicesAlerts.Alerts(AlertType.ERROR, "Error", null, me.getMessage());
    	}
    }
    
    @FXML
    void btnClickBack(ActionEvent event) {
    	Main.changeTela(telas.menuInicial);
    }

    @FXML
    void mostrarSenha(ActionEvent event) {
        toogleMostrarSenha = toogleMostrarSenha ? false : true;
    	textFieldPassword.setVisible(toogleMostrarSenha);
        to.setText(textFieldPassword.getText());
    }
    
}
