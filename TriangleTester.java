
public class TriangleTester
{

	public static void main(String[] args)
	{
		Triangle[] triangle = {new Triangle(2, 3, 4), new Triangle(4, 5, 6), new Triangle(3, 3, 3)};
		double[][] values = {{2, 3, 4}, {4, 5, 6}, {3, 3, 3}};
		boolean pass = true;
		
		for(int i = 0; i < values.length; i++)
		{
			if(triangle[i].getSide1() != values[i][0])
				pass = false;
			if(triangle[i].getSide2() != values[i][1])
				pass = false;
			if(triangle[i].getSide3() != values[i][2])
				pass = false;
			
			double per = 0;
			
			for(int j = 0; j < values[i].length; j++)
				per += values[i][j];
			
			if(triangle[i].perimeter() != per)
				pass = false;
			
			per /= 2;
						
			if(triangle[i].area() != Math.sqrt(per * (per - values[i][0]) * (per - values[i][1]) * (per - values[i][2])))
				pass = false;
		}
		
		if(pass)
			System.out.println("You're all clear, kid!");
		else
			System.out.println("This is not the java you're looking for.");
		
	}

}
