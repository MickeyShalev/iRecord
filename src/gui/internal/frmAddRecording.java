/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui.internal;

import Validators.EmailValidator;
import entities.Recording;
import gui.main.iWindow;
import iRecord.Controller.RecordingManager;
import iRecord.iRecord;
import iRecord.utilities.FileManager;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author nisan
 */
public class frmAddRecording extends javax.swing.JInternalFrame {
    private int sessionID, length, min, sec;
    private String lyrics, name, url, status, recID, prevRec;
    private String filePath;

    
    /**
     * Creates new form frmCreateSession
     */
    public frmAddRecording(int sessionID) {
        this.sessionID = sessionID;
        
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

        jLabel16 = new javax.swing.JLabel();
        pnlAdd = new javax.swing.JPanel();
        lblStudio = new javax.swing.JLabel();
        lblRate = new javax.swing.JLabel();
        lblmaxMus = new javax.swing.JLabel();
        lblisloation = new javax.swing.JLabel();
        lblLyricsError = new javax.swing.JLabel();
        tfURL = new javax.swing.JTextField();
        lblTitleError = new javax.swing.JLabel();
        lblStudioID = new javax.swing.JLabel();
        cbState = new javax.swing.JComboBox<>();
        lblPhone1 = new javax.swing.JLabel();
        lblRecording = new javax.swing.JLabel();
        Min = new javax.swing.JComboBox<>();
        Sec = new javax.swing.JComboBox<>();
        lblRate1 = new javax.swing.JLabel();
        lblRate2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblURLError = new javax.swing.JLabel();
        lblisloation1 = new javax.swing.JLabel();
        tfTitle1 = new javax.swing.JTextField();
        lblprvERR = new javax.swing.JLabel();
        attachFile = new javax.swing.JButton();
        lblPath = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lblGen = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();

        setBackground(new Color(0,0,0,0));
        getContentPane().setLayout(null);

        jLabel16.setBackground(new Color(0,0,0,0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Add new roon window");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 0, 360, 30);

        pnlAdd.setBackground(new Color(255,255,255,60));
        pnlAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStudio.setForeground(new java.awt.Color(255, 255, 255));
        lblStudio.setText("Session ID");
        pnlAdd.add(lblStudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        lblRate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRate.setForeground(new java.awt.Color(255, 255, 255));
        lblRate.setText("Youtube URL");
        pnlAdd.add(lblRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 90, -1));

        lblmaxMus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmaxMus.setForeground(new java.awt.Color(255, 255, 255));
        lblmaxMus.setText("Song Length");
        pnlAdd.add(lblmaxMus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 130, -1));

        lblisloation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblisloation.setForeground(new java.awt.Color(255, 255, 255));
        lblisloation.setText("Pervious Recording");
        pnlAdd.add(lblisloation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 130, -1));

        lblLyricsError.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblLyricsError.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblLyricsError, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 390, 20));

        tfURL.setText("Enter URL");
        tfURL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfURLFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfURLFocusLost(evt);
            }
        });
        pnlAdd.add(tfURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, 190, -1));

        lblTitleError.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblTitleError.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblTitleError, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 390, 20));

        lblStudioID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStudioID.setForeground(new java.awt.Color(255, 255, 255));
        lblStudioID.setText("ID");
        pnlAdd.add(lblStudioID, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 190, -1));

        cbState.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Option", "Sketelon", "Demo", "Mastered" }));
        cbState.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbStateFocusLost(evt);
            }
        });
        pnlAdd.add(cbState, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 190, -1));

        lblPhone1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhone1.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone1.setText("Recording ID");
        pnlAdd.add(lblPhone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblRecording.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRecording.setForeground(new java.awt.Color(255, 255, 255));
        lblRecording.setText("NUM");
        pnlAdd.add(lblRecording, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 190, -1));

        Min.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minutes", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        Min.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                MinFocusLost(evt);
            }
        });
        pnlAdd.add(Min, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 80, -1));

        Sec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minutes", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", " " }));
        Sec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                SecFocusLost(evt);
            }
        });
        pnlAdd.add(Sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 80, -1));

        lblRate1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRate1.setForeground(new java.awt.Color(255, 255, 255));
        lblRate1.setText("Song Title");
        pnlAdd.add(lblRate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        lblRate2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRate2.setForeground(new java.awt.Color(255, 255, 255));
        lblRate2.setText("Lyrics");
        pnlAdd.add(lblRate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 90, -1));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Lyrics");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextArea1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextArea1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        pnlAdd.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 190, 100));

        lblURLError.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblURLError.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblURLError, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 390, 20));

        lblisloation1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblisloation1.setForeground(new java.awt.Color(255, 255, 255));
        lblisloation1.setText("Recording Status");
        pnlAdd.add(lblisloation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 130, -1));

        tfTitle1.setText("Enter privious recording id");
        tfTitle1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfTitle1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfTitle1FocusLost(evt);
            }
        });
        pnlAdd.add(tfTitle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 190, -1));

        lblprvERR.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblprvERR.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblprvERR, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 390, 20));

        attachFile.setText("Attach File");
        attachFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                attachFileMouseClicked(evt);
            }
        });
        pnlAdd.add(attachFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 190, -1));

        lblPath.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblPath.setForeground(new java.awt.Color(255, 51, 51));
        pnlAdd.add(lblPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 570, 20));

        tfName.setText("Enter title");
        tfName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfNameFocusLost(evt);
            }
        });
        pnlAdd.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, -1));

        getContentPane().add(pnlAdd);
        pnlAdd.setBounds(0, 40, 780, 370);

        lblGen.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblGen.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblGen);
        lblGen.setBounds(10, 460, 380, 20);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Recording");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(10, 430, 160, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tfURLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfURLFocusGained
        if (tfURL.getText().equals("Enter URL"))
            tfURL.setText("");
    }//GEN-LAST:event_tfURLFocusGained
                    
    private void tfURLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfURLFocusLost
        String temp = tfURL.getText();
        if (tfURL.getText().equals("")){
            url = "N/A";
            updateWin();
            return;
        }
        
        if (!EmailValidator.validateURL(temp)){
            lblURLError.setText("Invalid URL");
            url = null;
            updateWin();
            return;
        }

        
        lblURLError.setText("");
        url = temp;
        updateWin();
    }//GEN-LAST:event_tfURLFocusLost
                
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        //System.out.println(sessionID + " " + recID + " " + min +" "+ sec +" "+ name +" " + lyrics +" "+ url +" "+ status + " " + filePath);
        
        if (sessionID < 1 || recID == null || min < 0 || sec < 0 || name == null || lyrics == null || url == null || filePath == null || status == null){
            lblGen.setText("One or more fields ane missing");
            updateWin();
            return;
        }
        length = min*60+sec;
        Recording rec = new Recording(sessionID, length, recID, name, lyrics, url, filePath, status, prevRec);
        
        if (RecordingManager.addRecording(rec) < 0){
            lblGen.setForeground(Color.red);
            lblGen.setText("Something went wrong");
        }
        else{
            lblGen.setForeground(Color.GREEN);
            lblGen.setText("Recording was added successfully");
        }
        
        updateWin();
         
    }//GEN-LAST:event_btnAddMouseClicked

    private void jTextArea1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusGained
        if (jTextArea1.getText().equals("Lyrics"))
            jTextArea1.setText("");
        
    }//GEN-LAST:event_jTextArea1FocusGained

    private void jTextArea1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextArea1FocusLost

        if (jTextArea1.getText().length() < 20) {
            lblLyricsError.setText("You must add lyrics");
            lyrics = null;
            
        }
        
        lyrics = jTextArea1.getText();
        lblLyricsError.setText("");
        iWindow.update();

    }//GEN-LAST:event_jTextArea1FocusLost

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

    private void MinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MinFocusLost
        if (Min.getSelectedIndex() == 0){
            min = -1;
            return;
        }
        
        min = Min.getSelectedIndex()-1;
        return;
    }//GEN-LAST:event_MinFocusLost

    private void SecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_SecFocusLost
        if (Sec.getSelectedIndex() == 0){
            sec = -1;
            return;
        }
        
        sec = Min.getSelectedIndex()-1;
        return;
    }//GEN-LAST:event_SecFocusLost

    private void cbStateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbStateFocusLost
        if (cbState.getSelectedIndex() == 0) {
            status = null;
            return;
        }
        status = (String)cbState.getSelectedItem();
    }//GEN-LAST:event_cbStateFocusLost

    private void tfTitle1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTitle1FocusGained
        if (tfTitle1.getText().equals("Enter privious recording id"))
            tfTitle1.setText("");
    }//GEN-LAST:event_tfTitle1FocusGained

    private void tfTitle1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfTitle1FocusLost
        String temp = tfTitle1.getText();
        
        //check if the recording belongs to the artist
        if (temp.equals("")){
            prevRec = null;
            return;
        }
        
        if (!RecordingManager.isArtistsRec(temp, iRecord.getLoggedUser().getID())){
            lblprvERR.setText("Recording doesn't belong to artist");
            updateWin();
            return;
        }
        
        //check if already previous
        if (RecordingManager.isAlreadyPrevious(temp)){
            lblprvERR.setText("Recording is already previous of another recording");
            updateWin();
            return;
        }
        
        
        String prevStatus = RecordingManager.getRecordingStatus(temp);
        if (prevStatus.equals("Sketlon") || prevStatus.equals("Demo") && status.equals("Mastered")){
            setRecordingStatus();
        }

        else if (prevStatus.equals("Sketlon") || status.equals("Demo")){
            setRecordingStatus();
        }

        else if (prevStatus.equals(status)){
            setRecordingStatus();
        }
        
        else{
            lblprvERR.setText("Privious status doesn't match current recrding status");
            updateWin();
            return;
        }
        
        
    }//GEN-LAST:event_tfTitle1FocusLost

    private void attachFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_attachFileMouseClicked
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        try {
            long size = Files.size(f.toPath()) / 1000;
            if(size>15360){
                //errFile.setIcon(xIcon.getIcon());
                lblPath.setText("File size can't be larger than 15MB");
                iWindow.update();
                return;
            }
            iRecord.log("Attempting to upload file size: "+(Files.size(f.toPath())) / 1000+"KB" );
          
        } catch (IOException ex) {
            Logger.getLogger(frmAddRecording.class.getName()).log(Level.SEVERE, null, ex);
        }
        String path = f.getAbsolutePath();
        lblPath.setText(path);
        
        String extension = "";

        int i = path.lastIndexOf('.');
        int p = Math.max(path.lastIndexOf('/'), path.lastIndexOf('\\'));

        if (i > p) {
            extension = path.substring(i+1);
        }
        
        if(!extension.contains("zip")){
            //errFile.setIcon(xIcon.getIcon());
            lblPath.setText("Up to 15MB zip file only");
            iWindow.update();
            return;
        }
        
        
        filePath = FileManager.toBase64(f);
        updateWin();
        
        /*
        //Try creating the file
        File uploads = new File("src/sources/recordings");
        iRecord.log("Upload dir: "+uploads.getAbsolutePath());
        File tmp = new File(uploads, recID+"."+extension);
        iRecord.log("Tmp file: "+tmp.getAbsolutePath());
        
        try {
           Files.copy(f.toPath(), tmp.toPath(), REPLACE_EXISTING);
           //errFile.setIcon(vIcon.getIcon());
           lblPath.setForeground(Color.GREEN);
           lblPath.setText("File was successfully saved");
        } catch (IOException ex) {
            Logger.getLogger(frmAddRecording.class.getName()).log(Level.SEVERE, null, ex);
            //errFile.setIcon(xIcon.getIcon());
            lblPath.setForeground(Color.red);
            lblPath.setText("Failed to save file.");
        }
        iRecord.log("Finished uploading. Short path: "+tmp.toPath());
        String shortIconPath = tmp.toPath().toString().replace("\\", "/").replace("/src", "");
        shortIconPath = shortIconPath.substring(1);
        iRecord.log("Short Icon Path: "+shortIconPath);
//        this.iconPath = shortIconPath;
//        try{
//        imgDisplay.setIcon(new javax.swing.ImageIcon(getClass().getResource(shortIconPath))); // NOI18N
//        } catch(Exception e){
//            imgDisplay.setVisible(false);
//        }
        filePath = tmp.getAbsolutePath();
        iWindow.update();
*/
    }//GEN-LAST:event_attachFileMouseClicked

    private void tfNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNameFocusGained
        if (tfName.getText().equals("Enter title"))
            tfName.setText("");
        
    }//GEN-LAST:event_tfNameFocusGained

    private void tfNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNameFocusLost
        if (tfName.getText().length() < 3){
            lblTitleError.setText("Must enter song name");
            name = null;
            updateWin();
            return;
        }
        
        name = tfName.getText();
        lblTitleError.setText("");
        updateWin();
    }//GEN-LAST:event_tfNameFocusLost

        
    private void init(){
        lblStudioID.setText("" + sessionID);
        
        initRecID(); 
    }
    
    /**
     * this method generates random id for artist
     * the generated id is checked by the controller before it's set
     */
    private void initRecID(){
        Random rand = new Random();
        int num = 0;
        String tempID = null;
        while (true){
            num = rand.nextInt(99999);
            if (num > 10000){
                tempID = "RE"+num;
                
                if (RecordingManager.getRecordingStatus(tempID) == null){
                    recID = tempID;
                    lblRecording.setText(tempID);
                    updateWin();
                    return;
                }
            }
        }

    }
    
    /**
     * Helper method for code reuse
     */
    private void setRecordingStatus(){
        
    }
    
    public void updateWin(){
        
        iWindow.update();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Min;
    private javax.swing.JComboBox<String> Sec;
    private javax.swing.JButton attachFile;
    private javax.swing.JButton btnAdd;
    private javax.swing.JComboBox<String> cbState;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblGen;
    private javax.swing.JLabel lblLyricsError;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblRate;
    private javax.swing.JLabel lblRate1;
    private javax.swing.JLabel lblRate2;
    private javax.swing.JLabel lblRecording;
    private javax.swing.JLabel lblStudio;
    private javax.swing.JLabel lblStudioID;
    private javax.swing.JLabel lblTitleError;
    private javax.swing.JLabel lblURLError;
    private javax.swing.JLabel lblisloation;
    private javax.swing.JLabel lblisloation1;
    private javax.swing.JLabel lblmaxMus;
    private javax.swing.JLabel lblprvERR;
    private javax.swing.JPanel pnlAdd;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfTitle1;
    private javax.swing.JTextField tfURL;
    // End of variables declaration//GEN-END:variables
}
