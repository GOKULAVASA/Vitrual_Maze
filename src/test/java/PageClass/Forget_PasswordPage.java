package PageClass;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forget_PasswordPage {


		WebDriver driver;
		public Forget_PasswordPage(WebDriver remotedriver){
			driver=remotedriver;
			PageFactory.initElements(remotedriver, this);
			
		}
		
		
		
		@FindBy(xpath="//span[@id='Forgot-Password']")
		WebElement forgetPassLink;
		
		@FindBy(xpath="//input[@id='login-email']")
		WebElement emailInputBox;
		
		@FindBy(xpath="//div[@class='email error' and contains(text(), \"User doesn't exist\")]")
		WebElement emailerror;
		
		@FindBy(xpath="//div[@id='snackbars' and contains(text(), 'Verification Code sent fail')]")
		WebElement validationsentfail;
		
		@FindBy(xpath="//div[@id='snackbars' and contains(text(), 'Verification Code sent Successfully')]")
		WebElement validationsentsucessfull;
		
		@FindBy(xpath="(//div[@class='otpHeader'])[2]//span")
		WebElement otpHeader;
		
		@FindBy(xpath="(//div[@id='Reset-form-text'])")
		WebElement receptantemailconfirmation;
		
		@FindBy(xpath="(//div[@id='Resetotp'])//input[1]")
		WebElement OTPFeild1;
		
		
		@FindBy(xpath="(//div[@id='Resetotp'])//input[2]")
		WebElement OTPFeild2;
		
		@FindBy(xpath="(//div[@id='Resetotp'])//input[3]")
		WebElement OTPFeild3;
		
		@FindBy(xpath="(//div[@id='Resetotp'])//input[4]")
		WebElement OTPFeild4;
		
		@FindBy(xpath="(//div[@id='Resetotp'])//input[5]")
		WebElement OTPFeild5;
		
		@FindBy(xpath="(//div[@id='Resetotp'])//input[6]")
		WebElement OTPFeild6;

		@FindBy(xpath="//input[@id='Resetpassword']")
		WebElement resetNewPassword;
		
		@FindBy(xpath="(//button[@class='Rectangle-8953-otp'])[2]")
		WebElement ChangeTheNewPassword;
		

		public WebElement changeNewPassword() {
			return ChangeTheNewPassword;
		}

		public WebElement NewPasswordreset() {
			return resetNewPassword;
		}
		
		public WebElement otpInputFeild() {
			return OTPFeild1;
		}
		
		
		
		

		public WebElement receptitianemail() {
		    return receptantemailconfirmation;
		}
		
		public WebElement OtpHeader() {
		    return otpHeader;
		}

		
		public WebElement forgetPasswordLink() {
		    return forgetPassLink;
		}

		public WebElement emailInputBx() {
		    return emailInputBox;
		}

		public WebElement emailerrormessage() {
		    return emailerror;
		}

		
		public WebElement validationFails() {
		    return validationsentfail;
		}
		public WebElement ValidationSucessfull() {
		    return validationsentsucessfull;
		}

	}


