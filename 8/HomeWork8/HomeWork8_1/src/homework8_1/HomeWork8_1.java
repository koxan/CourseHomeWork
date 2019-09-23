
package homework8_1;

import java.util.Random;
import java.util.Scanner;


public class HomeWork8_1 {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Введите ширину 1й матрицы");
        int size1 = scan.nextInt();
        System.out.println("Введите длину 1й матрицы:");
        int size2 = scan.nextInt();
        int value=0;
        int value1=0;
        int count=-1;
        
        int[][] mat1 = new int[size1][size2];
        
        System.out.println("Введите ширину 2й матрицы:");
    int size3= scan.nextInt();
    System.out.println("Введите длину 2й матрицы:");
    int size4= scan.nextInt();
    
        int[][] mat2= new int[size3][size4];
        int[][] mat3;
        
        if(size1==size3&&size2==size4&&size1!=0&&size2!=0&&size3!=0&&size4!=0){
        
        
        for(int i =0;i<size1;i++){
        for(int j=0;j<size2;j++){
            mat1[i][j]= rand.nextInt(20);
           
            
            System.out.print(mat1[i][j]+";");
            
          }
            System.out.println("");
        }
        System.out.println("");
        
        for(int i =0;i<size3;i++){
        for(int j=0;j<size4;j++){
            mat2[i][j]= rand.nextInt(20);
           
            
            System.out.print(mat2[i][j]+";");
            
          }
            System.out.println("");
        }
            System.out.println("");
            System.out.println("Полученный массив суммы:");
        for (int i = 0; i < size1; ++i) {
	for (int j = 0; j < size2; ++j) {
            value=mat1[i][j] ;
            value1=mat2[i][j];
            ++count;
            if(count==size2){
                System.out.println("");
                count=0;
            }
            
	
           System.out.print(value+value1+"; ");
			}
		}
        }
        else{
            
            System.out.println("Введите массивы с равной шириной и длиной для сложения.");
        
        }
}
    
}
