package sample;

public class Calculator {
    public final String expression;
    public Element objectExpression;

    public Calculator(String expression){
        this.expression = expression.replace(" ", "");
    }

    public void evaluate(){
        Parser parser = new Parser(expression);
        objectExpression = parser.mainMethod();
        System.out.println(objectExpression);
    }
}
