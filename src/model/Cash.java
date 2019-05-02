package model;

import javafx.beans.property.SimpleIntegerProperty;

public class Cash {
    SimpleIntegerProperty moneyProperty = new SimpleIntegerProperty();
    public Cash(){
        moneyProperty.setValue(100);
    }

    public SimpleIntegerProperty getMoneyProperty() {
        return moneyProperty;
    }

    public int getMoney() {
        return moneyProperty.getValue();
    }

    public void setMoney(int money) {
        moneyProperty.setValue(money);
    }
    public void collectWinnings(int[] correctCount){
        for (int i = 0; i<correctCount.length;i++){
                switch (correctCount[i]){
                    case 3: moneyProperty.setValue(moneyProperty.getValue()+200);
                        break;
                    case 4: moneyProperty.setValue(moneyProperty.getValue()+400);
                        break;
                    case 5: moneyProperty.setValue(moneyProperty.getValue()+500);
                        break;
                    case 6: moneyProperty.setValue(moneyProperty.getValue()+1000);
                        break;
                }

        }
    }
}
