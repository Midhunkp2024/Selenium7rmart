package testCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.SubCategoryPage;

public class SubCategoryPageTest extends BaseClass {
	LoginPage lp;
	HomePage hp;
	SubCategoryPage scp;

	@Test(priority = 1) // (enabled=false)
	public void verifyAlertMessageWhileCreatingNewSubCategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		scp = hp.clickOnSubCategoryMenu();
		scp.addSubCategory();
		boolean alertStatus = scp.getAlertMessage().contains("Sub Category Created Successfully");
		Assert.assertEquals(alertStatus, true,Constant.Scp_CreateNewSubCategory);
	}

	@Test(priority = 3)
	public void verifyAlertMessageAfterDeleteASubCategoryAndSearchWhetherItRemovedOrNot() throws IOException {

		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		scp = hp.clickOnSubCategoryMenu();
		scp.deleteSubCategory();
		boolean deleteAlertStatus = scp.deleteMessage().contains(".........RESULT NOT FOUND.......");
		Assert.assertEquals(deleteAlertStatus, true, Constant.Scp_DeleteSubCategory);
	}

	@Test(priority = 2)

	public void verifyAlertMessageWhileEditingNewSubCategory() throws IOException {

		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		scp = hp.clickOnSubCategoryMenu();
		scp.editSubCategory();
		boolean editAlertStatus = scp.editMessage().contains("Sub Category Updated Successfully");
		Assert.assertEquals(editAlertStatus, true, Constant.Scp_EditSubCategory);

	}

	@Test(priority = 4)
	public void verifyAlertMessageWhileChangingStatusOfSelectedSubCategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		scp = hp.clickOnSubCategoryMenu();
		scp.changeStatus();
		boolean changeStatusAlertMessage = scp.statusAlertMessage()
				.contains("Sub Category Status Changed Successfully");
		Assert.assertEquals(changeStatusAlertMessage, true, Constant.Scp_ChangeStatusOfSubCategory);

	}

	@Test(priority = 5)
	public void VerifyhomeHyperlinkFunctionalityFromSubCategoryPage() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		scp = hp.clickOnSubCategoryMenu();
		scp.homeHyperlink();
		String actual = hp.getHomePageHeading();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.Scp_HomeHyperlinkFunctionality);
	}

}
