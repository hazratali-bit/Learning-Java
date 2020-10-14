package com.ali;

import edu.duke.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ShapeParamProb{
    public double getPerimeter(Shape shape){
        double totlaPerim = 0;
        Point prevPt = shape.getLastPoint();
        for (Point currPt: shape.getPoints()){
            double currDist = prevPt.distance(currPt);
            totlaPerim= totlaPerim+currDist;
            prevPt=currPt;
        }
        return totlaPerim;
    }



    public double testPerimeter(String filename){
//        Scanner scanner = new Scanner(System.in);
//        String filename= scanner.nextLine();
        FileResource fileResource= new FileResource(filename);
        Shape shape= new Shape(fileResource);
        double per = getPerimeter(shape);

        return per;
    }

    public static void main(String[]args){
        ShapeParamProb case1= new ShapeParamProb();
        ShapeParamProb case2= new ShapeParamProb();
        ShapeParamProb case3= new ShapeParamProb();
        ShapeParamProb case4= new ShapeParamProb();


        double a1=case1.testPerimeter("example1.txt");
        double a2=case2.testPerimeter("example2.txt");
        double a3=case3.testPerimeter("example3.txt");
        double a4=case4.testPerimeter("example4.txt");


        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);


    }
}

class Question1 {
    public double getPerimeter(Shape shape){
        double totlaPerim = 0;
        Point prevPt = shape.getLastPoint();
        for (Point currPt: shape.getPoints()){
            double currDist = prevPt.distance(currPt);
            totlaPerim= totlaPerim+currDist;
            prevPt=currPt;
        }
        return totlaPerim;
    }



    public void testPerimeter(){
        FileResource fileResource= new FileResource("datatest4.txt");
        Shape shape= new Shape(fileResource);
        double length = getPerimeter(shape);
        System.out.println("Perimeter= "+length);
    }

    public static void main(String[]args){
        Question1 case1= new Question1();
        case1.testPerimeter();
    }
}

class Question2{
    public double getPerimeter(Shape shape){
        double totlaPerim = 0;
        Point prevPt = shape.getLastPoint();
        for (Point currPt: shape.getPoints()){
            double currDist = prevPt.distance(currPt);
            totlaPerim= totlaPerim+currDist;
            prevPt=currPt;
        }
        return totlaPerim;
    }



    public void testPerimeter(){
        FileResource fileResource= new FileResource("datatest1.txt");
        Shape shape= new Shape(fileResource);
        double length = getPerimeter(shape);
        double avgLen= (length/4);
        System.out.println("Average Length= "+avgLen);
    }

    public static void main(String[]args){
        Question2 case1= new Question2();
        case1.testPerimeter();
    }
}

class Question3 {
    public double getPerimeter(Shape shape){
        double [] distances={0,0,0,0,0,0,0,0,0,0,0,0};
        Point PrevPt = shape.getLastPoint();
        int i =0;
        for (Point currPt:shape.getPoints()){
            double currDist = PrevPt.distance(currPt);
            distances[++i]=currDist;
            PrevPt=currPt;
        }
        System.out.println(distances);
        double max =0;
        for (double j : distances){
            if (j>max) {
                max = j;
            }
        }
        return max;
    }



    public void testPerimeter(){
        FileResource fileResource= new FileResource("datatest4.txt");
        Shape shape= new Shape(fileResource);
        double length = getPerimeter(shape);
        System.out.println("Average Length= "+length);
    }

    public static void main(String[]args){
        Question3 case1= new Question3();
        case1.testPerimeter();
    }
}


class Question5{
    public double getPerimeter(Shape shape){
        double totlaPerim = 0;
        Point prevPt = shape.getLastPoint();
        for (Point currPt: shape.getPoints()){
            double currDist = prevPt.distance(currPt);
            totlaPerim= totlaPerim+currDist;
            prevPt=currPt;
        }
        return totlaPerim;
    }



    public double testPerimeter(String filename){
//        Scanner scanner = new Scanner(System.in);
//        String filename= scanner.nextLine();
        FileResource fileResource= new FileResource(filename);
        Shape shape= new Shape(fileResource);
        double per = getPerimeter(shape);

        return per;
    }

    public static void main(String[]args){
        Question5 case1= new Question5();
        Question5 case2= new Question5();
        Question5 case3= new Question5();
        Question5 case4= new Question5();
        Question5 case5= new Question5();
        Question5 case6= new Question5();

        double a1=case1.testPerimeter("example1.txt");
        double a2=case2.testPerimeter("example2.txt");
        double a3=case3.testPerimeter("example3.txt");
        double a4=case4.testPerimeter("example4.txt");
        double a5=case5.testPerimeter("example5.txt");
        double a6=case6.testPerimeter("example6.txt");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
        System.out.println(a6);

    }
}

