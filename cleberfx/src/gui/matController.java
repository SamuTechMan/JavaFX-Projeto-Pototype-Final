package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Alerts;
import util.Constraints;

public class matController {

	@FXML
	private TextField num1;
	@FXML
	private TextField num2;
	@FXML
	private Button limpar;
	@FXML
	private Label resultado;

	// Implementando o evento

	public void limpar() {
		num1.setText("");
		num2.setText("");
		resultado.setText("");
	}

	@FXML
	public void adicao() {
		try {

			Locale.setDefault(Locale.US);
			double numero1 = Double.parseDouble(num1.getText());
			double numero2 = Double.parseDouble(num2.getText());
			double soma = numero1 + numero2;
			resultado.setText(String.format("%.2f", soma));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Um numero Invalido foi informado!!", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void subtracao() {
		try {

			Locale.setDefault(Locale.US);
			double numero1 = Double.parseDouble(num1.getText());
			double numero2 = Double.parseDouble(num2.getText());
			double sub = numero1 - numero2;
			resultado.setText(String.format("%.2f", sub));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Um numero Invalido foi informado!!", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void multiplicacao() {
		try {

			Locale.setDefault(Locale.US);
			double numero1 = Double.parseDouble(num1.getText());
			double numero2 = Double.parseDouble(num2.getText());
			double multi = numero1 * numero2;
			resultado.setText(String.format("%.2f", multi));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Um numero Invalido foi informado!!", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void divisao() {
		try {

			Locale.setDefault(Locale.US);
			double numero1 = Double.parseDouble(num1.getText());
			double numero2 = Double.parseDouble(num2.getText());
			double divi = numero1 / numero2;
			resultado.setText(String.format("%.2f", divi));
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Somente Numeros!!", e.getMessage(), AlertType.ERROR);
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(num1);
		Constraints.setTextFieldDouble(num2);
		Constraints.setTextFieldMaxLength(num1, 12);
		Constraints.setTextFieldMaxLength(num2, 12);
	}

}
