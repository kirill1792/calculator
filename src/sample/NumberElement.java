package sample;

public class NumberElement implements Element{
    public String value;

    public NumberElement(String value) {
        this.value = value;
    }

    @Override
    public double calculate() {
        return Double.parseDouble(value);
    }
}
