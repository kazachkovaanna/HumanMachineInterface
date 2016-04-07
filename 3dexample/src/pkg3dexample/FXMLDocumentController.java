/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dexample;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author Ann
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Canvas canvas;
    private Scene scene;

    private TreeMap<String, Atom> atoms;
    private TreeMap<String, ArrayList<Atom>> molecule;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        MolParser mparser = new MolParser();
        File f = new File("./build/classes/pkg3dexample/Molecule.xml");
        try {
            parser.parse(f, mparser);
        } catch (SAXException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        atoms = mparser.getAtoms();
        molecule = mparser.getMolecule();
        // TODO
    }    
    public TreeMap<String, Atom> getAtoms() {
        return atoms;
    }

    public TreeMap<String, ArrayList<Atom>> getMolecule() {
        return molecule;
    }
    public void init(Scene sc){
        scene = sc;
        scene.setOnMouseClicked(new canHandler(canvas, atoms, molecule));
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BEIGE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        int i = 0;
        Random rand = new Random();
        for(Entry e:atoms.entrySet()){
            int val = molecule.get(e.getKey()).size();
            double x = i*canvas.getWidth()/atoms.size()+25;
            double y =  rand.nextDouble()*(canvas.getHeight()-40)+20;
            gc.strokeText(atoms.get(e.getKey()).getType(),x ,y);
            for(int j = 0; j<val; j++){
                double xp[]= new double[2];
                double yp[]= new double[2];
            }
            i++;
        }
    }
}
