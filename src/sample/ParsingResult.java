package sample;

public class ParsingResult {
    public Element expression;
    public int finalIndex;

    public ParsingResult(Element expression, int finalIndex) {
        this.expression = expression;
        this.finalIndex = finalIndex;
    }

}
