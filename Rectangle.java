/* --- This is the original annotated class made by Mr.Coleman. ---
 * What's the name?
 * The name of the class
 * 		ALWAYS public
 * 		starts with capital letter
 */

public class Rectangle
{
	/*
	 * What's it know about itself?
	 * Class variable section:
	 * 		keeps track of data associated with the class
	 * 		make sure to define only what is needed to describe the class
	 * 
	 */
	
	private double height;
	private double width;
	
	/*
	 * How's it made?
	 * Constructor
	 * 		creates an object of the class
	 * 		sets the beginning values
	 * 		we will ALWAYS have one (technically not necessary)
	 */
	
	public Rectangle(double h, double w)
	{
		height = h;
		width = w;
	}
	
	/*
	 * What's it do?
	 * Method(s)
	 * 		Can be any number of methods
	 * 		ALWAYS public
	 * 		return type: 
	 * 			void (returns nothing)
	 * 				-OR-
	 * 			data type of value returned
	 * 		name starts with lower case letter
	 * 		parameters in parentheses: 
	 * 			what data does it need
	 * 			need data type and name (different from class variable)
	 * 			separated by commas
	 */
	
	public double getHeight()
	{
		return height;
	}
	
	public double getWidth()
	{
		return width;
	}
	
	public void setHeight(double h)
	{
		height = h;
	}
	
	public void setWidth(double w)
	{
		width = w;
	}
	
	public double area()
	{
		return width * height;
	}
	
	public double perimeter()
	{
		return height + height + width + width;
	}
}
