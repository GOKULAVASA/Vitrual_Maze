package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageClass.Forget_PasswordPage;

@Test
public class TC_FP_visiblityCheck_001 extends BaseClass  {
	public void VisisblityTest() {
		
		Forget_PasswordPage fp=new Forget_PasswordPage(driver);
		boolean visible=fp.forgetPasswordLink().isDisplayed();
		if(visible) {
			Assert.assertTrue(visible);
		}
	}

}
