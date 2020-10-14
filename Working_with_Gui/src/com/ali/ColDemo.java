package com.ali;

import java.util.*;

public class ColDemo {

    public static void main(String[]args){
        List<Integer> values= new ArrayList<>();
        values.add(301);
        values.add(432);
        values.add(123);
        values.add(434);
        Comparator<Integer> c =  new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                if (o1%10<o2%10){
                    return 1;
                }
                else
                    return -1;
            }
        };

        Collections.sort(values,c);

        for (Object x: values){
            System.out.println(x);
        }
    }

}
