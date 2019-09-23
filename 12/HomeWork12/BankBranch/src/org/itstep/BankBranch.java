package org.itstep;


public class BankBranch {
    static final float BUY_USD = 27.3f;
    static final  float SELL_USD = 27.701f;

    public final static int countUAH = 1000000;
    public final static int countUSD = 1000000;

    private float countUAHInner;
    private float countUSDInner;
    private byte id;
    public static byte count;

    public BankBranch(byte countBranches){
        id=++count;
        countUAHInner = countUAH/countBranches;
        countUSDInner = countUSD/countBranches;

    }

    public float getCountUAHInner(){
        return countUAHInner;
    }

    public float getCountUSDInner(){
        return countUSDInner;
    }

    public byte getID(){
        return id;
    }

    public void exchange(Client client){
        if(client.getCurOper()== CurrencyOperation.SELL){
            countUSDInner += client.getSum();
            countUAHInner -= client.getSum()*BUY_USD;
        }
        else{
            countUAHInner+= client.getSum();
            countUSDInner-= client.getSum()/SELL_USD;
        }
    }

    public float gainUAH(){
        return (countUAHInner-1000000/count)+(countUSDInner-1000000/count)*BUY_USD;
    }

}
