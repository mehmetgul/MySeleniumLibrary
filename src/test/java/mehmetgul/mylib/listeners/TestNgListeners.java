package mehmetgul.mylib.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//When we create in testNG.xml file we don't require below annotation.
//@Listeners(mehmetgul.mylib.listeners.TestNgListeners.class)
public class TestNgListeners implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(" ****Test started**** " +result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(" ****Test successfull**** " +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(" ****Test failured**** " +result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(" ****Test skipped**** " +result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println(" ****Test finished**** " +context.getName());
	}
}
