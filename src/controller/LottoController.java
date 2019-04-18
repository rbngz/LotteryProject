package controller;

import javafx.scene.control.Button;
import model.LottoModel;
import view.Cashbar;
import view.LottoView;
import view.TipField;

import java.util.ArrayList;

public class LottoController {

    public LottoController(LottoModel model, LottoView view){
        model.money.getMoneyProperty().addListener(((observable, oldValue, newValue) -> {
            view.getCashBar().getMoney().setText(Integer.toString((int)newValue));
        }));

        view.getCashBar().getSubmitTipsButton().setOnAction(event -> {
            TipField tipfield = (TipField) view.getTips().getChildren().get(0);
            if (tipfield.getActiveProperty().getValue()) {
                ArrayList<Integer> tip = new ArrayList<>();
                for (int i = 1; i < 43; i++) {
                    if (tipfield.getChildren().get(i).getStyleClass().contains("pressedNum")) {
                        Button tipped = (Button) tipfield.getChildren().get(i);
                        tip.add(Integer.parseInt(tipped.getText()));
                    }
                }
                model.tips.addTip(tip);
                System.out.println(model.tips.getTip(0));
            }

        });

    }
}
