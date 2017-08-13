package com.allen;

import com.allen.controller.QueueManager;

/**
 * Created by yilunq on 12/08/17.
 *
 * This is the Main function to execute
 */
public class Main {
    public static void main(String[] args) {

        // ---------------------------------------------------
        // NEEDS TO BE MODIFY TO BE "read from File"
        // OR GET queueID AUTOMATICALLY
        String queueID = "0090FAE68C221ED78F84917FE2FBA0CB";
        //----------------------------------------------------

        QueueManager qm = new QueueManager(queueID);
        qm.run();
    }
}
