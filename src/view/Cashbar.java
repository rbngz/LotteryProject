package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Cash;

public class Cashbar extends HBox {
    private Label moneyLabel;
    private Button submitTips;
    private Label totalBet;
    private Label betLabel;


    public Cashbar(){
        moneyLabel = new Label("100");
        totalBet = new Label("Total Bet");
        submitTips = new Button("Submit Tips");

        this.getChildren().addAll(moneyLabel,totalBet, submitTips);
    }

    public Label getMoney() {
        return moneyLabel;
    }
    public Button getSubmitTipsButton(){
        return submitTips;
    }

    public void setTotalBet(int i) {
        this.totalBet.setText(Integer.toString(i*3));
    }
}
