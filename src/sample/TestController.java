package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class TestController {
    @FXML
    private GridPane buttons_grid;
    @FXML
    private TextField calcTextField;

    @FXML
    private void clickElementBtn(ActionEvent event) {
        System.out.println("Нажали на кнопку элемента");
        Button source = (Button) event.getSource();
        String buttonText = source.getText();
        System.out.println("Значение кнопки: " + buttonText);

        calcTextField.appendText(buttonText);
    }

    @FXML
    private void clickFunctionalBtn(ActionEvent event) {
        System.out.println("Нажали на функциональную кнопку");
        Button source = (Button) event.getSource();

        switch (source.getText()) {
            case "DEL" -> {
                System.out.println("Удаление последнего элемента");
                if (calcTextField.getLength() != 0) {
                    calcTextField.deleteText(calcTextField.getLength() - 1, calcTextField.getLength());
                }
            }
            case "C" -> {
                System.out.println("Очищистка поля ввода");
                calcTextField.clear();
            }
            case "=" -> {
                System.out.println("Вычисление значения выражения");
                Validator validator = new Validator(calcTextField.getText());
                if (validator.validate()) {
                    System.out.println("Выражение введено корректно");
                    Calculator calculator = new Calculator(calcTextField.getText());
                    calculator.evaluate();
                }
                else {
                    System.out.println("Выражение введено некорректно");
                }
            }
        }
    }
}
