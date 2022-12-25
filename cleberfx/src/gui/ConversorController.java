package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import util.Alerts;
import util.Constraints;

public class ConversorController {

	@FXML
	private TextField numTempF;
	@FXML
	private TextField numTempC;
	@FXML
	private Button Celsius;
	@FXML
	private Button Fahrenheit;
	@FXML
	private Label resultadoF;
	@FXML
	private Label resultadoC;
	@FXML
	private Button limpar;

	@FXML
	public void ConvCelsius() {
		try {

			Locale.setDefault(Locale.US);
			double Fahrenheit = Double.parseDouble(numTempF.getText());
			double celsius = (Fahrenheit - 32) / 1.8;
			resultadoF.setText(String.format("%.1f", celsius) + "°Celsius");
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Somente Números!!!", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void ConvFahrenheit() {
		try {

			Locale.setDefault(Locale.US);
			double celsius = Double.parseDouble(numTempC.getText());
			double Fahrenheit = (celsius * 1.8) + 32;
			resultadoC.setText(String.format("%.1f", Fahrenheit) + "°Fahrenheit");
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Somente Números!!!", e.getMessage(), AlertType.ERROR);
		}
	}

	@FXML
	public void limpar() {
		numTempF.setText("");
		numTempC.setText("");
		resultadoF.setText("");
		resultadoC.setText("");
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(numTempF);
		Constraints.setTextFieldDouble(numTempC);
		Constraints.setTextFieldMaxLength(numTempC, 12);
		Constraints.setTextFieldMaxLength(numTempF, 12);
	}
}