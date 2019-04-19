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
}
