package com.allen.controller;

import com.allen.model.DATA;
import com.allen.model.IRT;
import com.allen.model.JsonSaver;
import com.allen.model.TestJSON;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
                                                                            //**
        // --------- Get 'incidents' in Test raw Json String ---------
        jsonSourceCode = TestJSON.pageSource;
        incidentsInfo = parseJson(TestJSON.pageSource).getDATA();
    // ***** TEST ONLY ************** PREPARE TO DELETE ***********************


        // --------- Sort 'incidents' by IRT_EXPIRE date
        Arrays.sort(incidentsInfo);

        // --------- Save String to JSON file as the backup ----------
        JsonSaver.save(JsonStringFormatter.prettyJsonFormat(jsonSourceCode));

        // --------- Manipulate the incident_info ---------
        for (DATA data : incidentsInfo) {
            IRT irt = new IRT(data.getIRT_EXPIRY());

            if (data.hasValidIRT()) {
                System.out.println(irt);
                System.out.println(data.getLAST_CHANGED_AT_SAP());
            }
        }
    }

    private MainParser parseJson(String jsonString) {
        Gson gson = new Gson();
        MainParser mainParser = gson.fromJson(jsonString, MainParser.class);
        return mainParser;
    }
}
