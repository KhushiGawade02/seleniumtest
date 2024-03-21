package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/*
 * This class has been generated by Selenium IDE after recording the login scenario on localhost for Swag Labs application.
 * The purpose is to show how to write a basic Selenium test case
 * The recording was exported as Java Selenium with JUnit, with the only changes:
 * 1. setting the package to test.ui
 * Adding in the setup the setting of the property "webdriver.chrome.driver" pointing to the absolute folder on my computer of the Chrome Web Driver.
 * So this has to be changed accordingly
 */
public class LoginBasicTest {
	//IMPORTANT: Please download a Chrome driver and set this variable to the full path to the file
	private final static String CHROME_DRIVER_FULL_PATH ="C:\\Users\\Khushi\\Downloads\\chromedriver-win64.zip\\chromedriver-win64";
	//private final static String GECKO_DRIVER_FULL_PATH = "/Users/leonardolanni/Downloads/geckodriver";
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FULL_PATH);
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_FULL_PATH);
		//driver = new FirefoxDriver();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void login() {
		System.out.println("0. Start");
		
		System.out.println("1. Open target page");
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().setSize(new Dimension(1350, 637));
		
		System.out.println("2. Insert username and password");
		
		System.out.println(" 2.1 Insert username");
		driver.findElement(By.id("login_credentials")).click();
		driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
		
		System.out.println(" 2.1 Insert password");
		driver.findElement(By.cssSelector(".login_password")).click();
		driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
		driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
		
		System.out.println("3. Click submit to perform login");
		driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();

		System.out.println("4. Verify login has been successfully executed");
		System.out.println(" 4.1 Page title is 'Swag Labs'");
		Assert.assertEquals(driver.getTitle(), "Swag Labs");
		
		System.out.println(" 4.2 Page url contains 'inventory'");
		Assert.assertEquals(driver.getCurrentUrl().contains("inventory"), true);
		
		//Pause the execution for 2 seconds to show the logged in page
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("5. End");
	}
}
