package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import model.Cash;

public class Cashbar extends HBox {
    private Label money;

    public Cashbar(){
        money = new Label("100");
        this.getChildren().addAll(money);
    }

    public Label getMoney() {
        return money;
    }

}
