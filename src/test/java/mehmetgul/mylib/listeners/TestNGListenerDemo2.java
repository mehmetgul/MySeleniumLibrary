package mehmetgul.mylib.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class TestNGListenerDemo2 {

	@Test
	public void test4(){
		System.out.println("I am inside the test 4");
	}

	@Test
	public void test5(){
		System.out.println("I am inside the test 5");
		Assert.assertEquals("a","b");
	}

	@Test
	public void test6(){
		System.out.println("I am inside the test 6");
		throw new SkipException("This test is skippe");
	}
}
