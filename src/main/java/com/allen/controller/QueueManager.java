package com.allen.controller;

import com.allen.model.*;
import com.allen.view.mutiple_dialog.MultiDialogNew;
import com.allen.view.single_dialog.SingleDialogNew;
import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yilunq on 12/08/17.
 *
 * This class is a manager to organize and manage the interactive of all classes
 */
public class QueueManager {
    private String queueID;
    private DATA[] incidentsInfo;
    private ConnectionConfiguration cc;
    EmergeQueueList emergeQueueList;


    public QueueManager(String queueID) {
        this.queueID = queueID;
    }

    public void run() {
        emergeQueueList = new EmergeQueueList();
        String jsonSourceCode;




/*

         ///////////////////////////////////////////////////////////////////
        // --------- Open Connection -----------
        cc = new ConnectionConfiguration(queueID);
        cc.connect();

        // --------- Get 'incidents' in JsonObject via BCP -------
        jsonSourceCode = cc.getJsonSourceCode();
        incidentsInfo = parseJson(jsonSourceCode).getDATA();

         ////////////////////////////////////////////////////////////////////

*/









    // ***** below TEST ONLY ************** PREPARE TO DELETE ***********************
                                                                            //**
        // --------- Get 'incidents' in Test raw Json String ---------
        jsonSourceCode = TestJSON.pageSource;
        incidentsInfo = parseJson(TestJSON.pageSource2).getDATA();
    // ***** above TEST ONLY ************** PREPARE TO DELETE ***********************















        // --------- Sort 'incidents' by IRT_EXPIRE date
        Arrays.sort(incidentsInfo);

        // --------- Save String to JSON file as the backup ----------
        JsonSaver.save(JsonStringFormatter.prettyJsonFormat(jsonSourceCode));

        // --------- Manipulate the incident_info ---------
        for (DATA data : incidentsInfo) {
            IRT irt = new IRT(data.getIRT_EXPIRY());

            System.out.println(irt);
            if (data.hasValidIRT()) {
                if (irt.isLessThan(30)) {
                    emergeQueueList.addIncidentToArray(data);
                } else if (irt.isLessThan(45)) {
                    // set timer first, then launch the view in another Thread (Swing will create new thread for each view automatically)
                    Timer timer = new Timer();
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            new SingleDialogNew(data);
                            timer.cancel();
                        }
                    };
                    timer.schedule(task, (new Integer(data.hasMinutesLeft())-30) *   // minutes to sleep
                            60 *   // seconds to a minute
                            1000);
                }
            }
        }

        // launch the multiDialog window to show all about expired incidents at the same time
        if (emergeQueueList.getLst().size() != 0) {
            // launch the view
            new MultiDialogNew(emergeQueueList);
        }
    }

    private MainParser parseJson(String jsonString) {
        Gson gson = new Gson();
        MainParser mainParser = gson.fromJson(jsonString, MainParser.class);
        return mainParser;
    }
}