/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingready;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author Hannah Saliot
 */
public class ResultPage{
    @FXML
    private HBox leftHB;
    
    @FXML
    private VBox rightTopVB;
    
    @FXML
    private HBox rightBottomHB;
    
    @FXML
    private MenuItem add;
    
    private Stage thisStage;
    private TextFlow textSelection;
    
    private Evaluation evaluation;
    
    public ResultPage(Evaluation evaluation) throws IOException{
        this.evaluation = evaluation;
        thisStage = new Stage();
        thisStage.setMaximized(true);
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ResultPage.fxml"));
        loader.setController(this);
        
        thisStage.setScene(new Scene(loader.load()));
    }
    
    public void show(){
        thisStage.showAndWait();
    }
    
    @FXML
    private void initialize(){
        Label labelSelection = new Label(evaluation.getSelection() + "\n");
        Label labelStudent = new Label(evaluation.getStudent() + "\n");
        Label labelDateRecorded = new Label(evaluation.getDateRecorded() + "\n");
        
        rightTopVB.getChildren().addAll(labelSelection, labelStudent, labelDateRecorded);
        
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent t) {
                AddWavPage addWavePage = null;
                try {
                    addWavePage = new AddWavPage();
                } catch (IOException ex) {
                    Logger.getLogger(ResultPage.class.getName()).log(Level.SEVERE, null, ex);
                }
                addWavePage.open();
            }
        });
    }
}
