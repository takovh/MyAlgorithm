package examination.day1;

import java.util.Scanner;

public class Main3 {
    public static String getStr(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str;
    }

    public static void main(String[] args) {
        String S = getStr();
        String T = "";
        while (!S.equals("")){
            int len = S.length();
            if (S.charAt(0)<S.charAt(len-1)){
                T += S.substring(0,1);
                S = S.substring(1,len);
            }else{
                T += S.substring(len-1, len);
                S = S.substring(0,len-1);
            }
        }
        System.out.println(T);
    }
}
