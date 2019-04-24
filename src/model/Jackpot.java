package model;

import java.text.DecimalFormat;

public class Jackpot {
    int value;
    public Jackpot(){
        value = 3000000;
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
        System.out.println(totalPlayers);
        System.out.println(chances);
        System.out.println(Math.random());
        System.out.println(winnerCount);
        return winnerCount;

    }
}
