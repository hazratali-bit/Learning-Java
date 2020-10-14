package com.ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String [] args){
        Map<String,String> map = new HashMap<>();
        map.put("name","Navin");
        map.put("acotr","john");

        Set<String> keys =  map.keySet();
        for (String key : keys) {
            System.out.println(key + map.get(key));
        }
    }
}
