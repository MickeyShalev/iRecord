/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui.internal;

import Validators.EmailValidator;
import Validators.PhoneValidator;
import Validators.PositiveValidator;
import entities.*;
import gui.main.iWindow;
import iRecord.Controller.ArtistManager;
import iRecord.Controller.StudioAndRoomManager;
import iRecord.Validators.CharValidator;
import iRecord.utilities.EAuth;
import java.awt.Color;
import java.util.Date;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author nisan
 */
public class frmAddRoom extends javax.swing.JInternalFrame {
    private int studioID;
    private int roomID;
    private double hourRate;
    private int maxMusicians;
    private boolean hasIsolation;
    
    /**
     * Creates new form frmCreateSession
     */
    public frmAddRoom() {
        setTitle("Add Room");
        initComponents();
        
        init();
        
    }
    
    
    public frmAddRoom(int id) {
        setTitle("Add Room");
        initComponents();
        studioID = id;
        slctStudio.disable();
        
        int room = StudioAndRoomManager.getNextRoomNum(id);
        lblNum.setText(Integer.valueOf(room).toString());
        roomID = room;
        updateWin(); 
         
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
        lblMaxError = new javax.swing.JLabel();
        tfCost = new javax.swing.JTextField();
        tfEmaxNum = new javax.swing.JTextField();
        lblCostError = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        boxIso = new javax.swing.JComboBox<>();
        slctStudio = new javax.swing.JComboBox<>();
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
        lblStudio.setText("Select Studio");
        pnlAdd.add(lblStudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        lblRate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRate.setForeground(new java.awt.Color(255, 255, 255));
        lblRate.setText("Cost / Hour");
        pnlAdd.add(lblRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        lblmaxMus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmaxMus.setForeground(new java.awt.Color(255, 255, 255));
        lblmaxMus.setText("Maximum musicians");
        pnlAdd.add(lblmaxMus, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, -1));

        lblisloation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblisloation.setForeground(new java.awt.Color(255, 255, 255));
        lblisloation.setText("Isolation in Room");
        pnlAdd.add(lblisloation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 130, -1));

        lblMaxError.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblMaxError.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblMaxError, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 390, 20));

        tfCost.setText("Enter Room Cost");
        tfCost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCostFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCostFocusLost(evt);
            }
        });
        pnlAdd.add(tfCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 190, -1));

        tfEmaxNum.setText("Enter Number of Musicians");
        tfEmaxNum.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfEmaxNumFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfEmaxNumFocusLost(evt);
            }
        });
        pnlAdd.add(tfEmaxNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 190, -1));

        lblCostError.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblCostError.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblCostError, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 390, 20));

        lblPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Room Number");
        pnlAdd.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setText("Room Number");
        pnlAdd.add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 190, 20));

        boxIso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Option", "Yes", "No" }));
        boxIso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boxIsoMouseExited(evt);
            }
        });
        pnlAdd.add(boxIso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 190, -1));

        slctStudio.setModel(new javax.swing.DefaultComboBoxModel<>(new Studio[] { new Studio("Select Studio") }));
        slctStudio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                slctStudioItemStateChanged(evt);
            }
        });
        slctStudio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                slctStudioPropertyChange(evt);
            }
        });
        pnlAdd.add(slctStudio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 190, -1));

        getContentPane().add(pnlAdd);
        pnlAdd.setBounds(0, 40, 780, 260);

        lblGen.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblGen.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblGen);
        lblGen.setBounds(20, 340, 380, 20);

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Room");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(20, 310, 100, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tfCostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCostFocusGained
        if (tfCost.getText().equals("Enter Room Cost"))
            tfCost.setText("");
    }//GEN-LAST:event_tfCostFocusGained
    
    private void tfEmaxNumFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmaxNumFocusGained
        if (tfEmaxNum.getText().equals("Enter Number of Musicians"))
            tfEmaxNum.setText("");
    }//GEN-LAST:event_tfEmaxNumFocusGained
                
    private void tfCostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCostFocusLost
        
        if (!CharValidator.isNumber(tfCost.getText())){
            lblCostError.setText("Invalid number");
            hourRate = -1;
            updateWin();
            return;
        }
        
        double cost = PositiveValidator.stringToNum(tfCost.getText());
        if (cost < 1 || cost > 10000){
            lblCostError.setText("cost shpuld be between 1-10000");
            hourRate = -1;
            updateWin();
            return;
        }
        
        lblCostError.setText("");
        hourRate = cost;
        updateWin();
    }//GEN-LAST:event_tfCostFocusLost
    
    private void tfEmaxNumFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfEmaxNumFocusLost
                
        if (!CharValidator.isNumber(tfEmaxNum.getText())){
            lblMaxError.setText("Invalid number");
            maxMusicians = -1;
            updateWin();
            return;
        }
        
        double max = PositiveValidator.stringToNum(tfEmaxNum.getText());
        if (max < 1 || max > 100){
            lblMaxError.setText("Amount of musicians should bw between 1-100");
            maxMusicians = -1;
            updateWin();
            return;
        }
        
        lblMaxError.setText("");
        maxMusicians = (int) max;
        updateWin();
    }//GEN-LAST:event_tfEmaxNumFocusLost
            
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (studioID < 1 || roomID < 1 || hourRate < 1 || maxMusicians < 1 || boxIso.getSelectedIndex() ==0){
            lblGen.setText("One or more fields ane missing");
            updateWin();
            return;
        }
        else{
            pnlAdd.setVisible(false);
            Room toAdd = new Room (studioID, roomID, hourRate, maxMusicians, hasIsolation);
            
            //TODO - FIX THIS IF 
            if (StudioAndRoomManager.addRoom(toAdd) > 0){
                lblGen.setForeground(Color.GREEN);
                lblGen.setText("Studio was added succefully");
                btnAdd.hide();
            }
            else{
                lblGen.setText("Something went wrong");
                btnAdd.hide();
            }

            updateWin();
            return;
            
        }
         
    }//GEN-LAST:event_btnAddMouseClicked

    private void boxIsoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boxIsoMouseExited
        if (boxIso.getSelectedIndex() == 0) return;
        if (boxIso.getSelectedIndex() == 1) this.hasIsolation = true;
        else if (boxIso.getSelectedIndex() == 2) this.hasIsolation = false;
        
        updateWin();
        return;
    }//GEN-LAST:event_boxIsoMouseExited

    private void slctStudioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_slctStudioItemStateChanged
       if (slctStudio.getSelectedIndex() == 0) return;
        Studio s = (Studio) slctStudio.getSelectedItem();
        System.out.println(s.getsID() + "  " +s.getsName());
        
        studioID = s.getsID();
        int room = StudioAndRoomManager.getNextRoomNum(s.getsID());
        lblNum.setText(Integer.valueOf(room).toString());
        roomID = room;
        updateWin(); 
    }//GEN-LAST:event_slctStudioItemStateChanged

    private void slctStudioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_slctStudioPropertyChange
        
    }//GEN-LAST:event_slctStudioPropertyChange

        
    private void init(){
        initStudios(); 
    }
    
    /**
     * this method generates random id for artist
     * the generated id is checked by the controller before it's set
     */
    private void initStudios(){
       Map<Integer,Studio> studios = StudioAndRoomManager.getStudios();
       for (Studio s:studios.values()){
           slctStudio.addItem(s);
       }
       
    }

    
    public void updateWin(){
        
        iWindow.update();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxIso;
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel lblCostError;
    private javax.swing.JLabel lblGen;
    private javax.swing.JLabel lblMaxError;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRate;
    private javax.swing.JLabel lblStudio;
    private javax.swing.JLabel lblisloation;
    private javax.swing.JLabel lblmaxMus;
    private javax.swing.JPanel pnlAdd;
    private javax.swing.JComboBox<Studio> slctStudio;
    private javax.swing.JTextField tfCost;
    private javax.swing.JTextField tfEmaxNum;
    // End of variables declaration//GEN-END:variables
}
