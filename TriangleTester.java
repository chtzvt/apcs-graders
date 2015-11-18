// Define the TriangleTester class. 
public class TriangleTester
{
	// Define the main method, which is automatically run when the program is executed. 
	public static void main(String[] args)
	{
		/* Wow, would you look at that. A new type of variable you've not seen before. How exciting!
		 * This is called an Array, and it's essentially an ordered list of variables. 
		 * Each object in an array has a number, starting from 0, that is used to reference it.
		 * 
		 * Here's a more visual representation:
		 * triangle: 
		 *	 0) Triangle(2, 3, 4)
		 *	 1) Triangle(4, 5, 6)
		 *	 2) Triangle(3, 3, 3)
		 * so the code triangle[0] references the instance of the Triangle class at position 0, which has the side lengths of 2, 3, and 4.
		 * 
		 * Here, Mr.Coleman actually defines several arrays, the first being one named Triangle which contains several instances of
		 * the Triangle class, and one named values, which is actually an array of arrays (confusing, I know) with values that 
		 * correspond to the trangle instances in the first array. 
		 *
		 * The upshot of this is that any Triangle at any position in the triangle array will have corresponding side lengths in the 
		 * values array, which will allow Mr.Coleman to cross-reference the values returned from each Triangle instance with his own calculations. 
		 */

		Triangle[] triangle = {new Triangle(2, 3, 4), new Triangle(4, 5, 6), new Triangle(3, 3, 3)};
		double[][] values = {{2, 3, 4}, {4, 5, 6}, {3, 3, 3}};

		// Let's make a happy little boolean. 
		// As usual, this variable is used to keep track of whether or not you've passed or failed. 
		boolean pass = true;
		
		/* A for loop! Remember these? 
		 * Mr.Coleman is now going to loop through all of the values in the values array and test each of our triangles.
		 *  
		 * You've probably noticed values.length. Arrays, like strings, are objects, and as a result there are several properties and methods that
		 * can be called to get information about them or manipulate the data they contain. 
		 * As you can probably guess, values.length will return the number of entries in the array (i.e. the length). 
		 *
		 * In short, with this loop, Mr.Coleman will run all of the below code for each element in the values array.
		 */
		for(int i = 0; i < values.length; i++)
		{
			/* Here we are inside of the for loop. This may seem a bit confusing, since we have a few arrays with lots of values being juggled,
			 * but that's why these comments are here, after all.
			 * 		
			 * Throughout the rest of the loop, you'll see the variable i quite a bit. i is the variable which is used to store the increment
			 * for the for loop (see above), which you'll recall corresponds to the number of one of the elements in the triangle and values 
			 * arrays. 
			 * 
			 * Effectively, this allows Mr.Coleman to easily and concisely run checks on any given number of triangles/side lengths without 
			 * having to repeat his code many times, because all the code needed to run checks is the same across all triangles. 
			 * 
			 * This scales well, and this code could be used to check only a single triangle or multiple thousands, as the for loop 
			 * is set from the size of the array containing the triangle values. 
 			 */
 
			// Here, checks are run to ensure that the sides each triangle returns match the values
			// passed to the constructor when the instances were created. 
			if(triangle[i].getSide1() != values[i][0])
				pass = false;
			if(triangle[i].getSide2() != values[i][1])
				pass = false;
			if(triangle[i].getSide3() != values[i][2])
				pass = false;

			// Coleman initializes a variable to hold the perimeter. 
			double per = 0;
			
			/* Mr.Coleman loops through the array contained within values with side lengths that correspond to the triangle being checked, 
			 * the purpose being to add up all three sides of the triangle. 
			 *
			 * This could also be accomplished with the following code that may be more familiar to you: 
			 * 	per = values[i][0] + values[i][2] + values[i][3];
			 */
			for(int j = 0; j < values[i].length; j++)
				per += values[i][j];
			
			// Compare the perimeter calculated by the Triangle class to the one calculated by Mr.Coleman.
			if(triangle[i].perimeter() != per)
				pass = false;
			/*
			 * Mr.Coleman uses an assignment operator shorthand to divide the perimeter by 2.
			 * This is equivalent to:
			 * per = per / 2;
			 * 
			 * For more cool shorthand operators guaranteed to save you keystrokes, see here: http://java.about.com/od/c/g/compoundassgnment.htm
			 */			
			per /= 2;
								
			/* Here, Coleman compares the value returned by triangle.area() with one that he computes himself, thereby checking 
			 * that the area method functions properly.
			 * These values should be calculated using Heron's formula: http://www.mathopenref.com/heronsformula.html
			 */
			if(triangle[i].area() != Math.sqrt(per * (per - values[i][0]) * (per - values[i][1]) * (per - values[i][2])))
				pass = false;
		}
		
		if(pass)
			System.out.println("You're all clear, kid!");
		else
			System.out.println("This is not the java you're looking for.");
		
	}

}
