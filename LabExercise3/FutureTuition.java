package labExercise3;
// @author justinmahendra
public class FutureTuition{
    public static void main(String[] args){
        double tuition = 10000; // Year 0
        int year = 0;
        while(tuition < 20000){ // Loops until value of tuition is close enough to 20000.
            tuition = tuition * 1.07; // Multiply tuition by 1.07 % every loop
            year++; // Adds +1 into year every loop
        }
        System.out.println("Tuition will be doubled in " + year + " years"); // Show user output
        System.out.printf("Tuition will be $%.2f in %1d years",tuition, year);
    }
}

