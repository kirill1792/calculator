package sample;

public class BinaryExpression extends Expression{
    public Element leftOperand;
    public Element rightOperand;

    public BinaryExpression(Element leftOperand, Element rightOperand, Operation operation){
        super(operation);
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    @Override
    public double calculate() {
        double leftElemResult = leftOperand.calculate();
        double rightElemResult = rightOperand.calculate();
        return makeOperation(leftElemResult, rightElemResult);
    }


    private double makeOperation(double lRes, double rRes){
        double result = 0.0;
        switch (operation) {
            case PLUS -> result = lRes + rRes;
            case MINUS -> result = lRes - rRes;
            case MULTIPLY -> result = lRes * rRes;
            case DIVISION -> result = lRes / rRes;
        }
        return result;
    }
}
