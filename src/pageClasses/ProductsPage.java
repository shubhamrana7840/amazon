package pageClasses;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.formula.ThreeDEval;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseUi;

public class ProductsPage extends BaseUi {

	@FindBy(xpath = "//*[@id=\"p_72/1318476031\"]/span/a/section/i")
	WebElement fourStar;

	@FindBy(xpath = "//*[@id=\"p_72/1318477031\"]/span/a/section/i")
	WebElement threeStar;

	@FindBy(xpath = "//*[@id=\"p_72/1318478031\"]/span/a/section/i")
	WebElement twoStar;

	@FindBy(xpath = "//*[@id=\"p_72/1318479031\"]/span/a/section/i")
	WebElement oneStar;

	@FindBy(xpath = "//*[@id=\"low-price\"]")
	WebElement min;

	@FindBy(xpath = "//*[@id=\"high-price\"]")
	WebElement max;

	@FindBy(xpath = "//*[@id=\"p_36/price-range\"]/span/form/span[3]/span/input")
	WebElement go;

	public void mobiles() {
		List<WebElement> mobiles = driver.findElements(By.className("a-size-medium a-color-base a-text-normal"));
		for(int i=0;i<mobiles.size();i++)
		{
			System.out.println(mobiles.get(i).getText());
		}
	}

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		this.logger = report.createTest("HomePage");
	}

	public void selectRating(int rating) {
		if (rating == 1) {
			oneStar.click();
		} else if (rating == 2) {
			twoStar.click();
		} else if (rating == 3) {
			threeStar.click();
		} else if (rating == 4) {
			fourStar.click();
		}
	}

	
	public void setMinMax(int minValue, int maxValue) {
		this.min.sendKeys("" + minValue);
		this.max.sendKeys("" + maxValue);
	}

	public void clickGo() {
		go.click();
	}

}
