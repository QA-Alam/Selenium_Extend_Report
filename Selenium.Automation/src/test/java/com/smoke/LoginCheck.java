package com.smoke;


import org.testng.annotations.Test;

import com.generic.code.BaseWithPF;
import com.generic.code.LoginValidation;
import com.utility.TestConsoleResult;

public class LoginCheck extends BaseWithPF  {



@Test
	public  void main() {

	super.login();
	LoginValidation.getLoginValidation(driver);
	pf.getSearchBox().sendKeys("iphone");
	pf.getSearchBox().submit();
	TestConsoleResult.getTestResult(2, "Search iphone done", "Passed");
	}

}
