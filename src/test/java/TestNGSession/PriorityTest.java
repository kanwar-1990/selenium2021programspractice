package TestNGSession;

import org.testng.annotations.Test;

public class PriorityTest {

	
	/*
	 * In priority cases and non priority cases---Non Priority will be executed
	 * first on the basis of Alpabetic order We Can have a negative priority as
	 * well, And it will be executed before 0, if any priority is given like that We
	 * Can have similar priority as well, TestNG will check the priority and then
	 * based on Alphabetic order it will be executed
	 * 
	 * 
	 * 
	 ******************************************************************************* 
	 * if a test case has a priority -1 that will be executed first and then if any
	 * priority 0 is there, remaining if dont have the priority will be considered
	 * as 0 only and then any priority 2,3 will be executed
	 *
	 */
	
	
	@Test(priority=3)
	public void test6()
	{
		System.out.println("test6");
	}
	
	
	@Test(priority=-1)
	public void test1()
	{
		System.out.println("test1");
	}
	
	@Test(priority=2)
	public void test2()
	{
		System.out.println("test2");
	}
	
	@Test(priority=0)
	public void test3()
	{
		System.out.println("test3");
	}
	
	@Test
	public void test4()
	{
		System.out.println("test4");
	}
	@Test
	public void test5()
	{
		System.out.println("test5");
	}
	
	
}
