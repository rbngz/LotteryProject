package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Cash;

public class Cashbar extends HBox {
    private Label moneyLabel;
    private Button submitTips;
    private Label betLabel;


    public Cashbar(){
        moneyLabel = new Label("100");
        submitTips = new Button("Submit Tips");
        this.getChildren().addAll(moneyLabel, submitTips);
    }

    public Label getMoney() {
        return moneyLabel;
    }
    public Button getSubmitTipsButton(){
        return submitTips;
    }

}
