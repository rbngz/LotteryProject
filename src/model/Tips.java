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
    public ArrayList<ArrayList<Integer>> getTips(){return tips;}


    public boolean checkTips(){
        //TODO edit: check that only one lucky number is entered
        boolean allValid = true;
        for (int i = 0; i<tips.size();i++) {
            if (!(tips.get(i).size() == 7 && tips.get(i).get(6) <= 6)) {
                allValid=false;
            }
        }
        return allValid;
    }
    public void removeTips(){
        tips.clear();
    }


}
