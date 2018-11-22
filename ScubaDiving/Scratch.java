package ScubaDiving;

import java.util.Scanner;

public class Scratch {
    public static Scanner keyboard = new Scanner(System.in); // Declare Scanner
    public static void main(String[] args){
        // First Dive     
        int maxDepth = depths[depths.length-1];
        int depth = inputCheck("Please input depth value between ( 1 - "+maxDepth+" ) meters : " , 1 , maxDepth);
        depth = RoundUp(depth,depths);
        System.out.println("Depth of " + depths[depth] + " meters has max No Decompression Limit of " + bottomTime[depth][bottomTime[depth].length - 1] + " minutes\n");
        
        int maxTime  = bottomTime[depth][bottomTime[depth].length-1];       
        int time = inputCheck("Please input actual bottom time value between ( 1 - "+maxTime+" ) minutes : " , 1 , maxTime);
        time = RoundUp(time,bottomTime[depth]);
        getSafetyStop(depth,time);
        
        System.out.println("\nRounded to the nearest time of " + bottomTime[depth][time] + " minutes");
        getPressureGroup(time);
        // End of First Dive
        
        // Second Dive
        int depth2 = inputCheck("Please input depth value between ( 1 - "+depths[Math.abs(depth - 1)]+" ) meters : " , 1 , depths[Math.abs(depth - 1)]);
    }

    // Check's User input
    public static int inputCheck(String display, int minValue, int maxValue) {
        int input = 0;
        boolean valid = false;
        do{
        System.out.print(display);
        if(keyboard.hasNextInt()){
           input = keyboard.nextInt();
            if (input >= minValue && input <= maxValue) {
                valid = true;
                System.out.println("");
            }else {
                System.out.println("Not a valid value");
            }
        }
        else{
            System.out.print("Not a valid input!\n");
            keyboard.next();
        }
        }while(valid == false);
        return input;
    }
    
    // Rounding up a value to the nearest value inside an array.
    public static int RoundUp(int i, int[] array){ 
        int a = 0;
        for(int counter=0;counter<array.length;counter++){
            if (i<=array[counter]){
                a = counter; // Returns rounded up time value
                break;
            }
        }
        return a;
    }
    
    // Check depth and time to find if Safety Stop is needed
    public static void getSafetyStop(int a , int b){
        int depth = depths[a];
        int time  = bottomTime[a][b];
        if ((depth == 10 && time >= 160)
                || (depth == 12 && time >= 116)
                || (depth == 14 && time >= 82)
                || (depth == 16 && time >= 63)
                || (depth == 18 && time >= 51)
                || (depth == 20 && time >= 40)
                || (depth == 22 && time >= 32)
                || (depth == 25 && time >= 25)
                || depth >= 30) {
            System.out.println("Safety stop is REQUIRED for this dive");
        }
        else{
            System.out.println("Safety Stop is not required for this dive");
        }
    }
    
    // Get Pressure Group
    static void getPressureGroup(int a) {
        System.out.println("Pressure Group after this dive : " + pressureGroup[a]);
    }
    // Get newPressureGroup after user input surfaceInterval
    static void getNewPressureGroup(int oldPressureGroup,int surfaceInterval){
        
    }
    
    
    
    // Array Declaration
    public static String[] pressureGroup  = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static int[] depths = {10,12,14,16,18,20,22,25,30,35,40,42};
    public static int[][] bottomTime = 
            {{10,20,26,30,34,37,41,45,50,54,59,64,70,75,82,88,95,104,112,122,133,145,160,178,199,219}, // 10 meters
            {9,17,23,26,29,32,35,38,42,45,49,53,57,62,66,71,76,82,88,94,101,108,116,125,134,147}, // 12 meters
            {8,15,19,22,24,27,29,32,35,37,40,43,47,50,53,57,61,64,68,73,77,82,87,92,98}, // 14 meters
            {7,13,17,19,21,23,25,27,29,32,34,37,39,42,45,48,50,53,56,60,63,67,70,72}, // 16 meters
            {6,11,15,16,18,20,22,24,26,28,30,32,34,36,39,41,43,46,48,51,53,55,56}, // 18 meters
            {6,10,13,15,16,18,20,21,23,25,26,28,30,32,34,36,38,40,42,44,45}, // 20 meters
            {5,9,12,13,15,16,18,19,21,22,24,25,27,29,30,32,34,36,37}, // 22 meters
            {4,8,10,11,13,14,15,17,18,19,21,22,23,25,26,28,29}, // 25 meters
            {3,6,8,9,10,11,12,13,14,15,16,17,19,20}, // 30 meters
            {3,5,7,8,0,9,10,11,12,13,14}, // 35 meters
            {0,5,6,0,7,8,9}, // 40 meters
            {0,4,0,6,7,8}}; // 42 meters
}
