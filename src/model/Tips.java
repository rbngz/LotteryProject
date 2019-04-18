package model;

import java.util.ArrayList;

public class Tips {
    ArrayList<ArrayList<Integer>> tips;
    public Tips(){
        tips = new ArrayList<>();
    }

    public void addTip(ArrayList<Integer>tip){
        tips.add(tip);
    }
    public ArrayList<Integer> getTip(int i){
        return tips.get(i);
    }


}
