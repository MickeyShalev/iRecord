/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui.internal;

import Validators.EmailValidator;
import entities.Artist;
import gui.main.iWindow;
import iRecord.Controller.ArtistManager;
import iRecord.Validators.CharValidator;
import iRecord.utilities.EAuth;
import java.awt.Color;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author nisan
 */
public class frmAddArtist extends javax.swing.JInternalFrame {
    private String artistID;
    private String stageName;
    private String Email;
    private String password;
    private Date Exipred;
    
    /**
     * Creates new form frmCreateSession
     */
    public frmAddArtist() {
        setTitle("Add Artist Page");
        initComponents();
        
        init();
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblArtistID = new javax.swing.JLabel();
        lblStageName = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblPass2 = new javax.swing.JLabel();
        lblPass1 = new javax.swing.JLabel();
        lblMailError = new javax.swing.JLabel();
        tfStageName = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        lblPass4 = new javax.swing.JLabel();
        lblNameError = new javax.swing.JLabel();
        Pass1 = new javax.swing.JPasswordField();
        Pass2 = new javax.swing.JPasswordField();
        lblGen = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        getContentPane().setLayout(null);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Artist");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(10, 230, 110, 23);

        jLabel16.setBackground(new Color(0,0,0,0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Add new artist window");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 0, 360, 30);

        lblID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("Artist id");
        getContentPane().add(lblID);
        lblID.setBounds(150, 50, 110, 15);

        lblArtistID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblArtistID.setForeground(new java.awt.Color(255, 255, 255));
        lblArtistID.setText("Artist ID");
        getContentPane().add(lblArtistID);
        lblArtistID.setBounds(10, 50, 110, 15);

        lblStageName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStageName.setForeground(new java.awt.Color(255, 255, 255));
        lblStageName.setText("Stage Name");
        getContentPane().add(lblStageName);
        lblStageName.setBounds(10, 80, 110, 15);

        lblEmail.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(10, 105, 110, 20);

        lblPass2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPass2.setForeground(new java.awt.Color(255, 255, 255));
        lblPass2.setText("Retype Password");
        getContentPane().add(lblPass2);
        lblPass2.setBounds(10, 170, 110, 15);

        lblPass1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPass1.setForeground(new java.awt.Color(255, 255, 255));
        lblPass1.setText("Password");
        getContentPane().add(lblPass1);
        lblPass1.setBounds(10, 140, 110, 15);

        lblMailError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMailError.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblMailError);
        lblMailError.setBounds(330, 110, 280, 20);

        tfStageName.setText("Enter stage name");
        tfStageName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfStageNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfStageNameFocusLost(evt);
            }
        });
        tfStageName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfStageNameActionPerformed(evt);
            }
        });
        getContentPane().add(tfStageName);
        tfStageName.setBounds(150, 80, 170, 20);

        tfEmail.setText("Enter Email");
        tfEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEmailFocusLost(evt);
            }
        });
        getContentPane().add(tfEmail);
        tfEmail.setBounds(150, 110, 170, 20);

        lblPass4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPass4.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblPass4);
        lblPass4.setBounds(330, 170, 280, 20);

        lblNameError.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNameError.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblNameError);
        lblNameError.setBounds(330, 80, 280, 20);

        Pass1.setText("jPasswordField1");
        Pass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Pass1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Pass1FocusLost(evt);
            }
        });
        getContentPane().add(Pass1);
        Pass1.setBounds(150, 140, 170, 20);

        Pass2.setText("jPasswordField2");
        Pass2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Pass2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Pass2FocusLost(evt);
            }
        });
        getContentPane().add(Pass2);
        Pass2.setBounds(150, 170, 170, 20);

        lblGen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGen.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblGen);
        lblGen.setBounds(150, 230, 380, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tfStageNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfStageNameFocusGained
        if (tfStageName.getText().equals("Enter stage name"))
            tfStageName.setText("");
    }//GEN-LAST:event_tfStageNameFocusGained
    
    private void tfEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusGained
        if (tfEmail.getText().equals("Enter Email"))
            tfEmail.setText("");
    }//GEN-LAST:event_tfEmailFocusGained
    
    private void Pass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Pass1FocusGained
        Pass1.setText("");
    }//GEN-LAST:event_Pass1FocusGained
    
    private void Pass2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Pass2FocusGained
        Pass2.setText("");
    }//GEN-LAST:event_Pass2FocusGained
    
    private void tfStageNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfStageNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfStageNameActionPerformed

    private void tfStageNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfStageNameFocusLost
        String sn = tfStageName.getText();
        if (sn.length() < 3){
            lblNameError.setText("Name is too short");
            stageName = null;
            updateWin();
            return;
        }
        if (!CharValidator.isWord(sn)){
            lblNameError.setText("Name must contain at least 3 valid letters");
            stageName = null;
            updateWin();
            return;
        }
        
        lblNameError.setText("");
        stageName = sn;
        updateWin();
    }//GEN-LAST:event_tfStageNameFocusLost

    private void tfEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmailFocusLost
        String mail = tfEmail.getText();
        if (!EmailValidator.validateEmail(mail)){
            lblMailError.setText("Please enter valid email - username@domain.host");
            Email = null;
            updateWin();
            return;
        }

        Email = mail;
        updateWin();
        
    }//GEN-LAST:event_tfEmailFocusLost

    private void Pass2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Pass2FocusLost
        String pass1= Pass1.getText();
        String pass2 = Pass2.getText();
        if (pass1.length() < 4){
            lblPass4.setText("Password must contain at least 4 characters");
            password =null;
            updateWin();
            return;
        }
        
        if (!pass1.equals(pass2)){
            lblPass4.setText("Passwords does not match");
            password =null;
            updateWin();
            return;
        }
        
        lblPass4.setText("");
        password = pass2;
        updateWin();
  
    }//GEN-LAST:event_Pass2FocusLost

    private void Pass1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Pass1FocusLost
        String pass1= Pass1.getText();
        String pass2 = Pass2.getText();
        if (pass1.length() < 4){
            lblPass4.setText("Password must contain at least 4 characters");
            password =null;
            updateWin();
            return;
        }
        
        if (!pass1.equals(pass2)){
            lblPass4.setText("Passwords does not match");
            password =null;
            updateWin();
            return;
        }
        
        updateWin();
        
    }//GEN-LAST:event_Pass1FocusLost

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (artistID == null || stageName == null || Email == null || password == null){
            lblGen.setText("One or more fields ane missiong");
            updateWin();
            return;
        }
        else{
            //Artist toAdd = new Artist(artistID, stageName, password, new java.sql.Date dateExpired(), new EAuth(Artist));
        }
        
    }//GEN-LAST:event_btnAddMouseClicked
    
    
    
    
    
    private void init(){
        createArtistID();
   
    }
    
    /**
     * this method generates random id for artist
     * the generated id is checked by the controller before it's set
     */
    private void createArtistID(){
        Random rand = new Random();
        int num = 0;
        String tempID = null;
        while (ArtistManager.checkExistence(tempID) && num < 1000){
            num = rand.nextInt(9999);
            tempID = "AR"+num;
            
            if (ArtistManager.checkExistence(tempID))
                artistID = tempID;
        }
        
        iWindow.log("Found empty ID for artist " + artistID);
                
    }
    
    public void updateWin(){
        
        iWindow.update();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Pass1;
    private javax.swing.JPasswordField Pass2;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel lblArtistID;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGen;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblMailError;
    private javax.swing.JLabel lblNameError;
    private javax.swing.JLabel lblPass1;
    private javax.swing.JLabel lblPass2;
    private javax.swing.JLabel lblPass4;
    private javax.swing.JLabel lblStageName;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfStageName;
    // End of variables declaration//GEN-END:variables
}