package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.LottoModel;

public class LottoView {
    private Stage stage;
    private Button startGameButton;

    public LottoView(Stage stage, LottoModel model){
        this.stage = stage;
        VBox entryRoot = new VBox();
        HBox entryButtons = new HBox();
        entryButtons.getChildren().add(startGameButton = new Button("Start Game"));
        entryButtons.getChildren().add(new Button("Exit"));
        entryRoot.getChildren().add(entryButtons);

        Scene firstScene = new Scene(entryRoot);
        stage.setScene(firstScene);
        stage.setTitle("Lottery Game");
        stage.show();


    }
    public void startGame(){
        BorderPane gameRoot = new BorderPane();
        MenuBar menu = new MenuBar();
        Cashbar cashBar = new Cashbar();
        ProbabilityWindow probabilityWindow = new ProbabilityWindow();
        HBox gameBox = new HBox();
        VBox lotteryPane = new VBox();
        HBox tips = new HBox();
        for (int i = 0; i<5;i++){
            tips.getChildren().add(new TipField());
        }
        LotteryWindow lotteryWindow = new LotteryWindow();
        lotteryPane.getChildren().addAll(lotteryWindow,tips);

        gameBox.getChildren().addAll(lotteryPane, probabilityWindow);

        gameRoot.setTop(menu);
        gameRoot.setBottom(cashBar);
        gameRoot.setCenter(gameBox);


        Scene gameScene = new Scene(gameRoot);
        gameScene.getStylesheets().add(
                getClass().getResource("lotto.css").toExternalForm());
        stage.setScene(gameScene);

    }

    public Button getStartButton(){
        return startGameButton;
    }
}
