package homework6;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

public class MainTest {
    private Main mainClass;

    @BeforeEach
    public void init() {
        mainClass = new Main();
    }

    @CsvSource(value = {
            "1,2,4,4,2,3,4,1,7;1,7",
            "20,1,4,51,5,25,4,12,15,2,1,56;12,15,2,1,56",
            "4,1,2,3;1,2,3",
            "1,2,3,5,3,4,1; 1"
    }, delimiterString = ";")
    @ParameterizedTest
    public void createNewArrayBasedOldTest(@ConvertWith(IntegerArrayConverter.class) Integer[] oldArray,
                                       @ConvertWith(IntegerArrayConverter.class) Integer[] newArray) {
        Assertions.assertArrayEquals(newArray, mainClass.createNewArrayBasedOld(oldArray));
    }

    @CsvSource(value = {
            "1,1,1,4,4,1,4,4;true",
            "1,1,1,1,1,1; false",
            "4,4,4,4; false",
            "1,4,4,1,1,4,3; false"
    }, delimiterString = ";")
    @ParameterizedTest
    public void isArrayConsistsCertainNumbersTest(@ConvertWith(IntegerArrayConverter.class) Integer[] numbers,
                                             boolean isBoolean) {
        Assertions.assertEquals(isBoolean, mainClass.isArrayConsistsCertainNumbers(numbers));
    }



}
