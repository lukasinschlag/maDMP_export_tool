package com.tuwien.ds19.o4g4.prod.util;

public class TypeIdentifier {

    private static String[] types = new String[]{"HTTP", "ORCID", "DOI", "TSP", "TEXT"};
    private static String[] types_desc = new String[]{"http", "orcid", "doi", "tsp"};

    public static String checkType(String t){
        String found = types[types.length-1]; // default: TEXT
        for(String type : types_desc){
            if(t.toLowerCase().contains(type)){
                found = type;
            }
        }
        if(found.equals(types[1])){ // found orcid
            if(t.toLowerCase().contains(types_desc[0])) { // check if as url
                found = "HTTP-ORCID";
            }
        }
        return found;
    }
}
