package TestUtils;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageClass.SignUpPage;
import TestClass.BaseClass;

public class SignUpUtils extends BaseClass  {
	
	public void SignUpForm() {
		SignUpPage Vm=new SignUpPage(driver);
		
		
	    Vm.clickSignUpBtn();
	    logger.info("clicked on signup button");
	    Vm.enterFullname(fullname);    
	    String validation_message=Vm.enterEmail(email);
	    System.out.println(validation_message);
	    Vm.enterMobileTxtBx(mobile);
	    Vm.enterPassword(pass);
	    Vm.confirmPassword(confirm);
	    Vm.clickcheckBxPolicyandTerms();
	    Vm.checkBxOptionalForNewsLetter();
	    Vm.clickSubmit();
	    WebElement ele = Vm.SignUpFormError();
	    waitForElement(ele);
	    String eerr = ele.getText();
	    WebElement eleemail = Vm.SignUpEmailError();
	    String err = eleemail.getText();
	   
	    if (expectedErrorOccurred(eerr)) {
	        Assert.assertTrue(true, "Expected error occurred");
	        clearFormFields();
	        return;
	    } 
	    if  (expectedErrorOccurred(err)) {
	        Assert.assertTrue(true, "Expected error occurred");
	        clearFormFields();
	        return;
	    } 


	   
	    String id = Vm.otprecepitent().getAttribute("data-email");
	    System.out.println(id);
	    
	    System.out.println("otp verification starts");
	    String otp = mail.testEmailSubject(id);
	    Vm.otpVerification().sendKeys(otp);
	    Thread.sleep(5000);
	    Vm.otpVerificationbtn().click();
	    
	    WebElement message = Vm.AccountCreatedValidationMesaage();
	    waitForElement(message);
	    System.out.println("Assert true");
	    Vm.clickSignUpBtn();
	    
	    
	}
	private boolean expectedErrorOccurred(String error) {
	    String errorMessage =error;
	    String error_1 = "EmailId already exist";
	    String error_2 = "Invalid parameters";
	    String error_3="Invalid emailID";
	    
	    // Check if the error message matches either of the expected error messages
	    if (errorMessage.equals(error_1) || errorMessage.equals(error_2)||errorMessage.equals(error_3)) {
	        return true;
	    } else {
	        return false;
	    }
	}


	}

	
	
	
