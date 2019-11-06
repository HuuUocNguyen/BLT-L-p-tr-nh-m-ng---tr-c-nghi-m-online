/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.client;

import controller.client.ClientChat;
import controller.client.UsersOnline;
import java.io.IOException;
import static java.lang.System.exit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DeThi extends javax.swing.JFrame {

    public Connection conn;
    public PreparedStatement pst;
    public static ResultSet rs = null;
    public Statement st;
    public ClientChat chatToServer;
    public double diem;
    public int i = 0;
    HashMap<String[], String> questions;
    ArrayList<String> answers = new ArrayList<>();

    public DeThi(ClientChat chat) {
        initComponents();
        this.chatToServer = chat;
        Thread thoigian = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Date thoiGian = new Date();
                    //Khai bao dinh dang ngay thang
                    SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy ");
                    //parse ngay thang sang dinh dang va chuyen thanh string.
                    String showTime = dinhDangThoiGian.format(thoiGian.getTime());
                    //
                    //jTextFieldThoiGianNow.setText(showTime);
                    lbThoigiannow.setText(showTime);
                }
            }
        });
        thoigian.start();
    }

    public void setAnswers() {
        answers.add(jTextFieldDa1.getText());
        answers.add(jTextFieldDa2.getText());
        answers.add(jTextFieldDa3.getText());
        
        // add cau tra loi vao list -> kiem tra so voi hashmap

    }

    public void newTest() {
        try {
            chatToServer.sendMessage("/getListQuestions");
        } catch (IOException ex) {
            Logger.getLogger(DeThi.class.getName()).log(Level.SEVERE, null, ex);
        }
        questions = UsersOnline.questions;
        String[] aar = {"Question", "A", "B", "C", "D"};
        DefaultTableModel model = new DefaultTableModel(aar, 0);
        questions.forEach((key, value) -> {
            model.addRow(key);
        });
        jTableQuestion.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableQuestion = new javax.swing.JTable();
        lbThoigiannow = new javax.swing.JLabel();
        jTextFieldDa1 = new javax.swing.JTextField();
        jTextFieldDa2 = new javax.swing.JTextField();
        jTextFieldDa3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Câu 1:");

        jLabel2.setText("Câu 2:");

        jLabel3.setText("Câu 3:");

        jLabel6.setText("Thời gian:");

        jButton1.setText("Thoát");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Submit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Load đề thi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTableQuestion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Question", "A", "B", "C", "D"
            }
        ));
        jScrollPane2.setViewportView(jTableQuestion);

        lbThoigiannow.setText("time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(44, 44, 44)
                                .addComponent(lbThoigiannow)
                                .addGap(102, 102, 102)
                                .addComponent(jButton2)
                                .addGap(64, 64, 64)
                                .addComponent(jButton1)))
                        .addGap(36, 228, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDa1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDa2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDa3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldDa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldDa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(lbThoigiannow)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int confirmLogut = JOptionPane.showConfirmDialog(this, "Bạn muốn thoát game ?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirmLogut == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        newTest();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setAnswers();
        i = 0;
        diem = 0;
        questions.forEach((key, value) -> {
            if (value.equals(answers.get(i))) {
                diem += 1;
            }
            i++;
        });
        JOptionPane.showMessageDialog(rootPane, "Diem: " + diem);
        while (true) {            
            if(result!=""){
                JOptionPane.showMessageDialog(rootPane, "Ket qua: "+result);
                break;
            }
            
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public String result = "";

    public void setResult(String result) {
        this.result = result;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableQuestion;
    private javax.swing.JTextField jTextFieldDa1;
    private javax.swing.JTextField jTextFieldDa2;
    private javax.swing.JTextField jTextFieldDa3;
    private javax.swing.JLabel lbThoigiannow;
    // End of variables declaration//GEN-END:variables
}
