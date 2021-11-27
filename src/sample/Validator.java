package sample;

import java.util.HashMap;
import java.util.Map;

public class Validator {
    private final String expression;
    private static final String validSymbols = "0123456789+-*÷√^().";
    private static final Map<String, String> nextAcceptableNum = new HashMap<>();
    static {
        nextAcceptableNum.put("0", "0123456789+-*÷^).");
        nextAcceptableNum.put("1", "0123456789+-*÷^).");
        nextAcceptableNum.put("2", "0123456789+-*÷^).");
        nextAcceptableNum.put("3", "0123456789+-*÷^).");
        nextAcceptableNum.put("4", "0123456789+-*÷^).");
        nextAcceptableNum.put("5", "0123456789+-*÷^).");
        nextAcceptableNum.put("6", "0123456789+-*÷^).");
        nextAcceptableNum.put("7", "0123456789+-*÷^).");
        nextAcceptableNum.put("8", "0123456789+-*÷^).");
        nextAcceptableNum.put("9", "0123456789+-*÷^).");
        nextAcceptableNum.put("+", "0123456789(√");
        nextAcceptableNum.put("-", "0123456789(√");
        nextAcceptableNum.put("÷", "0123456789(√");
        nextAcceptableNum.put("*", "0123456789(√");
        nextAcceptableNum.put("√", "0123456789-(");
        nextAcceptableNum.put("^", "0123456789-(");
        nextAcceptableNum.put(".", "0123456789");
        nextAcceptableNum.put("(", "0123456789-(");
        nextAcceptableNum.put(")", "+-*÷^)");


    }

    public Validator(String expression) {
        this.expression = expression.replace(" ", "");
    }

    public boolean validate() {
    boolean[] results = {checkSymbols(), checkNextElement(), checkBrackets(), checkFirstElement()};

        for (boolean result : results) {
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSymbols() {
        for (int i = 0; i < expression.length(); i++) {
            if (!validSymbols.contains(Character.toString(expression.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    private boolean checkNextElement() {
        char prevElement = 0;
        for (int i = 0; i < expression.length(); i++) {
            char currentElement = expression.charAt(i);
            if (nextAcceptableNum.containsKey(Character.toString(prevElement))) {
                if(!nextAcceptableNum.get(Character.toString(prevElement)).contains(Character.toString(currentElement))) {
                    return false;
                }
            }
            prevElement = currentElement;
        }
        return true;
    }

    private boolean checkBrackets() {
        int bracketsCount = 0;
        for (int i = 0; i < expression.length(); i++) {
            String currentElement = Character.toString(expression.charAt(i));
            if(currentElement.equals("(")) {
                bracketsCount += 1;
            }
            else if (currentElement.equals(")")) {
                bracketsCount -= 1;
            }
            if (bracketsCount < 0) {
                return false;
            }
        }
        return bracketsCount == 0;
    }

    private boolean checkFirstElement(){
        return !"^*÷.".contains(Character.toString(expression.charAt(0)));
    }
}
