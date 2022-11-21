package GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseClass 
{
	public FileUtitlity fLib=new FileUtitlity();
	public ExcelUtitlity eLib=new ExcelUtitlity();
	public JavaUtitlity jLib=new JavaUtitlity();
	public WebDriverUtility wLib=new WebDriverUtility();
	public DataBaseUtitlity dLib=new DataBaseUtitlity();
	public WebDriver driver;
	public static WebDriver sDriver;
	
	public void connectToDB() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("----Connect to DB-------");
	}
	
	//@Parameters("Browsername")
	@BeforeClass
	public void lunchBrowser() throws Throwable
	{
		
		String BROWSER=fLib.readDataFrompropertyFile("browser");
		System.out.println("Launh the browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Inavalid Browser");
		}
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		
		String URL = fLib.readDataFrompropertyFile("URL");
		System.out.println("get the url");
		sDriver=driver;
		driver.get(URL);
		
	}
	/*
	@BeforeMethod
	public void loginToApp() throws Throwable
	{		
		System.out.println("Inside Before method");
	}
	
	@AfterMethod
	public void signout()
	{
		System.out.println("Inside After Method");
	}
	*/
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("Close the Browser");
	}
	
	@AfterSuite
	public void CloseDB() throws Throwable
	{
		dLib.closeDB();
		System.out.println("close DataBase Connection");
	}
	
	}
	
