package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;

public class HomePage extends BaseUi {
	WebDriver driver;

	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement textBox;

	public HomePage(WebDriver driver) {
		this.driver = driver; 
		this.logger = report.createTest("HomePage");
	}
	
	public ProductsPage searchProduct(String product)
	{
		textBox.sendKeys(product);
		searchButton.click();
		return PageFactory.initElements(driver, ProductsPage.class);
	}


}