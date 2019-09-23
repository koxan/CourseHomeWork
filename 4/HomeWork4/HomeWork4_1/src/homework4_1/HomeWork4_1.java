
package homework4_1;


public class HomeWork4_1 {

    
    public static void main(String[] args) {
          int num, a;
  	for(num = 2; num <= 100; num++) {
  		for(a = 2; (num % a) > 0; a++) {
  		}
  		if(a == num) 
                    System.out.println("Простое число : "+num);
  	}
    }
    }
