import java.util.Arrays;

public class Testing {


    public static void main(String[] args){
        int[] arr = {1,5,7,10,2};
        Arrays.sort(arr);
        int n = arr.length;

        if (arr[n-1] * arr[n-2] * arr[n-3] > arr[0] * arr[1] * arr[n-1]) {
            System.out.println( arr[n-1] +","+ arr[n-2]+ ","+arr[n-3]);
        }
        else {
            System.out.println( arr[0]+","+  arr[1]+","+  arr[n-1]);
        }
    }
}
