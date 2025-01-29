package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtilities;

public class HomePage {
	WebDriver driver;
	WaitUtilities wu=new WaitUtilities();

	public HomePage(WebDriver driver) {// constructor 9 t0 12 line
		this.driver = driver;
		PageFactory.initElements(driver, this); // with PageFactory(for use @findby, initElements is static method of
												// page factory
	}

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement homePageHeading;
	@FindBy(xpath = "//a//p[text()='Sub Category']")
	WebElement subCategoryMenu;
	@FindBy(xpath = "//a//p[text()='Category']")
	WebElement CategoryMenu;
	@FindBy(xpath = "//li[@class='nav-item dropdown']//a")
	WebElement AdminButton;
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']//a[2]")
	WebElement Logout;
	@FindBy(xpath = "//p[text()='Manage Contact']")
	WebElement manageContactMenu;

	public String getHomePageHeading() {
		wu.waitForWebElementText(driver, "7rmart supermarket");
		return homePageHeading.getText();// element.get text (7rsupermarket
	}

	public SubCategoryPage clickOnSubCategoryMenu() {
		subCategoryMenu.click();
		return new SubCategoryPage(driver);
	}

	public CategoryPage clickOnCategoryMenu() {
		CategoryMenu.click();
		return new CategoryPage(driver);
	}

	public LoginPage logOut() {
		AdminButton.click();
		Logout.click();
		return new LoginPage(driver);

	}

	public ManageContactPage clickOnManageContactMenu() {
		manageContactMenu.click();
		return new ManageContactPage(driver);
	}

}
