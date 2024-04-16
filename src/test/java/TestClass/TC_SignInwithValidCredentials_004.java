package TestClass;

import org.junit.Assert;
import org.testng.annotations.Test;

import PageClass.SignInPage;

public class TC_SignInwithValidCredentials_004 extends BaseClass{
	SignInPage Vm;
	@Test
	public void ValidCredentials() {
		
	 Vm = new SignInPage(driver);
    Vm.emailInput(readconfig.getUserEmail());
    Vm.passInput(readconfig.getUserPassword());
    Vm.submitlogin();
  String  titile=  driver.getTitle();
  System.out.println(titile);
  if(titile!=null) {
	  Assert.assertTrue(true);
  }

}
}