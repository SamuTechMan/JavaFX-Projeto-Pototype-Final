package util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

public class Utils {
	//essa fun��o retorna o stage atual
	//precisamos carregar uma nova janela, form de cadastro, na janela atual
	public static Stage currentStage(ActionEvent event) {
		//Essa fun��o vai retornar o controle do Stage atual
		return (Stage) ((Node) event.getSource()).getScene().getWindow();
	}
}
