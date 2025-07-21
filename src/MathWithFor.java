package src;
public class MathWithFor {

    public static void main(String[] args){
        final int FACTOR = 7;
        final int MAX_MULTIPLIER = 12;

        for (int i = 1; i <= MAX_MULTIPLIER; i++){
            int product = FACTOR * i;
            System.out.printf("%d x %d = %d%n", FACTOR, i, product);
        }
    }
}
//We can always replace the factor and get the multiplication table for all numbers