package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.Alerts;
import util.Constraints;

public class telaCalculadoraController {

	@FXML
	private TextField valorA;
	@FXML
	private TextField valorB;
	@FXML
	private TextField valorC;
	@FXML
	private Label valordex1;
	@FXML
	private Label valordex2;
	@FXML
	private Label resultado;
	@FXML
	private Label deltaSN;
	@FXML
	private Label deltaSV;
	@FXML
	private Button calcular;
	@FXML
	private Button limpar;

	@FXML
	public void BtnCalcular() {
		try {
			double delta, x1, x2;

			int a = Integer.parseInt(valorA.getText());
			int b = Integer.parseInt(valorB.getText());
			int c = Integer.parseInt(valorC.getText());

			delta = (b * b) + (-4 * (a * c));

			x1 = (double) ((-(b) + Math.sqrt(delta)) / (2 * a));

			x2 = (double) ((-(b) - Math.sqrt(delta)) / (2 * a));

			resultado.setText(String.format("%.2f", delta));
			valordex1.setText(String.format("%.2f", x1));
			valordex2.setText(String.format("%.2f", x2));
			if (delta >= 0) {
				deltaSV.setText("");
				deltaSN.setText("Delta possui Raiz!");
			} else {
				deltaSN.setText("");
				deltaSV.setText("Delta não possui Raiz!");
			}
		} catch (NumberFormatException e) {
			Alerts.showAlert("Error", "Somente Numero!!!", e.getMessage(), AlertType.ERROR);
			valorA.setText("");
			valorB.setText("");
			valorC.setText("");
			valordex1.setText("");
			valordex2.setText("");
			deltaSN.setText("");
			deltaSV.setText("");
			resultado.setText("");
		}

	}

	@FXML
	public void BtnLimpar() {
		valorA.setText("");
		valorB.setText("");
		valorC.setText("");
		valordex1.setText("");
		valordex2.setText("");
		deltaSN.setText("");
		deltaSV.setText("");
		resultado.setText("");
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		Constraints.setTextFieldDouble(valorA);
		Constraints.setTextFieldDouble(valorB);
		Constraints.setTextFieldDouble(valorC);
		Constraints.setTextFieldMaxLength(valorA, 12);
		Constraints.setTextFieldMaxLength(valorB, 12);
		Constraints.setTextFieldMaxLength(valorC, 12);
	}
}
