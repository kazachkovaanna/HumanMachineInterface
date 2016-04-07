/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dexample;

import java.util.ArrayList;
import java.util.TreeMap;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author kazac
 */
public class canHandler implements EventHandler<MouseEvent>{
    private Canvas canvas;
    private TreeMap<String, Atom> atoms;
    private TreeMap<String, ArrayList<Atom>> molecule;
    private Atom selectedAtom;
    public canHandler(Canvas c, TreeMap<String, Atom> at,TreeMap<String, ArrayList<Atom>> mol ){
        canvas = c;
        atoms = at;
        molecule = mol;
    }
    @Override
    public void handle(MouseEvent event) {
       //for(Atom)
    }

    
}
