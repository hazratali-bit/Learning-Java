package com.ali;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegxDemo {
    public static void main(String [] args) {
        // this means that the string must have to contain the exact word "ali" with the case ignored
        Pattern pattern  = Pattern.compile("ali",Pattern.CASE_INSENSITIVE);
        // this means that the string must contain the word ali doesn't matter what comees before the string.
        Pattern pattern1 = Pattern.compile(".ali");


        Pattern pattern2 = Pattern.compile("[r]");
        Matcher matcher = pattern2.matcher("i am hazrat ali");
        boolean matchf= matcher.find();
        if (matchf){
            System.out.println("match found");
        }
        else {
            System.out.println("not found");
        }
        Pattern p = Pattern.compile("[a-zA-Z]{9}");
        Matcher m = p.matcher("www.javapedia.net");
        System.out.println("Javapedia matched :" + m.matches());
        System.out.println("Javapedia found :" + m.find());

        // string that contains characters from a to z.
        Pattern pattern3= Pattern.compile("[a-z]");
        // strings that contains character form a to z or 0 to 9
        Pattern pattern4= Pattern.compile("[a-z[0-9]]");
        //
        Pattern pattern5 = Pattern.compile("[a-z &&[0-9]]");
    }
}
