package genericPackage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

public class BaseTest implements IAutoConstant{
	protected static WebDriver driver;
	
	@BeforeMethod 
	public void setUp() throws IOException
	{
		Flib flib = new Flib();
		String browserValue = flib.readPropertyData(PROPERTY_PATH, "browser");
		String url = flib.readPropertyData(PROPERTY_PATH, "url");
		if(browserValue.equals("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriver driver=new ChromeDriver(options);
			driver.manage().deleteAllCookies();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(url);
		}
		else if(browserValue.equals("firefox"))
		{
			System.setProperty(GECKO_KEY, GECKO_VALUE);
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(url);
		}
		else
		{
			Reporter.log("enter valid browser",true);
		}
	}

	public void failed(String methodName) 
	{
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenShot"+methodName+".png");
			Files.copy(src, dest);
		}
		catch (Exception e)
		{
		}
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}