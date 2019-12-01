package com.tecnicas_pucrs.interfaces.javafx;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DadosDoMotorista2Controller implements Initializable {

    @FXML
    private Button btn_buscar;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_voltar;

    @FXML
    private Text nome;

    @FXML
    private ListView viagens;

    private double x;
    private double y;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        DadosDoMotoristaController dadosDoMotoristaAtual = new DadosDoMotoristaController();
        System.out.println(dadosDoMotoristaAtual.retornaCPF());
        this.nome.setText(dadosDoMotoristaAtual.retornaCPF());


        viagens.getItems().add("Viagem um");
        viagens.getItems().add("Viagem dois");
        viagens.getItems().add("Viagem três");

        btn_voltar.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/views/DadosDoMotorista.fxml"));
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


}