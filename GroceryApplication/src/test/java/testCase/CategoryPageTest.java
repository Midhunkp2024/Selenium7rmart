package testCase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementRepository.CategoryPage;
import elementRepository.HomePage;
import elementRepository.LoginPage;

public class CategoryPageTest extends BaseClass {//inheritance
	LoginPage lp;
	HomePage hp;
	CategoryPage cp;

	@Test(priority = 2)
	public void verifyAlertMessageWhileEditingNewCategory() throws IOException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		cp = hp.clickOnCategoryMenu();
		cp.editCategory();
		boolean editAlertStatus = cp.categoryEditStatusAlert().contains("Category Updated Successfully");
		Assert.assertEquals(editAlertStatus, true,Constant.Cp_EditNewCategory );

	}

	@Test(priority = 1)
	public void verifyAlertMessageWhileCreatingNewCategory() throws IOException, AWTException {
		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		cp = hp.clickOnCategoryMenu();
		String imagePath = System.getProperty("user.dir") + "/src/main/resources/Attachments/pen.PNG";
		cp.addNewCategory(groceryLogin(10, 1), imagePath);
		boolean alertStatus = cp.categoryAddStatusAlert().contains("Category Created Successfully");
		Assert.assertEquals(alertStatus, true, Constant.Cp_CreateNewCategory);
	}

	@Test(priority = 3)
	public void verifyAlertMessageAfterDeleteACategoryAndSearchWhetherItRemovedOrNot() throws IOException {

		lp = new LoginPage(driver);
		hp = lp.login(groceryLogin(0, 0), groceryLogin(0, 1));
		cp = hp.clickOnCategoryMenu();
		cp.deleteSelectedCategory(groceryLogin(11, 1));
		cp.searchCategory(groceryLogin(11, 1));
		boolean deleteAlertStatus = cp.searchResultAfterDeleteCategory().contains(".........RESULT NOT FOUND.......");
		Assert.assertEquals(deleteAlertStatus, true, Constant.Cp_DeleteCategory);
	}
}
