package homework6;

import java.util.ArrayList;
import java.util.Arrays;

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
        boolean isNumberOne = false;
        boolean isNumberFour = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 1 && numbers[i] != 4) return false;
            if (numbers[i] == 1) isNumberOne = true;
            if (numbers[i] == 4) isNumberFour = true;
        }
        return isNumberOne && isNumberFour;
    }

}
