package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryPage;

public class LoginPageTest extends BaseClass {
	LoginPage lp;// login page object lp
	HomePage hp;
	SubCategoryPage scp;

	@Test(priority = 1, groups = "Smoke")
	public void LoginWithValidCredential() throws IOException {
		lp = new LoginPage(driver);// driver is called from base class(previous class)		
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		String actual = hp.getHomePageHeading();
		System.out.println(actual);
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.lp_LoginWithValidCredential);// hard assertion
	}

	@Test(priority = 2)
	public void verifyAlertMessageWhileRememberMeIconIsClickedAndRelogin() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		hp.logOut();		
		hp = lp.reLogin();
		String actual = hp.getHomePageHeading();
		System.out.println(actual);
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.lp_LoginWithValidCredential);// hard assertion
	}

	@Test(dataProvider = "data-provider", priority = 3)
	public void verifyAlertMessageWhileLoginWithInvalidCredential(String userName, String password) {
		lp = new LoginPage(driver);		
		hp = lp.login(userName, password);
		String actual = lp.readErrorMessage();
		System.out.println(actual);
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, Constant.Lp_LoginWithInvalidCredential);
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() throws IOException {
		return new Object[][] { { groceryLogin(1, 0), groceryLogin(1, 1) }, { groceryLogin(2, 0), groceryLogin(2, 1) },
				{ groceryLogin(3, 0), groceryLogin(3, 1) } };
	}
}
