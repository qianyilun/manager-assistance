/*
 * Created by JFormDesigner on Sun Aug 20 16:11:36 PDT 2017
 *
 * This class is to display a welcome page to let user know the QM Assistance is running
 *
 * @Allen Qian
 */

// Please note: 	if pack() method is used, setLocationRelativeTo should be used after pack() method call –

package com.allen.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author a aa
 */
public class StartPageNew {
    public StartPageNew() {
        initComponents();
    }

    private void closeBtnActionPerformed(ActionEvent e) {
        // TODO add your code here
        frame.dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - a aa
        frame = new JFrame();
        mainPanel = new JPanel();
        closeBtn = new JButton();
        content = new JLabel();

        //======== frame ========
        {
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setName("Welcome!");
            frame.setVisible(true);
            Container frameContentPane = frame.getContentPane();

            //======== mainPanel ========
            {

                // JFormDesigner evaluation mark
                mainPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), mainPanel.getBorder())); mainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                //---- closeBtn ----
                closeBtn.setText("Dismiss");
                closeBtn.addActionListener(e -> closeBtnActionPerformed(e));

                //---- content ----
                content.setText("Your Queue Manager is running now...");
                content.setFont(content.getFont().deriveFont(content.getFont().getSize() + 5f));

                GroupLayout mainPanelLayout = new GroupLayout(mainPanel);
                mainPanel.setLayout(mainPanelLayout);
                mainPanelLayout.setHorizontalGroup(
                    mainPanelLayout.createParallelGroup()
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addContainerGap(224, Short.MAX_VALUE)
                            .addComponent(content)
                            .addGap(217, 217, 217))
                        .addGroup(mainPanelLayout.createSequentialGroup()
                            .addGap(429, 429, 429)
                            .addComponent(closeBtn)
                            .addContainerGap(434, Short.MAX_VALUE))
                );
                mainPanelLayout.setVerticalGroup(
                    mainPanelLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                            .addContainerGap(67, Short.MAX_VALUE)
                            .addComponent(content)
                            .addGap(50, 50, 50)
                            .addComponent(closeBtn)
                            .addGap(58, 58, 58))
                );
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15))
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - a aa
    private JFrame frame;
    private JPanel mainPanel;
    private JButton closeBtn;
    private JLabel content;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
