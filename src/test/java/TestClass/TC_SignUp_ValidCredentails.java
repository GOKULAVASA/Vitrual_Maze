package TestClass;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import PageClass.SignUpPage;
import TestUtils.MailUtils;
@Test
public class TC_SignUp_ValidCredentails extends BaseClass {
	SignUpPage Vm;
	MailUtils mail;
    public void ValidCredentailsSignUp() throws IOException, MailosaurException, InterruptedException {
        Vm = new SignUpPage(driver);
        mail=new MailUtils();
        Vm.clickSignUpBtn();
        String randomEmail = generateRandomEmail();
        logger.info("Clicked on signup button");
        String RandomNmae = generateRandomEmail();
        Vm.enterFullname(RandomNmae+"eeeeeeeee");
        
        String mailId=randomEmail+"@vvaxddnq.mailosaur.net";
        String validation_message = Vm.enterEmail(mailId);
        System.out.println(validation_message);
        Vm.enterMobileTxtBx("9790709904");
        Vm.enterPassword("123@gkvasan");
        Vm.confirmPassword("123@gkvasan");
        Vm.clickcheckBxPolicyandTerms();
        Vm.checkBxOptionalForNewsLetter();
        Vm.clickSubmit();


       

        System.out.println("OTP verification starts");
        String otp = mail.testEmailSubject(mailId);
        System.out.println(otp);
        Vm.otpVerification().sendKeys(otp);
        Thread.sleep(5000);
        Vm.otpVerificationbtn().click();
        Vm.clickSignUpBtn();
       /* WebElement message = Vm.AccountCreatedValidationMesaage();
        waitForElement(message);
        System.out.println("Assert true");
       */ 
        System.out.println("================ACCOUNT CREATED==============");
    }


    public static String generateRandomEmail() {
        // Define the characters allowed in the local part of the email
        String allowedChars = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        
        StringBuilder sb = new StringBuilder();

        // Generate a random local part with 3 characters
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(allowedChars.length());
            sb.append(allowedChars.charAt(index));
        }

        // Concatenate with a domain part
        String email = sb.toString();

        return email;
    }
    
    
    
  
}
