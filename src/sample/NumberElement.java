package sample;

public class NumberElement implements Element{
    public String value;

    public NumberElement(String value) {
        this.value = value;
    }

    @Override
    public Number calculate() {
        return Integer.parseInt(value);
    }
}
