package mehmetgul.mylib.listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;


public class TestNGListenerDemo {

	@Test
	public void test1(){
		System.out.println("I am inside the test 1");
	}

	@Test
	public void test2(){
		System.out.println("I am inside the test 2");
		Assert.assertEquals("a","b");
	}

	@Test
	public void test3(){
		System.out.println("I am inside the test 3");
		throw new SkipException("This test is skippe");
	}
}
