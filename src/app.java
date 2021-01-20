import baseClasses.BaseUi;
import pageClasses.HomePage;
import pageClasses.ProductsPage;


public class app {
public static void main(String[] args) {
	

	BaseUi baseUi = new BaseUi();
	
	baseUi.invokeBrowser();
	
	HomePage homePage = baseUi.openWebsite("https://www.amazon.in/");
	
	ProductsPage productsPage=homePage.searchProduct("mobile");
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	productsPage.selectRating(2);
	
	
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	productsPage.setMinMax(5000,8000);
	
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	productsPage.clickGo();
	
	
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	productsPage.mobiles();
}
}
