
package homework8_3;

import java.util.Random;
import java.util.Scanner;


public class HomeWork8_3 {

    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Введите ширину матрицы:");
        int size1 = scan.nextInt();
        System.out.println("Введите длину матрицы:");
        int size2 = scan.nextInt();
        System.out.println("Введите число,на которое хотите умножить матрицу:");
        int value=scan.nextInt();
        int value1=0;
        
        int count=-1;
        
        int[][] mat1 = new int[size1][size2];
        
        
        int[][] mat3;
        
        
        if(size1!=0&&size2!=0){
        
        for(int i =0;i<size1;i++){
        for(int j=0;j<size2;j++){
            mat1[i][j]= rand.nextInt(20);
           
            
            System.out.print(mat1[i][j]+";");
            
          }
        
            System.out.println("");
           }
        System.out.println("");
        System.out.println("Умноженный массив:");
        for(int i =0;i<size1;i++){
        for(int j=0;j<size2;j++){
            value1=mat1[i][j];
            ++count;
            if(count==size2){
                System.out.println("");
                count=0;
            }
            
            System.out.print((value1*value)+";");
        }
            
          }
        
        }else{
            System.out.println("Введите корректный массив:");
        }
    
}
}
