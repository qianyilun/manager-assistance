package com.allen.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
** This class is to display a welcome page to let user know the QM Assistance is running
*
* https://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
* ---> Set the JFrame as center of a screen
*
* Please note: 	if pack() method is used, setLocationRelativeTo should be used after pack() method call –
*
* @Allen Qian
 */

public class StartPage {
    private JButton closeButton;
    private JLabel startLabel;
    private JPanel mainPanel;
    private JFrame defaultFrame;

    public void display() {
        JFrame frame = new JFrame("Welcome!");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        defaultFrame = frame;
    }

    public StartPage() {
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                defaultFrame.dispose();
            }
        });
    }
}
