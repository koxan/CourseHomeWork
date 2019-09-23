
package homework8_2;

import java.util.Random;
import java.util.Scanner;


public class HomeWork8_2 {

    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Введите ширину 1й матрицы:");
        int size1=scan.nextInt();
        System.out.println("Введите длину 1й матрицы:");
        int size2=scan.nextInt();
        System.out.println("Введите ширину 2го массива:");
        int size3=scan.nextInt();
        System.out.println("Введите длину 2го массива:");
        int size4=scan.nextInt();
        int [][] mat1 = new int[size1][size2];
        int [][] mat2 = new int[size3][size4];
        
       int m = mat1.length;
        int n = mat2[0].length;
        int o = mat2.length;
        int[][] res = new int[m][n];
        
        
        if(size1==size4){
            System.out.println("1й массив----->");
        for(int i = 0;i<size1;i++){
        for(int j =0;j<size2;j++){
        mat1[i][j]= rand.nextInt(20);
        
            System.out.print(mat1[i][j]+" ; ");
        }
            System.out.println("");
        }
        System.out.println("");
        System.out.println("2й массив------>");
        
        for(int i = 0;i<size3;i++){
        for(int j =0;j<size4;j++){
        mat2[i][j]=rand.nextInt(20);
        
            System.out.print(mat2[i][j]+" ; ");
        }
            System.out.println("");
        }
            System.out.println("");
            System.out.println("  Умноженный массив:");
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < o; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j]; 
                }
            }
        }
        
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.format("%6d ", res[i][j]);
            }
            System.out.println();
        }
           
        }else{
            System.out.println("Длина 1й матрицы должна быть равна ширине 2й матрицы.");
        }
        
        
        
    }
    
}
