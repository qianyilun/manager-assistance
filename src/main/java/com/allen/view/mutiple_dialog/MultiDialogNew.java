/*
 * Created by JFormDesigner on Sun Aug 20 20:10:59 PDT 2017
 *
 * This class will be override if MultiDialogNew.jfd was opened. Be aware of the nodes of treeView
 */

package com.allen.view.mutiple_dialog;

import com.allen.model.DATA;
import com.allen.model.EmergeQueueList;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class is to display one single incident information
 * @author Allen Qian
 */
public class MultiDialogNew {
    private EmergeQueueList emergeQueueList;

    public MultiDialogNew(EmergeQueueList emergeQueueList) {
        this.emergeQueueList = emergeQueueList;
        initComponents();
    }

    private void closeBtnActionPerformed(ActionEvent e) {
        frame.dispose();
    }

    private void sendEmailBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("send emails");
    }

    private void openLinkBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println("open the link");
    }

    private void RemindLaterBtnActionPerformed(ActionEvent e) {
        frame.setVisible(false);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
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
        bottomPanel = new JPanel();
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
                Title.setText("__default__");
                topPanel.add(Title);
            }
            frameContentPane.add(topPanel, BorderLayout.NORTH);

            //======== bottomPanel ========
            {

                //---- openLinkBtn ----
                openLinkBtn.setText("Open All Links");
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

                GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
                bottomPanel.setLayout(bottomPanelLayout);
                bottomPanelLayout.setHorizontalGroup(
                        bottomPanelLayout.createParallelGroup()
                                .addGroup(bottomPanelLayout.createSequentialGroup()
                                        .addGap(114, 114, 114)
                                        .addComponent(openLinkBtn)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 568, Short.MAX_VALUE)
                                        .addComponent(closeBtn)
                                        .addGap(82, 82, 82)
                                        .addComponent(sendEmailBtn)
                                        .addGap(62, 62, 62)
                                        .addComponent(RemindLaterBtn)
                                        .addGap(124, 124, 124))
                );
                bottomPanelLayout.setVerticalGroup(
                        bottomPanelLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                                        .addContainerGap(31, Short.MAX_VALUE)
                                        .addGroup(bottomPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(RemindLaterBtn)
                                                .addComponent(sendEmailBtn)
                                                .addComponent(closeBtn)
                                                .addComponent(openLinkBtn))
                                        .addGap(22, 22, 22))
                );
            }
            frameContentPane.add(bottomPanel, BorderLayout.SOUTH);

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
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - a aa
    private JFrame frame;
    private JPanel topPanel;
    private JLabel Title;
    private JPanel bottomPanel;
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

    private void addIncidentToTreeView() {
        treeView.setModel(new DefaultTreeModel(
                new DefaultMutableTreeNode("Root") {
                    {
                        for (DATA incident : emergeQueueList.getLst()) {
                            String userObject = "<" + incident.getOBJECT_ID() + ">: within " + incident.hasMinutesLeft() + " within minutes";
                            DefaultMutableTreeNode node1 = new DefaultMutableTreeNode(userObject);
                            node1.add(new DefaultMutableTreeNode("ID: " + incident.getOBJECT_ID()));
                            node1.add(new DefaultMutableTreeNode("Title: " + incident.getDESCRIPTION()));
                            node1.add(new DefaultMutableTreeNode("Priority: " + incident.getPRIORITY_DESCR()));
                            node1.add(new DefaultMutableTreeNode("Link: " + incident.getURL_MESSAGE()));
                            add(node1);
                        }
                    }
                }));
    }

}
