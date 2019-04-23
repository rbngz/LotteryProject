package model;

import java.util.ArrayList;
import java.util.Random;

public class NumberGenerator {
    public NumberGenerator(){

    }

    public ArrayList<Integer> generateNumbers(){
        ArrayList<Integer> numbers = new ArrayList<>();
        while(numbers.size()<6) {
            Integer next = (int) (Math.random() * 42 + 1);
            if(!numbers.contains(next)) numbers.add(next);
            //boolean alreadyThere = false;
            //for (int i= 0; i<numbers.size();i++){
            //    if (next == numbers.get(i))
            //}
        }
        numbers.add((int)(Math.random()*6+1));
        return numbers;
    }
}
