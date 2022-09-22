package homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Integer[] newArray = createNewArrayBasedOld(arr);
        System.out.println(isArrayConsistsCertainNumbers(new Integer[]{4, 4, 4, 4}));
    }

    public static Integer[] createNewArrayBasedOld(Integer[] array) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(array));
        int getLastIndex = numbers.lastIndexOf(4);
        Object[] numbersArray = numbers.subList(getLastIndex + 1, numbers.size()).toArray();
        return Arrays.copyOf(numbersArray, numbersArray.length, Integer[].class);
    }

    public static boolean isArrayConsistsCertainNumbers(Integer[] numbers) {
        ArrayList<Integer> certainNumbersArray = new ArrayList<>(Arrays.asList(numbers));
        if (!certainNumbersArray.removeAll(Collections.singleton(4)) || certainNumbersArray.size() == 0) return false;
        return certainNumbersArray.removeAll(Collections.singleton(1)) && certainNumbersArray.size() == 0;
    }

}
