/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmi;

import javafx.application.Application;
import javafx.stage.Stage;
import cmi.gui.loader.Loader;
import java.io.IOException;

/**
 *
 * @author kseniadiogenova
 */
public class CMI extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {  
        Loader.initLoader(primaryStage).loadMainMenu();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
