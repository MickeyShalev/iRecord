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
        importArtistsXML();
    }
    
    public static List<Timestamp> importXML(String ArtistID) {
        List<Timestamp> tsList = new ArrayList<Timestamp>();
        Document doc = null;
        try {
            System.out.println("Importing XML from HIA System - Artist " + ArtistID);
            try{
                File inputFile = new File("sources/xml/HIA-Artist-Shows.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
            
            
            } catch(Exception e){
                return tsList;
            }
            
            
            NodeList nList = doc.getElementsByTagName("Artist");
            
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
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

            }
        } catch (Exception e) {
            System.err.println("Could not locate XML File: HIA-Artist-Shows.xml");
            
        }
        
        return tsList;
    }
    

    /**
     * Go through all artists and launch the export xml for them
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
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            //Create new XML Document Parser
            Document doc = dBuilder.newDocument();
            // Root element
            Element rootElement = doc.createElement("iRecordXML");
            //Append to the document (doc)
            doc.appendChild(rootElement);

            //  Free element just to note the time this document was created
            Element time = doc.createElement("DateCreated");
            /** Append to the element created before (root)
            <iRecordXML>
              <DateCreated></DateCreated>
            </iRecordXML>
            * */
            rootElement.appendChild(time);
            
            //Create a text node and append so it will show: <DateCreated>d/m/Y h:m:s</dateCreated>
            time.appendChild(doc.createTextNode((new java.util.Date()).toString()));

            /**
             * Now we have:
             * <iRecordXML>
             *  <DateCreated>d/m/y h:m:s</datecreated>
             * </iRecordXML>
             */
            
            //Go through all artists, and for each artist created its' node and sessions
            for (Artist art : arts) {
                
                /**Create a new artist element so it will be:
                * <iRecordXML>
                 *  <DateCreated>d/m/y h:m:s</datecreated>
                 *  <Artist></Artist>
                 *  <Artist></Artist>
                 *  <Artist></Artist>
                 *  <Artist></Artist>
                 * </iRecordXML>
                */
                Element artistXML = doc.createElement("Artist");
                //Append it to the root element (iRecordXML)
                rootElement.appendChild(artistXML);
                
                /**
                 * Set attribute to the element
                 * Attribute shows as <element ATTRIBUTE="var"></element>
                 */
                /**
                 * Create the attribute ID
                 * <Artist ID></Artist>
                */
                Attr attr = doc.createAttribute("ID");
                /**
                 * Set attribute value to be the artist ID 
                 * <Artist ID="{art.getID()}"></Artist>
                 */
                attr.setValue(art.getID());
                //Append to the artist we created
                artistXML.setAttributeNode(attr);

                
                //Aquire session dates of the artist
                /** For each session we will create a child elements to the artist
                 * So we will have:
                * <iRecordXML>
                 *  <DateCreated>d/m/y h:m:s</datecreated>
                 *  <Artist ID="artist id">
                 *      <Session></Session>
                 *      <Session></Session>
                 *      <Session></Session>  
                 *  </Artist>
                 * </iRecordXML>
                * */
                ResultSet qry = iRecord.getDB().query("SELECT sessionStartDate FROM Session where ArtistID=\"" + art.getID() + "\"");
                while (qry.next()) {
                    
                    /** Create a new session element
                    * <Session></Session>
                    */
                    
                    Element session = doc.createElement("Session");
                    
                    /**
                     * Set text node for session element
                     * <Session>d/m/y h:m:s</Session>
                     */
                    session.appendChild(
                            doc.createTextNode(qry.getDate("sessionStartDate").toGMTString()));

                    /**
                     * Set an attribute with the TimeStamp from SQL
                     * <Session timestamp="getTime()">d/m/y h:m:s</Session>
                     */
                    session.setAttribute("timestamp", String.valueOf(qry.getDate("sessionStartDate").getTime()));
                    //Append it
                    artistXML.appendChild(session);
                }
            }


            /**
            * We finished!
            * The document is like this for example:
            * <iRecordXML>
            *  <DateCreated>d/m/y h:m:s</datecreated>
            *  <Artist ID="AR123">
            *      <Session timestamp="12351251512">12/2/2017 02:50:13</Session>
            *      <Session timestamp="65161816516">22/2/2016 15:14:13</Session>
            *      <Session timestamp="65151651656">6/2/2017 02:50:13</Session>
            *  </Artist>
            * </iRecordXML>
             */
            
            
            /**
             * Stuff to build and export the xml, no need to know anything about it
             */
            TransformerFactory transformerFactory
                    = TransformerFactory.newInstance();
            Transformer transformer
                    = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            
            /**
             * Name of the file is configured here
             */
            PrintStream prntstrm = new PrintStream(new File("sources/xml/iRecord-Artist-Sessions.xml"));
            
            
            
            /**
             * More stuff no need to know about
             */
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
    
    
    
    
    
    
    /**
     * This method reads artists xml file created by HIA system and convert it to list of artist 
     * @return 
     */
    public static ArrayList<String[]> importArtistsXML() {
        ArrayList<String[]> artists = new ArrayList<String[]>();
        Document doc;
        try {
            //System.out.println("Importing artist details XML from HIA System - Artists ");
            try{
                //reading file
                File inputFile = new File("sources/xml/HIA-Artist-Sessions.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
            
            
            } catch(Exception e){
                File inputFile = new File("sources/xml/HIA-Artist-Sessions.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
            }
            
            //define the tag name - Artist
            NodeList nList = doc.getElementsByTagName("Artist");
            //for each artist
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);     //load artist i from xml
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    //get his relevent details
                    NodeList dList = nNode.getChildNodes();
                    String id = eElement.getAttribute("ID");
                    String stagename = eElement.getElementsByTagName("strStageName").item(0).getTextContent();
                    String email = eElement.getElementsByTagName("strEmailAddr").item(0).getTextContent();
                    //System.out.println("Read: " + id + " " + stagename + " " + email);
                    artists.add(new String[]{id, stagename, email});
                    
                }

            }
        } catch (Exception e) {
            //System.err.println("Could not locate XML File: HIA-Artist-"+ArtistID+".xml");
            
        }
        
        return artists;
    }
    
   
    
}
