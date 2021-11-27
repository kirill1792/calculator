package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        var initialArray =  new ArrayList<Integer>(List.of(1, 14, 5, 23, 11, 37, 59, 25, 8, 1000));
        System.out.println(sortArray(initialArray));
    }

    private static List<Integer> sortArray(List<Integer> array) {
        if (array.size() == 0) {
            return new ArrayList<>();
        }
        else {
            int buffer = 0;
            for (int i = 0; i < array.size() - 1; i++) {
                int min = array.get(buffer);
                for (int j = buffer; j < array.size(); j++) {
                    if(array.get(j) < min){
                        min = array.get(j);
                    }
                }
                int minIndex = array.indexOf(min);
                int startVal = array.get(buffer);
                array.set(buffer, min);
                array.set(minIndex, startVal);
                buffer += 1;
            }
            return array;
        }
    }

    private static int getMinNum(List<Integer> array) {
        int min = array.get(0);
        for (Integer integer : array) {
            if (integer < min) {
                min = integer;
            }
        }
        return min;
    }
}
