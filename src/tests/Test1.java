package tests;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        var initialArray =  new ArrayList<>(List.of(14, 5, 23, 11, 37, 59, 25, 8));
        initialArray.add(0, 50);
        System.out.println(initialArray);
    }
}
