
package homework5;


public class HomeWork5 {

    
    public static void main(String[] args) {
        
        int count = 0;
        int position = 0;
        int[] arr1 = {0,1,1,1,0,0,0,0,0,0,0};
        int[] arr2 = new int[arr1.length + 1]; //
        System.out.println("Дан массив: ");

        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + ", ");
        }

        if (arr1[0] == 1) {
            arr2[position++] = 0;
        }
        

        count = 1;
        int prevValue = arr1[0];
        for (int i = 1; i < arr1.length; ++i)   {
            if (arr1[i] == prevValue)   {
                count++;

                if (arr1.length - 1 == i) {
                    arr2[position] = count;
                    break;
                }

            } else {
                arr2[position] = count;
                count = 1;
                position++;
            }

            prevValue = arr1[i];
        }

        System.out.println();
        for (int i = 0; i < position + 1; ++i) {
            System.out.print(arr2[i] + "; ");
        }
    }
    
}
