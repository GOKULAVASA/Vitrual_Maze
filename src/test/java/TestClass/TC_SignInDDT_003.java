package TestClass;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageClass.SignInPage;

import TestUtils.XLUtils;


public class TC_SignInDDT_003 extends BaseClass{
    SignInPage Vm;

    @Test(dataProvider = "SignUpData")
    public void SignUpDDTesting(String email, String pass) throws Exception {
        Vm = new SignInPage(driver);
        Vm.emailInput(email);
        Vm.passInput(pass);
        Vm.submitlogin();
      try {  
     if( Vm.isErrorMessagethere()) {
       
           String messagve= Vm.erromessage();
           System.out.println(messagve);
          
        }
      }catch(Exception e) {
    	  System.out.println("no error ");
      }
        
        checkFormValidation();
      
        Vm.clearemailInput();
        Vm.clearpassInput();
    }
    
    @DataProvider(name = "SignUpData")
    String[][] getData() throws IOException {
        String path = System.getProperty("user.dir") + "/src/test/java/TestData/VmazeSIGNIN.xlsx";
        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colnum = XLUtils.getCellCount(path, "Sheet1", 1);
        String[][] signUpData = new String[rownum][colnum];
        System.out.println(rownum + " rows" + colnum + " columns");
        for (int r = 1; r <= rownum; r++) {
            for (int c = 0; c < colnum; c++) {
                String cellData = XLUtils.getCellData(path, "Sheet1", r, c);
                signUpData[r - 1][c] = (cellData != null) ? cellData : ""; // Assign empty string if cell is null
            }
        }
        return signUpData;
    }



    public void checkFormValidation() {
        WebElement activeElement = driver.switchTo().activeElement();
        String messageStr = activeElement.getAttribute("validationMessage");
        System.out.println("Actual message appeared on screen: " + messageStr);
        System.out.println();
        
    }
}