package view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class TipField extends GridPane {
    public static SimpleIntegerProperty totalActive = new SimpleIntegerProperty();
    SimpleBooleanProperty activeProperty = new SimpleBooleanProperty();
    Button addTip;
    Label luckyNumbers;
    public static int index = 0;
    TipField previous;
    ArrayList<Integer> tippedNums;


    public TipField(TipField previous){
        super();
        this.previous = previous;
        tippedNums = new ArrayList<>();
        activeProperty.setValue(false);
        //create all numbers 1-42 and set the to disabled by default
        for (int i = 1; i < 43;i++){
            Button number = new Button(Integer.toString(i));
            this.add(number,(i-1)%6,(i-1)/6 +1);
            number.getStyleClass().add("tip");
            number.setDisable(true);
            number.setOnAction(event -> {
                if(!number.getStyleClass().contains("pressedNum")) {
                    number.getStyleClass().add("pressedNum");
                } else number.getStyleClass().remove("pressedNum");
            });
        }

        //add the button to add the tip, which enables all number buttons
        addTip = new Button("Add Tip");
        this.add(addTip,0,0,REMAINING,1);
        addTip.setId("addTipButton");
        if(previous!=null){
            addTip.setDisable(true);
        }

        //if button is pressed, the text changes to "remove tip" and vice versa.
        //all buttons get enabled/disabled
        addTip.setOnAction(event -> {
            if (!activeProperty.get()) {
                this.activeProperty.setValue(true);
                totalActive.setValue(totalActive.getValue()+1);
                addTip.setText("Remove Tip");
                for (int i = 1; i < 43; i++) {
                    this.getChildren().get(i - 1).setDisable(false);
                }
                for (int i = 1; i< 7 ; i++){
                    this.getChildren().get(43+i).setDisable(false);
                }
                this.luckyNumbers.setStyle(null);
                if(previous!=null) {
                    previous.addTip.setDisable(true);
                }

            } else{
                this.activeProperty.setValue(false);
                totalActive.setValue(totalActive.getValue()-1);
                addTip.setText("Add Tip");
                for (int i = 1; i < 51; i++) {
                    this.getChildren().get(i - 1).getStyleClass().remove("pressedNum");
                    this.getChildren().get(i - 1).setDisable(true);
                }
                this.luckyNumbers.setStyle("-fx-text-fill: grey");
                if(previous!=null) previous.addTip.setDisable(false);
            }
        });
        if(previous!=null) {
            previous.activeProperty.addListener(((observable, oldValue, newValue) -> {
                if (newValue == true) addTip.setDisable(false);
                else addTip.setDisable(false);

            }));
        }
        //
        luckyNumbers = new Label("Lucky Numbers");
        luckyNumbers.setStyle("-fx-text-fill: grey");
        this.add(luckyNumbers,0,8,REMAINING,1);
        for (int i = 1; i< 7 ; i++){
            Button number = new Button(Integer.toString(i));
            this.add(number,i-1,9);
            number.getStyleClass().add("tip");
            number.setDisable(true);
            number.setOnAction(event -> {
                if(!number.getStyleClass().contains("pressedNum")) {
                    number.getStyleClass().add("pressedNum");
                } else number.getStyleClass().remove("pressedNum");
            });
        }
        this.getStyleClass().add("tipField");
    }
    public SimpleBooleanProperty getActiveProperty(){
        return activeProperty;
    }
}
