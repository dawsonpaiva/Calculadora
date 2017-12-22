package trabalho.calculadora;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 *
 * @author Dawson Paiva Lima
 */
public class FXMLControllerCalculadora implements Initializable {

    @FXML
    private Text displayCalc;

    private LinkedList<String> calcPilha = new LinkedList<>();

    private OperacaoAritmetica opAritmetica = new OperacaoAritmetica();

    @FXML
    private void onActionNum(ActionEvent event) {
        if(this.displayCalc.getText().contains("Erro"))
            this.displayCalc.setText("");
        Button btnNum = (Button) event.getSource();
        String textDisplay = this.displayCalc.getText();
        textDisplay += btnNum.getText();
        this.displayCalc.setText(textDisplay);
    }

    @FXML
    private void onActionSoma(ActionEvent event) {
        if (!this.displayCalc.getText().equals("")) {
            this.calcPilha.push(this.displayCalc.getText());
            if (this.calcPilha.size() == 3) {
                this.realizarOperacao();
            }
            this.calcPilha.push("+");
            this.displayCalc.setText("");
        }
    }

    @FXML
    private void onActionSubtracao(ActionEvent event) {
        if (!this.displayCalc.getText().equals("")) {
            this.calcPilha.push(this.displayCalc.getText());
            if (this.calcPilha.size() == 3) {
                this.realizarOperacao();
            }
            this.calcPilha.push("-");
            this.displayCalc.setText("");
        }
    }

    @FXML
    private void onActionMultiplicacao(ActionEvent event) {
        if (!this.displayCalc.getText().equals("")) {
            this.calcPilha.push(this.displayCalc.getText());
            if (this.calcPilha.size() == 3) {
                this.realizarOperacao();
            }
            this.calcPilha.push("*");
            this.displayCalc.setText("");
        }
    }

    @FXML
    private void onActionDivisao(ActionEvent event) {
        if (!this.displayCalc.getText().equals("")) {
            this.calcPilha.push(this.displayCalc.getText());
            if (this.calcPilha.size() == 3) {
                this.realizarOperacao();
            }
            this.calcPilha.push("/");
            this.displayCalc.setText("");
        }
    }

    @FXML
    private void onActionBtnCalcular(ActionEvent event) {
        this.calcPilha.push(this.displayCalc.getText());
        if (this.calcPilha.size() == 3) {
            this.realizarOperacao();
            String result = this.calcPilha.pop();
            this.displayCalc.setText(result);
        }
    }

    @FXML
    private void onActionLimpar(ActionEvent event) {
        this.calcPilha = new LinkedList<>();
        this.displayCalc.setText("");
    }

    private void realizarOperacao() {
        Double num2 = Double.parseDouble(this.calcPilha.pop());
        String op = this.calcPilha.pop();
        Double num1 = Double.parseDouble(this.calcPilha.pop());
        Double result = 0.0;
        boolean error = false;
        try {
            switch (op) {
                case "+":
                    result = this.opAritmetica.soma(num1, num2);
                    break;
                case "-":
                    result = this.opAritmetica.subtracao(num1, num2);
                    break;
                case "*":
                    result = this.opAritmetica.multiplicacao(num1, num2);
                    break;
                case "/":
                    result = this.opAritmetica.divisao(num1, num2);
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.displayCalc.setText(e.getMessage());
            this.calcPilha = new LinkedList<>();
            error = true;
        }
        if(!error)
            this.calcPilha.push(result.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
