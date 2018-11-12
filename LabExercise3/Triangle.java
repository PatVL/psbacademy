package labExercise3;
// @author justinmahendra
import java.util.Scanner;

public class Triangle {
    public static Scanner keyboard = new Scanner(System.in); // Declare Scanner
    public static void main(String[] args){
        
        System.out.print("Please input an Integer : ");
        int N = keyboard.nextInt(); // Saving input into integer N
        
        for (int i = -N; i <= N; i++) { // Starts from -N to N so formula is (2N + 1)
            for (int j = -N; j <= N; j++) {
                if (Math.abs(i)+Math.abs(j) <= N) { // Absolute i + Absolute j less than N print *
                    System.out.print("* ");
                }
                else{
                    System.out.print(". "); // Else print . 
                }
            }
            System.out.println(); // Put Spaces this for loop
        }
    } 
}
