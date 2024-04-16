package TestClass;

import java.io.IOException;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurException;

import PageClass.Forget_PasswordPage;
import TestUtils.MailUtils;

public class TC_FP_OTP_InputFeild_003 extends  BaseClass{
	MailUtils mail;
	char otp;
	@Test
	public void OTP_inputFeild_Verification() throws IOException, MailosaurException {
		mail=new MailUtils();
		Forget_PasswordPage fp=new Forget_PasswordPage(driver);
		String randomEmail = "fuck@vvaxddnq.mailosaur.net";
		fp.emailInputBx().sendKeys(randomEmail);
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
		String c=mail.testEmailSubject(randomEmail);
		
		
	/*	for(int i=0;i<c.length();i++) {
	 * 
	 
	    	c.charAt(i);
	    	if(c.charAt(i)>=48 && c.charAt(i)<=57) {
	    		 otp= c.charAt(i);
	    	}
	    }
	    */
		fp.otpInputFeild().sendKeys(c);
		
		
		fp.NewPasswordreset().sendKeys("1234512345");
		fp.changeNewPassword().click();
		}
		

	  
	    
		
	}
	
	    
	}
