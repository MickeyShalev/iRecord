/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.main;

import gui.internal.*;
import iRecord.iRecord;
import java.sql.SQLException;
import java.awt.Color;

/**
 *
 * @author Administrator
 */
public class MainGui extends javax.swing.JFrame {

    /**
     * Creates new form MainGui
     */
    public MainGui() throws SQLException {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        refreshVars();
        iWindow.setPanel(ContentFrame);
        iWindow.setLblTitle(lblTitle);

    
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblUsernames = new javax.swing.JLabel();
        lblUserType = new javax.swing.JLabel();
        pnlAdmin = new javax.swing.JPanel();
        AR = new javax.swing.JPanel();
        AddArtist = new javax.swing.JLabel();
        SuspendArtist = new javax.swing.JLabel();
        SuspendArtist1 = new javax.swing.JLabel();
        FL = new javax.swing.JPanel();
        AddSoundman = new javax.swing.JLabel();
        AddMusician = new javax.swing.JLabel();
        SuspendFreelancer = new javax.swing.JLabel();
        SuspendFreelancer1 = new javax.swing.JLabel();
        STD = new javax.swing.JPanel();
        AddRoom = new javax.swing.JLabel();
        AddStudio = new javax.swing.JLabel();
        CreateSession = new javax.swing.JLabel();
        Artist = new javax.swing.JLabel();
        Freelancer = new javax.swing.JLabel();
        WatchRegistered = new javax.swing.JLabel();
        Studio = new javax.swing.JLabel();
        Expertise = new javax.swing.JLabel();
        ContentFrame = new javax.swing.JPanel();
        bg = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 766));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(204, 204, 204));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("Page Title");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 240, 20));

        lblUsernames.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUsernames.setForeground(new java.awt.Color(255, 255, 255));
        lblUsernames.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsernames.setText("First Name");
        getContentPane().add(lblUsernames, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 200, 30));

        lblUserType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUserType.setForeground(new java.awt.Color(255, 255, 255));
        lblUserType.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUserType.setText("User Type");
        getContentPane().add(lblUserType, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, 30));

        pnlAdmin.setOpaque(false);

        AR.setBackground(new Color (255,255,255,20));
        AR.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ARFocusLost(evt);
            }
        });

        AddArtist.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AddArtist.setForeground(new java.awt.Color(255, 255, 255));
        AddArtist.setText("Add Artist");
        AddArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddArtistMouseClicked(evt);
            }
        });

        SuspendArtist.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SuspendArtist.setForeground(new java.awt.Color(255, 255, 255));
        SuspendArtist.setText("Suspend Artist");
        SuspendArtist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuspendArtistMouseClicked(evt);
            }
        });

        SuspendArtist1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SuspendArtist1.setForeground(new java.awt.Color(255, 255, 255));
        SuspendArtist1.setText("Sessions");
        SuspendArtist1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuspendArtist1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ARLayout = new javax.swing.GroupLayout(AR);
        AR.setLayout(ARLayout);
        ARLayout.setHorizontalGroup(
            ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ARLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SuspendArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuspendArtist1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ARLayout.setVerticalGroup(
            ARLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ARLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SuspendArtist1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(SuspendArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        FL.setBackground(new Color (255,255,255,20));
        FL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FLFocusLost(evt);
            }
        });

        AddSoundman.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AddSoundman.setForeground(new java.awt.Color(255, 255, 255));
        AddSoundman.setText("Add Soundman");
        AddSoundman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddSoundmanMouseClicked(evt);
            }
        });

        AddMusician.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AddMusician.setForeground(new java.awt.Color(255, 255, 255));
        AddMusician.setText("Add Musician");
        AddMusician.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMusicianMouseClicked(evt);
            }
        });

        SuspendFreelancer.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SuspendFreelancer.setForeground(new java.awt.Color(255, 255, 255));
        SuspendFreelancer.setText("Suspend");
        SuspendFreelancer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuspendFreelancerMouseClicked(evt);
            }
        });

        SuspendFreelancer1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        SuspendFreelancer1.setForeground(new java.awt.Color(255, 255, 255));
        SuspendFreelancer1.setText("Add to Studio");
        SuspendFreelancer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SuspendFreelancer1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout FLLayout = new javax.swing.GroupLayout(FL);
        FL.setLayout(FLLayout);
        FLLayout.setHorizontalGroup(
            FLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FLLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FLLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AddMusician, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FLLayout.createSequentialGroup()
                        .addGroup(FLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddSoundman, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuspendFreelancer, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuspendFreelancer1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        FLLayout.setVerticalGroup(
            FLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FLLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(AddMusician, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AddSoundman, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SuspendFreelancer1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SuspendFreelancer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        STD.setBackground(new Color (255,255,255,20));
        STD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                STDFocusLost(evt);
            }
        });

        AddRoom.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AddRoom.setForeground(new java.awt.Color(255, 255, 255));
        AddRoom.setText("Add Room");
        AddRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddRoomMouseClicked(evt);
            }
        });

        AddStudio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        AddStudio.setForeground(new java.awt.Color(255, 255, 255));
        AddStudio.setText("Add Studio");
        AddStudio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddStudioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout STDLayout = new javax.swing.GroupLayout(STD);
        STD.setLayout(STDLayout);
        STDLayout.setHorizontalGroup(
            STDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(STDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        STDLayout.setVerticalGroup(
            STDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(STDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddStudio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AddRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        CreateSession.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        CreateSession.setForeground(new java.awt.Color(255, 255, 255));
        CreateSession.setText("Create Session");
        CreateSession.setToolTipText("");
        CreateSession.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateSessionMouseClicked(evt);
            }
        });

        Artist.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Artist.setForeground(new java.awt.Color(255, 255, 255));
        Artist.setText("Artist");
        Artist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArtistMouseClicked(evt);
            }
        });

        Freelancer.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Freelancer.setForeground(new java.awt.Color(255, 255, 255));
        Freelancer.setText("Freelancer");
        Freelancer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FreelancerMouseClicked(evt);
            }
        });

        WatchRegistered.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        WatchRegistered.setForeground(new java.awt.Color(255, 255, 255));
        WatchRegistered.setText("Watch Registered");
        WatchRegistered.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WatchRegisteredMouseClicked(evt);
            }
        });

        Studio.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Studio.setForeground(new java.awt.Color(255, 255, 255));
        Studio.setText("Studio");
        Studio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StudioMouseClicked(evt);
            }
        });

        Expertise.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Expertise.setForeground(new java.awt.Color(255, 255, 255));
        Expertise.setText("Expertise");
        Expertise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExpertiseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlAdminLayout = new javax.swing.GroupLayout(pnlAdmin);
        pnlAdmin.setLayout(pnlAdminLayout);
        pnlAdminLayout.setHorizontalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminLayout.createSequentialGroup()
                        .addComponent(CreateSession, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlAdminLayout.createSequentialGroup()
                        .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Artist, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WatchRegistered, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Freelancer, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Studio, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Expertise, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(FL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(STD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pnlAdminLayout.setVerticalGroup(
            pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAdminLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(CreateSession, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(Artist, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAdminLayout.createSequentialGroup()
                                .addComponent(Freelancer, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(WatchRegistered, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Expertise, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(AR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAdminLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(STD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAdminLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Studio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, 540));

        ContentFrame.setBackground(new Color(0,0,0,0));
        ContentFrame.setForeground(new java.awt.Color(255, 51, 102));
        ContentFrame.setAutoscrolls(true);
        ContentFrame.setOpaque(false);
        ContentFrame.setVisible(false);

        javax.swing.GroupLayout ContentFrameLayout = new javax.swing.GroupLayout(ContentFrame);
        ContentFrame.setLayout(ContentFrameLayout);
        ContentFrameLayout.setHorizontalGroup(
            ContentFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        ContentFrameLayout.setVerticalGroup(
            ContentFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );

        getContentPane().add(ContentFrame, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 830, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/images/iStudioGui.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 1020, 770));

        btnExit.setText("jButton1");
        btnExit.setEnabled(false);
        btnExit.setFocusPainted(false);
        btnExit.setFocusable(false);
        btnExit.setRequestFocusEnabled(false);
        btnExit.setRolloverEnabled(false);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 700, 160, 40));

        btnLogout.setText("jButton1");
        btnLogout.setEnabled(false);
        btnLogout.setFocusPainted(false);
        btnLogout.setFocusable(false);
        btnLogout.setRequestFocusEnabled(false);
        btnLogout.setRolloverEnabled(false);
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 160, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        iRecord.log("Logging out..");
        iRecord.setLoggedUser(null);
        dispose();
       
        iRecord.log("Successfully logged out");
        
        LoginGui tmp = new LoginGui();
        iRecord.log("Activating login screen");
        tmp.setVisible(true);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        iRecord.log("Quitting MuzaMusic");
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void btnViewReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewReportMouseClicked
      // frmViewReport add = new frmViewReport();
      // iWindow.openWin(add);
    }//GEN-LAST:event_btnViewReportMouseClicked

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void ArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArtistMouseClicked
        closeAllPanels();
        AR.setVisible(true);
        updateWin();
    }//GEN-LAST:event_ArtistMouseClicked

    private void FreelancerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FreelancerMouseClicked
        closeAllPanels();
        FL.setVisible(true);
        updateWin();
    }//GEN-LAST:event_FreelancerMouseClicked

    private void WatchRegisteredMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WatchRegisteredMouseClicked
        closeAllPanels();
        frmRegReport add = new frmRegReport();
        iWindow.openWin(add);
    }//GEN-LAST:event_WatchRegisteredMouseClicked

    private void AddMusicianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMusicianMouseClicked
        closeAllPanels();
        frmAddMusician add = new frmAddMusician();
        iWindow.openWin(add);
    }//GEN-LAST:event_AddMusicianMouseClicked

    private void AddStudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddStudioMouseClicked
        closeAllPanels();
        frmAddStudio add = new frmAddStudio(); 
        iWindow.openWin(add);
    }//GEN-LAST:event_AddStudioMouseClicked

    private void AddRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddRoomMouseClicked
        closeAllPanels();
        frmAddRoom add = new frmAddRoom();
        iWindow.openWin(add);
    }//GEN-LAST:event_AddRoomMouseClicked

    private void CreateSessionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateSessionMouseClicked
        closeAllPanels();
        frmCreateSession add = new frmCreateSession();
        iWindow.openWin(add);
    }//GEN-LAST:event_CreateSessionMouseClicked

    private void SuspendArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuspendArtistMouseClicked
        closeAllPanels();
        frmArtistSuspension add = new frmArtistSuspension();
        iWindow.openWin(add);
    }//GEN-LAST:event_SuspendArtistMouseClicked

    private void AddSoundmanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddSoundmanMouseClicked
        closeAllPanels();
        frmAddSoundman add = new frmAddSoundman();
        iWindow.openWin(add);
    }//GEN-LAST:event_AddSoundmanMouseClicked

    private void AddArtistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddArtistMouseClicked
        closeAllPanels();
        frmAddArtist add = new frmAddArtist();
        iWindow.openWin(add);
    }//GEN-LAST:event_AddArtistMouseClicked

    private void SuspendFreelancerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuspendFreelancerMouseClicked
        closeAllPanels();
        frmFreelancerSuspension add = new frmFreelancerSuspension();
        iWindow.openWin(add);
    }//GEN-LAST:event_SuspendFreelancerMouseClicked

    private void StudioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StudioMouseClicked
        closeAllPanels();
        STD.setVisible(true);
        updateWin();
    }//GEN-LAST:event_StudioMouseClicked

    private void ExpertiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExpertiseMouseClicked
        closeAllPanels();
        frmAddExpertise add = new frmAddExpertise();
        iWindow.openWin(add);
    }//GEN-LAST:event_ExpertiseMouseClicked

    private void SuspendArtist1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuspendArtist1MouseClicked
        closeAllPanels();
        frmSessions add = new frmSessions();
        iWindow.openWin(add);
    }//GEN-LAST:event_SuspendArtist1MouseClicked

    private void SuspendFreelancer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SuspendFreelancer1MouseClicked
        closeAllPanels();
        frmFreelancerToStudio add = new frmFreelancerToStudio();
        iWindow.openWin(add);
    }//GEN-LAST:event_SuspendFreelancer1MouseClicked

    private void ARFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ARFocusLost
        closeAllPanels();
        updateWin();
    }//GEN-LAST:event_ARFocusLost

    private void FLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FLFocusLost
        closeAllPanels();
        updateWin();
    }//GEN-LAST:event_FLFocusLost

    private void STDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_STDFocusLost
        closeAllPanels();
        updateWin();
    }//GEN-LAST:event_STDFocusLost

    private void closeAllPanels(){                              
        AR.setVisible(false);
        updateWin();
        FL.setVisible(false);                        
        updateWin();
        STD.setVisible(false);
        updateWin();       
    }

    public void refreshVars() {
        lblTitle.setText("Homepage");
        lblUserType.setText("" + iRecord.getLoggedUser().getUserAuth());
        lblUsernames.setText(iRecord.getLoggedUser().getID()+ " " + iRecord.getLoggedUser().getStageName());
        pnlAdmin.setVisible(false);
        AR.setVisible(false);
        FL.setVisible(false);
        STD.setVisible(false);
        //pnlRep.setVisible(false);
        //pnlAdmin1.setVisible(false);
        switch (iRecord.getLoggedUser().getUserAuth()) {
            case Artist:
                pnlAdmin.setVisible(true);
                break;
                
            case Freelancer:
                pnlAdmin.setVisible(true);
                break;
            
            case Administrator:
                pnlAdmin.setVisible(true);
                break;
        }

    }
    
    
    public void updateWin(){
        
        iWindow.update();
        
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AR;
    private javax.swing.JLabel AddArtist;
    private javax.swing.JLabel AddMusician;
    private javax.swing.JLabel AddRoom;
    private javax.swing.JLabel AddSoundman;
    private javax.swing.JLabel AddStudio;
    private javax.swing.JLabel Artist;
    private javax.swing.JPanel ContentFrame;
    private javax.swing.JLabel CreateSession;
    private javax.swing.JLabel Expertise;
    private javax.swing.JPanel FL;
    private javax.swing.JLabel Freelancer;
    private javax.swing.JPanel STD;
    private javax.swing.JLabel Studio;
    private javax.swing.JLabel SuspendArtist;
    private javax.swing.JLabel SuspendArtist1;
    private javax.swing.JLabel SuspendFreelancer;
    private javax.swing.JLabel SuspendFreelancer1;
    private javax.swing.JLabel WatchRegistered;
    private javax.swing.JLabel bg;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUserType;
    private javax.swing.JLabel lblUsernames;
    private javax.swing.JPanel pnlAdmin;
    // End of variables declaration//GEN-END:variables

}
