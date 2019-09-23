import java.util.Random;

/**
 * Created by Вит on 13.02.2017.
 */
public class Chicken {
   private String name;
   private int age;



    Chicken(){
    this("Unknown",0);
    }

    Chicken(String name,int age){
        this.name=name;
        this.age = age;
     }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    private void setAge(){
        this.age = age;
    }
     void printInfoChicken() {
        System.out.println("Имя курицы "+ name);
        System.out.println("Месяцев: "+ age);
    }


}
class ChickenFactory{
    public static void main(String[] args) {
        Random rand = new Random();

        String []ChickennName = {"Bamby","Barby","Baddy","Barkly","Bay","Baly","Banty","Baloky","Batory","Bazzy","Jamby","Jarby","Jaddy","Jarkly","Jay","Jaly","Janty","Jaloky","Jatory","Jazzy","Ramby","Rarby","Rarkly","Ray","RalyRanty","Ralok","Ratory","Razzy","Qamby","Qarby","Qaddy","Qarkly","Qay","Qaly","Qanty","Qaloky","Qatory","Mazzy","Mamby","Marby","Maddy","Markly","May","Maly","Manty","Maloky","Matory","Mazzy","Laddy","Ferry"};
        int [] age = new int[50];
        int number=0;
        int egg = 0;
        int sumEgg=0;
        int a = 0;
        for(int i = 0;i<50;i++){
            a=rand.nextInt(15)+1;
            age[i]=a;
            number++;
           if(a>=0&&a<=3){
             egg = 2;
             }
            if(a>=4&&a<=7){
                egg = 3;

            }
            if(a>=8&&a<=11){
                egg = 2;

            }
            if(a>11&&a<=15){
                egg = 1;
            }
            sumEgg=sumEgg+egg;


            System.out.println(" курочке #:"+ number + "----"+a+" месяц"+" и она дает в день "+egg+" яйца.");


        }
        System.out.println("Сумма яиц = "+ sumEgg+" ;");

        Chicken chiken0 = new Chicken(ChickennName[0],age[0]);
       Chicken chiken1 = new Chicken(ChickennName[1],age[1]);
        Chicken chiken2 = new Chicken(ChickennName[2],age[2]);
        Chicken chiken3 = new Chicken(ChickennName[3],age[3]);
        Chicken chiken4 = new Chicken(ChickennName[4],age[4]);
        Chicken chiken5 = new Chicken(ChickennName[5],age[5]);
        Chicken chiken6 = new Chicken(ChickennName[6],age[6]);
        Chicken chiken7 = new Chicken(ChickennName[7],age[7]);
        Chicken chiken8 = new Chicken(ChickennName[8],age[8]);
        Chicken chiken9 = new Chicken(ChickennName[9],age[9]);
        Chicken chiken10 = new Chicken(ChickennName[10],age[10]);
        Chicken chiken11 = new Chicken(ChickennName[11],age[11]);
       Chicken chiken12 = new Chicken(ChickennName[12],age[12]);
        Chicken chiken13 = new Chicken(ChickennName[13],age[13]);
        Chicken chiken14 = new Chicken(ChickennName[14],age[14]);
        Chicken chiken15 = new Chicken(ChickennName[15],age[15]);
        Chicken chiken16 = new Chicken(ChickennName[16],age[16]);
        Chicken chiken17 = new Chicken(ChickennName[17],age[17]);
        Chicken chiken18 = new Chicken(ChickennName[18],age[18]);
        Chicken chiken19 = new Chicken(ChickennName[19],age[19]);
        Chicken chiken20 = new Chicken(ChickennName[20],age[20]);
        Chicken chiken21 = new Chicken(ChickennName[21],age[21]);
        Chicken chiken22 = new Chicken(ChickennName[22],age[22]);
        Chicken chiken23 = new Chicken(ChickennName[23],age[23]);
        Chicken chiken24 = new Chicken(ChickennName[24],age[24]);
        Chicken chiken25 = new Chicken(ChickennName[25],age[25]);
        Chicken chiken26 = new Chicken(ChickennName[26],age[26]);
        Chicken chiken27 = new Chicken(ChickennName[27],age[27]);
       Chicken chiken28 = new Chicken(ChickennName[28],age[28]);
        Chicken chiken29 = new Chicken(ChickennName[29],age[29]);
       Chicken chiken30 = new Chicken(ChickennName[30],age[30]);
        Chicken chiken31 = new Chicken(ChickennName[31],age[31]);
        Chicken chiken32 = new Chicken(ChickennName[32],age[32]);
        Chicken chiken33 = new Chicken(ChickennName[33],age[33]);
        Chicken chiken34 = new Chicken(ChickennName[34],age[34]);
        Chicken chiken35 = new Chicken(ChickennName[35],age[35]);
        Chicken chiken36 = new Chicken(ChickennName[36],age[36]);
        Chicken chiken37 = new Chicken(ChickennName[37],age[37]);
        Chicken chiken38 = new Chicken(ChickennName[38],age[38]);
        Chicken chiken39 = new Chicken(ChickennName[39],age[39]);
        Chicken chiken40 = new Chicken(ChickennName[40],age[40]);
        Chicken chiken41 = new Chicken(ChickennName[41],age[41]);
        Chicken chiken42 = new Chicken(ChickennName[42],age[42]);
        Chicken chiken43 = new Chicken(ChickennName[43],age[43]);
        Chicken chiken44 = new Chicken(ChickennName[44],age[44]);
        Chicken chiken45 = new Chicken(ChickennName[45],age[45]);
        Chicken chiken46 = new Chicken(ChickennName[46],age[46]);
        Chicken chiken47 = new Chicken(ChickennName[47],age[47]);
        Chicken chiken48 = new Chicken(ChickennName[48],age[48]);
        Chicken chiken49 = new Chicken(ChickennName[49],age[49]);


chiken0.printInfoChicken();

        System.out.println(chiken1.getName()+ " " + chiken1.getAge()+" месяцев");






    }
}
