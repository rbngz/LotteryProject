package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Jackpot;

import java.util.ArrayList;

public class DialoguePane extends VBox {


    public DialoguePane(){
        super();
        this.setPrefWidth(200);
        this.getStyleClass().add("dialoguePane");
    }
    public void updateDialogue(ArrayList<ArrayList<Integer>> tips){
        this.getChildren().clear();

        this.getChildren().add(new Label("Total Tips: "+tips.size()));

        for (int i = 0; i< tips.size();i++){

            Label tipLabel = new Label(showTip(tips.get(i)));
            this.getChildren().add(tipLabel);
        }
    }
    public void showEvaluation(int[] correctCount){
        for(int i = 0;i<correctCount.length;i++){
            this.getChildren().add(new Label("Tip " + (i+1) + " right guesses: "+ correctCount[i]));
        }
    }
    private String showTip(ArrayList<Integer> tip){
        String tipString = tip.get(0).toString();
        for (int i = 1; i<6;i++){
            tipString+= ", "+ tip.get(i);
        }
        tipString += " + " + tip.get(tip.size()-1);
        return tipString;
    }
    public void showAllWinners(int[] winnerCount){
        this.getChildren().add(new Label("Jackpot Winners: "+winnerCount[0]));
        int rightCount = 6;
        for(int i = 1;i<winnerCount.length;i++){
            if(i%2==0) {
                this.getChildren().add(new Label("Winner " + rightCount +" + "+ 1+": \t"+winnerCount[i]));
            } else {
                this.getChildren().add(new Label("Winner "+ rightCount + ": \t"+winnerCount[i]));
                rightCount--;
            }
        }
    }

}
