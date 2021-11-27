package sample;

public abstract class Expression implements Element{
    public Operation operation;

    public Expression(Operation operation) {
        this.operation = operation;
    }
}
