package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

WebDriver driver;
public SignUpPage(WebDriver remotedriver){
	driver=remotedriver;
	PageFactory.initElements(remotedriver, this);
}


	@FindBy(xpath="//div[@id='signupToggle']//span[contains(text(),'Sign Up')]")
	WebElement SignupBtn;
	
	@FindBy(xpath="//input[@id='signup-username' and @name='signupName']")
	WebElement fullNameTxtBx;
	
	@FindBy(xpath="//input[@id='signup-email' and @name='signupEmail']")
	WebElement EmailTxtBx;
	
	@FindBy(xpath="//input[@id='signup-mobile' and @name='signupMobile']")
	WebElement MobileTxtBx;
	
	@FindBy(xpath="//input[@id='signup-password' and @name='signupPassword']")
	WebElement PasswordTxtBx;
	
	@FindBy(xpath="//input[@id='signup-confirmPassword' and @name='signupConfirmPassword']")
	WebElement ConfirmPasswordTxtBx;
	
	@FindBy(xpath="//input[@id='terms-vms-policy']")
	WebElement CheckBxBtnPolicyandConditions;
	
	@FindBy(xpath="//input[@id='newsLetter']")
	WebElement CheckBxNewsLetter;
	
	@FindBy(xpath="//div[@id='signup-submit' and @class='submitDiv']/button")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//div[@id='otp-form-text']")
	WebElement otpverification;
	
	@FindBy(xpath="//div[@id='otp']//input[1]")
	WebElement otpInputs;
	
	@FindBy(xpath="//div[@id='snackbars' and contains(text(),'accounts created successfully')]")
	WebElement validationMessage;
	
	@FindBy(xpath="//div[@id='signupFormError']")
	WebElement SignUpFormError;
	
	@FindBy(xpath="//div[@id='signupEmailError']")
	WebElement SignUpEmailError;
	

	@FindBy(xpath="//div[@id='signupPasswordError']")
	WebElement PasswordErrorMessage;
	

			@FindBy(xpath="(//button[@class='Rectangle-8953-otp'])[1]")
			WebElement otpverifybtn;
			
			
			public WebElement SignUppasswordError() {
				return PasswordErrorMessage;
			}
			
			public WebElement SignUpEmailError() {
				return SignUpEmailError;
			}

			public WebElement SignUpFormError() {
				return SignUpFormError;
			}

			public WebElement AccountCreatedValidationMesaage() {
				return validationMessage;
			}

			public WebElement otpVerificationbtn() {
				return otpverifybtn;
			}

	public WebElement otpVerification() {
		return otpInputs;
	}
	public WebElement otprecepitent() {
		return otpverification;
	}
	
	public boolean otp() {
		return otpverification.isDisplayed();
	}
	
	public void clickSignUpBtn() {
		SignupBtn.click();
	}
	
	public void enterFullname(String fullname) {
		fullNameTxtBx.sendKeys(fullname);
	}
	
	public String enterEmail(String email) {
		EmailTxtBx.sendKeys(email);
		String error_message =EmailTxtBx.getAttribute("validationMessage");
		return error_message;
	
			
	}
	
	
	public void enterMobileTxtBx(String num) {
		MobileTxtBx.sendKeys(num);
	}
	public void enterPassword(String pass) {
		PasswordTxtBx.sendKeys(pass);
	}
	public void confirmPassword(String confirm) {
		ConfirmPasswordTxtBx.sendKeys(confirm);
	}
	
	public void clickcheckBxPolicyandTerms() {
		CheckBxBtnPolicyandConditions.click();
	}
	public void checkBxOptionalForNewsLetter() {
		CheckBxNewsLetter.click();
	}
	
	public void clickSubmit() {
		SubmitBtn.click();
	}
	
	public void clearnumfeild() {
		

		MobileTxtBx.clear();
	}
	public void clearpasswordfeild() {
	

		PasswordTxtBx.clear();
	}
	public void cleaconfrimfeild() {
		
		ConfirmPasswordTxtBx.clear();
	}
	
	public void clearcheckbox() {
	
		CheckBxBtnPolicyandConditions.click();
	}
	public void clearsecondcheckboc() {
	
		CheckBxNewsLetter.click();;
	}
	
	
	public void clearusernamefeild() {
		
		fullNameTxtBx.clear();
	}
	
	public void clearemailfeild() {
			EmailTxtBx.clear();
		
	
			
	}
	
	
	
}


