package com.allen.controller;

import com.allen.model.DATA;
import com.allen.model.TestJSON;
import com.google.gson.Gson;

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
        /* ///////////////////////////////////////////////////////////////////
        // --------- Open Connection -----------
        cc = new ConnectionConfiguration(queueID);
        cc.connect();

        // --------- Get 'incidents' in JsonObject via BCP -------
        incidentsInfo = parseJson(cc.getJsonSourceCode()).getDATA();

        */ ////////////////////////////////////////////////////////////////////

    // ***** TEST ONLY ************** PREPARE TO DELETE ***********************

        // --------- Get 'incidents' in Test raw Json String ---------
        incidentsInfo = parseJson(TestJSON.pageSource).getDATA();

    // ***** TEST ONLY ************** PREPARE TO DELETE ***********************



        for (DATA data : incidentsInfo) {
            System.out.println(data.getIRT_EXPIRY());
        }

    }

    private MainParser parseJson(String jsonString) {
        Gson gson = new Gson();
        MainParser mainParser = gson.fromJson(jsonString, MainParser.class);
        return mainParser;
    }

    private void saveJsonFile(String formattedJson) {
        
    }
}
