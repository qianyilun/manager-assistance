package com.allen.model;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * This class is to save a Web json source code to a json file as a backup log
 *
 * @author Allen Qian
 */

public class JsonSaver {
    // https://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java
    public static void save(String formattedJson) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter( new FileWriter("history.json"));
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            writer.write("//Captured by " + timeStamp + "\n" + formattedJson);
        }
        catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
