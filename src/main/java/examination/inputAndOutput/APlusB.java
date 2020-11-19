package examination.inputAndOutput;

import java.util.*;

/**
 * ACM竞赛之输入输出
 * 在ACM程序设计竞赛中，一道题目的所有测试数据是放在一个文本文件中，选手将一道题目的程序提交给评判系统运行，
 * 程序从该文件中读取测试数据，再把运行结果输出到另一个文本文件中。系统把输出文件与标准答案比对，来评判程序编写得正确与否。
 * ACM现场赛采用的输入输出形式有
 * （1）文件输入、标准输出；
 * （2）文件输入、文件输出；
 * （3）标准的输入输出。
 * 而Web形式的ACM程序设计在线评判系统一般采用标准的输入输出，但输入结束有文件末尾标识（EOF)，这可以用于确定输入结束。
 *
 * scanner.hasNext()
 * Returns true if this scanner has another token in its input.
 * This method may block while waiting for input to scan. The scanner does not advance past any input.
 *
 * scanner.nextLine()
 */
public class APlusB {

    /**
     * 输入描述:
     * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据包括多组。
     *
     * 输出描述:
     * 输出a+b的结果
     *
     * 输入
     * 1 5
     * 10 20
     *
     * 输出
     * 6
     * 30
     *
     * parseInt()返回的是基本类型int
     * 而valueOf()返回的是包装类Integer
     */
    public void test1(){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            String nums[] = s.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            System.out.println(a+b);
        }
    }

    /**
     * 输入描述:
     * 输入第一行包括一个数据组数t(1 <= t <= 100)
     * 接下来每行包括两个正整数a,b(1 <= a, b <= 10^9)
     *
     * 输出描述:
     * 输出a+b的结果
     *
     * 输入
     * 2
     * 1 5
     * 10 20
     *
     * 输出
     * 6
     * 30
     */
    public void test2(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] a = new int[n];
        int[] b = new int[n];
        int[] result = new int[n];
        for(int i=0;i<n;i++){
            String s = scanner.nextLine();
            a[i] = Integer.parseInt(s.split(" ")[0]);
            b[i] = Integer.parseInt(s.split(" ")[1]);
            result[i] = a[i] + b[i];
        }
        for(int i : result){
            System.out.println(i);
        }
    }

    /**
     * 输入描述:
     * 输入包括两个正整数a,b(1 <= a, b <= 10^9),输入数据有多组, 如果输入为0 0则结束输入
     *
     * 输出描述:
     * 输出a+b的结果
     *
     * 输入
     * 1 5
     * 10 20
     * 0 0
     *
     * 输出
     * 6
     * 30
     */
    public void test3(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String s = scanner.nextLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            if(a==0 && b==0){
                break;
            }else{
                System.out.println(a+b);
            }
        }
    }

    /**
     * 输入描述:
     * 输入数据包括多组。
     * 每组数据一行,每行的第一个整数为整数的个数n(1 <= n <= 100), n为0的时候结束输入。
     * 接下来n个正整数,即需要求和的每个正整数。
     *
     * 输出描述:
     * 每组数据输出求和的结果
     *
     * 输入
     * 4 1 2 3 4
     * 5 1 2 3 4 5
     * 0
     *
     * 输出
     * 10
     * 15
     */
    public void test4(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();
            int sum = 0;
            if(n==0){
                break;
            }else{
                while(n>0){
                    sum += scanner.nextInt();
                    n--;
                }
                System.out.println(sum);
            }
        }
    }

    /**
     * 输入描述:
     * 输入的第一行包括一个正整数t(1 <= t <= 100), 表示数据组数。
     * 接下来t行, 每行一组数据。
     * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
     * 接下来n个正整数, 即需要求和的每个正整数。
     *
     * 输出描述:
     * 每组数据输出求和的结果
     *
     * 输入
     * 2
     * 4 1 2 3 4
     * 5 1 2 3 4 5
     *
     * 输出
     * 10
     * 15
     */
    public void test5(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (; n>0; n--){
            String[] s = scanner.nextLine().split(" ");
            int m = Integer.parseInt(s[0]);
            int result = 0;
            for (; m>0; m--){
                result += Integer.parseInt(s[m]);
            }
            System.out.println(result);
        }
    }

    /**
     * 输入描述:
     * 输入数据有多组, 每行表示一组输入数据。
     * 每行的第一个整数为整数的个数n(1 <= n <= 100)。
     * 接下来n个正整数, 即需要求和的每个正整数。
     *
     * 输出描述:
     * 每组数据输出求和的结果
     *
     * 输入
     * 4 1 2 3 4
     * 5 1 2 3 4 5
     *
     * 输出
     * 10
     * 15
     */
    public void test6(){
        Scanner scanner = new Scanner(System.in);

    }

    /**
     * 返回数组
     * @return
     */
    public Integer[] test7(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        return list.toArray(new Integer[list.size()]);
    }

    public static void main(String[] args) {
        APlusB main = new APlusB();
        main.test4();
    }

}
