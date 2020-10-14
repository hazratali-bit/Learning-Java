package com.ali;

public class Point {
    private int x;
    private int y;

    public Point(int startx, int starty){
        x=startx;
        y=starty;
    }
    public int getX(){return x;}
    public int getY(){return y;}

    public double distance(Point otherPt){
        int dx = otherPt.getX();
        int dy = otherPt.getY();
        double deltaD= Math.sqrt(dx*dx+dy*dy);
        return deltaD;
    }


    public static void main (String[] args){
        Point point1= new Point(2,3);
        Point point2= new Point(4,5);
        System.out.println(point1.distance(point2));
    }
}

