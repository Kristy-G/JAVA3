package Lesson6;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static Throwable RuntimeException = new RuntimeException();

    public static void main(String[] args) throws Throwable {

    }

    public static ArrayList<Integer> Method1(ArrayList<Integer> arr) throws Throwable{
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (!arr.contains(4)) {
            throw RuntimeException;
        }
        else {
            int index = arr.lastIndexOf(4);
            for (int i = index+1; i < arr.size(); i++) {
                arrayList.add(arr.get(i));
            }
            return arrayList;
        }
    }

    public static boolean Method2(ArrayList<Integer> arr) throws Throwable {
        for (Integer i:
             arr) {
            if(i !=1 && i!=4) {
                throw RuntimeException;
            }
        }
        return arr.contains(1) && arr.contains(4);
    }
}


