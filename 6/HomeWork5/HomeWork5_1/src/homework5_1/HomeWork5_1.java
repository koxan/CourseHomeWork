
package homework5_1;

import java.util.Scanner;


public class HomeWork5_1 {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размерность массива:");
        int n = scanner.nextInt();

        int array1[] = new int[n];
        for (int i = 0; i < array1.length; i++) {
            System.out.println((i + 1) + " элемент массива:");
            array1[i] = scanner.nextInt();
        }
        int summ = 0;
        for (int i=0;i<array1.length;i++){
            summ += array1[i];
        }
        int array2[] = new int[summ];
        int value=0;
        int flag =0;
        int m=0;
        if (array1[0]==0){
            value=1;
            m++;
        }

        for (int i=m;i<array1.length;i++){

            for (int j=0;j<array1[i];j++){
                array2[flag]=value;
                flag++;
            }
            if (value==0){
                value=1;
            }
            else {
                if (value == 1) value = 0;
            }

        }

        System.out.println("\n\nРаспакованный массив:" + summ);
        for (int i=0;i<array2.length;i++){
            System.out.println((i+1) + " элемент: " + array2[i]);
        }
       
    }
    
}
