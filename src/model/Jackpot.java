package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.DecimalFormat;

public class Jackpot {
    //int value;
    SimpleIntegerProperty value;
    SimpleStringProperty valueString;
    public Jackpot(){
        value = new SimpleIntegerProperty(300000);
        valueString = new SimpleStringProperty();
    }


    public int[] runSimulation(){
        int totalPlayers = (int) (300000 + Math.random()*700000); // generate random amount of players between 300'000 and 1'000'000
        double[] chances = {
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0)*(3.0/39.0)*(2.0/38.0)*(1.0/37.0)*(1.0/6.0), // 6+1
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0)*(3.0/39.0)*(2.0/38.0)*(1.0/37.0), // 6
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0)*(3.0/39.0)*(2.0/38.0)*(1.0/6.0), // 5+1
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0)*(3.0/39.0)*(2.0/38.0), // 5
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0)*(3.0/39.0)*(1.0/6.0), // 4+1
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0)*(3.0/39.0), // 4
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0)*(1.0/6.0), // 3+1
                (6.0/42.0)*(5.0/41.0)*(4.0/40.0), // 3

        };

        int[] winnerCount = new int[chances.length];
        for(int x = 0; x<chances.length;x++){
            for (int i = 0;i<totalPlayers;i++){
                if(Math.random()<chances[x]){
                    winnerCount[x]++;
                }
            }
        }
        if(winnerCount[0]==0){ //no jackpot winners
            value.setValue(value.getValue()+(totalPlayers*3));
        } else{
            value.setValue(3000000);
        }
        return winnerCount;

    }
    public SimpleIntegerProperty getValueProperty(){
        return value;
    }

}
