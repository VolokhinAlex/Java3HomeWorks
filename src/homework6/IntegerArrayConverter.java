package homework6;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerArrayConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new IllegalArgumentException(
                    "The parameter should be a string: " + source);
        }
        try {
            ArrayList<String> numbers = new ArrayList<>(Arrays.asList(((String) source).split(",")));
            Integer[] stringToIntegerArray = new Integer[numbers.size()];
            for (int i = 0; i < numbers.size(); i++) {
                stringToIntegerArray[i] = Integer.valueOf(numbers.get(i));
            }
            return stringToIntegerArray;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Error to convert", e);
        }
    }
}
