import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PuzzleJavaTest {
    public static void main(String[] args) {

        // Create an array with the following values: 3,5,1,2,7,9,8,13,25,32. Print the sum of all numbers in the array. Also have the function return an array that only includes numbers that are greater than 10 (e.g. when you pass the array above, it should return an array with the values of 13,25,32)

        int[] array1 = {1,-6,9,51,20};
        ArrayList <Integer> newArray = new ArrayList <Integer>();
        newArray = PuzzleJava.sumAndGreaterThanTen(array1); 
        System.out.println(newArray);

         // Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.

        String[] array2 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        List <String> Listy = Arrays.asList(array2);
        ArrayList <String> newArray2 = new ArrayList <String>(); 
        newArray2 = PuzzleJava.ShuffleArray(Listy);
        System.out.println(newArray2);

        // Create an array that contains all 26 letters of the alphabet (this array must have 26 values). Shuffle the array and, after shuffling, display the last letter from the array. Have it also display the first letter of the array. If the first letter in the array is a vowel, have it display a message.

        Character[] array3 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        PuzzleJava.ShuffleAlphabet(array3);

    //     Generate and return an array with 10 random numbers between 55-100.
    //     To get a random integer, you can use the nextInt method of the   Random class. 
        
        ArrayList <Integer> array4 = PuzzleJava.random10Frm55to100();
        System.out.print(array4);

        // Generate and return an array with 10 random numbers between 55-100 and have it be sorted (showing the smallest number in the beginning). Display all the numbers in the array. Next, display the minimum value in the array as well as the maximum value.

        ArrayList <Integer> array5 = new ArrayList <Integer>();
        array5 = PuzzleJava.randomNumberSort();
        System.out.println(array5);


        // Create a random string that is 5 characters long.\
        
        String stringRope = PuzzleJava.randomString();
        System.out.println(stringRope);

        // Generate an array with 10 random strings that are each 5 characters long
        String [] GenString = PuzzleJava.tenRandomString();
        //"Arrays.toString(GenString)"... converts the array of strings into a string 
        System.out.println(Arrays.toString(GenString));
    }
}