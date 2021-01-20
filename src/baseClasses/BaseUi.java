package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pageClasses.HomePage;
import utilities.ExtentReportManager;

public class BaseUi {

	public WebDriver driver=null;
	public WebDriverWait wait = null;
	
	public DesiredCapabilities cap = null;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	static Properties prop = readProperties();
	public void invokeBrowser() {
		String browserName=prop.getProperty("browser");
		
		String projectPath = System.getProperty("user.dir");
		this.logger = report.createTest("invokeBrowser");
		try {
			if (browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedrivers/chromedriver.exe");
				
				WebDriver driver = new ChromeDriver();
			}
			else if (browserName.equalsIgnoreCase("edge")) 
			{
				System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedrivers/chromedriver.exe");
				
				//WebDriver driver = new Edge();
			} 
			else {
				System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedrivers/chromedriver.exe");
				
				//WebDriver driver = new GekoDriver();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
//			reportFail(e.getMessage());
		}
		try {
			
			logger.log(Status.INFO, "node is connected to hub http://192.168.1.28:4444/wd/hub");
			driver = new RemoteWebDriver(new URL(" http://192.168.0.111:4444/wd/hub"), cap);			//pass address of hub as argument in URL()
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
	}

	public HomePage openWebsite(String url) {
//		logger = report.createTest("invokeBrowser");
		logger.log(Status.INFO, "Opening website https://www.amazon.in/");
		
		driver.get(url);
		//assertEquals(driver.getTitle(), "Movie Tickets, Plays, Sports, Events & Cinemas nearby - BookMyShow");
		driver.manage().window().maximize();
		return PageFactory.initElements(driver, HomePage.class);
	}

	public void waits(WebDriver driver, int time, WebElement element) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static Properties readProperties() {
		File file = new File("config.properties");
		  
		FileInputStream fileInput = null;
		
		try {
			fileInput = new FileInputStream(file);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}
	
	public void threadSleep(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeAndFlushReport()
	{
		report.flush();
		driver.close();
	}
}
