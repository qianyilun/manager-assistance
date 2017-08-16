package com.allen.model;

import java.util.ArrayList;
import java.util.List;

/*
** This class is to save all incidents that are about expired.
*
* The final purpose is to display in the GUI.
 */
public class EmergeQueueList {
    private List<DATA> lst = new ArrayList<>();

    public List<DATA> getLst() {
        return lst;
    }

    public void addIncidentToArray(DATA incident) {
        lst.add(incident);
    }
}
