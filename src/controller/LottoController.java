package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import model.LottoModel;
import model.NumberGenerator;
import view.Cashbar;
import view.LottoView;
import view.TipField;

import java.util.ArrayList;

public class LottoController {

    public LottoController(LottoModel model, LottoView view){
        model.money.getMoneyProperty().addListener(((observable, oldValue, newValue) -> {
            view.getCashBar().setMoneyLabel((int)newValue);
        }));
        //Start of simulation
        view.getCashBar().getSubmitTipsButton().setOnAction(event -> {
            model.tips.removeTips();
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
                    model.tips.addTip(tip);
                }
            }
            if(model.tips.checkTips()) {
                //run draw when all tips are valid
                ArrayList<Integer> numbers = model.numberGenerator.generateNumbers();
                for (int i = 0;i<5;i++){
                    TipField tipfield = (TipField) view.getTips().getChildren().get(i);
                    tipfield.disableField();
                }
                view.getCashBar().getSubmitTipsButton().setDisable(true);
                view.getDialoguePane().updateDialogue(model.tips.getTips());
                model.money.setMoney(model.money.getMoney()-(model.tips.getTips().size())*3);
                view.getLotteryWindow().drawNumbers(numbers,view);
                view.getDialoguePane().showAllWinners(model.jackpot.runSimulation());

                view.getDialoguePane().showEvaluation(model.tips.evaluate(numbers));
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

        view.getCashBar().getNewGame().setOnAction(event -> {
            //remove all active tips when "new game" button is pressed
            for(int i = TipField.totalActive.getValue(); i>0;i--){
                TipField tipfield = (TipField) view.getTips().getChildren().get(i-1);
                tipfield.addTip.setDisable(false);
                tipfield.addTip.fire();
            }
            if(TipField.totalActive.getValue()==0){
                TipField tipField = (TipField) view.getTips().getChildren().get(0);
                tipField.addTip.setDisable(false);
            }
            view.getCashBar().getSubmitTipsButton().setDisable(false);

            view.getCashBar().getNewGame().setDisable(true);
        });
        for(int i = 0;i<5;i++){
            TipField tipField = (TipField) view.getTips().getChildren().get(i);
            tipField.getRandomTip().setOnAction(event -> {
                //first remove all selected numbers
                for (int j = 0; j < tipField.getChildren().size(); j++) {
                    tipField.getChildren().get(j).getStyleClass().remove("pressedNum");
                }
                //generate random numbers and mark them as pressed
                ArrayList<Integer> randomTip = model.numberGenerator.generateNumbers();
                System.out.println(randomTip);
                for (int j = 0;j<randomTip.size()-1;j++){
                    tipField.getChildren().get(randomTip.get(j)-1).getStyleClass().add("pressedNum");
                }
                tipField.getChildren().get(randomTip.get(randomTip.size()-1)+43).getStyleClass().add("pressedNum");
                tipField.tipCount.setValue(6);
            });
        }



    }



}
