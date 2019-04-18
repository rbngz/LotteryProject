package model;

import javafx.beans.property.SimpleIntegerProperty;

public class Cash {
    int money;
    SimpleIntegerProperty moneyProperty = new SimpleIntegerProperty();
    public Cash(){
        money = 100;
    }

    public SimpleIntegerProperty getMoneyProperty() {
        return moneyProperty;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
