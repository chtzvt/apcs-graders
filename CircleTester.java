
public class CircleTester
{

	public static void main(String[] args)
	{
		Circle circle = new Circle(4.2);
		
		System.out.println("The radius is:\t\t" + circle.getRadius() + " (4.2)");
		System.out.println("The diameter is:\t" + circle.diameter() + " (8.4)");
		System.out.println("The area is:\t\t" + circle.area() + " (~55.42)");
		System.out.println("The circumference is:\t" + circle.circumference() + " (~26.39)");
		
		circle.setRadius(3.7);
		
		System.out.println("\nThe radius is:\t\t" + circle.getRadius() + " (3.7)");
		System.out.println("The diameter is:\t" + circle.diameter() + " (7.4)");
		System.out.println("The area is:\t\t" + circle.area() + " (~43.01)");
		System.out.println("The circumference is:\t" + circle.circumference() + " (~23.25)");

		
	}

}
