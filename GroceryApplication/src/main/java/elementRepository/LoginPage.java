package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.EncryptDecryptUtility;
import utilities.WaitUtilities;

public class LoginPage {
	WebDriver driver;
	EncryptDecryptUtility edu = new EncryptDecryptUtility();
	

	public LoginPage(WebDriver driver) {// constructor
		this.driver = driver;// driver initialize
		PageFactory.initElements(driver, this); // with PageFactory(for use @findby, initElements is static method of
												// page factory,driver is web driver and this is for current class instance
												// variable
	}
	
	@FindBy(xpath = "//input[@name='username']") // declaring username
	WebElement userNameField;// web element deceleration
	@FindBy(name = "password") // declaring pwd
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signInButton;
	@FindBy(xpath = "//h5[text()=' Alert!'] ")
	// @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;
	@FindBy(xpath = "//label[@for='remember']")
	WebElement rememberMe;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginPageHeading;

//function
	public HomePage login(String userName, String password) {
		userNameField.sendKeys(userName);
		passwordField.sendKeys(password);
		rememberMe.click();
		signInButton.click();
		return new HomePage(driver);// constructor calling
	}

	public HomePage reLogin() {
		signInButton.click();
		return new HomePage(driver);
	}

	public String readErrorMessage() {
		return errorMessage.getText();
	}

	public String getLoginPageHeading() {
		return loginPageHeading.getText();
	}

	public String decryptPassword(String password) throws Exception {
		// return EncryptDecryptUtility.decrypt(password, "1234567890123456");
		String decrptPassword = edu.decrypt(password, "1234567890123456");
		return decrptPassword;
	}

}
