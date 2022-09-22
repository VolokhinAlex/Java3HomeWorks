package homework6;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class IntegerArrayConverter implements ArgumentConverter {

    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        if (!(source instanceof String)) {
            throw new IllegalArgumentException(
                    "The argument should be a string: " + source);
        }
        try {
            int[] numbers = Arrays.stream(((String) source).split(",")).mapToInt(Integer::parseInt).toArray();
            Integer[] result = new Integer[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                result[i] = numbers[i];
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Failed to convert", e);
        }
    }
}
