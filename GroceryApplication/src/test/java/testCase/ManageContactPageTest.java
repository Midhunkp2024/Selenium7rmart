package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ManageContactPage;

public class ManageContactPageTest extends BaseClass{
	LoginPage lp;
	HomePage hp;
	ManageContactPage mcp;
	
	@Test(enabled = true)
	public void verifyEditContactUsFunctionalityFromManageContactPge() throws IOException, Exception  {
		lp = new LoginPage(driver);	
		String password = lp.decryptPassword(groceryLogin(20, 0));
		hp = lp.login(groceryLogin(0, 1), password);
		mcp = hp.clickOnManageContactMenu();
		mcp.editContact();
		boolean alertStatus = mcp.getAlertMessage().contains("Contact Updated Successfully");
		Assert.assertEquals(alertStatus, true, Constant.Mcp__EditContactUsFunctionality);
		
	}

}
