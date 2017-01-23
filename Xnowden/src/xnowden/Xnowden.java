/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xnowden;

import java.awt.AWTException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Henrique
 */
public class Xnowden extends Application {
    Automato  aut;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        try {
            aut = new Automato();
        } catch (AWTException ex) {
            Logger.getLogger(Xnowden.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        btn.setText("Tirar Captura de Ecrã");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    //    System.out.println("Hello World!");
                    aut.takePicture();
                } catch (IOException ex) {
                    Logger.getLogger(Xnowden.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AWTException ex) {
                    Logger.getLogger(Xnowden.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}