import org.jetbrains.annotations.NotNull;

import java.util.*;

public class FindDuplicates {

    private static Set<Integer> findIntegerDuplicates(List<Integer> integerListContainingDuplicates)
    {
        final Set<Integer> duplicateInteger = new HashSet<>();
        final Set<Integer> uniqueIntegers = new HashSet<>();

        for (Integer integer : integerListContainingDuplicates)
        {
            if (!uniqueIntegers.add(integer))
            {
                duplicateInteger.add(integer);
            }
        }
        for (Integer integer : duplicateInteger) {
            uniqueIntegers.remove(integer);
        }

        System.out.println("Unique Integers :");
        uniqueIntegers.iterator().forEachRemaining(System.out::println);

        return duplicateInteger;
    }

    private static Set<String> findStringDuplicates(List<String> stringListContainingDuplicates)
    {
        final Set<String> duplicateString = new HashSet<>();
        final Set<String> uniqueString = new HashSet<>();

        for (String string : stringListContainingDuplicates) {
            if(!uniqueString.add(string))
            {
                duplicateString.add(string);
            }
        }

        for(String string : duplicateString) {
            uniqueString.remove(string);
        }

        System.out.println("Unique Strings :");
        uniqueString.iterator().forEachRemaining(System.out::println);

        return duplicateString;
    }

    private static <T> Set<T> findDuplicates(@NotNull Collection<T> collection) {

        Set<T> duplicates = new LinkedHashSet<>();
        Set<T> uniques = new HashSet<>();

        for(T t : collection) {
            if(!uniques.add(t)) {
                duplicates.add(t);
            }
        }
        for(T t : duplicates)
        {
            uniques.remove(t);
        }
        uniques.iterator().forEachRemaining(System.out::println);
        return duplicates;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<Integer>(){{
            add(23);
            add(34);
            add(23);
            add(45);
            add(56);
            add(78);
            add(78);
        }
        };
        Collections.sort(integerList);
        System.out.println("Sorted Integer List:");
        integerList.iterator().forEachRemaining(System.out::println);
        Set<Integer> integerDuplicates = findIntegerDuplicates(integerList);

        System.out.println("Duplicate Integers :");
        integerDuplicates.iterator().forEachRemaining(System.out::println);

        integerDuplicates = findDuplicates(integerList);
        System.out.println("Duplicate Integers From Generic Method:");
        integerDuplicates.iterator().forEachRemaining(System.out::println);

        List<String> stringList = new ArrayList<String>() {{
            add("Divakar");
            add("Vikash");
            add("Divakar");
            add("Shikha");
            add("Shikha");
            add("Aarya");
            add("Ayantika");
            add("Aneek");
        }};
        Collections.sort(stringList);
        System.out.println("Sorted String List:");
        stringList.iterator().forEachRemaining(System.out::println);
        Set<String> stringDuplicates = findStringDuplicates(stringList);
        System.out.println("Duplicate String :");
        stringDuplicates.iterator().forEachRemaining(System.out::println);

        stringDuplicates = findDuplicates(stringList);
        System.out.println("Duplicate String From Generic Method :");
        stringDuplicates.iterator().forEachRemaining(System.out::println);

    }

}
