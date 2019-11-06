/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controller.client.ClientChat;
import controller.client.UsersOnline;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.exit;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author User
 */
public class ViewProcessChat extends javax.swing.JFrame {

    UsersOnline usersOnline;

    ArrayList clientOutputStreams;
    ArrayList<String> users;

    public ViewProcessChat() {
    }

    // Trình xử lý ứng dụng khách
    public class ClientHandler implements Runnable {

        BufferedReader reader; // read data
        Socket sock;
        PrintWriter client;

        public ClientHandler(Socket clientSocket, PrintWriter user) {
            client = user;
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream()); // read file basic
                reader = new BufferedReader(isReader);
            } catch (Exception ex) {
                jTextAreaChat.append("Lỗi ngoài mong đợi ... \n");
            }
        }

        @Override
        public void run() {
            String message, connect = "Connect", disconnect = "Disconnect", chat = "Chat";
            String[] data;
            try {
                while ((message = reader.readLine()) != null) {
                    jTextAreaChat.append("Received: " + message + "\n");
                    data = message.split(":"); // tách từ trong chuỗi sau dấu :

                    for (String str : data) {
                        jTextAreaChat.append(str + "\n");
                    }

                    if (data[2].equals(connect)) {
                        tellEveryone((data[0] + ":" + data[1] + ":" + chat));
                        userAdd(data[0]);
                    } else if (data[2].equals(disconnect)) {
                        tellEveryone((data[0] + ":has disconnected." + ":" + chat));
                        userRemove(data[0]);
                    } else if (data[2].equals(chat)) {
                        tellEveryone(message);
                    } else {
                        jTextAreaChat.append("Không có điều kiện nào được đáp ứng. \n");
                    }
                }
            } catch (Exception ex) {
                jTextAreaChat.append("Mất kết nối. \n");
                ex.printStackTrace();
                clientOutputStreams.remove(client);
            }
        }
    }

    public class ServerStart implements Runnable {

        @Override
        public void run() {
            clientOutputStreams = new ArrayList();
            users = new ArrayList();

            try {
                ServerSocket serverSock = new ServerSocket(2222);

                while (true) {
                    Socket clientSock = serverSock.accept();
                    PrintWriter writer = new PrintWriter(clientSock.getOutputStream());
                    clientOutputStreams.add(writer);

                    Thread listener = new Thread(new ClientHandler(clientSock, writer));
                    listener.start();
                    jTextAreaChat.append("có kết nối. \n");
                }
            } catch (Exception ex) {
                jTextAreaChat.append("Ngoai le. \n");
            }
        }
    }

    public void userAdd(String data) {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        jTextAreaChat.append("Before " + name + " added. \n");
        users.add(name);
        jTextAreaChat.append("After " + name + " added. \n");
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String str : tempList) {
            message = (str + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }

    public void tellEveryone(String message) {
        Iterator it = clientOutputStreams.iterator();

        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                jTextAreaChat.append("Sending: " + message + "\n");
                writer.flush();
                jTextAreaChat.setCaretPosition(jTextAreaChat.getDocument().getLength());

            } catch (Exception ex) {
                jTextAreaChat.append("Lỗi khi thông báo cho mọi người. \n");
            }
        }
    }

    public void userRemove(String data) {
        String message, add = ": :Connect", done = "Server: :Done", name = data;
        users.remove(name);
        String[] tempList = new String[(users.size())];
        users.toArray(tempList);

        for (String token : tempList) {
            message = (token + add);
            tellEveryone(message);
        }
        tellEveryone(done);
    }

    public ViewProcessChat(UsersOnline usrol) {
        initComponents();
        usersOnline = usrol;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaChat = new javax.swing.JTextArea();
        jButtonStart = new javax.swing.JButton();
        jButtonEnd = new javax.swing.JButton();
        jButtonUserOnline = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jButtonComeBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextAreaChat.setColumns(20);
        jTextAreaChat.setRows(5);
        jScrollPane1.setViewportView(jTextAreaChat);

        jButtonStart.setText("Start");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonEnd.setText("End");
        jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEndActionPerformed(evt);
            }
        });

        jButtonUserOnline.setText("User online");
        jButtonUserOnline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserOnlineActionPerformed(evt);
            }
        });

        jButtonClean.setText("Clean");
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        jButtonComeBack.setText("Come back");
        jButtonComeBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComeBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonStart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonUserOnline))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jButtonEnd)
                                .addGap(97, 97, 97)
                                .addComponent(jButtonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonComeBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStart)
                    .addComponent(jButtonUserOnline)
                    .addComponent(jButtonExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEnd)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonComeBack))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonComeBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComeBackActionPerformed
        // TODO add your handling code here:
        try {
            this.dispose();
            ClientChat chat = null;
            UsersOnline testOnline = new UsersOnline(chat);
            testOnline.setVisible(true);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButtonComeBackActionPerformed

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        // TODO add your handling code here:
        jTextAreaChat.setText("");

    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
            startNewServer();
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        tellEveryone("Server's STOP.\n:Chat");
        jTextAreaChat.append("Server STOP... \n");

        jTextAreaChat.setText("");
    }//GEN-LAST:event_jButtonEndActionPerformed

    private void jButtonUserOnlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserOnlineActionPerformed
        jTextAreaChat.append("\n Online users : \n");
        for (String current_user : users) {
            jTextAreaChat.append(current_user);
            jTextAreaChat.append("\n");
        }
    }//GEN-LAST:event_jButtonUserOnlineActionPerformed

    public void startNewServer() {
        Thread starter = new Thread(new ServerStart());
        starter.start();

        jTextAreaChat.append("Server started...\n");
    }

    public static void main() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            ViewProcessChat server = new ViewProcessChat();
            server.setTitle("Chat-Server");
            server.setVisible(true);
            server.startNewServer();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonComeBack;
    private javax.swing.JButton jButtonEnd;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonUserOnline;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaChat;
    // End of variables declaration//GEN-END:variables
}
