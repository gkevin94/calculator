package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Label screen;
    public Button nine;
    public Button eight;
    public Button seven;
    public Button six;
    public Button five;
    public Button four;
    public Button three;
    public Button two;
    public Button one;
    public Button devide;
    public Button multiply;
    public Button subtract;
    public Button add;
    public Button zero;
    public Button dec;
    public Button equal;
    private BigDecimal currentvalue;
    private Operand operand;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void number(ActionEvent actionEvent) {
        String valueOfScreen = screen.getText();
        screen.textProperty().set(valueOfScreen + ((Button) actionEvent.getSource()).getText());
    }

    public void operand(ActionEvent actionEvent) {
        currentvalue = new BigDecimal(screen.getText());
        screen.setText("");
        for (Operand o: Operand.values()){
            if (o.getOperandValue().equals(((Button) actionEvent.getSource()).getText())){
                operand = o;
                break;
            }
        }
    }

    public void equal(ActionEvent actionEvent) {
        BigDecimal value = new BigDecimal(screen.getText());
        BigDecimal sum = new BigDecimal(0);
        if (operand != null){
            switch (operand){
                case ADD:
                    sum = currentvalue.add(value);
                    break;
                case SUBTRACT:
                    sum = currentvalue.subtract(value);
                    break;
                case DIVIDE:
                    sum = currentvalue.divide(value, 5, RoundingMode.HALF_UP);
                    break;
                case MULTIPLY:
                    sum = currentvalue.multiply(value);
                    break;
            }
        }
        if (sum.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0){
            screen.setText(sum.toBigInteger().toString());
        } else {
            screen.setText(sum.toString());
        }
    }

    public void clear(ActionEvent actionEvent) {
        currentvalue = new BigDecimal(0);
        operand = null;
        screen.setText("");
    }
}
