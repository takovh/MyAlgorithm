package examination.day1;

import java.util.*;

public class Main1 {

    public static String getStr(){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        return str;
    }

    /**
     * 判断str内的括号是否匹配
     * @param str
     * @return
     */
    public static boolean isMatch(String str){
        if (str.equals("")) return false;
        Stack<String> s = new Stack<>();
        for (int i = 0; i<str.length(); i++){
            if (s.isEmpty()) {
                s.push(str.substring(i,i+1));
                continue;
            }
            if (s.peek().equals("(")&&str.substring(i,i+1).equals(")")){
                s.pop();
            }
        }
        if (s.isEmpty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        String str = getStr();
        if(isMatch(str)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

