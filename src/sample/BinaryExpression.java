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
    public Number calculate() {
        return null;
    }
}
