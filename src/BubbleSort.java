import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 3, 7, 9, 4, 1})));
    }

    public static int [] bubbleSort(int [] arr){
        int tmp;
        for (int i = arr.length-1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }
}
