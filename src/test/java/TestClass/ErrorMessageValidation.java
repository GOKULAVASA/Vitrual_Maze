package TestClass;

import org.testng.annotations.Test;

import PageClass.SignUpPage;

public class ErrorMessageValidation extends BaseClass{

	@Test
	public void ErrorValidationMessage() {
		SignUpPage sp=new SignUpPage(driver);
		sp.clickSignUpBtn();
		sp.enterFullname("eqvalance");
		sp.enterEmail("a@gmail.com");
		sp.enterPassword("111");
		sp.confirmPassword("111");
		sp.clearcheckbox();
		sp.clickSubmit();
		String message=sp.SignUppasswordError().getText();
		
		System.out.println(message);
		
	}
}
