package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	public SignInPage(WebDriver remotedriver){
		driver=remotedriver;
		PageFactory.initElements(remotedriver, this);
	}
	
	@FindBy(xpath="//div[@id='signinToggle']")
	WebElement signInButton;
	@FindBy(xpath="//input[@id='login-email']")
	WebElement emailinputBx;
	@FindBy(xpath="//input[@id='login-password']")
	WebElement passinputBx;
	@FindBy(xpath="//button[@id='loginSubmit']")
	WebElement loginSubmitBtn;
	@FindBy(xpath="//div[@class='signinFormError error' and contains(text(),'Incorrect emailId or Password, Try again')]")
	WebElement errorMessage;
	@FindBy(xpath="//div[@class='signinFormError error']")
	WebElement messagerror;
	
	
	public boolean signInbuttonvisibility() {
		return signInButton.isDisplayed();
	}
	public void emailInput(String email) {
		 emailinputBx.sendKeys(email);
	}
	
	public void passInput(String pass) {
		passinputBx.sendKeys(pass);
	}
	
	public void submitlogin() {
		loginSubmitBtn.click();
	}

	public String erromessage() {
		return messagerror.getText();
	}
	public Boolean isErrorMessagethere() {
		return errorMessage.isDisplayed();
	}
	
	public void clearemailInput() {
		 emailinputBx.clear();
	}
	
	public void clearpassInput() {
		passinputBx.clear();
	}

}
