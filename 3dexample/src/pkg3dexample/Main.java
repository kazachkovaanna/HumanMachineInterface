/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dexample;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author Ann
 */
public class Main extends Application {
    Stage primaryStage;
    private TreeMap<String, Atom> atoms;
    private TreeMap<String, ArrayList<Atom>> molecule;
    Group atomsGroup;
    
    private void setGroup(){
        if(atoms != null){
            int length = atoms.size();
            double y = 0;
            double x = 0;
            Random rand = new Random();
            ArrayList elements = new ArrayList();
            for(Atom el: atoms.values()){
                el.setX(x+(double)el.getDiameter());
                y = rand.nextDouble()*200.0;
                el.setY(y);
                Sphere s = new Sphere(el.getDiameter()*10);
                PhongMaterial material1 = new PhongMaterial();
                material1.setDiffuseColor(el.getColor());
                material1.setSpecularColor(Color.WHITESMOKE);
                material1.setSpecularPower(3.0);
                s.setMaterial(material1);
                s.setTranslateX(x);
                s.setTranslateY(y);
                elements.add(s);
                x += (double)(el.getDiameter()+5) *10.0;
            }
            atomsGroup = new Group(elements);
        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();      
        FXMLDocumentController controller = loader.getController();
        Scene scene = new Scene(root);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.show();
        controller.init(scene);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
