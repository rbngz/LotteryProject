package controller;

import model.LottoModel;
import view.LottoView;

public class LottoController {

    public LottoController(LottoModel model, LottoView view){
        view.getStartButton().setOnAction(event -> {
            view.startGame();
        });
        model.money.getMoneyProperty().addListener(((observable, oldValue, newValue) -> {
            view.getCashBar().getMoney().setText(Integer.toString((int)newValue));
        }));

    }
}
