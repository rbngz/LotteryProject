package model;

public class LottoModel {
    public Cash money;
    public Tips tips;
    public NumberGenerator numberGenerator;
    public Jackpot jackpot;
    public LottoModel(){
        money = new Cash();
        tips = new Tips();
        numberGenerator = new NumberGenerator();
        jackpot = new Jackpot();

    }
}
