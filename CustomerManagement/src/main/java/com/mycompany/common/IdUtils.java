/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.common;

import java.util.Random;

/**
 * Generate random number
 */
public class IdUtils {
 
    public static long getID() {
        Random random = new Random(System.currentTimeMillis());
        return random.nextLong();
    }
    
}
