/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import views.ClientChatWithClient;
import views.viewChatClient;
import views.ViewProcessChat;

public class UsersOnline extends javax.swing.JFrame {

    ClientChat chatToServer;
    Thread chatToOtherClient;
    String username;
    String message = null;
    String ar[] = {"Username", "Point", "Status"};
    DefaultTableModel tbModel = new DefaultTableModel(ar, 0);

    public UsersOnline() {
        initComponents();
        String[] s = {"ten", "diem", "trang thai"};
        tbModel.addRow(s);
        jTableUsersOnline.setModel(tbModel);
        listenEventCloseX();
    }

    public UsersOnline(ClientChat chat, String username) throws IOException {
        initComponents();
        this.username = username;
        this.chatToServer = chat;
        requestListUserOnline(chat);
        receiveMassage();
        listenEventCloseX();
    }

    public UsersOnline(ClientChat chat) throws IOException {
        initComponents();
        this.chatToServer = chat;
        listenEventCloseX();
    }

    public void listenEventCloseX() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                int choose = JOptionPane.showConfirmDialog(null, "Ban co chac muon thoat?",
                        null, JOptionPane.YES_NO_OPTION);
                if (choose == JOptionPane.YES_OPTION) {
                    try {
                        chatToServer.sendMessage("/thoat");
                    } catch (IOException ex) {
                        Logger.getLogger(UsersOnline.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        System.exit(0);
                    }
                }
            }

        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableUsersOnline = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Chat with client");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Chat with  server");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Chat with players");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Làm bài thi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTableUsersOnline.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "User", "Status", "Point"
            }
        ));
        jTableUsersOnline.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsersOnlineMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableUsersOnline);

        jLabel1.setText("USER ONLINE");

        jTextFieldUsername.setText("Username");

        jButton5.setText("Mời chơi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(181, 181, 181))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(29, 29, 29)
                        .addComponent(jButton2)
                        .addGap(28, 28, 28)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        this.dispose();
        viewChatClient chat_Client = new viewChatClient();
        chat_Client.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ViewProcessChat.main();
        this.dispose();
        ClientChatWithClient clientChatWithClient = new ClientChatWithClient();
        clientChatWithClient.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        ViewProcessChat.main();
        this.dispose();
        ClientChatWithClient clientChatWithClient = new ClientChatWithClient();
        clientChatWithClient.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        DeThi dethi = new DeThi(chatToServer);
        dethi.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTableUsersOnlineMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsersOnlineMouseClicked
        int choose = JOptionPane.showConfirmDialog(null, "Mời tham gia thi đấu ?",
                null, JOptionPane.YES_NO_OPTION);
//        if (choose == JOptionPane.YES_OPTION) {
//            int row = jTableUsersOnline.getSelectedRow();
//            int col = jTableUsersOnline.getSelectedColumn();
//            String name = jTableUsersOnline.getModel().getValueAt(row, 0).toString();
//            try {
//                chatToServer.sendMessage("/testRoom");
//                chatToServer.sendMessage(name);
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(rootPane, "Ngoai le :" + ex);
//            }
//            finally{}
//        }
    }//GEN-LAST:event_jTableUsersOnlineMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int choose = JOptionPane.showConfirmDialog(null, "Mời tham gia thi đấu ?",
                null, JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            String name = jTextFieldUsername.getText();
            try {
                chatToServer.sendMessage("/testRoom");
                chatToServer.sendMessage(name);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(rootPane, "Ngoai le :" + ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersOnline().setVisible(true);
            }
        });
    }

    public void receiveMassage() {
        Thread receiveReponse = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        message = chatToServer.getMassage();
                        if (!message.equals("/showUserOnline")) {
                            System.out.println("Nhan duoc tin nhan :       " + message);
                        }
                        switch (message) {
                            case "/showUserOnline":
                                showUserOnline();
                                break;
                            case "/inviteTest":
                                inviteTest();
                                break;
                            case "/responseListQuestions":
                                responseListQuestion();
                                break;
                            case "/replyInvitation":
                                String reply = chatToServer.getMassage();
                                if (reply.equals("/replyInviteYes")) {
                                    chatToServer.sendMessage("/yes");
                                    DeThi dethi = new DeThi(chatToServer);
                                    dethi.setVisible(true);
                                } else if (reply.equals("/getReplyInviteNo")) {
                                    JOptionPane.showMessageDialog(rootPane, "Lời mời bị từ chối !");
                                } else if (reply.equals("/getReplyInviteYes")) {
                                    DeThi dethi = new DeThi(chatToServer);
                                    dethi.setVisible(true);
                                }
                                break;
                            case "/responsePoint":
                                String kq = chatToServer.getMassage();
                                dethi.setResult(kq);
                                break;
                        }

                    }
                } catch (Exception e) {
                }
            }

            private void showUserOnline() throws IOException {
                listUO = chatToServer.getMassage();
                String ar[] = {"Username", "Point", "Status"};
                DefaultTableModel tbModel = new DefaultTableModel(ar, 0);
                jTableUsersOnline.setModel(tbModel);
                String[] usr = listUO.split("@");
                for (int i = 0; i < usr.length; i++) {
                    String[] usrAtribute = usr[i].split(":");
                    tbModel.addRow(usrAtribute);
                }
            }

            private void inviteTest() throws IOException {
                message = chatToServer.getMassage();
                int choose = JOptionPane.showConfirmDialog(null, message + " mời tham gia thi đấu! Chấp thuận ?",
                        null, JOptionPane.YES_NO_OPTION);
                if (choose == JOptionPane.YES_OPTION) {
                    chatToServer.sendMessage("/yes");
                    DeThi dethi = new DeThi(chatToServer);
                    dethi.setVisible(true);
                } else if (choose == JOptionPane.NO_OPTION) {
                    chatToServer.sendMessage("/no");
                }
            }

            private void responseListQuestion() throws IOException {
                message = chatToServer.getMassage();//lay de
                questions = new HashMap<>();
                System.out.println(message);
                String[] listQ = message.split("@");
                for (int i = 0; i < listQ.length; i++) {
                    String[] tmp = listQ[i].split(":");
                    String[] content = new String[5];
                    content[0] = tmp[0];
                    content[1] = tmp[1];
                    content[2] = tmp[2];
                    content[3] = tmp[3];
                    content[4] = tmp[4];
                    questions.put(content, tmp[5]);
                }
            }
        });
        receiveReponse.start();
    }

    public void requestListUserOnline(ClientChat chat) throws IOException {
        try {
            Thread requestListUSer = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            chatToServer.sendMessage("/getUserOnline");
                            Thread.sleep(2000);
                        } catch (IOException ex) {
                            Logger.getLogger(UsersOnline.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(UsersOnline.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            requestListUSer.start();

        } catch (Exception e) {
        }

    }

    String listUO;
    public static HashMap<String[], String> questions = new HashMap<>();
    public DeThi dethi;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableUsersOnline;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

}
