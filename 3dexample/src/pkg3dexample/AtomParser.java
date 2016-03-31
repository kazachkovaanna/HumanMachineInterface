/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3dexample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Ann
 */
public class AtomParser extends DefaultHandler {
    private String currentEl;
    private Atom atom;
    
    @Override 
    public void startDocument() throws SAXException { 
        atom = new Atom();
    }
    
    public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException {
        currentEl = qName;
    }
    @Override 
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException { 
      currentEl = ""; 
    } 
 
    
    @Override 
    public void characters(char[] ch, int start, int length) throws SAXException { 
        switch(currentEl){
            case "diameter":
                int value = Integer.parseInt(new String(ch,start,length));
                atom.setDiameter(value);
                break;
            case "valency":
                int val = Integer.parseInt(new String(ch,start,length));
                atom.setValency(val);
                break;
        }
    }
    public Atom getAtom(){
        return atom;
    }
    

}
