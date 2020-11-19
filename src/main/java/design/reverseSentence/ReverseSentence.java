package design.reverseSentence;

import java.util.Scanner;

public class ReverseSentence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sentence = in.nextLine();
        in.close();
        String[] arr = sentence.split(" ");
        String out = "";
        for (int i = arr.length-1; i >= 0; i--){
            out += arr[i];
            if (i != 0) out += " ";
        }
        System.out.println(out);
    }
}
