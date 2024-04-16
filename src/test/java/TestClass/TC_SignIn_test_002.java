package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageClass.SignInPage;

public class TC_SignIn_test_002 extends BaseClass {
	@Test
	public void visibility_signBtn() {
	SignInPage login=new SignInPage(driver);
	
boolean visibility=login.signInbuttonvisibility();

if(visibility) {
	Assert.assertTrue(visibility);
	System.out.println("Assert  :"+visibility);
}



}
}