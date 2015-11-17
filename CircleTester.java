// Define our circle tester class.
public class CircleTester
{
	// This main method will run by default when this class is compiled and executed.
	public static void main(String[] args)
	{
		// Create a new instance of our circle class (referred to as instantiation) with a radius of 4.2.
		Circle circle = new Circle(4.2);
		
		// Prints a variety of statistics about the circle to the console.
		System.out.println("The radius is:\t\t" + circle.getRadius() + " (4.2)");
		System.out.println("The diameter is:\t" + circle.diameter() + " (8.4)");
		System.out.println("The area is:\t\t" + circle.area() + " (~55.42)");
		System.out.println("The circumference is:\t" + circle.circumference() + " (~26.39)");
		
		// Run the setRadius method to set a new radius for the circle. 
		circle.setRadius(3.7);
		
		// Prints out yet more statistics, though they now reflect the updated radius.
		System.out.println("\nThe radius is:\t\t" + circle.getRadius() + " (3.7)");
		System.out.println("The diameter is:\t" + circle.diameter() + " (7.4)");
		System.out.println("The area is:\t\t" + circle.area() + " (~43.01)");
		System.out.println("The circumference is:\t" + circle.circumference() + " (~23.25)");

		
	}

}
