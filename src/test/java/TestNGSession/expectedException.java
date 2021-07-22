package TestNGSession;

import org.testng.annotations.Test;

public class expectedException {

	/*
	 * expectedException---Can be used, if you know an exception has come If u are
	 * not sure of the exception--we can also use parent class of exception as
	 * exception or if u belive an exception and error might come together u may use
	 * throwable class which is grand parent of all the exceptions
	 * We can also write multiple exceptions and use it
	 * We can also directly use try/catch and let the execution happen once -- the exception is found
	 */

	@Test(expectedExceptions = ArithmeticException.class)
	public void exceptedException() {
		System.out.println("Before Starting test.......");

		int i = 9 / 0;
		System.out.println("After Starting test........");
	}

	@Test(expectedExceptions = Exception.class)
	public void exceptedException1() {
		System.out.println("Before Starting test.......");

		int i = 9 / 0;
		System.out.println("After Starting test........");
	}

	@Test(expectedExceptions = Throwable.class)
	public void exceptedException2() {
		System.out.println("Before Starting test.......");

		int i = 9 / 0;
		System.out.println("After Starting test........");
	}

	@Test(expectedExceptions = { ArithmeticException.class, NullPointerException.class })
	public void exceptedException3() {
		System.out.println("Before Starting test.......");

		int i = 9 / 0;
		System.out.println("After Starting test........");
	}

	@Test()
	public void exceptedException4() {

		System.out.println("Before Starting test.......");

		try {
			int i = 9 / 0;

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("After Starting test........");
	}

}
