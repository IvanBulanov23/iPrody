package Test;

import fraemwork.Annotation.Test;
import fraemwork.assertions.AssertExpection;
import fraemwork.assertions.Assertions;

public class ArrayTest {
    @Test
    public void testIntegerArray() throws AssertExpection {
        Integer[] currentArray = {1, 2, 3, 4, 5, 6, 7};
        Integer[] toContainArray = {2, 3, 4};
        Assertions.contains(currentArray, toContainArray);
    }

    @Test
    public void testStringArray() throws AssertExpection {
        String[] currentArray = {"Mama", "Asa"};
        String[] toContainArray = {"Mama", "Assa"};
        Assertions.contains(currentArray, toContainArray);
    }
}
