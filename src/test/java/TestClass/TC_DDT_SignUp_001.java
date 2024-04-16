package TestClass;




import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClass.SignUpPage;
import TestUtils.MailUtils;
import TestUtils.XLUtils;

@Test
public class TC_DDT_SignUp_001 extends BaseClass{
	MailUtils mail;

	SignUpPage Vm;

	
	@Test(dataProvider = "SignUpData")
	public void SignUpDDTesting(String fullname, String email,String mobile,String pass,String confirm) throws Exception {
	    mail=new MailUtils();
	    Vm = new SignUpPage(driver);
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
	private void clearFormFields() {
	    Vm.clearusernamefeild();
	    Vm.clearemailfeild();
	    Vm.clearnumfeild();
	    Vm.clearpasswordfeild();
	    Vm.cleaconfrimfeild();
	    Vm.clearcheckbox();
	    Vm.clearsecondcheckboc();
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


	

	@DataProvider(name = "SignUpData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/TestData/GK_Vaze.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "sheet1",1);
		String[][] SignUp = new String[rownum][colnum];
		System.out.println(rownum +" rows"+colnum +" coloumns");
		for (int r = 1; r <= rownum; r++) {
			for (int c = 0; c < colnum; c++) {
				SignUp[r - 1][c] = XLUtils.getCellData(path, "Sheet1", r, c);
			}
		}

		return SignUp;
	}

	public void checkFormValidation() {
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		System.out.println("Actual message appeared on screen: " + messageStr);
		System.out.println();



	}

}

