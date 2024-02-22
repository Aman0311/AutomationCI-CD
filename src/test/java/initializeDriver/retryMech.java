package initializeDriver;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryMech implements IRetryAnalyzer{

	int count = 0;
	int retry =1;
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<retry)
		{
			count++;
			return true;
		}
		
		return false;
	}

}
