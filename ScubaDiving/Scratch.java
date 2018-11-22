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
        maxDepth = depths[depths.length-2];
        int depth2 = inputCheck("Please input depth value between ( 1 - "+maxDepth+" ) meters : " , 1 , maxDepth);
        depth2 = RoundUp(depth2,depths);
        System.out.println("Depth of " + depths[depth2] + " meters has max No Decompression Limit of " + andl[depth2] + " minutes\n");

        int time2 = inputCheck("Please input actual bottom time value between ( 1 - "+ abt[depth2][abt[depth2].length-1] +" ) minutes : " , 1 , abt[depth2][abt[depth2].length-1]);
        time2 = RoundUp(time2,abt[depth2]);
        System.out.println("Minimum Pressure Group required for Second Dive = " + pressureGroup[ (abt[depth2].length-1) - time2]);
        // End of Second Dive
        
        // Display Surface Interval to User
        System.out.println("Surface Interval : " + surfaceTime[time][(abt[depth2].length-1) - time2]);
        // End of Display Surface Interval
        
        
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
        System.out.println("Pressure Group after this dive : " + pressureGroup[a] + "\n");
    }
    // Get newPressureGroup after user input surfaceInterval
    static void getNewPressureGroup(int oldPressureGroup,int surfaceInterval){
        
    }
    
    
    
    // Array Declaration
    public static String[] pressureGroup  = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    public static int[] depths = {10,12,14,16,18,20,22,25,30,35,40,42};
    public static int[] andl   = {209,138,90,65,50,39,32,25,17,11,7};
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
    public static int[][] abt = 
        {{20,41,59,74,86,97,107,115,124,131,137,144,149,155,160,165,169,174,178,182,185,189,193,199,209}, // 10
        {13,22,31,39,46,53,59,65,71,76,81,85,90,94,98,102,105,109,112,115,118,121,124,130,138}, // 12
        {6,11,16,21,25,30,34,37,41,45,48,51,55,58,61,63,66,69,71,74,76,79,83,90}, // 14
        {2,5,9,12,16,19,22,24,27,30,33,35,38,49,43,45,47,49,51,53,55,59,65}, // 16
        {3,5,8,10,13,15,17,20,22,24,26,28,39,32,34,36,38,40,41,45,50}, // 18
        {3,5,7,9,11,13,15,17,19,20,22,24,25,27,29,30,32,35,39}, // 20
        {3,5,7,8,10,12,13,15,16,18,19,21,22,24,25,28,32}, // 22
        {3,4,6,7,8,10,11,12,14,15,16,18,19,21,25}, // 25
        {3,4,5,6,7,8,9,10,11,12,14,17}, // 30
        {3,4,5,5,6,7,9,11}, // 35
        {4,7}}; // 40
    public static String[][] surfaceTime = 
            {{"0:00 to 3:00"}, // A
            {"0:48 to 3:48", "0:00 to 0:47"}, // B
            {"1:10 to 4:10", "0:22 to 1:09", "0:00 to 0:21"}, // C
            {"1:19 to 4:19", "0:31 to 1:18", "0:09 to 0:30", "0:00 to 0:08"}, // D
            {"1:38 to 4:28", "0:39 to 1:27", "0:17 to 0:38", "0:08 to 0:16", "0:00 to 0:07"}, // E
            {"1:35 to 4:35", "0:47 to 1:34", "0:25 to 0:46", "0:16 to 0:24", "0:08 to 0:15", "0:00 to 0:07"}, // F
            {"1:42 to 4:42", "0:54 to 1:41", "0:32 to 0:53", "0:23 to 0:31", "0:14 to 0:22", "0:07 to 0:13", "0:00 to 0:06"}, // G
            {"1:48 to 4:48", "1:00 to 1:47", "0:38 to 0:59", "0:29 to 0:37", "0:21 to 0:28", "0:13 to 0:20", "0:06 to 0:12", "0:00 to 0:05"}, // H
            {"1:54 to 4:54", "1:06 to 1:53", "0:44 to 1:05", "0:35 to 0:43", "0:27 to 0:34", "0:19 to 0:26", "0:12 to 0:18", "0:06 to 0:11", "0:00 to 0:05"}, // I
            {"2:00 to 5:00", "1:12 to 1:59", "0:50 to 1:11", "0:41 to 0:49", "0:32 to 0:40", "0:25 to 0:31", "0:18 to 0:24", "0:12 to 0:17", "0:06 to 0:11", "0:00 to 0:05"}, // J
            {"2:05 to 5:05", "1:17 to 2:04", "0:55 to 1:16", "0:46 to 0:54", "0:38 to 0:45", "0:30 to 0:37", "0:23 to 0:29", "0:17 to 0:22", "0:11 to 0:16", "0:05 to 0:10", "0:00 to 0:04"}, // K
            {"2:10 to 5:10", "1:22 to 2:09", "1:00 to 1:21", "0:51 to 0:59", "0:43 to 0:50", "0:35 to 0:42", "0:28 to 0:34", "0:22 to 0:27", "0:16 to 0:21", "0:10 to 0:15", "0:05 to 0:09", "0:00 to 0:04"}, // L
            {"2:15 to 5:15", "1:26 to 2:14", "1:05 to 1:25", "0:56 to 1:04", "0:47 to 0:55", "0:40 to 0:46", "0:33 to 0:39", "0:26 to 0:32", "0:20 to 0:25", "0:15 to 0:19", "0:10 to 0:14", "0:05 to 0:09", "0:00 to 0:04"}, // M
            {"2:19 to 5:19", "1:31 to 2:18", "1:09 to 1:30", "1:00 to 1:08", "0:52 to 0:59", "0:44 to 0:51", "0:37 to 0:43", "0:31 to 0:36", "0:25 to 0:30", "0:19 to 0:24", "0:14 to 0:18", "0:09 to 0:13", "0:04 to 0:08", "0:00 to 0:03"}, // N
            {"2:24 to 5:24", "1:35 to 2:23", "1:13 to 1:34", "1:04 to 1:12", "0:56 to 1:03", "0:48 to 0:55", "0:42 to 0:47", "0:35 to 0:41", "0:29 to 0:34", "0:24 to 0:28", "0:18 to 0:23", "0:13 to 0:17", "0:09 to 0:12", "0:04 to 0:08", "0:00 to 0:03"}, // O
            {"2:28 to 5:28", "1:39 to 2:27", "1:17 to 1:38", "1:08 to 1:16", "1:00 to 1:07", "0:52 to 0:59", "0:46 to 0:51", "0:39 to 0:45", "0:33 to 0:38", "0:28 to 0:32", "0:22 to 0:27", "0:17 to 0:21", "0:13 to 0:16", "0:08 to 0:12", "0:04 to 0:07", "0:00 to 0:03"}, // P
            {"2:31 to 5:31", "1:43 to 2:30", "1:21 to 1:42", "1:12 to 1:20", "1:04 to 1:11", "0:56 to 1:03", "0:49 to 0:55", "0:43 to 0:48", "0:37 to 0:42", "0:31 to 0:36", "0:26 to 0:30", "0:21 to 0:25", "0:17 to 0:20", "0:12 to 0:16", "0:08 to 0:11", "0:04 to 0:07", "0:00 to 0:03"}, // Q
            {"2:25 to 5:35", "1:47 to 2:34", "1:25 to 1:46", "1:16 to 1:24", "1:08 to 1:15", "1:00 to 1:07", "0:53 to 0:59", "0:47 to 0:52", "0:41 to 0:46", "0:35 to 0:40", "0:30 to 0:39", "0:25 to 0:29", "0:20 to 0:24", "0:16 to 0:19", "0:12 to 0:15", "0:08 to 0:11", "0:04 to 0:07", "0:00 to 0:03"}, // R
            {"2:39 to 5:39", "1:50 to 2:38", "1:28 to 1:49", "1:19 to 1:27", "1:11 to 1:18", "1:04 to 1:10", "0:57 to 1:03", "0:50 to 0:56", "0:44 to 0:49", "0:39 to 0:43", "0:33 to 0:38", "0:28 to 0:32", "0:24 to 0:27", "0:19 to 0:23", "0:15 to 0:18", "0:11 to 0:14", "0:07 to 0:10", "0:04 to 0:06", "0:00 to 0:03"}, // S
            {"2:42 to 5:42", "1:54 to 2:41", "1:32 to 1:53", "1:23 to 1:31", "1:14 to 1:22", "1:07 to 1:13", "1:00 to 1:06", "0:54 to 0:59", "0:48 to 0:53", "0:42 to 0:47", "0:37 to 0:41", "0:32 to 0:36", "0:27 to 0:31", "0:23 to 0:26", "0:18 to 0:22", "0:14 to 0:17", "0:10 to 0:13", "0:07 to 0:10", "0:03 to 0:06", "0:00 to 0:02"}, // T
            {"2:45 to 5:45", "1:57 to 2:44", "1:35 to 1:56", "1:26 to 1:34", "1:18 to 1:25", "1:10 to 1:17", "1:03 to 1:09", "0:57 to 1:02", "0:51 to 0:51", "0:45 to 0:50", "0:40 to 0:44", "0:35 to 0:39", "0:30 to 0:34", "0:26 to 0:29", "0:22 to 0:25", "0:18 to 0:18", "0:14 to 0:17", "0:10 to 0:13", "0:07 to 0:09", "0:03 to 0:06", "0:00 to 0:02"}, // U
            {"2:48 to 2:48", "2:00 to 2:47", "1:38 to 1:59", "1:29 to 1:37", "1:21 to 1:28", "1:13 to 1:20", "1:06 to 1:12", "1:00 to 1:05", "0:54 to 0:59", "0:48 to 0:53", "0:43 to 0:47", "0:38 to 0:42", "0:34 to 0:37", "0:29 to 0:33", "0:25 to 0:28", "0:21 to 0:24", "0:17 to 0:20", "0:13 to 0:16", "0:10 to 0:12", "0:06 to 0:09", "0:03 to 0:05", "0:00 to 0:02"}, // V
            {"2:51 to 5:51", "2:03 to 2:50", "1:41 to 2:02", "1:32 to 1:40", "1:24 to 1:31", "1:16 to 1:23", "1:09 to 1:15", "1:03 to 1:08", "0:57 to 1:02", "0:51 to 0:56", "0:46 to 0:50", "0:41 to 0:45", "0:37 to 0:40", "0:32 to 0:36", "0:28 to 0:31", "0:24 to 0:27", "0:20 to 0:23", "0:16 to 0:19", "0:13 to 0:15", "0:09 to 0:12", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}, // W
            {"2:54 to 5:54", "2:06 to 2:53", "1:44 to 2:05", "1:35 to 1:43", "1:27 to 1:34", "1:19 to 1:26", "1:12 to 1:18", "1:06 to 1:11", "1:00 to 1:05", "0:54 to 0:59", "0:49 to 0:53", "0:44 to 0:48", "0:40 to 0:43", "0:35 to 0:39", "0:31 to 0:34", "0:27 to 0:30", "0:23 to 0:26", "0:19 to 0:22", "0:16 to 0:18", "0:12 to 0:15", "0:09 to 0:11", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}, // X
            {"2:57 to 5:57", "2:09 to 2:56", "1:47 to 2:08", "1:38 to 1:46", "1:30 to 1:37", "1:22 to 1:29", "1:15 to 1:21", "1:09 to 1:14", "1:03 to 1:08", "0:57 to 1:02", "0:52 to 0:56", "0:47 to 0:51", "0:42 to 0:46", "0:38 to 0:41", "0:34 to 0:37", "0:30 to 0:33", "0:26 to 0:29", "0:22 to 0:25", "0:19 to 0:21", "0:15 to 0:18", "0:12 to 0:14", "0:09 to 0:11", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}, // Y
            {"3:00 to 6:00", "2:12 to 2:59", "1:50 to 2:11", "1:41 to 1:49", "1:32 to 1:40", "1:25 to 1:31", "1:18 to 1:24", "1:12 to 1:17", "1:06 to 1:11", "1:00 to 1:05", "0:55 to 0:59", "0:50 to 0:54", "0:45 to 0:49", "0:41 to 0:44", "0:36 to 0:40", "0:32 to 0:35", "0:29 to 0:31", "0:25 to 0:28", "0:21 to 0:24", "0:18 to 0:20", "0:15 to 0:17", "0:12 to 0:14", "0:09 to 0:11", "0:06 to 0:08", "0:03 to 0:05", "0:00 to 0:02"}}; // Z
    
}
