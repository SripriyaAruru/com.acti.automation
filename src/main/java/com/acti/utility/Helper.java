package com.acti.utility;

public class Helper {
	public static void sleep()
	{
		try 
		{
			Thread.sleep(2000);
		} 
		catch (InterruptedException e) 
		{	
			e.printStackTrace();
		}
	}

}


