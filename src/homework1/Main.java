package homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[] words = {"apple", "orange", "Today", "Monday", "car", "bicycle"};
        System.out.println("Массив до изменений: " + Arrays.toString(words));
        changePositionOfElements(5, 0, words);
        System.out.println("Массив после изменений: " + Arrays.toString(words));
        System.out.println("Массив words преобразован в ArrayList, со значениями:\n" + convertArrayToArrayList(words));

        FruitBox<Apple> apples = new FruitBox<>();
        apples.add(new Apple());
        apples.add(new Apple());

        FruitBox<Orange> oranges = new FruitBox<>();
        oranges.add(new Orange());

        FruitBox<Apple> apple = new FruitBox<>();
        apple.add(new Apple());
        apple.add(new Apple());

        System.out.println("Равны ли коробки? - " + apples.compare(apple));
        System.out.println("Равны ли коробки? - " + apples.compare(oranges));

        apples.putInAnotherBox(apple);
    }

    private static <T> void changePositionOfElements(int firstElement, int secondElement, T... array) {
        if (array.length < firstElement || array.length < secondElement) return;
        T firstElArray = array[firstElement];
        array[firstElement] = array[secondElement];
        array[secondElement] = firstElArray;
    }

    private static <T> ArrayList<T> convertArrayToArrayList(T... array) {
        return new ArrayList<>(Arrays.asList(array));
    }


}
