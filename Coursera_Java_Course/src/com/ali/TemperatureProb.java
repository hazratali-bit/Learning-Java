package com.ali;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class TemperatureProb {
    public CSVRecord hottestHourInFile(CSVParser parser){
        CSVRecord largestSofar = null;
        for (CSVRecord currentRow : parser ){
            if (largestSofar== null){
                largestSofar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSofar.get("TemperatureF"));
                if ( currentTemp < largestTemp){
                    largestSofar = currentRow;
                }
            }
        }
        return largestSofar;
    }



    public CSVRecord hottestInManyDays(){
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if (largestSoFar == null){
                largestSoFar=currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
                if ( currentTemp < largestTemp){
                    largestSoFar = currentRow;
                }
            }
        }
        return largestSoFar;
            }
    public CSVRecord humidityInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            } else {
//                System.out.println(currentRow);
                if (currentRow.get("Humidity").equals("N/A")){
                    continue;
                }
                else {
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double largestTemp = Double.parseDouble(largestSoFar.get("Humidity"));
                if (currentTemp < largestTemp) {
                    largestSoFar = currentRow;
                }
            }}
        }
        return largestSoFar;

    }


    public void testHottestInManyDay(){
        CSVRecord largest = hottestInManyDays();
        System.out.println(largest);
    }

    public void testHumidityInManyDay(){
        CSVRecord largest = humidityInManyDays();
        System.out.println(largest);
        System.out.println(largest.get("Humidity"));
        System.out.println(largest.get("DateUTC"));

    }
    public CSVRecord lowHumidityinFile(CSVParser parser){
        CSVRecord largestSofar = null;
        for (CSVRecord currentRow : parser ){
            if (largestSofar== null){
                largestSofar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double largestTemp = Double.parseDouble(largestSofar.get("Humidity"));
                if ( currentTemp < largestTemp){
                    largestSofar = currentRow;
                }
            }
        }
        return largestSofar;
    }
    public void testlowhumidityinFile(){
        FileResource fr = new FileResource("nc_weather/2014/weather-2014-04-01.csv");
        CSVRecord largest = lowHumidityinFile(fr.getCSVParser());
        System.out.println(largest);
    }

    public static void main(String [] args){
        TemperatureProb case1 = new TemperatureProb();
        case1.testHumidityInManyDay();
    }
}


/////////////// temperature second section //////////////////////////////////


 class L8 {
    public double coldestHourInFile(CSVParser parser){
        int count =0;
        double temp=0;
        for (CSVRecord currentRow : parser ) {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            if (Integer.parseInt(currentRow.get("Humidity"))>=80) {
                temp += currentTemp;
                count++;
            }
        }
        return temp/count;
    }

    public void testcoldestHourInFile(){
        FileResource fr = new FileResource();
        double coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println(coldest);
    }
    public static void main(String [] args){
        L8 case1 = new L8();
        case1.testcoldestHourInFile();
    }

}


class Q3 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSofar = null;
        for (CSVRecord currentRow : parser ){
            if (coldestSofar== null){
                coldestSofar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSofar.get("TemperatureF"));
                if ( currentTemp < coldestTemp){
                    coldestSofar = currentRow;
                }
            }
        }
        return coldestSofar;
    }

    public void testcoldestHourInFile(){
        FileResource fr = new FileResource();
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println(coldest.get("TemperatureF"));
    }
    public static void main(String [] args){
        Q3 case1 = new Q3();
        case1.testcoldestHourInFile();
    }

}

class Q4 {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestSofar = null;
        for (CSVRecord currentRow : parser ){
            if (coldestSofar== null){
                coldestSofar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldestSofar.get("TemperatureF"));
                if ( currentTemp < coldestTemp){
                    coldestSofar = currentRow;
                }
            }
        }
        return coldestSofar;
    }

    public CSVRecord coldestTempInMany(){
        CSVRecord coldestSofar = null;
        DirectoryResource dr= new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord currentRow=coldestHourInFile(fr.getCSVParser());
            if (coldestSofar ==null){
                coldestSofar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double largestTemp = Double.parseDouble(coldestSofar.get("TemperatureF"));
                if (currentTemp < largestTemp) {
                    coldestSofar = currentRow;
                }
            }
        }
        return coldestSofar;
    }

    public void testcoldestTempInMany(){
        CSVRecord coldest = coldestTempInMany();
        System.out.println(coldest);
    }
    public static void main(String [] args){
        Q4 case1 = new Q4();
        case1.testcoldestTempInMany();
    }

}

class Q5 {
    public CSVRecord lowHumidityinFile(CSVParser parser){
        CSVRecord largestSofar = null;
        for (CSVRecord currentRow : parser ){
            if (largestSofar== null){
                largestSofar = currentRow;
            }
            else {
                double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                double largestTemp = Double.parseDouble(largestSofar.get("Humidity"));
                if ( currentTemp < largestTemp){
                    largestSofar = currentRow;
                }
            }
        }
        return largestSofar;
    }


    public void testlowhumidityinFile(){
//        FileResource fr = new FileResource("nc_weather/2014/weather-2014-04-01.csv");
        FileResource fr = new FileResource();

        CSVRecord largest = lowHumidityinFile(fr.getCSVParser());
        System.out.println(largest);
    }
    public static void main(String [] args){
        Q5 case1 = new Q5();
        case1.testlowhumidityinFile();
    }

}

class Q6 {
    public CSVRecord lowHumidityinFile(CSVParser parser){
        CSVRecord largestSofar = null;
        for (CSVRecord currentRow : parser ){
            if (largestSofar== null){
                largestSofar = currentRow;
            }
            else {
                if (currentRow.get("Humidity").equals("N/A")){
                    continue;
                }
                else {
                    double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                    double largestTemp = Double.parseDouble(largestSofar.get("Humidity"));

                    if ( currentTemp < largestTemp){
                        largestSofar = currentRow;
                    }
                }}
        }
        return largestSofar;
    }

    public CSVRecord humidityInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowHumidityinFile(fr.getCSVParser());
            if (largestSoFar == null) {
                largestSoFar = currentRow;
            } else {
//                System.out.println(currentRow);
                if (currentRow.get("Humidity").equals("N/A")){
                    continue;
                }
                else {
                    double currentTemp = Double.parseDouble(currentRow.get("Humidity"));
                    double largestTemp = Double.parseDouble(largestSoFar.get("Humidity"));
                    if (currentTemp < largestTemp) {
                        largestSoFar = currentRow;
                    }
                }}
        }
        return largestSoFar;

    }


    public void testlowestHumidityinMany(){
        CSVRecord largest = humidityInManyDays();
        System.out.println(largest);
    }
    public static void main(String [] args){
        Q6 case1 = new Q6();
        case1.testlowestHumidityinMany();
    }

}

