package elementRepository;

import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class CategoryPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu=new WaitUtilities();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[4]//a[1]")
	WebElement categoryEditIcon;
	@FindBy(xpath = "//input[@id='category']")
	WebElement editCategoryName;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement categoryUpdateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryEditStatusAlert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[4]//a[2]")
	WebElement deleteCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categoryField;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement discountField;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageAttachmentField;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	@FindBy(xpath = "//ul[@class='ms-list']")
	WebElement categoryDiscountField;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryAddStatusAlert;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']//table//tbody//tr//td[1]")
	List<WebElement> tableSize;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement categoryDeleteStatusAlert;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement lastCreatedCategoryName;
	@FindBy(xpath = "//span[@id='res']//Center")
	WebElement altertmessageAfterSearchdeletedCategory;
	
	@FindBy(xpath = "//a[text()=' Search']")
	WebElement searchButtonOfCategory;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categoryFieldinsideCategorySearch;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButtonInsideCategorySearch;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td//span//center")
	WebElement ResultAfterDeleteCategory;
	
	
	public void editCategory() {
		categoryEditIcon.click();
		editCategoryName.sendKeys("new");		
		gu.pageScroll(200,400, driver);
		wu.waitForWebElement(driver, categoryUpdateButton, "class","btn btn-danger", 10);	
		System.out.println(editCategoryName.getText());
		//categoryUpdateButton.click();
		gu.clickJavaScriptExecutor(driver,categoryUpdateButton);
		
		
	}
	public String categoryEditStatusAlert() {
		 return categoryEditStatusAlert.getText();
}
	public void addNewCategory(String catagory, String imagePath) throws AWTException{
		newButton.click();
		categoryField.sendKeys(catagory + gu.generateCurrentDateAndTime());
		discountField.click();	
		gu.pageScroll(200, 400, driver);
		imageAttachmentField.sendKeys(imagePath);
		gu.clickJavaScriptExecutor(driver, saveButton);
	}
	public String categoryAddStatusAlert() {
		 return categoryAddStatusAlert.getText();
}
	public void deleteSelectedCategory(String category) {
		
		for (int i = 0; i < tableSize.size(); i++) {
			if (tableSize.get(i).getText().equals(category)) {
				String deleteElement = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr["+(i+1)+"]//td[4]//a[2]";				
				WebElement deleteButton = driver.findElement(By.xpath(deleteElement));
				gu.clickJavaScriptExecutor(driver, deleteButton);
				gu.alertAccept(driver);
			} 
		}
	}
	public void searchCategory(String catagory){
		searchButtonOfCategory.click();
		categoryFieldinsideCategorySearch.sendKeys(catagory);
		searchButtonInsideCategorySearch.click();			
	}	
	public String searchResultAfterDeleteCategory() {		
		return ResultAfterDeleteCategory.getText();
	}	
	}

