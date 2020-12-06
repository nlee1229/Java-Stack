public class PythagoreanTest {
    public static void main(String[] args) {
        int legA = 2;
        int legB = 6;
        // Pythagorean is our class. We are accessing that class in our test file. We are able to do this because our class is public. iD is just our variable name. And the new just means it is making a copy of the class?***
        Pythagorean iD = new Pythagorean();
        double calculateHypotenuse = iD.calculateHypotenuse(legA, legB);
        System.out.println(calculateHypotenuse);
    }
}
