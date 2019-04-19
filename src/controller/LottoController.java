package controller;

import javafx.scene.control.Alert;
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
            for(int i = 0; i<5;i++) {
                TipField tipfield = (TipField) view.getTips().getChildren().get(i);
                if (tipfield.getActiveProperty().getValue()) {
                    ArrayList<Integer> tip = new ArrayList<>();
                    for (int j = 1; j < 50; j++) {
                        if (tipfield.getChildren().get(j).getStyleClass().contains("pressedNum")) {
                            Button tipped = (Button) tipfield.getChildren().get(j);
                            tip.add(Integer.parseInt(tipped.getText()));
                        }
                    }
                    /*for (int j = 1; j< 7 ; j++){
                        if(tipfield.getChildren().get(43+i).getStyleClass().contains("pressedNum")){
                            Button tipped = (Button) tipfield.getChildren().get(j);
                            tip.add(Integer.parseInt(tipped.getText()));
                        }
                    }*/
                    model.tips.addTip(tip);
                }
            }
            if(model.tips.checkTips()) {
                view.getDialoguePane().updateDialogue(model.tips.getTips());
            } else{
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setHeaderText("Tips not valid");
                errorAlert.setContentText("At least one of your tips is not valid. Choose 6 numbers and 1 lucky number!");
                errorAlert.showAndWait();
            }
        });
        TipField.totalActive.addListener(((observable, oldValue, newValue) -> {
            view.getCashBar().setTotalBet((int) newValue);
        }));



    }



}
