package view;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

import java.util.ArrayList;

public class LotteryWindow extends HBox {
    public LotteryWindow(){
        super();
        this.setPrefHeight(160);
    }
    public void drawNumbers(ArrayList<Integer> numbers){
        this.getChildren().clear();
        int ballNum = 0;
        for (int i = 0;i<7;i++){
            Ball ball = new Ball(numbers.get(i));
            this.getChildren().add(ball);
            HBox.setMargin(ball,new Insets(20));

            TranslateTransition tt = new TranslateTransition(Duration.millis(1000),ball);
            tt.setFromY(-200);
            tt.setToY(0);
            SequentialTransition sqt = new SequentialTransition(
                    new PauseTransition(Duration.millis(1000*ballNum)),
                    tt
            );
            ballNum++;
            sqt.play();




        }
    }


}
