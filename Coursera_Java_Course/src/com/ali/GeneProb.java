package com.ali;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Shape;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GeneProb {
    public int findStopCodon(String dnaStr,
                             int startIndex,
                             String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        while (currIndex!=-1){
            int diff = currIndex-startIndex;
            if (diff %3 == 0){
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon,currIndex+1);
            }
        }
        return -1;
    }

    public String findGene(String dna,int where){
        int startIndex = dna.indexOf("ATG",where);
        if (startIndex ==-1){
            return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");

        int minIndex =0;
        if (taaIndex ==-1 ||
                (tgaIndex !=-1 && tgaIndex < taaIndex)) {
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        if (minIndex ==-1 ||
                (tagIndex  != -1 && tagIndex<minIndex)){
            minIndex=tagIndex;
        }
        if (minIndex==-1){
            return "";
        }
        return dna.substring(startIndex,minIndex+3);
    }

    public void printAllGene(String dna){
        int i =0;
        int startIndex =0;
        while (true){
            String currentGene = findGene(dna,startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            double cgr= cgratio(currentGene);
            if (cgr >0.35){
                i++;
            }

            startIndex=dna.indexOf(currentGene,startIndex)+currentGene.length();
        }
        System.out.println(i);
    }


    public double cgratio(String genee){
        int geneeLen= genee.length();
        int noC = findC(genee);
        int noG = findG(genee);
        int noCG = noG+ noC;
        double ratio= (double) noCG/geneeLen;
        return ratio;
    }

    public int findC(String genee){
        int count = 0;
        int stPos =0;
        int currPos =0;
        char [] geneeArr = genee.toCharArray();
        for (char letter: geneeArr){
            int checkC = genee.indexOf("C",stPos);
            if (checkC==-1){
                break;
            }
            else {
                count +=1;
                stPos=checkC+1;
            }
        }
        return count;
    }
    public int findG(String genee){
        int count = 0;
        int stPos =0;
        int currPos =0;
        char [] geneeArr = genee.toCharArray();
        for (char letter: geneeArr){
            int checkC = genee.indexOf("G",stPos);
            if (checkC==-1){
                break;
            }
            else {
                count +=1;
                stPos=checkC+1;
            }
        }
        return count;
    }

    public void testPerimeter(){
        try {
            File fobj = new File("q5.txt");
            Scanner reader= new Scanner(fobj);
            String dna ="";
            while (reader.hasNextLine()){
                dna =dna + reader.nextLine();
//                System.out.println(dna);

            }
//            double cgrat = cgratio(dna);

            printAllGene(dna);
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.getStackTrace();
        }

    }

    public static void main(String[] args){
        GeneProb case1 = new GeneProb();
        case1.testPerimeter();


    }
        }






 class Question7 {
    public int findStopCodon(String dnaStr,
                             int startIndex,
                             String stopCodon){
        int count =0;
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        while (true){
            if (currIndex==-1)
                break;
            int diff = currIndex-startIndex;
            if (diff %3 == 0){
                count += 1;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon,currIndex+1);
            }
        }
        return count;
    }
    public  static void main(String [] args ){
        Question7 case1 = new Question7();
        int c= case1.findStopCodon("CTGCTGCTGACTGSSSYDGDF",0,"CTG");
        System.out.println(c);
    }

}


class TagFinder {
    public String findProtein(String dna) {
        int start = dna.indexOf("atg");
        if (start == -1) {
            return "";
        }
        int stop = dna.indexOf("tag", start+3);
        if ((stop - start) % 3 == 0) {
            return dna.substring(start, stop+3);
        }
        else {
            return "";
        }
    }

    public void testing() {
        String a = "cccatggggtttaaataataataggagagagagagagagttt";
        String ap = "atggggtttaaataataatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG";
        //String ap = "ATGCCCTAG";
        String result = findProtein(a);
        if (ap.equals(result)) {
            System.out.println("success for " + ap + " length " + ap.length());
        }
        else {
            System.out.println("mistake for input: " + a);
            System.out.println("got: " + result);
            System.out.println("not: " + ap);
        }
    }

    public void realTesting() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            String s = fr.asString();
            System.out.println("read " + s.length() + " characters");
            String result = findProtein(s);
            System.out.println("found " + result);
        }
    }
}

    class Question4{

public int findStopCodon(String dnaStr,
        int startIndex,
        String stopCodon){
        int currIndex = dnaStr.indexOf(stopCodon,startIndex+3);
        while (currIndex!=-1){
        int diff = currIndex-startIndex;
        if (diff %3 == 0){
        return currIndex;
        }
        else {
        currIndex = dnaStr.indexOf(stopCodon,currIndex+1);
        }
        }
        return -1;
        }

public String findGene(String dna,int where){
        int startIndex = dna.indexOf("ATG",where);
        if (startIndex ==-1){
        return "";
        }
        int taaIndex = findStopCodon(dna,startIndex,"TAA");
        int tagIndex = findStopCodon(dna,startIndex,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex,"TGA");

        int minIndex =0;
        if (taaIndex ==-1 ||
        (tgaIndex !=-1 && tgaIndex < taaIndex)) {
        minIndex = tgaIndex;
        }
        else {
        minIndex = taaIndex;
        }
        if (minIndex ==-1 ||
        (tagIndex  != -1 && tagIndex<minIndex)){
        minIndex=tagIndex;
        }
        if (minIndex==-1){
        return "";
        }
        return dna.substring(startIndex,minIndex+3);
        }

public void printAllGene(String dna){
        int i =0;
        int [] lenData = new int [70];
        int startIndex =0;
        while (true){
        String currentGene = findGene(dna,startIndex);
        if (currentGene.isEmpty()){
        break;
        }
        lenData [i]= currentGene.length();
        i++;
        System.out.println(i+currentGene);

        startIndex=dna.indexOf(currentGene,startIndex)+currentGene.length();
        }
        for (int j=0; j<lenData.length ; j++)
        System.out.println(lenData[j]);
        }

public void test(){


        try {
        File fobj = new File("q5.txt");
        Scanner reader= new Scanner(fobj);
        String dna ="";
        while (reader.hasNextLine()){
        dna =dna + reader.nextLine();
//                System.out.println(dna);

        }
        dna = dna.toUpperCase();
//            System.out.println(dna.length());
        printAllGene(dna);
        reader.close();
        }
        catch (FileNotFoundException e){
        System.out.println("error occured");
        e.getStackTrace();
        }



        }
public static void main(String []args){
        Question4 case1 = new Question4();
        case1.test();
        }
        }