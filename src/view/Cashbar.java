package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import model.Cash;

public class Cashbar extends HBox {
    private Label moneyLabel;
    private Button submitTips;
    private Label totalBet;
    private Label betLabel;
    private Button newGame;
    private Label jackpotLabel;
    private Region spacer;



    public Cashbar(){
        super();
        moneyLabel = new Label("100$");
        betLabel = new Label("--");
        totalBet = new Label("Total Bet: ");
        submitTips = new Button("Submit Tips");
        newGame = new Button("New Game");
        newGame.setDisable(true);
        jackpotLabel = new Label("Jackpot: 0$");
        jackpotLabel.setId("jackpotLabel");

        spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);


        this.getChildren().addAll(moneyLabel,totalBet,betLabel, submitTips,newGame,spacer,jackpotLabel);
        this.setId("bottomBar");
    }

    public void setMoneyLabel(int money) {
        moneyLabel.setText((money)+"$");
    }
    public Button getSubmitTipsButton(){
        return submitTips;
    }
    public Label getJackpotLabel(){ return jackpotLabel; }

    public void setTotalBet(int i) {
        this.betLabel.setText((i*3) + "$");
    }
    public Button getNewGame(){ return newGame; }
}
