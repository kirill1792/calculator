package sample;

public class Parser {
    private final String myExpression;
    private static final String ints = "0123456789";
    private static final String operations = "+-*÷√^";

    public Parser(String myExpression) {
        this.myExpression = myExpression;
    }

    public Element mainMethod(){
        return parse(0).expression;
    }

    public ParsingResult parse(int startIndex){
        Element currentLeftElement;
        if (Character.toString(myExpression.charAt(startIndex)).equals("(")){
            ParsingResult res = parse(startIndex + 1);
            currentLeftElement = res.expression;
            startIndex = res.finalIndex + 1;
        }
        else {
            currentLeftElement = new NumberElement(checkForNumber(startIndex));
        }

        int i = startIndex;
        while (i < myExpression.length()){
            int currentIndex = i;
            if (Character.toString(myExpression.charAt(i)).equals(")")) {
                return new ParsingResult(currentLeftElement, i);
            }
            Element currentRightElement;
            if (operations.contains(Character.toString(myExpression.charAt(i))) & i > 0) {
                if(Character.toString(myExpression.charAt(i + 1)).equals("(")){
                    ParsingResult res = parse(i + 2);
                     currentRightElement = res.expression;
                     i = res.finalIndex;
                }
                else {
                    currentRightElement = new NumberElement(checkForNumber(i + 1));
                }
                if ("+-".contains(Character.toString(myExpression.charAt(i)))) {
                    int result = checkNextOperation(i + 1);
                    if (result < 0){
                        currentLeftElement = new BinaryExpression(currentLeftElement, currentRightElement,
                                Operation.byCode(Character.toString(myExpression.charAt(currentIndex))));
                    }
                    else {
                        boolean usedBrackets = false;
                        int oldI = i;
                         Element leftElement = currentRightElement;
                         Element rightElement;
                         if(Character.toString(myExpression.charAt(result + 1)).equals("(")) {
                             ParsingResult res = parse(result + 2);
                             rightElement = res.expression;
                             i = res.finalIndex;
                             usedBrackets = true;
                         }
                         else {
                             rightElement = new NumberElement(checkForNumber(result + 1));
                         }
                         currentRightElement = new BinaryExpression(leftElement, rightElement, Operation.byCode(
                                 Character.toString(myExpression.charAt(result))));
                         currentLeftElement = new BinaryExpression(currentLeftElement, currentRightElement,
                                 Operation.byCode(Character.toString(myExpression.charAt(oldI))));
                         if (!usedBrackets) {
                             i = result;
                         }
                    }
                }
                else {
                    currentLeftElement = new BinaryExpression(currentLeftElement, currentRightElement,
                            Operation.byCode(Character.toString(myExpression.charAt(currentIndex))));
                }
            }
            i++;
        }
        return new ParsingResult(currentLeftElement, i);
    }

    private String checkForNumber(int startIndex){
        StringBuilder num = new StringBuilder();
        for (int i = startIndex; i < myExpression.length(); i++) {
             if (Character.isDigit(myExpression.charAt(i)) | i == startIndex & "+-".contains(Character.toString(myExpression.charAt(i)))) {
                num.append(myExpression.charAt(i));
             }
             else {
                 break;
             }
        }
        return num.toString();
    }

    //private ParsingResult parseBrackets(int index){
        //ParsingResult
    //}

    private int checkNextOperation(int startIndex) {
        for (int i = startIndex; i < myExpression.length(); i++) {
            if ("+-*÷".contains(Character.toString(myExpression.charAt(i)))) {
                if("*÷".contains(Character.toString(myExpression.charAt(i)))){
                    return i;
                }
                else {
                    return -1;
                }
            }
        }

        return -1;
    }

    //private void createBinEx(Operation operation){

    //}

    //private BinaryExpression searchForExpressions(){

    //for (int i = 0; i < myExpression.length(); i++) {
    //if (operations.contains(Character.toString(myExpression.charAt(i)))) {

    //}
    //}

}
