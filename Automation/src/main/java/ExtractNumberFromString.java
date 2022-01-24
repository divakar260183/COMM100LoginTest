import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExtractNumberFromString {
    public static int getNumberFromString(String searchTerm) {
        double number = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < searchTerm.length(); i++) {
            if (Character.isDigit(searchTerm.charAt(i))) {
                int num = Integer.parseInt(String.valueOf(searchTerm.charAt(i)));
                list.add(num);
            }
        }
        for (int i=0; i<list.size();i++) {
            number = number + list.get(i) * Math.pow(10, list.size()-i-1);
        }
        return (int) number;
    }

    public static void main(String[] args) {
        System.out.println("Enter the String :");
        Scanner in = new Scanner(System.in);
        String searchTerm = in.nextLine();
        System.out.println("Search Term entered is :"+ searchTerm);
        int value = Integer.parseInt(searchTerm.replaceAll("[^0-9]", ""));
        System.out.println("The number extracted from entered string using step is :"+ value);
        int number = getNumberFromString(searchTerm);
        System.out.println("The number extracted from entered string using method is :"+ number);
    }
}
