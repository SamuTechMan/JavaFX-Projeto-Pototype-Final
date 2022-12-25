package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import util.Alerts;

public class viewController implements Initializable {

	@FXML
	private MenuItem ArquivoSair;
	@FXML
	private MenuItem SobreVersao;
	@FXML
	private MenuItem SobreQuemSomos;
	@FXML
	private MenuItem MathSimples;
	@FXML
	private MenuItem MathBhaskara;
	@FXML
	private MenuItem telainicio;
	@FXML
	private MenuItem telaConversor;

	@FXML
	public void MathBhaskara() {
		loadView("/gui/MatBhaskara.fxml");
	}

	@FXML
	public void telainicio() {
		loadView("/gui/telainicio.fxml");
	}

	@FXML
	public void ArquivoSair() {
		System.exit(0);
	}

	@FXML
	public void MathSimples() {
		loadView("/gui/MatSimples.fxml");
	}

	@FXML
	public void SobreVersao() {
		loadView("/gui/Versao.fxml");
	}

	@FXML
	public void SobreQuemSomos() {
		loadView("/gui/Sobre.fxml");
	}

	@FXML
	public void TelaConversor() {
		loadView("/gui/conversor.fxml");
	}

	public void initialize(URL url, ResourceBundle rb) {
		// TODO Auto-generated method stub

	}

	/*
	 * O objetivo do método de loadView é carregar uma view na janela principal da
	 * aplicação. Para isso precisamos pegar uma referência da ca cena principal,
	 * que foi criada na classe Main. Uma vez a referência da Cena principal tenha
	 * sido exposta na classe Main, podemos obter uma referência aqui no método de
	 * loadView para manipularmos a janela principal da aplicação.
	 */

	public synchronized void loadView(String absolutName) {
		try {
			// carregando uma view, passando como parâmetro a localização (absolutName)
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutName));
			VBox newVBox = loader.load();

			// obtendo uma referência da cena principa, criada e exposta na classe Main
			Scene mainScene = Main.getMainScene();

			// fazendo o casting de scrooPane que é o componente da cena principal, para o
			// VBox
			// que é o componente na nova tela a ser carregada na cena principal
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();

			// guardando o componente MenuBar que dever ser carregado junto com todas as
			// views
			// do sistema
			Node mainMenu = mainVBox.getChildren().get(0);

			// limpando todos os componentes da view principal
			mainVBox.getChildren().clear();

			// adicionando o mainMenu porque deve estar presente em todas as views
			mainVBox.getChildren().add(mainMenu);

			// adicionando todos os componente filhos do layout newVBox (é o layout da tela
			// a ser carregada na janela principal)
			mainVBox.getChildren().addAll(newVBox.getChildren());

		} catch (IOException e) {
			// caso acontece algum erro, emitirá um alerta, conforme implementado
			// anteriormente
			// possíveis erros aqui é 1) não conseguir obter uma referência da cena
			// principal,
			// 2)não conseguir carregar alguma tela, 3) não encontrar os componentes da
			// VBox principal
			Alerts.showAlert("IO Exception", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}

}
