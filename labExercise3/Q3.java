package labExercise3;
// @author justinmahendra
import java.util.Scanner;
public class Q3 {
    public static Scanner keyboard = new Scanner(System.in); // Declare Scanner
    public static void main(String[] args){
        String decrypted = "";
        String decrypt = "Q tqsm bw qvdqbm gwc nwz i tcvkp";
        char character;
        int shift = 8; 
        System.out.println("Text  : " + decrypt); 
        System.out.println("Key : " + shift); 
        for(int i = 0; i < decrypt.length(); ++i){
            character = decrypt.charAt(i);
            if(character>= 'a' && character<= 'z'){ // Check if charactrer is between a - z
                character = (char)(character - shift);     
                if(character < 'a'){ // If character is below 'a' read from behind z y x w v u t
                    character= (char)(character + 'z' - 'a' + 1);
                }decrypted += character; // Save shifted character into decrypted
            }
            else if(character >= 'A' && character <= 'Z'){ // Check if character is between A - Z
                character = (char)(character - shift);
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
