package com.ali;

public class Test{
}

class Result {
        public static String decryptPassword(String s) {
        int j=0;
        //  char []sArr= s.toCharArray();
        char[] sArr = new char[s.length()];

        // Copy character by character into array
        for (int i = 0; i < s.length(); i++) {
            sArr[i] = s.charAt(i);
        }

        for ( int i=sArr.length-1 ; i>=0; ){
            if (sArr[i]=='*'){
                char temp=sArr[i-1];
                sArr[i-1]=sArr[i-2];
                sArr[i-2]=temp;
                sArr[i]='\n';
                i-=2;

            }
            else if(sArr[i]=='0'){
                sArr[i]=sArr[j];
                sArr[j]='\n';
                j++;
                i-=1;
            }
            else {
                i-=1;
            }
        }
        StringBuilder r= new StringBuilder();
        for (char ch : sArr){
            if (ch=='\n'){
                continue;
            }
            r.append(ch);

        }
        return r.toString();
    }
}