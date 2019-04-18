package view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DialoguePane extends VBox {

    public DialoguePane(){
        for(int i = 0; i<5; i++){
            Label tipLabel = new Label();
            tipLabel.setPrefWidth(100);
            this.getChildren().add(tipLabel);
        }

    }
    public void updateDialogue(ArrayList<ArrayList<Integer>> tips){

        for (int i = 0; i< tips.size();i++){
            Label tipLabel = (Label) this.getChildren().get(i);
            tipLabel.setText(null);
            tipLabel.setText(tips.get(i).toString());
        }


    }

}
