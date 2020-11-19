package sort;

public class BubbleSort {
    /**
     * 对数组进行冒泡排序，下标大的元素值大
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr){
        int len = arr.length;
        if (len < 2) return arr;
        for (int i = 0; i < len-1; i++){
            for (int j = 0; j < len-1; j++){
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                if (j == len-1-i) break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,1,3,5};
        sort(arr);
        for (int i = 0; i<arr.length; i++) System.out.print(arr[i] + "\t");
    }
}
