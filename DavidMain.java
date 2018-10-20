/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojectpsb;
import java.util.Scanner;
/**
 *
 * @author david
 */
public class MiniProjectPSB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        
        FindSurfaceTime fst = new FindSurfaceTime();
        UseSurfaceTime ust = new UseSurfaceTime();
        
        System.out.println("Select one input output option: ");
        System.out.println("1. Input depth, Input bottom time, Input repetetive dive's depth, Input repetitive dive's bottom time, Output Surface time");
        System.out.println("2. Input depth, Input bottom time, Input surface time,Input repetetive dive's depth, Output NDL, Output pressure group");
        System.out.print("(1/2): ");
        int option = input.nextInt();
        
        if (option == 1){
            fst.main(args);
        }else if (option == 2){
            ust.main(args);
        }
    }
    
}
