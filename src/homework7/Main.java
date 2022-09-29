package homework7;

import homework7.annotations.AfterSuite;
import homework7.annotations.BeforeSuite;
import homework7.annotations.Test;

public class Main {

    public static void main(String[] args) {
        StartTests.start(Main.class);
    }

    @BeforeSuite
    public static void methodTest0() {
        System.out.println("BeforeSuite Annotation");
    }

    @AfterSuite
    public static void methodTest1() {
        System.out.println("AfterSuite Annotation");
    }

    @Test
    public static void methodTest2() {
        System.out.println("Method with priority 1");
    }

    @Test(priority = 2)
    public static void methodTest3() {
        System.out.println("Method with priority 2");
    }

    @Test(priority = 3)
    public static void methodTest4() {
        System.out.println("Method with priority 3");
    }

    @Test(priority = 5)
    public static void methodTest5() {
        System.out.println("Method with priority 5");
    }

    @Test(priority = 7)
    public static void methodTest6() {
        System.out.println("Method with priority 7");
    }

    @Test(priority = 8)
    public static void methodTest7() {
        System.out.println("Method with priority 7");
    }

}
