/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingready;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lorenz
 */
public class SignupPage implements Initializable {

    @FXML
    private Hyperlink hlSLogin;
    @FXML
    private TextField tfSUsername;
    @FXML
    private TextField tfSFirstName;
    @FXML
    private TextField tfSLastName;
    @FXML
    private PasswordField pfSPassword;
    @FXML
    private PasswordField pfSConfirmPassword;
    @FXML
    private Button btnSSignup;
    @FXML
    private StackPane stackPane;
    
    private Stage thisStage;

    public SignupPage(Stage stage)throws IOException{
        thisStage = stage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignupPage.fxml"));
        loader.setController(this);
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("SignupPage.css").toExternalForm());
        thisStage.setScene(scene);
        thisStage.setMaximized(true);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        stackPane.setPrefHeight(Screen.getPrimary().getBounds().getHeight());
        stackPane.setPrefWidth(Screen.getPrimary().getBounds().getWidth());
        // TODO
        hlSLogin.setOnAction((ActionEvent e) -> {
            try {
                
                toLogin();
                        } catch (IOException ex) {
                Logger.getLogger(SignupPage.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnSSignup.setOnAction((ActionEvent e) -> {
            if(tfSUsername.getText().length()!=0&&pfSPassword.getText().length()!=0&&pfSConfirmPassword.getText().equals(pfSPassword.getText())&&
                    tfSLastName.getText().length()!=00&&tfSFirstName.getText().length()!=00){
                System.out.println(tfSUsername.getText());
                System.out.println(pfSPassword.getText());
                try {
                    toLogin();
                } catch (IOException ex) {
                    Logger.getLogger(SignupPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                System.out.println("else");
        });
    }
    public void toLogin() throws IOException{
        LoginPage login = new LoginPage(thisStage);
    }
}