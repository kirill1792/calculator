package sample;

public class Calculator {
    public final String expression;
    public Element objectExpression;

    public Calculator(String expression){
        this.expression = expression.replace(" ", "");
    }

    public double evaluate(){
        Parser parser = new Parser(expression);
        objectExpression = parser.mainMethod();
        return objectExpression.calculate();
    }
}
