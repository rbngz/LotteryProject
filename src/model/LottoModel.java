package model;

public class LottoModel {
    public Cash money;
    public Tips tips;
    public NumberGenerator numberGenerator;
    public LottoModel(){
        money = new Cash();
        tips = new Tips();
        numberGenerator = new NumberGenerator();
    }
}
