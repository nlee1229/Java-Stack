public class BasicsTest {

    public static void main(String[] args) {
        Basics basicTest = new Basics();
        basicTest.oneToTwoFiftyFive();

        basicTest.oddOneToTwoFiftyFive();

        basicTest.sum();

        int[] arrayyy = {5,15,2,5,6,9};
        basicTest.iterate(arrayyy);

        int[] arrayyy2 = {-3, 5, 8, 17};
        basicTest.findMax(arrayyy2);

        int[] arrayyy3 = {2, 10, 3, -5, 9};
        basicTest.getAverage(arrayyy3);
    
        basicTest.arrayWithOddNumbers();

        int[] arrayyy4 = {1,3,-6,9,17,6};
        int y = 7;
        basicTest.greaterThanY(arrayyy4, y);

        int[] arrayyy5 = {6,2,7,-9,10};
        basicTest.squareTheValues(arrayyy5);

        int[] arrayyy6 = {1,2,3,4,5,6};
        basicTest.maxMinAvg(arrayyy6);

        int[] arrayyy7 = {2,5,8,9,5};
        basicTest.shiftingValues(arrayyy7);
    }
}

