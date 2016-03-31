/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dexample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Ann
 */
public class MolParser extends DefaultHandler {

    private TreeMap<String, Atom> atoms;
    private TreeMap<String, ArrayList<Atom>> molecule;
    private String currentElement;
    private String molName;
    private SAXParserFactory factory;
    private SAXParser parser;
    private AtomParser atp;

    @Override 
    public void startDocument() throws SAXException { 
        try {
            atoms = new TreeMap<String, Atom>();
            molecule = new TreeMap<String, ArrayList<Atom>>();
            factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();
            atp = new AtomParser();
        } catch (ParserConfigurationException ex) {
        }
              
    } 
 
    @Override
    public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
        currentElement = qName;
        int length = attributes.getLength();
        switch(currentElement){
            case "molecule":
                if(length>0)molName = attributes.getValue(0);
                break;
            case "atom":
                String id = attributes.getValue(0);
                String type = attributes.getValue(1);
                File atom = new File("./build/classes/pkg3dexample/atoms/"+type+".xml");
                try {
                    parser.parse(atom, atp);
                    //atoms parser
                }   catch (IOException ex) {                
                }
                Atom atm = atp.getAtom();
                if(type.equals("C")) atm.setColor(Color.BLACK);
                atoms.put(id, atm);
                break;
            case "link":
                String from = attributes.getValue(0);
                String to = attributes.getValue(1);
                ArrayList al = molecule.get(from);
                if(al== null){
                    al = new ArrayList();
                    al.add(to);
                }
                else{
                    al.add(to);
                }
                molecule.replace(from, al);
                break;
        
        }
    }
    
    public TreeMap<String, Atom> getAtoms() {
        return atoms;
    }

    public TreeMap<String, ArrayList<Atom>> getMolecule() {
        return molecule;
    }
   // @Override 
    //public void characters(char[] ch, int start, int length) throws SAXException { 
        
    //}

}
