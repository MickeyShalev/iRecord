/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package gui.internal;

import entities.*;
import gui.main.iWindow;
import iRecord.Controller.ExpertieseManager;
import iRecord.Validators.CharValidator;
import java.awt.Color;
import java.util.HashSet;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author nisan
 */
public class frmAddExpertise extends javax.swing.JInternalFrame {
    
    private javax.swing.JComboBox<Expertise> cbExpertise;
    private String name = null;
    private int num = -1;
    private Expertise toRemove = null;
    
    /**
     * Creates new form frmCreateSession
     */
    public frmAddExpertise() {
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
        lblRate = new javax.swing.JLabel();
        lblMaxError = new javax.swing.JLabel();
        tfCost = new javax.swing.JTextField();
        lblCostError = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblNum = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        lblGen = new javax.swing.JLabel();
        lblPhone1 = new javax.swing.JLabel();
        cbOperation = new javax.swing.JComboBox<>();
        pnlRemove = new javax.swing.JPanel();
        lblMaxError1 = new javax.swing.JLabel();
        lblCostError1 = new javax.swing.JLabel();
        lblPhone2 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        javax.swing.JComboBox<String> cbExpertise = new javax.swing.JComboBox<>();

        setBackground(new Color(0,0,0,0));
        getContentPane().setLayout(null);

        jLabel16.setBackground(new Color(0,0,0,0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Add or Remove expertise");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 0, 360, 30);

        pnlAdd.setBackground(new Color(255,255,255,60));
        pnlAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblRate.setForeground(new java.awt.Color(255, 255, 255));
        lblRate.setText("Expertise Name");
        pnlAdd.add(lblRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, -1));

        lblMaxError.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblMaxError.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblMaxError, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 390, 20));

        tfCost.setText("Enter expertise name");
        tfCost.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCostFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCostFocusLost(evt);
            }
        });
        pnlAdd.add(tfCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 190, -1));

        lblCostError.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblCostError.setForeground(new java.awt.Color(255, 0, 51));
        pnlAdd.add(lblCostError, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 390, 20));

        lblPhone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Expertise Number");
        pnlAdd.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblNum.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblNum.setForeground(new java.awt.Color(255, 255, 255));
        lblNum.setText("Num");
        pnlAdd.add(lblNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 190, 20));

        btnAdd.setBackground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Expertise");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        pnlAdd.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, 20));

        getContentPane().add(pnlAdd);
        pnlAdd.setBounds(10, 70, 780, 120);

        lblGen.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblGen.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblGen);
        lblGen.setBounds(20, 200, 380, 20);

        lblPhone1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhone1.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone1.setText("Select Operation");
        getContentPane().add(lblPhone1);
        lblPhone1.setBounds(20, 40, 102, 20);

        cbOperation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Operation", "Add Expertise", "Remove Expertise" }));
        cbOperation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOperationActionPerformed(evt);
            }
        });
        getContentPane().add(cbOperation);
        cbOperation.setBounds(160, 40, 190, 20);

        pnlRemove.setBackground(new Color(255,255,255,60));
        pnlRemove.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMaxError1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblMaxError1.setForeground(new java.awt.Color(255, 0, 51));
        pnlRemove.add(lblMaxError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 390, 20));

        lblCostError1.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        lblCostError1.setForeground(new java.awt.Color(255, 0, 51));
        pnlRemove.add(lblCostError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 390, 20));

        lblPhone2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPhone2.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone2.setText("Select Expertise");
        pnlRemove.add(lblPhone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnRemove.setBackground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remove Expertise");
        btnRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRemoveMouseClicked(evt);
            }
        });
        pnlRemove.add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 130, 20));

        cbExpertise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbExpertise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExpertiseActionPerformed(evt);
            }
        });
        pnlRemove.add(cbExpertise, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 230, -1));

        getContentPane().add(pnlRemove);
        pnlRemove.setBounds(10, 70, 780, 120);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tfCostFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCostFocusGained
        if (tfCost.getText().equals("Enter expertise name"))
            tfCost.setText("");
    }//GEN-LAST:event_tfCostFocusGained
                    
    private void tfCostFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCostFocusLost
        
        if (!CharValidator.isWord(tfCost.getText()) || tfCost.getText().length() < 3 ){
            lblCostError.setText("Invalid or too short name");
            name = null;
            updateWin();
            return;
        }
        
        lblCostError.setText("");
        name = tfCost.getText();
        updateWin();
    }//GEN-LAST:event_tfCostFocusLost
                
    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        if (num < 0 || name == null){
            lblGen.setForeground(Color.red);
            lblGen.setText("One or more fields ane missing");
            updateWin();
            return;
        }
        else{
            pnlAdd.setVisible(false);
    
            if (ExpertieseManager.addInstrument(num, name)){
                lblGen.setForeground(Color.GREEN);
                lblGen.setText("Expertise was added succefully");
                btnAdd.hide();
            }

            updateWin();
            return;
            
        }
         
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRemoveMouseClicked
        if (cbExpertise.getSelectedIndex() == 0) return;
        if (ExpertieseManager.removeInstrument(toRemove.getNum(), toRemove.getName())){
            lblGen.setForeground(Color.GREEN);
            lblGen.setText("Expertise was removed");
            pnlRemove.setVisible(false);
            updateWin();
        }
        else{
            lblGen.setForeground(Color.red);
            lblGen.setText("Not removoed - there is a musician with this experties");
        }
    }//GEN-LAST:event_btnRemoveMouseClicked

    private void cbOperationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOperationActionPerformed
        if (cbOperation.getSelectedIndex() == 0) return;
        else if (cbOperation.getSelectedIndex() == 1){
            pnlRemove.setVisible(false);
            pnlAdd.setVisible(true);
            num = ExpertieseManager.getNextNum();
            updateWin();
            return;
        }
        
        else if (cbOperation.getSelectedIndex() == 2){
            pnlAdd.setVisible(false);
            pnlRemove.setVisible(false);
            num = -1;
            updateWin();
            return;
        }
    }//GEN-LAST:event_cbOperationActionPerformed

    private void cbExpertiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExpertiseActionPerformed
        if (cbExpertise.getSelectedIndex() == 0) return;
        else toRemove = (Expertise)cbExpertise.getSelectedItem();
        updateWin();

    }//GEN-LAST:event_cbExpertiseActionPerformed

        
    private void init(){
        pnlAdd.setVisible(false);
        pnlRemove.setVisible(false);
        
        
        //Set expertise combo box
        HashSet<Expertise>  exp = ExpertieseManager.getInstrument();
        cbExpertise = new JComboBox<>();
        cbExpertise.removeAllItems();        
        cbExpertise.setModel(new DefaultComboBoxModel<Expertise>(new Expertise[] {new Expertise(0, "Select Expertise")}));
        
        for (Expertise e : exp){
            cbExpertise.addItem(e);
        }
        
    }

    
    public void updateWin(){
        
        iWindow.update();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> cbOperation;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel lblCostError;
    private javax.swing.JLabel lblCostError1;
    private javax.swing.JLabel lblGen;
    private javax.swing.JLabel lblMaxError;
    private javax.swing.JLabel lblMaxError1;
    private javax.swing.JLabel lblNum;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPhone1;
    private javax.swing.JLabel lblPhone2;
    private javax.swing.JLabel lblRate;
    private javax.swing.JPanel pnlAdd;
    private javax.swing.JPanel pnlRemove;
    private javax.swing.JTextField tfCost;
    // End of variables declaration//GEN-END:variables
}
