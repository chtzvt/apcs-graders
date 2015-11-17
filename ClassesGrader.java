// We need the Scanner class in order to grab input from the user. 
import java.util.Scanner;

//Define the ClassesGrader class. 
public class ClassesGrader
{

	/* This main method is invoked as soon as you run the program. 
	 * This method definition also specifies the kinds of exceptions (more on those later) that it throws.
	 * In this case, InterruptedException must be specified so that Mr.Coleman can call Thread.Sleep() without the compiler complaining.
	 *
	 * Here's a brief introduction to exceptions: http://www.tutorialspoint.com/java/java_exceptions.htm 
	 */ 
	public static void main(String[] args) throws InterruptedException
	{
		// Instantiate (create a new instance of) the Scanner class
		Scanner input = new Scanner(System.in);
		
		// Creates instances of the various assigned classes.
		// (Refer to their respective specs to find the meaning of the arguments passed to the constructors of each class).
		SuperDie die = new SuperDie(4);
		TV tv = new TV();
		Door door = new Door("Certain Dooooooooom");
		Stopwatch sw = new Stopwatch();
		
		/* These three booleans are used to keep track of your passing or failing. 
		 *
		 * These are needed because of the way that grading works in these classes. Here, a series of checks are run, and if at any point during those checks
		 * your program does not produce the expected result, then you have failed. Therefore, it's easy to keep track of your grade because rather than grading the
		 * individual features of your code, either you completely pass, or completely fail (i.e. true or false).  
		 */ 
		boolean passSuperDie = true;
		boolean passTV = true;
		boolean passDoor = true;
		
		System.out.println("For the following answer:\n\t1 for yes\n\t2 for no");
		
		//SuperDie Test
		System.out.print("Do you want to test SuperDie? ");
	
		// Grab the next integer from the Scanner we created earlier.
		// User input corresponds to one of the menu options on the prompt for running the SuperDie test, where 1 = yes, and 2 = no. 
		if(input.nextInt() == 1)
		{
			// The user chose 1, so let's run the test. 			
			// Earlier, we created a die with 4 sides on it. 

			// This integer will store the number of times our die rolls a certain number. 
			int roll = 0;
					
			// Each time we roll a 3, out of 100000 total rolls, increment the value of roll by one. 
			for(int i = 1; i <= 100000; i++)
				if(die.roll() == 3)  
					roll++;

			// If the number of times we rolled a 3 is greater than 26000 or less than 24000, we have failed.
			if(roll > 26000 || roll < 24000)
				passSuperDie = false; 
			
			//Set the number of sides on the die to 20
			die.setSides(20); 
			// Clear the value of roll to prepare it for more tests. 
			roll = 0;
			
			// Another 100000 roll set, again checking for the number 3. 
			for(int i = 1; i <= 100000; i++)
				if(die.roll() == 3)
					roll++;

			// Since there are more sides on the die, the probability of rolling a 3 has decreased. 
			// If the number of times we rolled a 3 is greater than 6000 or less than 4000, we have failed.
			if(roll > 6000 || roll < 4000)
				passSuperDie = false;
			

			// Final check to determine success or failure. 
			// If none of the above checks have run (which would set passSuperDie to false), then congratulations! You passed. 
			if(passSuperDie)
				System.out.println("Pass");
			else
				System.out.println("Fail");
		}

		//TV test		
		System.out.print("\nDo you want to test TV? ");
		
		// Recall the comments on the menu from earlier. 
		if(input.nextInt() == 1)
		{
			// Using the TV we instantiated a while back, we're now going to run a series of checks.

			// By default, the TV should be off.  
			if(tv.isOn()){
				passTV = false;
				System.out.println("TV was ON by default, should be OFF.\n");
			}

			if(tv.getChannel() != 2){
				passTV = false;
				System.out.println("TV was NOT set to channel 2 by default.\n");
			}

			if(tv.getVolume() != 10){
				passTV = false;
				System.out.println("TV volume was NOT set to 10 by default.\n");			
			}

			// Cycle the TV's "power".
			tv.power();
			// Set the TV's channel to 42.
			tv.setChannel(42);

			// Raise the TV's volume by 2, then decrease it by 1. 
			// This effectively increases the TV's volume by 1.
			tv.raiseVolume();
			tv.raiseVolume();
			tv.lowerVolume();
			
			if(!tv.isOn()){
				passTV = false;
				System.out.println("TV was set to OFF when it should have been ON after using power method for the first time.\n");
			}

			if(tv.getChannel() != 42){
				passTV = false;
				System.out.println("TV channel SHOULD have been set to 42, but was " + tv.getChannel() + " instead!\n");
			}

			if(tv.getVolume() != 11){
				passTV = false;
				System.out.println("TV volume SHOULD have been set to 11, but was " + tv.getVolume() + " instead!\n");
			}

			// Attempt to set the TV to an invalid channel. 
			// The expected behavior is that the TV will do nothing in response. 			
			tv.setChannel(200);

			// Raise the volume by 20.
			// Once the volume hits the maximum of 20, the TV should not increase it any more. 
			for(int i = 1; i <= 20; i++)
				tv.raiseVolume();
			
			if(tv.getChannel() != 42){
				passTV = false;
				System.out.println("TV channel SHOULD *still* have been set to 42, but was " + tv.getChannel() + " instead!\n");
			}

			if(tv.getVolume() != 20){
				passTV = false;
				System.out.println("TV volume SHOULD have been set to 20, but was " + tv.getVolume() + " instead!\n");
			}
			
			// Lower the volume to zero. 
			// Once the TV hits the minimum volume, it should stay there and do nothing further, even if we continue to run tv.lowerVolume().
			for(int i = 1; i <= 22; i++)
				tv.lowerVolume();
			
			if(tv.getVolume() != 0){
				passTV = false;
				System.out.println("TV volume SHOULD have been set to 20, but was " + tv.getVolume() + " instead!\n");
			}			

			if(passTV)
				System.out.println("Pass");
			else
				System.out.println("Fail");
		}
		
		
		//Door Test
		System.out.print("\nDo you want to test Door? ");
		// Once again, yet another menu.
		if(input.nextInt() == 1)
		{
			// When we created an instance of the Door class, we supplied an inscription to the constructor. 
			// Upon retreival, this should be the string "Certain Dooooooooom".

			// Note that Mr.Coleman had to use the .equals() method. In Java, Strings are objects, so they behave a bit differently from other variable types like chars, 
			// ints, and booleans. Unlike what you're used to using (==, >=, etc) the only way to compare strings is using this method.  
			if(!door.getInscription().equals("Certain Dooooooooom")){
				passDoor = false;
				System.out.println("Door inscription is INCORRECT.\n");
			}

			if(!door.isLocked() || !door.isClosed()){
				passDoor = false;
				System.out.println("Expected door to be LOCKED and CLOSED, but it WAS NOT.\n");			
			}

			// "Open" the door. 
			door.open();
			
			// Make sure that the door's state was set to open after we ran the open method. 
			if(!door.isClosed()){
				passDoor = false;
				System.out.println("Expected door to be open after opening it, but it WAS NOT.\n");
			}
			
			// "Unlock" the door. 
			door.unlock();
			
			if(door.isLocked()){
				passDoor = false;
                                System.out.println("Expected door to be unlocked after unlocking it, but it WAS NOT.\n");			
			}

			// "Open" the door again.
			// Some silly people might write their open method in such a way that it cycles the door's open state. 
			// Forobvious reasons, that is incorrect. This test catches those people. 
			door.open();
			
			if(door.isClosed()){
				passDoor = false;
                                System.out.println("Why did OPENING the door a second time CLOSE the door?.\n");			
			}

			// Cycle the door's lock state. 
			// The door SHOULD NOT lock while open.
			door.lock();
			
			if(door.isLocked()){
				passDoor = false;
                                System.out.println("Doors SHOULD NOT lock while open.\n");
			}
			
			// "Close" the door.
			door.close();
			
			if(!door.isClosed()){
				passDoor = false;
                                System.out.println("Closing the door FAILED. Closing the door should, in theory, close the door.\n");
			}
			
			// Now that the door is closed, we should be able to "lock" it. 
			door.lock();
			
			// Make sure that our closed door has now been locked. 
			if(!door.isLocked()){
				passDoor = false;
                                System.out.println("Expected door to become LOCKED after running door.lock().\n");
			}

			// Mr.Coleman decided to print out the value of passDoor for some reason. 
			// It's like a party in your console. 
			System.out.println(passDoor);
		
			if(passDoor)
				System.out.println("Pass");
			else
				System.out.println("Fail");
			
		}
				
		//Stopwatch Test

		// Yet another menu.
		System.out.print("\nDo you want to test Stopwatch? ");
		if(input.nextInt() == 1)
		{
			// Start the stopwatch.
			sw.startStopwatch();
			
			// This causes the program to "sleep" (i.e. wait) for 2000ms (2 sec).
			Thread.sleep(2000);

			System.out.println("Split 1 should be 2 seconds");
			// Set and get split one. 
			sw.setSplitOne();
			sw.getSplitOne();

			// Sleep for 3 seconds. 
			Thread.sleep(3000);

			System.out.println("Split 2 should be 5 seconds");
			// Set and get split two.
			sw.setSplitTwo();
			sw.getSplitTwo();

			// Sleep for 4 more seconds.
			Thread.sleep(4000);

			// Print the total time on the stopwatch.
			System.out.println("Final time should be 9 seconds");
			sw.stopStopwatch();
		}
	}

}
