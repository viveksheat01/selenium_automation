package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.errors.AppErrors;

public class ResigterPageTest extends BaseTest {
	
	
	@BeforeClass
	public void regSetUp() {
		regpage=loginpage.navigateToRegisterPage();
	}
	
	
	@Test
	public void userRegisterPageTest() {
	Assert.assertTrue(regpage.userRegister("vivek", "singh", 
				"qaautomstion1101@gmail.com", "224153221", "1234", "yes"), 
			AppErrors.REGISTER_NOT_DONE);
	}
	
	
	

}
