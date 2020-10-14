package com.ali;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String args []){
        Set <Integer> values = new TreeSet<>();
        values.add(63);
        values.add(42);
        values.add(53);
        values.add(54);


        for (int i: values){
            System.out.println(i);
        }

    }
}
