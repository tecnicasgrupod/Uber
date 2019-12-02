package com.tecnicas_pucrs.interfaces.javafx;


import com.tecnicas_pucrs.Fachada;
import com.tecnicas_pucrs.casos_de_uso.politicas.CalculoCustoViagem;
import com.tecnicas_pucrs.casos_de_uso.politicas.MotoristaEquivalente;
import com.tecnicas_pucrs.casos_de_uso.politicas.PrecoIntegro;
import com.tecnicas_pucrs.casos_de_uso.politicas.SeletorDeMotorista;
import com.tecnicas_pucrs.casos_de_uso.repositorios.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class DadosDaSolicitacaoController implements Initializable {

    private Fachada fachada = new Fachada(new CalculoCustoViagem(new PrecoIntegro()), new SeletorDeMotorista(new MotoristaEquivalente()), RepoBairros.getInstance(), RepoCidades.getInstance(), RepoMotoristas.getInstance(), RepoPassageiros.getInstance(), RepoViagens.getInstance());

    @FXML
    private Button btn_buscar;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_voltar;

    @FXML
    private TextField cpf_passageiro;

    @FXML
    private TextField bairro_origem;

    @FXML
    private TextField bairro_destino;

    @FXML
    private ChoiceBox pagamento;

    @FXML
    private ChoiceBox categoria;

    static int idViagemAtual;

    private double x;
    private double y;

    public DadosDaSolicitacaoController(){
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pagamento.getItems().add("Dinheiro");
        pagamento.getItems().add("Débito");
        pagamento.getItems().add("Crédito");

        categoria.getItems().add("Simples");
        categoria.getItems().add("Normal");
        categoria.getItems().add("Luxo");

    btn_buscar.setOnAction(new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            try {
                System.out.println(cpf_passageiro.getText());
                System.out.println(bairro_origem.getText());
                System.out.println(bairro_destino.getText());
                System.out.println(pagamento.getSelectionModel().getSelectedItem().toString());
                System.out.println(categoria.getSelectionModel().getSelectedItem().toString());
                idViagemAtual = fachada.solicitaVeiculoParaViagem(cpf_passageiro.getText(), "canoas", bairro_origem.getText(), bairro_destino.getText(), pagamento.getSelectionModel().getSelectedItem().toString(), categoria.getSelectionModel().getSelectedItem().toString());
                Parent root = FXMLLoader.load(getClass().getResource("/views/DadosDaViagem.fxml"));
                root.setOnMousePressed(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        x = event.getSceneX();
                        y = event.getSceneY();
                    }
                });
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    public void handle(MouseEvent event) {
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    }
                });

                stage.setScene(scene);
                stage.setTitle("UBER");
                stage.initStyle(StageStyle.UNDECORATED);
                stage.initStyle(StageStyle.TRANSPARENT);
                Image applicationIcon = new Image(getClass().getResourceAsStream("/img/logo.png"));
                stage.getIcons().add(applicationIcon);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });
}

    public void exit() {
        System.exit(0);
    }

    public static int getViagemAtual() {

        System.out.println("Pegou a viagem");
        return idViagemAtual;
    }
}