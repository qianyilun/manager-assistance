package com.allen.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by yilunq on 12/08/17.
 *
 * This is pre-step for save JSON file
 *
 * Pretty JSON String method is from
 *  https://stackoverflow.com/questions/4105795/pretty-print-json-in-java
 *
 *  @author Allen Qian
 */
public class JsonStringFormatter {
    public static String prettyJsonFormat(String uglyJsonString) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJsonString);
        return gson.toJson(je);
    }
}
