package com.ali;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Readfile{
    public static void main(String[] args) {
        try {
            File fobj = new File("textfile.txt");
            Scanner reader= new Scanner(fobj);
            while (reader.hasNextLine()){
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("error occured");
            e.getStackTrace();
        }
    }
}

