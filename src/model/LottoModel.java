package model;

public class LottoModel {
    public Cash money;
    public Tips tips;
    public LottoModel(){
        money = new Cash();
        tips = new Tips();
    }
}
