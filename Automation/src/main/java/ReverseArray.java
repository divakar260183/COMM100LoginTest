import java.util.Arrays;
import java.util.Collections;

public class ReverseArray {

    public static void main(String[] args) {
        Integer[] arr1 ={10,12,15,9,7,20};
        ReverseArray reverseArray = new ReverseArray();
        reverseArray.reverse_using_swapping(arr1);
        Integer[] arr2 ={10,12,15,9,7,20};
        reverseArray.reverse_using_collections(arr2);
        String [] string_arr = {"one", "Two", "Three", "Four", "Five", "Six","Seven"};
        reverseArray.reverse_using_collections(string_arr);
        String str = "Hello";
        str = "Ram";
        System.out.println("str :"+str);
    }

    public void reverse_using_swapping(Integer[] int_arr) {
        int size = int_arr.length;
        for (int i=0;i<size/2;i++) {
            int temp = int_arr[i];
            int_arr[i] = int_arr[size-i-1];
            int_arr[size-i-1] = temp;
        }
        System.out.println("Reversed Array using swapping:");
        for (Integer integer : int_arr) System.out.println(integer);
    }

    public void reverse_using_collections(Integer[] int_arr) {
        Collections.reverse(Arrays.asList(int_arr));
        System.out.println("Reversed Integer Array using collections:"+ Arrays.asList(int_arr));
    }

    public void reverse_using_collections(String[] str_arr) {
        Collections.reverse(Arrays.asList(str_arr));
        System.out.println("Reversed String Array using collections:"+ Arrays.asList(str_arr));
    }
}
