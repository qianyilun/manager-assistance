package com.allen;

import com.allen.controller.QueueManager;
import com.allen.view.single_dialog.SingleDialog;
import com.allen.view.single_dialog.SingleDialogNew;
import com.allen.view.start_page.StartPageNew;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yilunq on 12/08/17.
 *
 * This is the Main function to execute
 *
 * @author Allen Qian
 */
public class Main {
    private static Timer timer;
    private static TimerTask task;

    public static void main(String[] args) {

        // ---------------------------------------------------
        // NEEDS TO BE MODIFY TO BE "read from File"
        // OR GET queueID AUTOMATICALLY
        String queueID = "0090FAE68C221ED78F8482FB683BC0CB";
        //----------------------------------------------------

        start(queueID);
    }

    public static void start(String queueID) {
        // display welcome start page
        StartPageNew sp = new StartPageNew();

        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                QueueManager qm = new QueueManager(queueID);
                qm.run();
            }
        };

        // note, period should be 15 mins
        timer.schedule(task, 0, 15 *   // minutes to sleep
                                            60 *   // seconds to a minute
                                            1000); // milliseconds to a second);
    }
}
