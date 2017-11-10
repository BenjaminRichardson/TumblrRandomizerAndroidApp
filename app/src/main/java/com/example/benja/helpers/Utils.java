package com.example.benja.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ben Richardson on 11/6/2017.
 */

public class Utils {

    /***
     * Tests provided string to see if it is a valid part of a URL
     * example: xyz.abc.
     * @param s
     * @return
     */
    public static boolean isValidUrlChunk(String s){
        if(s == null){ return false; }
        Pattern p = Pattern.compile("[a-zA-Z-]+");
        Matcher m = p.matcher(s);
        return m.matches();
    }
}
