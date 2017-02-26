/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package iRecord.Controller;

import entities.Artist;
import iRecord.iRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 *
 * @author nisan
 */
public class XMLManager {
    
    public static void main(String[] args) {
        //importXML("AR002");
        //TODO
    }
    
    public static List<Timestamp> importXML(String ArtistID) {
        List<Timestamp> tsList = new ArrayList<Timestamp>();
        Document doc;
        try {
            System.out.println("Importing XML from HIA System - Artist " + ArtistID);
            try{
                File inputFile = new File("src/xmlimport/HIA-Artist-" + ArtistID + ".xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
            }catch(Exception e){
                File inputFile = new File("xmlimport/HIA-Artist-" + ArtistID + ".xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
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
    
    /**
     * On a given artist it will export to xml the show dates of the artist
     *
     * @param art
     */
    public static void ExportXML(){
        List<Artist> arrl = new ArrayList<Artist>();
        ResultSet qry = iRecord.getDB().query("SELECT ArtistID from Artists");
        
        try {
            while(qry.next()){
                arrl.add(new Artist(qry.getString(1)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //ExportArtistsXML(arrl.toArray(new Artist[arrl.size()]));
        ExportSessionXML(arrl.toArray(new Artist[arrl.size()]));
    }
    public static void ExportSessionXML(Artist[] arts) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder
                    = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // root element
            Element rootElement = doc.createElement("iRecordXML");
            doc.appendChild(rootElement);

            //  supercars element
            Element time = doc.createElement("DateCreated");
            rootElement.appendChild(time);
            time.appendChild(doc.createTextNode((new java.util.Date()).toString()));

            for (Artist art : arts) {
                Element artistXML = doc.createElement("Artist");
                rootElement.appendChild(artistXML);
                
                // setting attribute to element
                Attr attr = doc.createAttribute("ID");
                attr.setValue(art.getID());
                artistXML.setAttributeNode(attr);

                //Run the query and get session dates
                ResultSet qry = iRecord.getDB().query("SELECT sessionStartDate FROM Session where ArtistID=\"" + art.getID() + "\"");
                while (qry.next()) {
                    Element session = doc.createElement("Session");
                    session.appendChild(
                            doc.createTextNode(qry.getDate("sessionStartDate").toGMTString()));

                    session.setAttribute("timestamp", String.valueOf(qry.getDate("sessionStartDate").getTime()));
                    artistXML.appendChild(session);
                }
            }
            // carname element

            // write the content into xml file
            TransformerFactory transformerFactory
                    = TransformerFactory.newInstance();
            Transformer transformer
                    = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            
            PrintStream prntstrm = new PrintStream(new File("iRecord-Artist-Sessions.xml"));
            iRecord.log("Aquiring stream result");
            StreamResult result
                    = new StreamResult(prntstrm);
            iRecord.log("Transforming result");
            transformer.transform(source, result);
     iRecord.log("Successfully exported iRecord-Artist-Sessions.xml file for HIA System.");
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
