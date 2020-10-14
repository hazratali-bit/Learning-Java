package com.ali;

import javax.naming.NamingEnumeration;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class Main extends Thread{
    public void run(){
        System.out.println("the thread is running.");
        Date rightNow;
        Locale currentLocale;
        DateFormat timeFormatter;
        DateFormat dateFormatter;
        String timeOutput;
        String DateOutput;

        for (int i=0; i<=20;i++){
            rightNow=new Date();
            currentLocale = new Locale("en");
            timeFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT,currentLocale);
            dateFormatter= DateFormat.getDateInstance(DateFormat.DEFAULT,currentLocale);
            timeOutput=timeFormatter.format(rightNow);
            DateOutput = dateFormatter.format(currentLocale);
            System.out.println(timeOutput);
            System.out.println(DateOutput);
        }

    }
    public static void main(String [] args){
        Main cs= new Main();
        cs.start();
    }
}
