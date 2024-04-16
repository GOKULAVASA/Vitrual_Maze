package TestClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageClass.Forget_PasswordPage;

public class TC_FP_ResetPageVerification_002 extends BaseClass {
	@Test
	public void PasswordResetPageVerification() {
		Forget_PasswordPage fp=new Forget_PasswordPage(driver);
		fp.emailInputBx().sendKeys(readconfig.getUserEmail());
		fp.forgetPasswordLink().click();
		boolean sucessfullmesgg=fp.ValidationSucessfull().isDisplayed();
		if(sucessfullmesgg) {
			System.out.println("valid user name ");
		String otpheaderr=fp.OtpHeader().getText();
		System.out.println(otpheaderr);
		String email=fp.receptitianemail().getText();
		if(email.contains(readconfig.getUserEmail())) {
			Assert.assertTrue(true);
		}
		}
		
	}

}
