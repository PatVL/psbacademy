import java.util.Scanner;

public class testPlatform2 {
    public static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args){
        String[] pg        = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int[]   depths     = {10,12,14,16,18,20,22,25,30,35,40,42};
        int[][] bottomTime = 
            {{10,20,26,30,34,37,41,45,50,54,59,64,70,75,82,88,95,104,112,122,133,145,160,178,199,219}, // 10
            {9,17,23,26,29,32,35,38,42,45,49,53,57,62,66,71,76,82,88,94,101,108,116,125,134,147}, // 12
            {8,15,19,22,24,27,29,32,35,37,40,43,47,50,53,57,61,64,68,73,77,82,87,92,98}, // 14
            {7,13,17,19,21,23,25,27,29,32,34,37,39,42,45,48,50,53,56,60,63,67,70,72}, // 16
            {6,11,15,16,18,20,22,24,26,28,30,32,34,36,39,41,43,46,48,51,53,55,56}, // 18
            {6,10,13,15,16,18,20,21,23,25,26,28,30,32,34,36,38,40,42,44,45}, // 20
            {5,9,12,13,15,16,18,19,21,22,24,25,27,29,30,32,34,36,37}, // 22
            {4,8,10,11,13,14,15,17,18,19,21,22,23,25,26,28,29}, // 25
            {3,6,8,9,10,11,12,13,14,15,16,17,19,20}, // 30
            {3,5,7,8,-1,9,10,11,12,13,14}, // 35
            {-1,5,6,-1,7,8,9}, // 40
            {-1,4,-1,6,7,8}}; // 42
            
            // Needs code improvements.
            // Change long variables.
            int mDives = inputCheck("How many dives : ","stop inputting shits", 1 , 4);
            int[] multi_depth = new int[mDives];
            int[] multi_time  = new int[mDives];
            int[] return_time = new int[mDives]; // Remove this. Why would you want to save Pressure Groups.
            
            for (int i = 0; i < multi_depth.length; i++) {
                int depth = inputCheck("Input depth value : ","Input number between (0 - 42) meters", 0 , 42 );
                int[] returnDepth = RoundUp(depth,depths);  // Rounding up input to the nearest depth
                multi_depth[i] = returnDepth[0];    // Saves rounded depth for easy access later on
                System.out.println(returnDepth[0]+" meters has NDL of "+bottomTime[returnDepth[1]][bottomTime[returnDepth[1]].length-1]+" minutes");
                
                int times = inputCheck("Input bottom time : ","Input number between (0 - "+bottomTime[returnDepth[1]][bottomTime[returnDepth[1]].length-1]+")", 0 ,bottomTime[returnDepth[1]][bottomTime[returnDepth[1]].length-1]);
                int returnTime = time(returnDepth[1],bottomTime,times);
                return_time[i] = returnTime;
                multi_time[i] = bottomTime[returnDepth[1]][returnTime];
                System.out.println("Actual bottom time = "+bottomTime[returnDepth[1]][returnTime]+" minutes");
                System.out.println("Pressure Group after Dive = "+pg[returnTime]); // Remove this. Doesnt work for multiple dives

            }
            System.out.println("\n\nCheck Array Values");
            for (int i = 0; i < multi_depth.length; i++) {
                System.out.print(multi_depth[i]+" meters");
                System.out.print(" and ABT of "+multi_time[i]+" minutes");
                System.out.println(" and Pressure Group of "+pg[return_time[i]]); // Remove this
            }
 
            
            
        
    }
    public static int[] RoundUp(int i, int[] array){
        int a = 0;
        int b = 0;
        for(int count=0;count<array.length;count++){
            if (i<=array[count]){
                a = array[count]; // Returns rounded up time value
                b = count;  // Returns the value of the location from the array
                break;
            }
        }
        return new int[] {a,b};
    }
    
    // Prevents user from inputting random things except what is needed.
    // showUser     : Text to display to guide user for inputs
    // ErrorMessage : If user inputs invalid value, Display custom error message
    // minValue     : Minimum integer value
    // maxValue     : Maximum Integer Value 
    public static int inputCheck(String showUser,String ErrorMessage,int minValue,int maxValue) {
        int input = 0;
        boolean valid = false;
        
        do{
        System.out.print(showUser);
        if(keyboard.hasNextInt()){
           input = keyboard.nextInt();
            if (input < minValue || input > maxValue) {
                System.out.println(ErrorMessage);
            }else  {
                valid = true;
            }
        }
        else{
            System.out.print("Not a valid input!\n");
            keyboard.next();
        }
        }while(valid == false);
        return input;
    }
    
    // Change this into RoundTime to simplify code.
    public static int time(int i ,int[][] array,int j){
        int round_time = 0;
        // System.out.print("Input Actual Bottom Time = ");
        // int time = keyboard.nextInt();
        // Rounding Up to the Nearest Time
        for (int b = 0; b <= array[i].length; b++) {
            if (j <= array[i][b]) {
                round_time = b;
                break;
            }
        }
        return round_time;
    }
}
