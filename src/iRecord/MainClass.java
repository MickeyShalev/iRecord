/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iRecord;

import gui.main.LoginGui;
import gui.main.iWindow;
import javax.swing.JFrame;
import iRecord.utilities.EAuth;

/**
 *
 * @author Administrator
 */
public class MainClass {
      public static void main(String[] args) {
          
            //Initiate Main Project
            iReport project = new iReport();
            //Initiate GUI
            //JFrame LoginGui = new LoginGui();
            iReport.log("Opening Login Window through iWindow");
            iWindow.openLogin();
            
        }
      }

