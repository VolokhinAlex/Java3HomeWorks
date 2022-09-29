package homework7;

import homework7.annotations.AfterSuite;
import homework7.annotations.BeforeSuite;
import homework7.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class StartTests {

    public static void start(Class<?> classForTest) {
        isMoreOneWithBeforeSuiteOrAfterSuite(classForTest);
        ArrayList<Method> listMethodsWithAnnotationTest = new ArrayList<>();
        Method[] methods = classForTest.getMethods();
        Method beforeSuiteAnnotation = null, afterSuiteAnnotation = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteAnnotation = method;
            } else if (method.isAnnotationPresent(Test.class)) {
                listMethodsWithAnnotationTest.add(method);
                checkMaxAndMinPriorities(listMethodsWithAnnotationTest, 1, 10);
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteAnnotation = method;
            }
        }

        try {
            if (beforeSuiteAnnotation != null) {
                beforeSuiteAnnotation.invoke(classForTest.getDeclaredMethod(beforeSuiteAnnotation.getName()));
            }
            testsWithPriorities(listMethodsWithAnnotationTest);
            if (afterSuiteAnnotation != null) {
                afterSuiteAnnotation.invoke(classForTest.getDeclaredMethod(afterSuiteAnnotation.getName()));
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void isMoreOneWithBeforeSuiteOrAfterSuite(Class<?> classForTest) {
        int countBeforeAnnotation = 0;
        int countAfterAnnotation = 0;
        Method[] methods = classForTest.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                countBeforeAnnotation++;
            } else if (method.isAnnotationPresent(AfterSuite.class)) {
                countAfterAnnotation++;
            }
        }
        if (countBeforeAnnotation > 1) throw new RuntimeException("The BeforeSuite annotation must be in a single copy");
        if (countAfterAnnotation > 1) throw new RuntimeException("The AfterSuite annotation must be in a single copy");
    }

    public static void testsWithPriorities(ArrayList<Method> methods) {
        methods.sort(Comparator.comparingInt(sort -> sort.getAnnotation(Test.class).priority()));
        for (int i = methods.size() - 1; i >= 0; i--) {
            try {
                methods.get(i).invoke(methods.get(i).getName());
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void checkMaxAndMinPriorities(ArrayList<Method> methods, int minPriority, int maxPriority) {
        for (Method method : methods) {
            Test annotation = method.getAnnotation(Test.class);
            if (annotation.priority() < minPriority || annotation.priority() > maxPriority) {
                throw new RuntimeException("Exceeding the limits of acceptable priority values");
            }
        }
    }

}
