package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class SubCategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement selectCategoryField;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement selectSubCategoryField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement firstSubCategoryName;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[2]")
	WebElement firstCategoryName;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a[2]")
	WebElement subCategoryDeleteIcon;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton;
	@FindBy(xpath = "//select[@id='un']")
	WebElement searchCategory;
	@FindBy(xpath = "//input[@name='ut']")
	WebElement searchSubCategory;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchButtonInside;
	@FindBy(xpath = "//span[@id='res']")
	WebElement deleteMessage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a[1]")
	WebElement subCategoryEditIcon;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subCategoryEdit;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement editMessage;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[4]//a")
	WebElement changeStatus;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement statusAlert;
	@FindBy(xpath = "//li[@class='breadcrumb-item']")
	WebElement homeHyperlink;

	public void addSubCategory() {

		newButton.click();
		gu.selectDropdownWithVisibleText(selectCategoryField, "phone");
		selectSubCategoryField.sendKeys("iphone" + gu.generateCurrentDateAndTime());
		saveButton.click();
	}

	public String getAlertMessage() {
		return alertMessage.getText();
		
	}

	public void deleteSubCategory() {
		String SubCategoryName = firstSubCategoryName.getText();
		String categoryName = firstCategoryName.getText();
		subCategoryDeleteIcon.click();
		wu.waitForAlertIsPresent(driver, 10);
		gu.alertAccept(driver);
		searchButton.click();
		gu.selectDropdownWithVisibleText(searchCategory, categoryName);
		searchSubCategory.sendKeys(SubCategoryName);
		searchButtonInside.click();
	}

	public String deleteMessage() {
		return deleteMessage.getText();
		
	}

	public void editSubCategory() {
		subCategoryEditIcon.click();
		subCategoryEdit.sendKeys("new");
		updateButton.click();
	}

	public String editMessage() {
		return editMessage.getText();
	}

	public void changeStatus() {
		changeStatus.click();

	}

	public String statusAlertMessage() {
		return statusAlert.getText();
	}

	public void homeHyperlink() {
		homeHyperlink.click();

	}

}
