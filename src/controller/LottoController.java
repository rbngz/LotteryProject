package controller;

import model.LottoModel;
import view.LottoView;

public class LottoController {

    public LottoController(LottoModel model, LottoView view){
        view.getStartButton().setOnAction(event -> {
            view.startGame();
        });

    }
}
