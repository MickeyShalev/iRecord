/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iRecord.Controller;

import java.io.File;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author nisan
 */
public class XMLManager {

    public static void main(String[] args) {
        importXML("AR002"); 
        //TODO
    }

    public static List<Timestamp> importXML(String ArtistID) {
        List<Timestamp> tsList = new ArrayList<Timestamp>();
        Document doc;
        try {
            System.out.println("Importing XML from HIA System - Artist " + ArtistID);
            try{
                File inputFile = new File("src/xmlimport/HIA-Artist-" + ArtistID + ".xml");
                 DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            }catch(Exception e){
                File inputFile = new File("xmlimport/HIA-Artist-" + ArtistID + ".xml");
                 DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            }
           

            NodeList nList = doc.getElementsByTagName("Artist");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (!eElement.getAttribute("ID").equals(ArtistID)) {
                        continue;
                    }

                    NodeList dList = nNode.getChildNodes();
                    //Go through the sessions
                    for (int j = 0; j < dList.getLength(); j++) {
                        String d = dList.item(j).getNodeName();
                        if (!d.equals("Session")) {
                            continue;
                        }
                        Element ele = (Element) dList.item(j);
                        String tsString = ele.getAttribute("timestamp");
                        Node n = dList.item(j);
                        String date = n.getNodeValue();
                        Timestamp ts = new Timestamp(Long.parseLong(tsString));

                        tsList.add(ts);

                        System.err.println("Aquired session - Timestamp: " + tsString + " Date: " + dList.item(j).getTextContent());
                        System.err.println("Converted date: " + tsList.get(tsList.size() - 1));
                    }

                }

                /* if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               System.out.println("Student roll no : " 
                  + eElement.getAttribute("rollno"));
               System.out.println("First Name : " 
                  + eElement
                  .getElementsByTagName("firstname")
                  .item(0)
                  .getTextContent());
               System.out.println("Last Name : " 
               + eElement
                  .getElementsByTagName("lastname")
                  .item(0)
                  .getTextContent());
               System.out.println("Nick Name : " 
               + eElement
                  .getElementsByTagName("nickname")
                  .item(0)
                  .getTextContent());
               System.out.println("Marks : " 
               + eElement
                  .getElementsByTagName("marks")
                  .item(0)
                  .getTextContent());
            }*/
            }
        } catch (Exception e) {
            System.err.println("Could not locate XML File: HIA-Artist-"+ArtistID+".xml");
            
        }
        
               return tsList;
    }

}
