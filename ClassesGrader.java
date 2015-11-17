import java.util.Scanner;

public class ClassesGrader
{

	public static void main(String[] args) throws InterruptedException
	{
		Scanner input = new Scanner(System.in);
		
		SuperDie die = new SuperDie(4);
		TV tv = new TV();
		Door door = new Door("Certain Dooooooooom");
		Stopwatch sw = new Stopwatch();
		
		boolean passSuperDie = true;
		boolean passTV = true;
		boolean passDoor = true;
		
		System.out.println("For the following answer:\n\t1 for yes\n\t2 for no");
		
		//SuperDie Test
		System.out.print("Do you want to test SuperDie? ");
		if(input.nextInt() == 1)
		{
			int roll = 0;
					
			for(int i = 1; i <= 100000; i++)
				if(die.roll() == 3)
					roll++;
			
			if(roll > 26000 || roll < 24000)
				passSuperDie = false;
			
			die.setSides(20);
			roll = 0;
			
			for(int i = 1; i <= 100000; i++)
				if(die.roll() == 3)
					roll++;
			
			if(roll > 6000 || roll < 4000)
				passSuperDie = false;
			
			if(passSuperDie)
				System.out.println("Pass");
			else
				System.out.println("Fail");
		}
		//TV test
		
		System.out.print("\nDo you want to test TV? ");
		if(input.nextInt() == 1)
		{
			if(tv.isOn())
				passTV = false;
			if(tv.getChannel() != 2)
				passTV = false;
			if(tv.getVolume() != 10)
				passTV = false;
			
			tv.power();
			tv.setChannel(42);
			tv.raiseVolume();
			tv.raiseVolume();
			tv.lowerVolume();
			
			if(!tv.isOn())
				passTV = false;
			if(tv.getChannel() != 42)
				passTV = false;
			if(tv.getVolume() != 11)
				passTV = false;
			
			tv.setChannel(200);
			for(int i = 1; i <= 20; i++)
				tv.raiseVolume();
			
			if(tv.getChannel() != 42)
				passTV = false;
			if(tv.getVolume() != 20)
				passTV = false;
			
			for(int i = 1; i <= 22; i++)
				tv.lowerVolume();
			
			if(tv.getVolume() != 0)
				passTV = false;
			
			if(passTV)
				System.out.println("Pass");
			else
				System.out.println("Fail");
		}
		
		
		//Door Test
		System.out.print("\nDo you want to test Door? ");
		if(input.nextInt() == 1)
		{
			if(!door.getInscription().equals("Certain Dooooooooom"))
				passDoor = false;
			if(!door.isLocked() || !door.isClosed())
				passDoor = false;
			
			door.open();
			
			if(!door.isClosed())
				passDoor = false;
			
			door.unlock();
			
			if(door.isLocked())
				passDoor = false;
			
			door.open();
			
			if(door.isClosed())
				passDoor = false;
			
			door.lock();
			
			if(door.isLocked())
				passDoor = false;
			
			door.close();
			
			if(!door.isClosed())
				passDoor = false;
			
			door.lock();
			
			if(!door.isLocked())
				passDoor = false;
			
			System.out.println(passDoor);
		
			if(passDoor)
				System.out.println("Pass");
			else
				System.out.println("Fail");
			
		}
			
		
		//Stopwatch Test
		System.out.print("\nDo you want to test Stopwatch? ");
		if(input.nextInt() == 1)
		{
			sw.startStopwatch();
			Thread.sleep(2000);
			System.out.println("Split 1 should be 2 seconds");
			sw.setSplitOne();
			sw.getSplitOne();
			Thread.sleep(3000);
			System.out.println("Split 2 should be 5 seconds");
			sw.setSplitTwo();
			sw.getSplitTwo();
			Thread.sleep(4000);
			System.out.println("Final time should be 9 seconds");
			sw.stopStopwatch();
		}
	}

}
