import java.util.ArrayList;

public class Basics {
    //void bc we're not returning anything. Static is saying that the varibla or method is going to be the same for every instance of a class.
    public void oneToTwoFiftyFive() {
        for (int i = 1; i<=255; i++) {
            System.out.print(i + "\n");
        }
    }

    public void oddOneToTwoFiftyFive() {
        for (int i = 1; i <=255; i+=2) {
            System.out.print(i + "\n");
        }
    }

    public void sum() {
        int sum = 0;
        for (int i = 0; i <=255; i++) {
            System.out.println(i);
            System.out.println(sum +=i);
        }
    }

    public void iterate(int[] arr) {
        for (int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void findMax(int[] array) {
        int num = 0;
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[num] < array[i]) {
                num = i;
            } 
            else {
                continue;
            }
        }
        max = array[num];
        System.out.println(max);
    }
    
    public void getAverage(int[] array) {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total = total + array[i]; 
        }
        total = total/array.length;
        System.out.println(total);
    }

    public void arrayWithOddNumbers() {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i = 1; i <= 255; i++) {
            if (i % 2 == 0) {
                continue;
            }
            else {
                myArray.add(i);
            }
        }
        System.out.println(myArray);
    }
    
    public void greaterThanY(int[] array, int y) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > y ) {
                total = total + 1;
            }
        }
        System.out.println(total); 
    }

    public void squareTheValues(int[] array) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            myArray.add(array[i] *= array[i]);
        }
        System.out.println(myArray);
    }

    public void eliminateNegNumbers(int[] array) {
        
    }

    public void maxMinAvg(int[] array) {
        ArrayList <Integer> arrX = new ArrayList<Integer>();

        //find maximum value
        int num = 0; 
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[num] < array[i]) {
                num = i;
            } 
            else {
                continue;
            }
        }
        max = array[num];
        arrX.add(max);

        //Find minimum value
        int minNum = 0;
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[minNum] > array[i]) {
                minNum = i;
            }
        }
        min = array[minNum];
        arrX.add(min);

        //Find average value
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total = total + array[i]; 
        }
        total = total/array.length;
        arrX.add(total);
        
        System.out.println(arrX);
    }

    public void shiftingValues(int[] array) {
        ArrayList <Integer> arrX = new ArrayList<Integer>();

        int temp = array[0];

        //in our for loop, we are shifting all of the numbers of the index to the left
        for (int i = 0; i < array.length - 1; i++) {
            //for ex, if i = 0, array[0] = to the next following array, which in this case is array[i]
            array[i] = array[i+1];
            arrX.add(array[i]);
        }

        arrX.add(array[array.length - 1] = temp);
        System.out.println(arrX);
    }
}


