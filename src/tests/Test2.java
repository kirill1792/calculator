package tests;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        var initialArray =  new ArrayList<>(List.of(14, 5, 23, 11, 37, 59, 25, 8));
        int prevVal = initialArray.get(0);
        int toIndex = 5;
        initialArray.set(0, initialArray.get(5));
        initialArray.set(toIndex, prevVal);
        System.out.println(initialArray);
    }
}
