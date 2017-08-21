/*
 * Created by JFormDesigner on Sun Aug 20 16:33:26 PDT 2017
 */

package com.allen.view.single_dialog;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.tree.*;

/**
 * @author Allen Qian
 */
public class SingleDialog {
    public SingleDialog() {
        initComponents();
    }

    private void closeBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        frame.dispose();
    }

    // remind engineer 9 minutes later
    private void RemindLaterBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        frame.setVisible(false);
        try {
            Thread.sleep(9 *   // minutes to sleep
                    60 *   // seconds to a minute
                    1000); // milliseconds to a second
        } catch (InterruptedException except) {
            except.printStackTrace();
        }
        frame.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - a aa
        frame = new JFrame();
        title = new JLabel();
        panel1 = new JPanel();
        openLinkBtn = new JButton();
        closeBtn = new JButton();
        sendEmailBtn = new JButton();
        RemindLaterBtn = new JButton();
        panel2 = new JPanel();
        treeView = new JTree();

        //======== frame ========
        {
            frame.setTitle("Warning!");
            frame.setVisible(true);
            Container frameContentPane = frame.getContentPane();

            //---- title ----
            title.setText("__default__");

            //======== panel1 ========
            {

                // JFormDesigner evaluation mark
                panel1.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- openLinkBtn ----
                openLinkBtn.setText("Open the Link");

                //---- closeBtn ----
                closeBtn.setText("Dismiss");
                closeBtn.addActionListener(e -> closeBtnActionPerformed(e));

                //---- sendEmailBtn ----
                sendEmailBtn.setText("Send email now");

                //---- RemindLaterBtn ----
                RemindLaterBtn.setText("Remind Me Later");
                RemindLaterBtn.addActionListener(e -> RemindLaterBtnActionPerformed(e));

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(openLinkBtn)
                            .addGap(319, 319, 319)
                            .addComponent(closeBtn)
                            .addGap(76, 76, 76)
                            .addComponent(sendEmailBtn)
                            .addGap(78, 78, 78)
                            .addComponent(RemindLaterBtn)
                            .addContainerGap(65, Short.MAX_VALUE))
                );
                panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                            .addContainerGap(17, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(closeBtn)
                                    .addComponent(openLinkBtn))
                                .addComponent(sendEmailBtn)
                                .addComponent(RemindLaterBtn))
                            .addGap(31, 31, 31))
                );
            }

            //======== panel2 ========
            {

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGap(0, 1456, Short.MAX_VALUE)
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGap(0, 363, Short.MAX_VALUE)
                );
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap(57, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGap(718, 718, 718)
                                .addComponent(title))
                            .addGroup(frameContentPaneLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, frameContentPaneLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(title)
                        .addGap(33, 33, 33)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }

        //---- treeView ----
        treeView.setModel(new DefaultTreeModel(
            new DefaultMutableTreeNode("The incident <_ID__> is about expire within __ mins.") {
                {
                    add(new DefaultMutableTreeNode("ID:"));
                    add(new DefaultMutableTreeNode("Title:"));
                    add(new DefaultMutableTreeNode("Pecent:"));
                    add(new DefaultMutableTreeNode("Link:"));
                }
            }));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - a aa
    private JFrame frame;
    private JLabel title;
    private JPanel panel1;
    private JButton openLinkBtn;
    private JButton closeBtn;
    private JButton sendEmailBtn;
    private JButton RemindLaterBtn;
    private JPanel panel2;
    private JTree treeView;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
