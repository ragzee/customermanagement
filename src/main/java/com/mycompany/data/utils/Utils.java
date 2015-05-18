/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.data.utils;

import com.google.gson.Gson;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * Utility to convert to/from json
 */
public class Utils {

    public static DBObject convertPOJOtoDBObject(Object pojo) {
        String json = new Gson().toJson(pojo);
        return (DBObject) JSON.parse(json);
    }

    public static Object convertDBObjectToPOJO(DBObject dbObj, Class clazz) {
        String json = dbObj.toString();
        return new Gson().fromJson(json, clazz);
    }
}
