package view;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class TipField extends GridPane {
    public static SimpleIntegerProperty totalActive = new SimpleIntegerProperty();
    SimpleBooleanProperty activeProperty = new SimpleBooleanProperty();
    public Button addTip;
    Label luckyNumbers;
    public static int index = 0;
    TipField previous;
    ArrayList<Integer> tippedNums;
    public SimpleIntegerProperty tipCount;
    Label tipCountLabel;
    public Button randomTip;


    public TipField(TipField previous){
        super();
        this.previous = previous;
        tipCount= new SimpleIntegerProperty(0);
        tippedNums = new ArrayList<>();
        activeProperty.setValue(false);
        //create all numbers 1-42 and set the to disabled by default
        for (int i = 1; i < 43;i++){
            Button number = new Button(Integer.toString(i));
            this.add(number,(i-1)%6,(i-1)/6 +1);
            number.getStyleClass().add("tip");
            number.setDisable(true);
            number.setOnAction(event -> {
                //count how many numbers are selected and restrict user to 6 numbers
                    if (!number.getStyleClass().contains("pressedNum")&&tipCount.getValue()<6) {
                        number.getStyleClass().add("pressedNum");
                        tipCount.setValue(tipCount.getValue() + 1);
                    } else if(number.getStyleClass().contains("pressedNum")){
                        number.getStyleClass().remove("pressedNum");
                        tipCount.setValue(tipCount.getValue() - 1);
                }
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
                for (int i = 0; i < this.getChildren().size(); i++) {
                    this.getChildren().get(i).setDisable(false);
                }


                if(previous!=null) {
                    previous.addTip.setDisable(true);
                }

            } else{
                this.activeProperty.setValue(false);
                totalActive.setValue(totalActive.getValue()-1);
                addTip.setText("Add Tip");
                tipCount.setValue(0);
                for (int i = 0; i < this.getChildren().size(); i++) {
                    this.getChildren().get(i).getStyleClass().removeAll("pressedNum","correctTip","wrongTip");
                    if(i!=42)this.getChildren().get(i).setDisable(true);
                }
                if(previous!=null) previous.addTip.setDisable(false);
            }
        });
        if(previous!=null) {
            previous.activeProperty.addListener(((observable, oldValue, newValue) -> {
                if (newValue) addTip.setDisable(false);
                else addTip.setDisable(true);

            }));
        }
        //
        luckyNumbers = new Label("Lucky Numbers");
        luckyNumbers.setDisable(true);
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
        tipCountLabel = new Label("Selected Numbers: "+tipCount.getValue()+"/6");
        tipCount.addListener((observable, oldValue, newValue) ->{
            tipCountLabel.setText("Selected Numbers: "+newValue+"/6");
        });
        tipCountLabel.setDisable(true);
        this.add(tipCountLabel,0,10,REMAINING,1);
        randomTip = new Button("");
        this.add(randomTip,5,10,REMAINING,1);
        Image randomIcon = new Image(this.getClass().getClassLoader().getResourceAsStream("images/random.png"));
        ImageView imv = new ImageView(randomIcon);
        imv.setPreserveRatio(true);
        imv.setFitHeight(15);
        randomTip.setGraphic(imv);
        randomTip.setDisable(true);



        this.getStyleClass().add("tipField");
    }
    public SimpleBooleanProperty getActiveProperty(){
        return activeProperty;
    }
    public void disableField(){
        for (int i = 0; i<this.getChildren().size();i++){
            this.getChildren().get(i).setDisable(true);
        }
    }
    public Button getRandomTip(){
        return randomTip;
    }
}
