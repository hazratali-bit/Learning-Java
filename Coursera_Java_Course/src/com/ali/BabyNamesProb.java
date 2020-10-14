package com.ali;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;

public class BabyNamesProb {

    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int boyTotalBirths = 0;
        int girlTotalBirths = 0;
        int boyCount = 0;
        int girlCount = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(record.get(2));
            totalBirths += numBorn;
            if (record.get(1).equals("M")) {
                boyTotalBirths += numBorn;
                boyCount++;
            } else {
                girlTotalBirths += numBorn;
                girlCount++;
            }
        }
        System.out.println("Total data = " + (boyCount + girlCount));
        System.out.println("Total births = " + totalBirths);
        System.out.println("Total girls = " + girlCount);
        System.out.println("Total girls births = " + girlTotalBirths);
        System.out.println("Total boys = " + boyCount);
        System.out.println("Total boys births = " + boyTotalBirths);
    }



    public int getRank(int year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv" );
        int rank = 0;
        boolean recordFound = false;
        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentName = record.get(0);
            String currentGender = record.get(1);
            if (currentGender.equals(gender)) {
                rank++;
                if (currentName.equals(name)) {
                    recordFound = true;
                    break;
                }
            }
        }
        if (recordFound) {
            return rank;
        } else {
            return -1;
        }
    }

    public String getName(int year, int rank, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv" );
        String name = "NO NAME";
        int currentRank = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);
            if (currentGender.equals(gender)) {
                currentRank++;
                if (currentRank == rank) {
                    name = record.get(0);
                    break;
                }
            }
        }
        return name;
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int currentYearRank = getRank(year, name, gender);
        String newName = getName(newYear, currentYearRank, gender);
        System.out.println(name + " born in " + newYear + " would be " + newName + " if she was born in " + newYear);
    }

    public int yearOfHighestRank(String name, String gender) {
        int year = Integer.MIN_VALUE;
        int rank = Integer.MAX_VALUE;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(currentYear, name, gender);
            if (currentRank != -1 && currentRank < rank) {
                rank = currentRank;
                year = currentYear;
            }
        }
        if (year == Integer.MIN_VALUE) {
            return -1;
        } else {
            return year;
        }
    }

    public double getAverageRank(String name, String gender) {
        double totalRank = 0;
        int recordCount = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            int currentYear = Integer.parseInt(f.getName().substring(3, 7));
            int currentRank = getRank(currentYear, name, gender);
            if (currentRank != -1) {
                totalRank += currentRank;
                recordCount++;
            }
        }
        if (recordCount == 0) {
            return -1.0;
        } else {
            return totalRank / recordCount;
        }
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv" );
        int rank = getRank(year, name, gender);
        int totalBirths = 0;
        int currentRank = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            String currentGender = record.get(1);
            if (currentGender.equals(gender)) {
                currentRank++;
                if (currentRank < rank) {
                    int currentBirths = Integer.parseInt(record.get(2));
                    totalBirths += currentBirths;
                } else {
                    break;
                }
            }
        }
        return totalBirths;
    }

    public void testGetTotalBirthsRankedHigher() {
        int year = 2012;
        String name = "Ethan";
        String gender = "M";
        System.out.println("Total births higher than " + name + " is " + getTotalBirthsRankedHigher(year, name, gender));
    }
    public void testYearOfHighestRank() {
        String name = "Mason";
        String gender = "M";
        System.out.println(name + " most popular year is " + yearOfHighestRank(name, gender));
    }

    public void testGetRank() {
        int year = 1971;
        String name = "Frank";
        String gender = "M";
        int rank = getRank(year, name, gender);
        System.out.println(name + " rank is " + rank);
    }
    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    public void testGetName() {
        int year = 2012;
        int rank = 2;
        String gender = "M";
        String name = getName(year, rank, gender);
        System.out.println(year + " rank " + rank + " is " + name);
    }

    public void testWhatIsNameInYear() {
        whatIsNameInYear("Isabella", 2012, 2014, "F");
    }

    public void testGetAverageRank() {
        String name = "Mason";
        String gender = "M";
        System.out.println("Average rank for " + name + " is " + getAverageRank(name, gender));
        name = "Jacob";
        gender = "M";
        System.out.println("Average rank for " + name + " is " + getAverageRank(name, gender));
    }

    public static void main(String [] args){
        BabyNamesProb c = new BabyNamesProb();
//        //question no 4
//        int Frankr=c.getRank(1971,"Frank","M");
//        System.out.println(Frankr);
//        // question no 8
//        int rank=c.getRank(1974,"Owen","M");
//        String name = c.getName(2014,rank,"M");
//        System.out.println(name);
//        // question no 12
//        double avg = c.getAverageRank("Robert","M");
//        System.out.println(avg);
        //question no 9
//        int res = c.yearOfHighestRank("Genevieve","F");
//        System.out.println(res);
        // question no 10
//        int res = c.yearOfHighestRank("Mich","M");
//        System.out.println(res);
        // question no 11
//        double res=c.getAverageRank("Susan","F");
//        System.out.println(res);
        // question no 12
        double res=c.getAverageRank("Robert","M");
        System.out.println(res);
    }
}

class W4 {
    public int countgirlsnames(CSVParser parser) {

        for (CSVRecord currentRow : parser) {
//            System.out.println(currentRow.get(0));
//            System.out.println(currentRow.get(1));
//            System.out.println(currentRow.get(2));

            if (currentRow.get(2).equals("335")) {
                System.out.println(currentRow.get(0));
                System.out.println(currentRow.get(1));
                System.out.println(currentRow.get(2));
            }
        }
        return 0;
    }
    public static void main(String [] args){
        W4 case1 = new W4();
        FileResource fr = new FileResource();
        case1.countgirlsnames(fr.getCSVParser());
    }
}


class W14 {
    public int countboyssnames(CSVParser parser) {
        int count = 0;
        int rank = 0;
        for (CSVRecord currentRow : parser) {
            if (currentRow.get(1).equals("F") && currentRow.get(0).equals("Emily")) {
//                rank = Integer.parseInt(currentRow.get(2));
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String [] args){
        W14 case1 = new W14();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1990.csv");
        int c =case1.countboyssnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}

class Wq4 {
    //
    public int getFrankrank(CSVParser parser) {
        int count = 0;
        int rank = 0;
        for (CSVRecord currentRow : parser) {
            if (currentRow.get(1).equals("M")) {
                count++;
            }
            if (currentRow.get(1).equals("M") && currentRow.get(0).equals("Frank")) {
                System.out.println(currentRow);
//                rank = Integer.parseInt(currentRow.get(2));
                break;
            }
        }
        return count;
    }
    public static void main(String [] args){
        Wq4 case1 = new Wq4();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1971.csv");
        int c =case1.getFrankrank(fr.getCSVParser(false));
        System.out.println(c);
    }
}


class Wq1 {
    public int countgirlsnames(CSVParser parser) {
        int count = 0;
        for (CSVRecord currentRow : parser) {

            if (currentRow.get(1).equals("F")) {
                count++;
            }
        }
        return count;
    }
    public static void main(String [] args){
        Wq1 case1 = new Wq1();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1900.csv");
        int c =case1.countgirlsnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}

class Wq2 {
    public int countboyssnames(CSVParser parser) {
        int count = 0;
        for (CSVRecord currentRow : parser) {

            if (currentRow.get(1).equals("M")) {
                count++;
            }
        }
        return count;
    }
    public static void main(String [] args){
        Wq2 case1 = new Wq2();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1905.csv");
        int c =case1.countboyssnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}

class Wq3 {
    public int countboyssnames(CSVParser parser) {
        int count = 0;
        int rank = 0;
        for (CSVRecord currentRow : parser) {
            count++;
            if (currentRow.get(1).equals("F") && currentRow.get(2).equals("Emily")) {
//                rank = Integer.parseInt(currentRow.get(2));
                break;
            }
        }
        return count;
    }
    public static void main(String [] args){
        Wq3 case1 = new Wq3();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1960.csv");
        int c =case1.countboyssnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}


class Wq5 {
    public String countboyssnames(CSVParser parser) {
        int count = 0;
        String name="";
        for (CSVRecord currentRow : parser) {
            count++;
            if (count==350) {
                name = currentRow.get(0);
            }
        }
        return name;
    }
    public static void main(String [] args){
        Wq5 case1 = new Wq5();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1980.csv");
        String  c =case1.countboyssnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}
class Wq6 {
    public String countboyssnames(CSVParser parser) {
        int count = 0;
        String name="";
        for (CSVRecord currentRow : parser) {

            if (currentRow.get(1).equals("M")) {
                count++;
            }
            if (count==450){
                name=currentRow.get(0);
            }
        }
        return name;
    }
    public static void main(String [] args){
        Wq6 case1 = new Wq6();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1982.csv");
        String  c =case1.countboyssnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}
class Wq7 {
    public int countboyssnames(CSVParser parser) {
        int count = 0;
        String name="";
        String  rank="";
        for (CSVRecord currentRow : parser) {
            count++;
            if (currentRow.get(0).equals("Owen") && currentRow.get(1).equals("M")) {
                break;
            }
        }
        return count;
    }


    public static void main(String [] args){
        Wq7 case1 = new Wq7();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob1974.csv");
        int  c =case1.countboyssnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}
class Q7b {
    public int countboyssnames(CSVParser parser) {
        int count = 0;
        String name="";
        String  rank="";
        for (CSVRecord currentRow : parser) {
            count++;
            if (count ==10151) {
                System.out.println(currentRow.get(0));
                break;
            }
        }
        return count;
    }


    public static void main(String [] args){
        Q7b case1 = new Q7b();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob2014.csv");
        int  c =case1.countboyssnames(fr.getCSVParser(false));
        System.out.println(c);
    }
}





