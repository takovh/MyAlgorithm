package examination.day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Integer[] a = getInput();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static Integer[] getInput(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        return list.toArray(new Integer[list.size()]);
    }
}
