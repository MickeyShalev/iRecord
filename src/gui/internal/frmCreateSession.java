/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.internal;

import entities.Musician;
import entities.Room;
import entities.Soundman;
import entities.Studio;
import gui.main.iWindow;
import iRecord.iRecord;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import iRecord.Controller.SessionManager;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author nisan
 */
public class frmCreateSession extends javax.swing.JInternalFrame {

    List<java.sql.Date> unavailableDates;
    List<Room> chosenRooms;
    Map<Integer, Studio> studioList;
    Map<String, Soundman> smMap;
    Studio stud;
    Date sessionStartDate, sessionEndDate;
    List<Soundman> chosenSoundmen;
    Map<Musician, Room> chosenMusicians;
    /**
     * Creates new form frmCreateSession
     */
    public frmCreateSession() {
        setTitle("Create Session Page");
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
        jButton1 = new javax.swing.JButton();
        srTitle = new javax.swing.JLabel();
        srDate = new javax.swing.JLabel();
        stDate = new javax.swing.JLabel();
        srTime = new javax.swing.JLabel();
        stTime = new javax.swing.JLabel();
        srStudio = new javax.swing.JLabel();
        stStudio = new javax.swing.JLabel();
        srAddress = new javax.swing.JLabel();
        stAddress = new javax.swing.JLabel();
        srRooms = new javax.swing.JLabel();
        stRooms = new javax.swing.JLabel();
        pnlStudioChooser = new javax.swing.JPanel();
        slctStudio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        pnlDateChooser = new javax.swing.JPanel();
        endTimeSpinner = new javax.swing.JSpinner();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        startTimeSpinner = new javax.swing.JSpinner();
        checkDates = new javax.swing.JButton();
        dateErr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pnlSoundmanChooser = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSoundman = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        errSoundmanlbl = new javax.swing.JLabel();
        pnlMusicianChooser = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMusician = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        errMusicianlbl = new javax.swing.JLabel();
        pnlRoomChooser = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRooms = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        errRoomlbl = new javax.swing.JLabel();
        srtotalSoundmen = new javax.swing.JLabel();
        stTotalSoundmen = new javax.swing.JLabel();

        setBackground(new Color(0,0,0,0));
        getContentPane().setLayout(null);

        jLabel16.setBackground(new Color(0,0,0,0));
        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Welcome to Create Session feature!");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(10, 0, 360, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Create Session");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 470, 140, 20);

        srTitle.setForeground(new java.awt.Color(255, 255, 255));
        srTitle.setText("Session Details");
        getContentPane().add(srTitle);
        srTitle.setBounds(590, 50, 230, 16);

        srDate.setForeground(new java.awt.Color(255, 255, 255));
        srDate.setText("Date");
        getContentPane().add(srDate);
        srDate.setBounds(590, 70, 70, 16);

        stDate.setForeground(new java.awt.Color(255, 255, 255));
        stDate.setText("stDate");
        getContentPane().add(stDate);
        stDate.setBounds(730, 70, 250, 16);

        srTime.setForeground(new java.awt.Color(255, 255, 255));
        srTime.setText("Time");
        getContentPane().add(srTime);
        srTime.setBounds(590, 90, 70, 16);

        stTime.setForeground(new java.awt.Color(255, 255, 255));
        stTime.setText("stTime");
        getContentPane().add(stTime);
        stTime.setBounds(730, 90, 240, 16);

        srStudio.setForeground(new java.awt.Color(255, 255, 255));
        srStudio.setText("Studio");
        getContentPane().add(srStudio);
        srStudio.setBounds(590, 110, 80, 16);

        stStudio.setForeground(new java.awt.Color(255, 255, 255));
        stStudio.setText("stStudio");
        getContentPane().add(stStudio);
        stStudio.setBounds(730, 110, 220, 16);

        srAddress.setForeground(new java.awt.Color(255, 255, 255));
        srAddress.setText("Address");
        getContentPane().add(srAddress);
        srAddress.setBounds(590, 130, 100, 16);

        stAddress.setForeground(new java.awt.Color(255, 255, 255));
        stAddress.setText("stAddress");
        getContentPane().add(stAddress);
        stAddress.setBounds(730, 130, 260, 16);

        srRooms.setForeground(new java.awt.Color(255, 255, 255));
        srRooms.setText("Total Rooms");
        getContentPane().add(srRooms);
        srRooms.setBounds(590, 150, 120, 16);

        stRooms.setForeground(new java.awt.Color(255, 255, 255));
        stRooms.setText("stRooms");
        getContentPane().add(stRooms);
        stRooms.setBounds(730, 150, 200, 16);

        pnlStudioChooser.setOpaque(false);
        pnlStudioChooser.setLayout(null);
        pnlStudioChooser.setVisible(false);

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
        pnlStudioChooser.add(slctStudio);
        slctStudio.setBounds(40, 50, 320, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Select Studio");
        pnlStudioChooser.add(jLabel4);
        jLabel4.setBounds(40, 20, 80, 30);

        getContentPane().add(pnlStudioChooser);
        pnlStudioChooser.setBounds(50, 60, 390, 100);

        pnlDateChooser.setOpaque(false);
        pnlDateChooser.setLayout(null);

        endTimeSpinner.setModel(new SpinnerDateModel());
        endTimeSpinner.setEditor(new JSpinner.DateEditor(endTimeSpinner, "HH:mm"));
        endTimeSpinner.setValue(new Date(54000000));
        endTimeSpinner.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                endTimeSpinnerPropertyChange(evt);
            }
        });
        pnlDateChooser.add(endTimeSpinner);
        endTimeSpinner.setBounds(280, 40, 50, 22);

        jXDatePicker1.setBackground(new Color(0,0,0,0));
        jXDatePicker1.setForeground(new java.awt.Color(204, 0, 153));
        jXDatePicker1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXDatePicker1ActionPerformed(evt);
            }
        });
        pnlDateChooser.add(jXDatePicker1);
        jXDatePicker1.setBounds(10, 40, 160, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Start Time");
        pnlDateChooser.add(jLabel5);
        jLabel5.setBounds(190, 10, 60, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("End Time");
        pnlDateChooser.add(jLabel3);
        jLabel3.setBounds(280, 10, 60, 30);

        startTimeSpinner.setModel(new SpinnerDateModel());
        startTimeSpinner.setEditor(new JSpinner.DateEditor(startTimeSpinner, "HH:mm"));
        startTimeSpinner.setValue(new Date(46800000));
        startTimeSpinner.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                startTimeSpinnerPropertyChange(evt);
            }
        });
        pnlDateChooser.add(startTimeSpinner);
        startTimeSpinner.setBounds(190, 40, 60, 22);

        checkDates.setBackground(new java.awt.Color(255, 255, 255));
        checkDates.setText("Check Dates");
        checkDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDatesActionPerformed(evt);
            }
        });
        pnlDateChooser.add(checkDates);
        checkDates.setBounds(10, 70, 160, 20);

        dateErr.setBackground(new Color(0,0,0,0));
        dateErr.setForeground(new java.awt.Color(255, 255, 255));
        dateErr.setText("err");
        dateErr.setOpaque(true);
        dateErr.setVisible(false);
        pnlDateChooser.add(dateErr);
        dateErr.setBounds(180, 70, 260, 16);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Select Session Date");
        pnlDateChooser.add(jLabel6);
        jLabel6.setBounds(10, 10, 170, 30);

        getContentPane().add(pnlDateChooser);
        pnlDateChooser.setBounds(50, 60, 390, 100);

        pnlSoundmanChooser.setVisible(false);
        pnlSoundmanChooser.setOpaque(false);
        pnlSoundmanChooser.setLayout(null);

        tblSoundman = new javax.swing.JTable(){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    return String.class;
                    case 1:
                    return String.class;
                    default:
                    return Boolean.class;
                }
            }

            public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);

                //  Color row based on a cell value

                int modelRow = convertRowIndexToModel(row);
                if(getValueAt(modelRow, column)==null)
                c.setBackground(Color.LIGHT_GRAY);
                return c;
            }

        };
        tblSoundman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblSoundman);

        pnlSoundmanChooser.add(jScrollPane2);
        jScrollPane2.setBounds(0, 210, 620, 100);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Soundmen Selection");
        pnlSoundmanChooser.add(jLabel9);
        jLabel9.setBounds(10, 10, 160, 14);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Please use the table below in order to select the soundmen to hire. ");
        pnlSoundmanChooser.add(jLabel10);
        jLabel10.setBounds(10, 30, 370, 20);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("You may select several soundmen with same positions to the same session");
        pnlSoundmanChooser.add(jLabel11);
        jLabel11.setBounds(10, 50, 520, 20);

        jButton3.setText("Continue");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlSoundmanChooser.add(jButton3);
        jButton3.setBounds(0, 320, 110, 25);

        errSoundmanlbl.setVisible(false);
        errSoundmanlbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        errSoundmanlbl.setForeground(new java.awt.Color(255, 51, 51));
        errSoundmanlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errSoundmanlbl.setText("errSoundmanlbl");
        pnlSoundmanChooser.add(errSoundmanlbl);
        errSoundmanlbl.setBounds(0, 150, 620, 30);

        getContentPane().add(pnlSoundmanChooser);
        pnlSoundmanChooser.setBounds(50, 60, 820, 370);

        pnlMusicianChooser.setVisible(false);
        pnlMusicianChooser.setOpaque(false);
        pnlMusicianChooser.setLayout(null);

        tblMusician = new javax.swing.JTable(){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    return String.class;
                    case 1:
                    return String.class;
                    case 2:
                    return String.class;

                    default:
                    return String.class;
                }
            }
        };
        tblMusician.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblMusician);

        pnlMusicianChooser.add(jScrollPane3);
        jScrollPane3.setBounds(0, 210, 640, 100);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Musician Selection");
        pnlMusicianChooser.add(jLabel12);
        jLabel12.setBounds(10, 10, 160, 14);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Please use the table below in order to split the musicians into the rooms. ");
        pnlMusicianChooser.add(jLabel13);
        jLabel13.setBounds(10, 30, 370, 20);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Note that the session won't be approve if no musicians are chosen.");
        pnlMusicianChooser.add(jLabel14);
        jLabel14.setBounds(10, 50, 520, 20);

        jButton4.setText("Continue");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlMusicianChooser.add(jButton4);
        jButton4.setBounds(0, 320, 110, 25);

        errRoomlbl.setVisible(false);
        errMusicianlbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        errMusicianlbl.setForeground(new java.awt.Color(255, 51, 51));
        errMusicianlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errMusicianlbl.setText("errMusicianlbl");
        pnlMusicianChooser.add(errMusicianlbl);
        errMusicianlbl.setBounds(0, 150, 620, 30);

        getContentPane().add(pnlMusicianChooser);
        pnlMusicianChooser.setBounds(50, 60, 830, 370);

        pnlRoomChooser.setVisible(false);
        pnlRoomChooser.setOpaque(false);
        pnlRoomChooser.setLayout(null);

        tblRooms = new javax.swing.JTable(){
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    return String.class;
                    case 1:
                    return String.class;
                    case 2:
                    return String.class;
                    case 3:
                    return String.class;
                    default:
                    return Boolean.class;
                }
            }
        };
        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRooms);

        pnlRoomChooser.add(jScrollPane1);
        jScrollPane1.setBounds(0, 210, 640, 100);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Room Selection");
        pnlRoomChooser.add(jLabel2);
        jLabel2.setBounds(10, 10, 160, 14);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Please use the table below in order to select the rooms to rent. ");
        pnlRoomChooser.add(jLabel7);
        jLabel7.setBounds(10, 30, 370, 20);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Note that session will not be approved if not chosen at least one acoustic isolated room.");
        pnlRoomChooser.add(jLabel8);
        jLabel8.setBounds(10, 50, 520, 20);

        jButton2.setText("Continue");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlRoomChooser.add(jButton2);
        jButton2.setBounds(0, 320, 110, 25);

        errRoomlbl.setVisible(false);
        errRoomlbl.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        errRoomlbl.setForeground(new java.awt.Color(255, 51, 51));
        errRoomlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errRoomlbl.setText("errRoomlbl");
        pnlRoomChooser.add(errRoomlbl);
        errRoomlbl.setBounds(0, 150, 620, 30);

        getContentPane().add(pnlRoomChooser);
        pnlRoomChooser.setBounds(50, 60, 830, 370);

        srtotalSoundmen.setForeground(new java.awt.Color(255, 255, 255));
        srtotalSoundmen.setVisible(false);
        srtotalSoundmen.setText("Total Soundmen");
        getContentPane().add(srtotalSoundmen);
        srtotalSoundmen.setBounds(590, 170, 170, 16);

        stTotalSoundmen.setForeground(new java.awt.Color(255, 255, 255));
        stTotalSoundmen.setText("stTotalSoundmen");
        stTotalSoundmen.setVisible(false);
        getContentPane().add(stTotalSoundmen);
        stTotalSoundmen.setBounds(730, 170, 200, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
// TODO add your handling code here:
       
        
       

    }//GEN-LAST:event_jXDatePicker1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      if(slctStudio.getSelectedItem().equals(new Studio("Select Studio")))
          return;
      Studio chosen = (Studio) slctStudio.getSelectedItem();
      System.err.println("Selected studio: "+chosen.getsID()+" - "+chosen.getsName());
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void startTimeSpinnerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_startTimeSpinnerPropertyChange
        // TODO add your handling code here:
        init();
    }//GEN-LAST:event_startTimeSpinnerPropertyChange

    private void endTimeSpinnerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_endTimeSpinnerPropertyChange
        // TODO add your handling code here:
     
    }//GEN-LAST:event_endTimeSpinnerPropertyChange

    private void checkDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDatesActionPerformed
        // TODO add your handling code here:
        updateDate();
        
    }//GEN-LAST:event_checkDatesActionPerformed

    private void slctStudioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_slctStudioPropertyChange
        // TODO add your handling code here:
     
    }//GEN-LAST:event_slctStudioPropertyChange

    private void slctStudioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_slctStudioItemStateChanged
        // TODO add your handling code here:
           stud = (Studio) slctStudio.getSelectedItem();
        if(stud.toString().equals("Select Studio"))
            return;
        System.err.println(stud);
        Object[][] roomList = new Object[stud.getsRooms().size()][5];
        int i=0;
        for(Room r : stud.getsRooms().values()){
            System.err.println("WTF");
            int j=0;
            roomList[i][j++]=r;
            roomList[i][j++]=r.getHourRate();
            roomList[i][j++]=r.getMaxMusicians();
            roomList[i][j++]=r.getHasIsolation();
            roomList[i][j]=Boolean.FALSE;
            i++;
            
        }
        tblRooms.setModel(new javax.swing.table.DefaultTableModel(
    roomList,
    new String [] {
        "#", "Hourly Rate", "Maxmimum Capacity", "Acoustic", "Select Room"
    }
));
        srStudio.setVisible(true);
        stStudio.setText(stud.toString());
        stStudio.setVisible(true);
        srAddress.setVisible(true);
        stAddress.setText(stud.getsAddress());
        stAddress.setVisible(true);
        pnlRoomChooser.setVisible(true);
        pnlStudioChooser.setVisible(false);
    }//GEN-LAST:event_slctStudioItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Boolean flag = false;
        
        chosenRooms = new ArrayList<Room>();
        System.err.println("Number of rows: "+tblRooms.getModel().getRowCount());
        for(int i=0; i<tblRooms.getModel().getRowCount();i++){
            Room r = (Room) tblRooms.getModel().getValueAt(i, 0);
            Boolean selected = (Boolean) tblRooms.getModel().getValueAt(i, 4);
            if(selected){
                chosenRooms.add(r);
                if(r.getHasIsolation() && !flag)
                    flag=r.getHasIsolation();
            System.err.println("Room: #"+r+" Selected: "+selected);
            }
        }
        if(chosenRooms.size()==0){
            errRoomlbl.setText("Must select atleast one room.");
            errRoomlbl.setVisible(true);
        } else if(!flag){
            errRoomlbl.setText("Must have atleast one acoustic room reserved.");
            errRoomlbl.setVisible(true);
        }else{
        
        pnlRoomChooser.setVisible(false);
        pnlSoundmanChooser.setVisible(true);
        srRooms.setVisible(true);
        stRooms.setText(""+chosenRooms.size());
        stRooms.setVisible(true);
        
        }
        
        
        /**
         * Get SM Map
         */
        smMap = new HashMap<String, Soundman>();
        SessionManager.getSMMap(smMap, stud, sessionStartDate, sessionEndDate);
          Object[][] soundmanList = new Object[smMap.size()][5];
        int i=0;
        for(Soundman s : smMap.values()){
        System.err.println("Added Soundman "+s+" to table");
            int j=0;
            soundmanList[i][j++]=s;
            soundmanList[i][j++]="$"+s.getFullPayment().toString()+" ($"+s.getDownPayment().toString()+")";
            
            soundmanList[i][j++]=s.getIsProducer()?false:null;
            soundmanList[i][j++]=s.getIsMixTech()?false:null;
            soundmanList[i][j]=s.getIsMasterTech()?false:null;
            i++;
            
        }
        tblSoundman.setModel(new javax.swing.table.DefaultTableModel(
    soundmanList,
    new String [] {
        "Soundman", "Payment (Advance)", "Producer", "Mix Tech", "Master Tech"
    }
){
            @Override
            public boolean isCellEditable(int row, int column) {
                return getValueAt(row, column) != null;
            }
  
});
       
        iWindow.update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        chosenSoundmen = new ArrayList<Soundman>();
        for(int i=0; i<tblSoundman.getRowCount();i++){
            Soundman s = (Soundman) tblSoundman.getValueAt(i, 0);
            Boolean isProducer =  tblSoundman.getValueAt(i, 2)==null?false:(Boolean)tblSoundman.getValueAt(i, 2);
            Boolean isMixTech =  tblSoundman.getValueAt(i, 3)==null?false:(Boolean)tblSoundman.getValueAt(i, 3);
            Boolean isMasterTech =  tblSoundman.getValueAt(i, 4)==null?false:(Boolean)tblSoundman.getValueAt(i, 4);
            
            //Check if soundman is selected and in what
            if(!isProducer && !isMixTech && !isMasterTech)
                continue;
            
            s.setRoles(isProducer, isMixTech, isMasterTech);
            
            chosenSoundmen.add(s);
            
        }
        srtotalSoundmen.setVisible(true);
        stTotalSoundmen.setText(""+chosenSoundmen.size());
        stTotalSoundmen.setVisible(true);
        pnlSoundmanChooser.setVisible(false);
        
        /**
         * Set the musicians
         */
        chosenMusicians = new HashMap<Musician, Room>();
        SessionManager.getMSMap(chosenMusicians, stud, sessionStartDate, sessionEndDate);
        pnlMusicianChooser.setVisible(true);
        iWindow.update();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    
    private void init(){
        
        /**
         * Hide panel statistics
         * 
         */
        srAddress.setVisible(false);
        srDate.setVisible(false);
        srRooms.setVisible(false);
        srStudio.setVisible(false);
        srTime.setVisible(false);
        stAddress.setVisible(false);
        stDate.setVisible(false);
        stRooms.setVisible(false);
        stStudio.setVisible(false);
        stTime.setVisible(false);
        srTitle.setVisible(false);
                
        
        
        /**
         * Module 1 -> Disable Dates which artist is already occupied
         */
        unavailableDates = ((entities.Artist)iRecord.getLoggedUser()).getUnavailableDates();
        Date[] dates = new Date[unavailableDates.size()];
        dates = (Date[]) unavailableDates.toArray(dates);
        iRecord.importXML(iRecord.getLoggedUser().getID());
        jXDatePicker1.getMonthView().setUnselectableDates(dates);

        
        /**
         * Module 2 -> Display studio and rooms to choose from
         */
        //Get all studios and fill their rooms
        studioList = SessionManager.getStudios();
        
        
    }

    public void updateDate(){
        System.err.println("Date Error\nStartTimeSpinner: "+startTimeSpinner.getValue()+" \nEndTimeSpinner: "+endTimeSpinner.getValue()+"\nDate Chosen: "+jXDatePicker1.getDate());
        if(jXDatePicker1.getDate()==null || ((java.util.Date)startTimeSpinner.getValue()).after((java.util.Date)endTimeSpinner.getValue())){
            dateErr.setText("Please choose a valid date and time");
            
            dateErr.setVisible(true);
            iWindow.update();
            
            return;
        }
        
        dateErr.setVisible(false);
        checkDates.setEnabled(false);
        Date dateStart = jXDatePicker1.getDate();
        Date dateEnd = (Date) dateStart.clone() ;
        Date endTime = (Date)endTimeSpinner.getValue();
        Date startTime = (Date)startTimeSpinner.getValue();
        dateStart.setHours(startTime.getHours());
        dateStart.setMinutes(startTime.getMinutes());
        dateEnd.setHours(endTime.getHours());
        dateEnd.setMinutes(endTime.getMinutes());
        
        /**
         * Set global vars
         */
        sessionStartDate = dateStart;
        sessionEndDate = dateEnd;
        
        Map<Integer, Studio> studioList = SessionManager.getStudios();
        SessionManager.clearRooms(studioList, dateStart, dateEnd);
        pnlStudioChooser.setVisible(true);
        pnlDateChooser.setVisible(false);
        
        /**
         * Add the statistics
         */
        srTitle.setVisible(true);
        srDate.setVisible(true);
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/Y");
        stDate.setText(sdf.format(dateStart));
        stDate.setVisible(true);
        
        srTime.setVisible(true);
        stTime.setText((new SimpleDateFormat("HH:mm").format(dateStart)+" - "+(new SimpleDateFormat("HH:mm").format(dateEnd))));
        stTime.setVisible(true);
        
        for(Studio stud : studioList.values())
            slctStudio.addItem(stud);
        iWindow.update();
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkDates;
    private javax.swing.JLabel dateErr;
    private javax.swing.JSpinner endTimeSpinner;
    private javax.swing.JLabel errMusicianlbl;
    private javax.swing.JLabel errRoomlbl;
    private javax.swing.JLabel errSoundmanlbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JPanel pnlDateChooser;
    private javax.swing.JPanel pnlMusicianChooser;
    private javax.swing.JPanel pnlRoomChooser;
    private javax.swing.JPanel pnlSoundmanChooser;
    private javax.swing.JPanel pnlStudioChooser;
    private javax.swing.JComboBox<Studio> slctStudio;
    private javax.swing.JLabel srAddress;
    private javax.swing.JLabel srDate;
    private javax.swing.JLabel srRooms;
    private javax.swing.JLabel srStudio;
    private javax.swing.JLabel srTime;
    private javax.swing.JLabel srTitle;
    private javax.swing.JLabel srtotalSoundmen;
    private javax.swing.JLabel stAddress;
    private javax.swing.JLabel stDate;
    private javax.swing.JLabel stRooms;
    private javax.swing.JLabel stStudio;
    private javax.swing.JLabel stTime;
    private javax.swing.JLabel stTotalSoundmen;
    private javax.swing.JSpinner startTimeSpinner;
    private javax.swing.JTable tblMusician;
    private javax.swing.JTable tblRooms;
    private javax.swing.JTable tblSoundman;
    // End of variables declaration//GEN-END:variables
}
