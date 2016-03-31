/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmi.gui.loader;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import cmi.CMI;


/**
 *
 * @author kseniadiogenova
 */
public class Loader {
    
    private static Loader loader;   //Экзепляр класса загрузчика - с ним будут работать все окна
    private Stage stage;            //Окно на котором отрисовывается
    private Scene mainMenu;         //Главное меню
    private FXMLLoader fxmlLoader;
    
    public Loader(Stage stage){
        this.stage = stage;
        fxmlLoader = new FXMLLoader();
    }
    
    public static Loader initLoader(Stage stage){
        if(loader==null){
           loader = new Loader(stage); 
        }
        return loader;
    }
    
    public static Loader getLoader(){        
        return loader;
    }
    
    public void loadMainMenu() throws IOException{   
        if(mainMenu == null){
            Parent root = fxmlLoader.load(getClass().getResource("mainMenu/FXMLMainMenu.fxml"));/*);   Loader.class.getResource("mainMenu/FXMLMainMenu.fxml")     */
            Scene scene = new Scene(root);
            stage.show();
            mainMenu = scene;
        }
        stage.setScene(mainMenu);
    }
    
}
