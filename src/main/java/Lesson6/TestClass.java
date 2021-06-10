package Lesson6;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestClass {

    @Test
    public void testMethod1() throws Throwable {
        ArrayList<Integer> arr11 = new ArrayList<>();
        arr11.add(5); arr11.add(3);
        ArrayList<Integer> arr12 = new ArrayList<>();
        arr12.add(1); arr12.add(4); arr12.add(5); arr12.add(3);
        ArrayList<Integer> arr21 = new ArrayList<>();
        arr21.add(45); arr21.add(17); arr21.add(23);
        ArrayList<Integer> arr22 = new ArrayList<>();
        arr22.add(33); arr22.add(21); arr22.add(4); arr22.add(45); arr22.add(17); arr22.add(23);
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(7); arr3.add(5); arr3.add(12);
        Assert.assertEquals(arr11, Main.Method1(arr12));
        Assert.assertEquals(arr21, Main.Method1(arr22));
        Assert.assertThrows(RuntimeException.class, () -> {
            Main.Method1(arr3);
        });
    }

    @Test
    public void testMethod2() throws Throwable {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1); arr1.add(4); arr1.add(4); arr1.add(1);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(4); arr2.add(4); arr2.add(4); arr2.add(4); arr2.add(4); arr2.add(4);
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(1); arr3.add(5); arr3.add(4);
        Assert.assertEquals(true, Main.Method2(arr1));
        Assert.assertEquals(false, Main.Method2(arr2));
        Assert.assertThrows(RuntimeException.class, () -> {
            Main.Method2(arr3);
        });
    }
}
