package iRecord;

import entities.Musician;
import gui.main.LoginGui;
import gui.main.iWindow;
import iRecord.Controller.ArtistManager;
import iRecord.Controller.FreelancerManager;
import iRecord.Controller.StudioAndRoomManager;
import javax.swing.JFrame;
import iRecord.utilities.EAuth;
import java.util.Date;

/**
 * @author Administrator
 */
public class MainClass {
      public static void main(String[] args) {
          
            //Initiate Main Project
            iRecord project = new iRecord();
            //Initiate GUI
            //JFrame LoginGui = new LoginGui();
            //Musician s = new Musician("FR1111", "A","A","A", 20.0, 1, 0 , new Date(), "A@A.A"); 
            //FreelancerManager.addMusician(s);
            iRecord.log("Opening Login Window through iWindow");
            iWindow.openLogin();
            
        }
      }

