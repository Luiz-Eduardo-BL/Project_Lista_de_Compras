import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginControler {

    @FXML
    private Button botaoLogin;

    @FXML
    private TextField nomeUser;

    @FXML
    private PasswordField senhaUser;

    @FXML
    void fazerLogin(ActionEvent event) {
      String nome = nomeUser.getText();
      String senha = senhaUser.getText();

      Cliente cliente = new Cliente();
      cliente = cliente.login(nome, senha);

      //se cliente estiver no clienteFile.txt, entao ele logou com sucesso
      if(cliente.isStatusLogin()){
        System.out.println("Login realizado com sucesso!");
      }
      else{
        System.out.println("Login falhou!");
      }
    }

}

