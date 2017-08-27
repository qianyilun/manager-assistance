/*
 * Created by JFormDesigner on Sun Aug 20 16:11:36 PDT 2017
 *
 * This class is to display a welcome page to let user know the QM Assistance is running
 *
 * @Allen Qian
 */

// Please note: 	if pack() method is used, setLocationRelativeTo should be used after pack() method call –

package com.allen.view.start_page;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.TimeZone;
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
        content = new JLabel();
        panel1 = new JPanel();
        closeBtn = new JButton();
        panel2 = new JPanel();
        timeZone = new JLabel();

        //======== frame ========
        {
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.setName("Welcome!");
            frame.setVisible(true);
            frame.setAlwaysOnTop(true);
            frame.setTitle("Run successfully!");
            frame.setResizable(false);
            Container frameContentPane = frame.getContentPane();

            //======== mainPanel ========
            {

                // JFormDesigner evaluation mark
                mainPanel.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                        "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                        javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                        java.awt.Color.red), mainPanel.getBorder())); mainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

                mainPanel.setLayout(new FlowLayout());

                //---- content ----
                content.setText("Your Queue Manager is running now...");
                content.setFont(content.getFont().deriveFont(content.getFont().getSize() + 5f));
                mainPanel.add(content);
            }

            //======== panel1 ========
            {
                panel1.setLayout(new FlowLayout());

                //---- closeBtn ----
                closeBtn.setText("Dismiss");
                closeBtn.addActionListener(e -> closeBtnActionPerformed(e));
                panel1.add(closeBtn);
            }

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- timeZone ----
                timeZone.setText("_default_");
                panel2.add(timeZone);
            }

            GroupLayout frameContentPaneLayout = new GroupLayout(frameContentPane);
            frameContentPane.setLayout(frameContentPaneLayout);
            frameContentPaneLayout.setHorizontalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(frameContentPaneLayout.createParallelGroup()
                            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
                            .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
                            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE))
                        .addContainerGap())
            );
            frameContentPaneLayout.setVerticalGroup(
                frameContentPaneLayout.createParallelGroup()
                    .addGroup(frameContentPaneLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(mainPanel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
            );
            frame.pack();
            frame.setLocationRelativeTo(frame.getOwner());
            setTimezoneLabel();
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - a aa
    private JFrame frame;
    private JPanel mainPanel;
    private JLabel content;
    private JPanel panel1;
    private JButton closeBtn;
    private JPanel panel2;
    private JLabel timeZone;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void setTimezoneLabel() {
        TimeZone tz = Calendar.getInstance().getTimeZone();

        System.out.println("Time Zone: " + tz.getDisplayName() + ",   " + tz.getID());
        timeZone.setText("Time Zone: " + tz.getDisplayName() + ",   " + tz.getID());
    }

}
