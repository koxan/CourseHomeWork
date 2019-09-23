package org.itstep;

/**
 * Created by Вит on 16.02.2017.
 */
public class Client {
    private double sum;
    private CurrencyOperation curOper;

    public double getSum(){
        return sum;
    }

    public CurrencyOperation getCurOper(){
        return curOper;
    }
    void infoClient(){
        System.out.println(sum);
        System.out.println(curOper);
    }
    public Client(){
        double randSum;
        boolean isSell;
        CurrencyOperation curOper;

        isSell = Main.rand.nextBoolean();
        curOper = isSell ? CurrencyOperation.SELL : CurrencyOperation.BUY;
        randSum = isSell ? Main.rand.nextInt(391)+10: Main.rand.nextInt(9901)+100;

        this.sum = randSum;
        this.curOper=curOper;
    }
}
