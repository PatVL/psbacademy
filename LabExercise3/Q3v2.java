package labExercise3;
// @author justinmahendra
import java.util.Scanner;
public class Q3v2 {
    public static Scanner keyboard = new Scanner(System.in); // Declare Scanner
    public static void main(String[] args){
        String decrypted = "";
        String decrypt = "Xxxic meui itv OEYF swsjweprmql";
        char character;
        int shift = 5;
        int aShift = 0; // Alternating Shift 
        System.out.println("Text  : " + decrypt); 
        System.out.println("Key : " + shift); 
        for(int i = 0; i < decrypt.length(); ++i){
            if (i == 0 || i % 3 == 0) { // 0 , 3 ,6
                aShift = shift;
            }
            else if (i == 1 || i % 3 == 1) { // 1 , 4 , 7
                aShift = shift - 1;
            }
            else if(i == 2 || i % 3 == 2){
                aShift = shift - 2;   // Is the algorithm broken??? it isnt N+1
            }   
            character = decrypt.charAt(i);
            if(character>= 'a' && character<= 'z'){ // Check if charactrer is between a - z
                character = (char)(character - aShift);     
                if(character < 'a'){ // If character is below 'a' read from behind z y x w v u t
                    character= (char)(character + 'z' - 'a' + 1);
                }decrypted += character; // Save shifted character into decrypted
            }
            else if(character >= 'A' && character <= 'Z'){ // Check if character is between A - Z
                character = (char)(character - aShift);
                if(character < 'A'){
                character = (char)(character + 'Z' - 'A' + 1); // If character is below A read from behind Z Y X W V U T
                }     
                decrypted += character; // Save shifted character into decrypted
            } 
            else{decrypted += character;} // Save shifted character into decrypted   
        }
        System.out.println("Decrytped Message : "+decrypted);  // Print out Decrypted Message
    }
}
