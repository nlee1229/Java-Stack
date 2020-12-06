import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.List;
import java.util.Arrays;

public class PuzzleJava {
    public static ArrayList <Integer> sumAndGreaterThanTen (int[] arr) {
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        int sum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if (arr[i]>10) {
                myArray.add(arr[i]);
            }
        }
        System.out.println(sum);
        return(myArray);
    }

    public static ArrayList <String> ShuffleArray (List<String> arr) {
        ArrayList <String> myArray = new ArrayList <String>();
        Collections.shuffle(arr);

            for (int i = 0; i < arr.size(); i++) {
                
                System.out.println(arr.get(i));

                if (arr.get(i).length() > 5) {
                    myArray.add(arr.get(i));
                }
            }
                return(myArray);
    }


    public static void ShuffleAlphabet(Character[] arr) {
        ArrayList <Character> myArray = new ArrayList <Character>();
        List <Character> Listy = Arrays.asList(arr);
        Collections.shuffle(Listy);

        Listy.toArray(arr);


        if (arr[0] == 'a' || arr[0] == 'e' || arr[0] == 'i' || arr[0] == 'o' || arr[0] == 'u') {
            System.out.println(arr[0] + " Sorry, this is a vowel.");
        }
        else {
            System.out.println(arr[0]);
        }

        System.out.println(arr[arr.length-1]);
    }


    public static ArrayList <Integer> random10Frm55to100() {
        //variable r is the instance of random
        Random r = new Random();
        ArrayList <Integer> returnArray = new ArrayList<>();
        for (int i=0; i < 10; i++); {
            returnArray.add(r.nextInt(45) + 55);
        }
        return returnArray;
    }

    public static ArrayList <Integer> randomNumberSort() {
        Random r = new Random();
        ArrayList <Integer> sortNum = new ArrayList <Integer>();
        for (int i=0; i < 10; i++) {
            sortNum.add(r.nextInt(45) + 55);
        }
        Collections.sort(sortNum);
        System.out.println(sortNum);
        System.out.println(sortNum.get(0));
        System.out.println(sortNum.get(sortNum.size()-1));
        return (sortNum);
        }

    public static String randomString() {
        String dino = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder string = new StringBuilder();
        Random rand = new Random();
        
        for (int i = 0; i < 5; i++) {
            //gets a random number between 1 & the length of the alphabet
            int index = rand.nextInt(dino.length());
            // the value of index is set to method random. and that radnom is getting the random number from dino. Char yum is getting a char at that index
            char yum = dino.charAt(index);
            // creating a string from each char. that it gets from the for loop
            string.append(yum);
        }
        String rope = string.toString();
        return (rope); 
    }

    public static String[] tenRandomString() {
        String[] array = new String[10];
        for (int i = 0; i < 10; i++) {
            // randomString is coming from the previous method
            array[i] = randomString();
        }
        return(array);
    }
}
