public class FirstSecondLargest {
    public static void main(String[] args) {
        int[] arr = {12,34,13,24,56,6};
        int first_largest=0;
        int second_largest=0;
        for (int j : arr) {
            if (j > first_largest) {
                second_largest = first_largest;
                first_largest = j;
            }
        }
        System.out.println("First Largest:" + first_largest);
        System.out.println("Second Largest:" + second_largest);
    }
}
