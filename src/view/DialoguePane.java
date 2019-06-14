package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
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

            HBox tipLabel = new HBox(showTip(tips.get(i)));
            this.getChildren().add(tipLabel);
        }
    }
    public void showEvaluation(int[] correctCount){
        for(int i = 0;i<correctCount.length;i++){
            this.getChildren().add(new Label("Tip " + (i+1) + " right guesses: "+ correctCount[i]));
        }
    }
    private HBox showTip(ArrayList<Integer> tip){
        HBox tipNums = new HBox();
        for (int i = 0; i<5;i++){
            Label ball = new Label(Integer.toString(tip.get(i)));
            ball.setPrefSize(30,30);
            ball.setId("ball");
            ball.setAlignment(Pos.CENTER);
            tipNums.getChildren().add(ball);
        }
        tipNums.getChildren().add(new Label(" + "));
        Label lastBall = new Label(Integer.toString(tip.get(5)));
        lastBall.setPrefSize(30,30);
        lastBall.setId("ball");
        lastBall.setAlignment(Pos.CENTER);
        tipNums.getChildren().add(lastBall);

        return tipNums;
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
