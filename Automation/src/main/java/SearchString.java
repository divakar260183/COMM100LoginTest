import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchString {
    public static int getNumberOfOccurrence(String searchTerm, String searchContent ) {
        int count = 0;
        if (searchTerm.length() == 1) {
            char expectedChar = searchTerm.charAt(0);
            char[] charArray = searchContent.toCharArray();
            for (int i = 0; i < searchContent.length(); i++) {
                if (Character.toLowerCase(charArray[i]) == Character.toLowerCase(expectedChar))
                    count++;
            }
        } else if (searchTerm.length()>1) {
            String[] searchTermWords = searchTerm.split(" ");
            if (searchTermWords.length == 1) {
                String[] searchContentWords = searchContent.split(" ");
                for (String searchContentWord : searchContentWords) {
                    if (searchTerm.equalsIgnoreCase(searchContentWord)) {
                        count++;
                    }
                }
            } else {
                Pattern searchTermPattern = Pattern.compile(searchTerm);
                Matcher matcher = searchTermPattern.matcher(searchContent);
                while(matcher.find()) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int occurrences = getNumberOfOccurrence("Hello Cat", "Hello World. Hello Cat. Hello World");
        System.out.println("Occurrences :"+occurrences);
    }
}
