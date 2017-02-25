package iRecord;

import entities.Recording;
import gui.main.iWindow;
import iRecord.*;
import iRecord.Controller.ExpertieseManager;
import iRecord.Controller.RecordingManager;

/**
 * @author Administrator
 */
public class MainClass {
      public static void main(String[] args) {
          
            //Initiate Main Project
            iRecord project = new iRecord();
            //Initiate GUI
            //JFrame LoginGui = new LoginGui();

            iRecord.log("Opening Login Window through iWindow");
            iWindow.openLogin();
            
        }
      }

