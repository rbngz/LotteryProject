package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TipField extends GridPane {
    boolean active = false;
    Button addTip;
    Label luckyNumbers;
    

    public TipField(){
        super();
        //create all numbers 1-42 and set the to disabled by default
        for (int i = 1; i < 43;i++){
            Button number = new Button(Integer.toString(i));
            this.add(number,(i-1)%6,(i-1)/6 +1);
            number.getStyleClass().add("tip");
            number.setDisable(true);
        }

        //add the button to add the tip, which enables all number buttons
        addTip = new Button("Add Tip");
        this.add(addTip,0,0,REMAINING,1);
        addTip.setId("addTipButton");
        addTip.setOnAction(event -> {
            if (!active) {
                this.active = true;
                addTip.setText("Remove Tip");
                for (int i = 1; i < 43; i++) {
                    this.getChildren().get(i - 1).setDisable(false);
                }
                for (int i = 1; i< 7 ; i++){
                    this.getChildren().get(43+i).setDisable(false);
                }
                this.luckyNumbers.setStyle(null);


            } else{
                this.active = false;
                addTip.setText("Add Tip");
                for (int i = 1; i < 43; i++) {
                    this.getChildren().get(i - 1).setDisable(true);
                }
                for (int i = 1; i< 7 ; i++){
                    this.getChildren().get(43+i).setDisable(true);
                }
                this.luckyNumbers.setStyle("-fx-text-fill: grey");
            }
        });

        //
        luckyNumbers = new Label("Lucky Numbers");
        luckyNumbers.setStyle("-fx-text-fill: grey");
        this.add(luckyNumbers,0,8,REMAINING,1);
        for (int i = 1; i< 7 ; i++){
            Button number = new Button(Integer.toString(i));
            this.add(number,i-1,9);
            number.getStyleClass().add("tip");
            number.setDisable(true);
        }
        this.getStyleClass().add("tipField");
    }
}
