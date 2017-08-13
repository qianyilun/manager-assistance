package com.allen.controller;

import com.allen.model.DATA;
import com.allen.model.TestJSON;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yilunq on 12/08/17.
 *
 * This class is a manager to organize and manage the interactive of all classes
 */
public class QueueManager {
    private String queueID;
    private DATA[] incidentsInfo;
    private ConnectionConfiguration cc;


    public QueueManager(String queueID) {
        this.queueID = queueID;
    }

    public void run() {
        String jsonSourceCode;
        /* ///////////////////////////////////////////////////////////////////
        // --------- Open Connection -----------
        cc = new ConnectionConfiguration(queueID);
        cc.connect();

        // --------- Get 'incidents' in JsonObject via BCP -------
        jsonSourceCode = cc.getJsonSourceCode();
        incidentsInfo = parseJson(jsonSourceCode).getDATA();

        */ ////////////////////////////////////////////////////////////////////

    // ***** TEST ONLY ************** PREPARE TO DELETE ***********************

        // --------- Get 'incidents' in Test raw Json String ---------
        jsonSourceCode = TestJSON.pageSource;
        incidentsInfo = parseJson(TestJSON.pageSource).getDATA();

    // ***** TEST ONLY ************** PREPARE TO DELETE ***********************


        // --------- Save String to JSON file as the backup ----------
        saveJsonFile(JsonStringFormatter.prettyJsonFormat(jsonSourceCode));

        // --------- Manipulate the incident_info ---------
        for (DATA data : incidentsInfo) {
            System.out.println(data.getIRT_EXPIRY());
        }

    }

    private MainParser parseJson(String jsonString) {
        Gson gson = new Gson();
        MainParser mainParser = gson.fromJson(jsonString, MainParser.class);
        return mainParser;
    }

    // https://stackoverflow.com/questions/1053467/how-do-i-save-a-string-to-a-text-file-using-java
    private void saveJsonFile(String formattedJson) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter( new FileWriter("history.json"));
            String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
            writer.write("//Captured by " + timeStamp + "\n" + formattedJson);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
