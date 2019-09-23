package org.itstep;

import java.util.Random;

/**
 * Created by Вит on 16.02.2017.
 */
public class Main {
    public static Random rand;

    public static void main(String[] args) {
        Main.rand = new Random();
        Client client;
        byte randBranch = 0;
        
        BankBranch[] branches = new BankBranch[10];
        for(int i =0;i<branches.length;i++){
            client = new Client();
            branches[i]=new BankBranch((byte)branches.length);
            branches[randBranch].exchange(client);
            client.infoClient();

        }
        
        float gainUAHAll = 0,curGain , max = -1;
        byte maxId = -1;
        for(int i = 0;i<branches.length;i++){
            curGain = branches[i].gainUAH();
            gainUAHAll += curGain;
            if(curGain>max){
                max = curGain;
                maxId = branches[i].getID();
            }
        }
        System.out.println("Общий доход банка(грн) -" + gainUAHAll);
        System.out.println("Филиал с самой большой выручкой(грн) №"+ maxId );

    }
}
