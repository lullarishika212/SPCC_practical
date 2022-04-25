import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public  class CodeOptimization {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int no_of_instructions;
        System.out.print("\nEnter number of instructions: ");
        no_of_instructions = sc.nextInt();
	
	  System.out.println("\nEnter the instructions:");
        Set<String> set1 = new HashSet<>();
        for(int i = 0; i < no_of_instructions; i ++){
            String instruction = sc.next();
            String[] result = instruction.split("=");

            if(!set1.contains(result[1])){
                set1.add(result[1]);
            }
        }

        System.out.println("\n**Optimimized Code:**\n ");
        int i = 1;
        for(String str : set1){
            System.out.println("t" + i + " = " + str);
            i = i + 1;
        }
    }
}