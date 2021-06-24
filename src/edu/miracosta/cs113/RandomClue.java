package edu.miracosta.cs113;

/**
 * RandomClue.java : Your job is to ask your AssistantJack and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where a set of random numbers is generated every attempt until all three
 * random numbers match the solution from the AssistantJack object.
 *
 * This is a sample solution, a driver using random number implementation.
 * You can use this file as a guide to create your own SEPARATE driver for
 * your implementation that can solve it in <= 20 times consistently.
 *
 * @author Nery Chapeton-Lamas (material from Kevin Lewis)
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class RandomClue {

    /* 
     * ALGORITHM: (*** New ***: i have to find a way that the case is solved in less than 20 cases each time)
     *
     *	1). Prompt the the user for witch theory they would like to test(1,2,3)
     *	2). Read in the answer they choose for answerSet
     *	3). INSTANTIATE jack = new AssistantJack(answerSet)
     *	4). To test for solution (the random may have to be removed)
     *	5). Bring "solution = jack.checkAnswer(weapon, location, murder);" outside the do-while loop
     *  6). Keep looping as long as there is not a perfect match with the solution. 
     *  7). Display results to user.
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder = 1, weapon = 1, location = 1 ;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would you like to test? (1, 2, 3[random]): "); // correction on sentence format. 
        answerSet = keyboard.nextInt();
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);
        
        solution = jack.checkAnswer(weapon, location, murder); // pulling outside the loop to check
        													   // for base .checkAnswer(1,1,1) * Note: need to assign variables to 1 for starting value.
        
        // Caution : changing do-while to a while loop because i don't want to loop at least once before checking the solution 
        while(solution != 0) { // this will keep looping as long as there is not a perfect match 
        	
        	// changing the random so i don't get over a maximum of 20 cases each time. 
        	switch (solution) {
        		case 1:
        			weapon++; //trying next weapon
        			break;
        		case 2:
        			location++; // trying next location 
        			break;
        		case 3:
        			murder++;  //trying next murder
        			break;
        	
        	/*weapon = random.nextInt(6) + 1;
            location = random.nextInt(10) + 1;
            murder = random.nextInt(6) + 1;*/
        	}
        	solution = jack.checkAnswer(weapon, location, murder);
            
        }

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}