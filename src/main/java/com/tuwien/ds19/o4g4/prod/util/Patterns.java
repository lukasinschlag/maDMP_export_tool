package com.tuwien.ds19.o4g4.prod.util;

import java.util.regex.Pattern;

public class Patterns {

    public static Pattern getMail(){
        return Pattern.compile("(^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*)");
    }

    public static Pattern getORCID(){
        return Pattern.compile("(orcid[^\\s]+)");
    }

    public static Pattern getURI(){
        return Pattern.compile("(\\w+:(/?/?)[^\\s]+)");
    }

    public static Pattern getDOI(){
        return Pattern.compile("(10.\\d{4,9}.[\\w.-]+)");
    }

    public static Pattern getURL(){
        return Pattern.compile("((https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");
    }
}
