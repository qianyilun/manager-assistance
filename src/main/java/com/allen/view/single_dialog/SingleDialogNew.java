/*
 * Created by JFormDesigner on Sun Aug 20 20:10:59 PDT 2017
 */

package com.allen.view.single_dialog;

import com.allen.controller.EmailSend;
import com.allen.controller.OpenURL;
import com.allen.model.DATA;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import javax.swing.tree.*;

/**
 * This class is to display one single incident information
 * @author Allen Qian
 */
public class SingleDialogNew {
    private DATA incident;
    public SingleDialogNew(DATA incident) {
        System.out.println(incident);
        this.incident = incident;
        initComponents();
    }

    private void closeBtnActionPerformed(ActionEvent e) {
        // stop the countdown timer first
        counter = Integer.MAX_VALUE;
        timer.cancel();
        sendEmailBtn.setText("Send email Now");


        frame.dispose();
    }

    private void sendEmailBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        // stop the countdown timer first
        counter = Integer.MAX_VALUE;
        timer.cancel();
        sendEmailBtn.setText("Send email Now");


        System.out.println("send emails");
        frame.dispose(); // dispose frame first since it can "speed up" action time

        String content = "\n * " + incident.getDESCRIPTION() + ": has " + (Integer.parseInt(incident.hasMinutesLeft())-10) + " minutes to expire\n" + incident.getURL_MESSAGE();
        EmailSend.send(content);
    }

    private void openLinkBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        // stop the countdown timer first
        counter = Integer.MAX_VALUE;
        timer.cancel();
        sendEmailBtn.setText("Send email Now");


        System.out.println("open the link");
        URL url = null;
        try {
            url = new URL(incident.getURL_MESSAGE());
        } catch (MalformedURLException except) {
            except.printStackTrace();
        }
        OpenURL.openWebpage(url);
        System.out.println(incident.getURL_MESSAGE());
    }

    private void RemindLaterBtnActionPerformed(ActionEvent e) {
        // stop the countdown timer first
        counter = Integer.MAX_VALUE;


        frame.setVisible(false);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                counter = 600;
                frame.setVisible(true);
            }
        };

        timer.schedule(task, 9 *   // minutes to sleep
                                  60 *   // seconds to a minute
                                  1000); // milliseconds to a second

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - a aa
        frame = new JFrame();
        topPanel = new JPanel();
        Title = new JLabel();
        buttomPanel = new JPanel();
        openLinkBtn = new JButton();
        closeBtn = new JButton();
        sendEmailBtn = new JButton();
        RemindLaterBtn = new JButton();
        centerPane = new JScrollPane();
        treeView = new JTree();
        leftPanel = new JPanel();
        leftLabelHelper = new JLabel();
        rightPanel = new JPanel();
        rightLabelHelper = new JLabel();

        //======== frame ========
        {
            frame.setVisible(true);
            frame.setTitle("Reminder");
            Container frameContentPane = frame.getContentPane();
            frameContentPane.setLayout(new BorderLayout());

            //======== topPanel ========
            {

                // JFormDesigner evaluation mark
                topPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), topPanel.getBorder())); topPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 53));

                //---- Title ----
                String title = incident.getDESCRIPTION() + " <ID: " + incident.getOBJECT_ID() + ">" + " will expire within " + incident.hasMinutesLeft() + " minutes";
                Title.setText(title);
                topPanel.add(Title);
            }
            frameContentPane.add(topPanel, BorderLayout.NORTH);

            //======== buttomPanel ========
            {

                //---- openLinkBtn ----
                openLinkBtn.setText("Open the Link");
                openLinkBtn.addActionListener(e -> openLinkBtnActionPerformed(e));

                //---- closeBtn ----
                closeBtn.setText("Dismiss");
                closeBtn.addActionListener(e -> closeBtnActionPerformed(e));

                //---- sendEmailBtn ----
                sendEmailBtn.setText("Send email now");
                sendEmailBtn.addActionListener(e -> sendEmailBtnActionPerformed(e));

                //---- RemindLaterBtn ----
                RemindLaterBtn.setText("Remind me Later");
                RemindLaterBtn.addActionListener(e -> RemindLaterBtnActionPerformed(e));

                GroupLayout buttomPanelLayout = new GroupLayout(buttomPanel);
                buttomPanel.setLayout(buttomPanelLayout);
                buttomPanelLayout.setHorizontalGroup(
                    buttomPanelLayout.createParallelGroup()
                        .addGroup(buttomPanelLayout.createSequentialGroup()
                            .addGap(114, 114, 114)
                            .addComponent(openLinkBtn)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 572, Short.MAX_VALUE)
                            .addComponent(closeBtn)
                            .addGap(82, 82, 82)
                            .addComponent(sendEmailBtn)
                            .addGap(62, 62, 62)
                            .addComponent(RemindLaterBtn)
                            .addGap(124, 124, 124))
                );
                buttomPanelLayout.setVerticalGroup(
                    buttomPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, buttomPanelLayout.createSequentialGroup()
                            .addContainerGap(31, Short.MAX_VALUE)
                            .addGroup(buttomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(RemindLaterBtn)
                                .addComponent(sendEmailBtn)
                                .addComponent(closeBtn)
                                .addComponent(openLinkBtn))
                            .addGap(22, 22, 22))
                );
            }
            frameContentPane.add(buttomPanel, BorderLayout.SOUTH);

            //======== centerPane ========
            {

                //---- treeView ----
                addIncidentToTreeView();

                centerPane.setViewportView(treeView);
            }
            frameContentPane.add(centerPane, BorderLayout.CENTER);

            //======== leftPanel ========
            {
                leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

                //---- leftLabelHelper ----
                leftLabelHelper.setText("    ");
                leftPanel.add(leftLabelHelper);
            }
            frameContentPane.add(leftPanel, BorderLayout.WEST);

            //======== rightPanel ========
            {
                rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));

                //---- rightLabelHelper ----
                rightLabelHelper.setText("    ");
                rightPanel.add(rightLabelHelper);
            }
            frameContentPane.add(rightPanel, BorderLayout.EAST);
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());

            detectHelper();
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - a aa
    private JFrame frame;
    private JPanel topPanel;
    private JLabel Title;
    private JPanel buttomPanel;
    private JButton openLinkBtn;
    private JButton closeBtn;
    private JButton sendEmailBtn;
    private JButton RemindLaterBtn;
    private JScrollPane centerPane;
    private JTree treeView;
    private JPanel leftPanel;
    private JLabel leftLabelHelper;
    private JPanel rightPanel;
    private JLabel rightLabelHelper;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private int counter;
    private Timer timer;

    private void addIncidentToTreeView() {
        treeView.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("Root") {
                    {
                        String userObject = "<" + incident.getOBJECT_ID() + ">: within " + incident.hasMinutesLeft() + " minutes";
                        DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(userObject);
                        node1.add(new DefaultMutableTreeNode("ID: " + incident.getOBJECT_ID()));
                        node1.add(new DefaultMutableTreeNode("Title: " + incident.getDESCRIPTION()));
                        node1.add(new DefaultMutableTreeNode("Priority: " + incident.getPRIORITY_DESCR()));
                        node1.add(new DefaultMutableTreeNode("Link: " + incident.getURL_MESSAGE()));
                        add(node1);
                    }
                }));
    }

    // protect the incident from Queue Manager is leave computer alone
    // https://www.youtube.com/watch?v=Euexl32lB8w
    private void detectHelper() {
        timer = new Timer();
        counter = 600;
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(counter);
                sendEmailBtn.setText("Send email Now " + " (or " + counter + " seconds)");
                counter--;
                if (counter == -1) {
                    // send automatic emails
                    sendEmailBtnActionPerformed(null);

                    timer.cancel();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 1000,1000);
    }

}
