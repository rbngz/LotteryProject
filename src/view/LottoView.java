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
    private HBox tips;
    private Cashbar cashBar;
    private DialoguePane dialoguePane;
    private LotteryWindow lotteryWindow;

    public LottoView(Stage stage, LottoModel model){
        this.stage = stage;
        BorderPane gameRoot = new BorderPane();
        MenuBar menu = new MenuBar();
        cashBar = new Cashbar();
        dialoguePane = new DialoguePane();
        HBox gameBox = new HBox();
        VBox lotteryPane = new VBox();
        tips = new HBox();
        tips.getChildren().add(new TipField(null));
        for (int i = 1; i<5;i++){
            tips.getChildren().add(new TipField((TipField)tips.getChildren().get(i-1)));
        }
        lotteryWindow = new LotteryWindow();
        lotteryPane.getChildren().addAll(lotteryWindow,tips);

        gameBox.getChildren().addAll(lotteryPane, dialoguePane);

        gameRoot.setTop(menu);
        gameRoot.setBottom(cashBar);
        gameRoot.setCenter(gameBox);
        gameRoot.setStyle("-fx-background-color: rgb(255,104,104)");


        Scene gameScene = new Scene(gameRoot);
        gameScene.getStylesheets().add(
                getClass().getResource("lotto.css").toExternalForm());
        stage.setScene(gameScene);


        stage.show();


    }
    public void startGame(){

    }

    public Button getStartButton(){
        return startGameButton;
    }
    public Cashbar getCashBar(){
        return cashBar;
    }
    public HBox getTips(){
        return tips;
    }

    public DialoguePane getDialoguePane() {
        return dialoguePane;
    }

    public LotteryWindow getLotteryWindow() {
        return lotteryWindow;
    }
}
