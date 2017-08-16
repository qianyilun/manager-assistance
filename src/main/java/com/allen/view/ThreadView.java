package com.allen.view;

/*
** This class is to create a warning message/dialog to show all the incident information
*  By using multi-thread solution
 */

import com.allen.model.DATA;

import java.util.ArrayList;
import java.util.List;

public class ThreadView extends Applicaiton implements Runnable{
    List<DATA> lst = new ArrayList<>();
}
