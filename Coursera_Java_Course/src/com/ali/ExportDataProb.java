package com.ali;

import edu.duke.*;
import org.apache.commons.csv.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class ExportDataProb {
    public void csvPrint () throws ParseException {
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        int count =0;
        for (CSVRecord record : parser){
            Boolean exp = record.get("Exports").contains("cocoa");
            if (exp){
                System.out.println(record.get("Country"));
//                System.out.println(record);
//                count++;
//                System.out.println(record.get("Country"));
            }
        }
//        System.out.println(count);
    }
    public static void main (String [] args){
        ExportDataProb case1 = new ExportDataProb();
        try {
            case1.csvPrint();
        }
        catch (Exception e){

        }

    }
}
////////////////////Second Section////////////

 class L3 {
    public void csvPrint () throws ParseException {
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        int count =0;
        for (CSVRecord record : parser){
//            Boolean exp = record.get("Exports").contains("fish") && record.get("Exports").contains("nuts");
//            Boolean exp = record.get("Exports").contains("gold");
//            Boolean exp = record.get("Country").equals("Nauru");

            try {
                String pr=record.get("Value (dollars)");
                double oneTri = 999999999999d;
                Locale locale = Locale.US;
                Number number = NumberFormat.getCurrencyInstance(locale).parse(pr);
//                System.out.println(number);
//                System.out.println(pr);
                Boolean exp = number.doubleValue()> oneTri;
                if (exp){

                    System.out.println(record.get("Country"));
//                System.out.println(record);
//                count++;
//                System.out.println(record.get("Country"));
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

//            Boolean exp = (double)pr> oneTri;
//            if (exp){
//
//                System.out.println(record.get("Country"));
////                System.out.println(record);
////                count++;
////                System.out.println(record.get("Country"));
//            }
        }
        System.out.println(count);
    }
    public static void main (String [] args){
        L3 case1 = new L3();
        try {
            case1.csvPrint();
        }
        catch (Exception e){

        }

    }
}


class WeekQ1 {
    public void csvPrint () throws ParseException {
        FileResource fr = new FileResource("exportdata.csv");
        CSVParser parser = fr.getCSVParser();
        int count =0;
        for (CSVRecord record : parser){
//            System.out.println(record);
//            question no 3
//            Boolean exp = record.get("Exports").contains("fish") && record.get("Exports").contains("nuts");
//            Boolean exp = record.get("Exports").contains("gold");
//            Boolean exp = record.get("Country").equals("Nauru");

            try {
                String pr=record.get("Value (dollars)");
                double oneTri = 999999999999d;
                Locale locale = Locale.US;
                Number number = NumberFormat.getCurrencyInstance(locale).parse(pr);
//                System.out.println(number);
//                System.out.println(pr);
                Boolean exp = number.doubleValue()> oneTri;
                if (exp){

                    System.out.println(record.get("Country"));
//                System.out.println(record);
//                count++;
//                System.out.println(record.get("Country"));
                }
            }
            catch (Exception e){
                System.out.println(e);
            }

//            Boolean exp = (double)pr> oneTri;
//            if (exp){
//
//                System.out.println(record.get("Country"));
////                System.out.println(record);
////                count++;
////                System.out.println(record.get("Country"));
//            }
        }
        System.out.println(count);
    }
    public static void main (String [] args){
        WeekQ1 case1 = new WeekQ1();
        try {
            case1.csvPrint();
        }
        catch (Exception e){

        }

    }
}





