package pagePackage;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		//to avoid stalereFrenceException
		@FindBy(name="username") private WebElement UsernameTB; 
		@FindBy(name="pwd") private WebElement PasswordTB;
		@FindBy(id="loginButton") private WebElement loginButton;

		@FindBy(id="keepLoggedInCheckBox") private WebElement LoggedInCheckBox;
		@FindBy(xpath="//a[.='Actimind Inc.']") private WebElement ActiMindLine;
		@FindBy(id="licenseLink") private WebElement LicenseLink;

		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getUsernameTB() {
			return UsernameTB;
		}
		public WebElement getPasswordTB() {
			return PasswordTB;
		}
		public WebElement getLoginButton() {
			return loginButton;
		}
		public WebElement getLoggedInCheckBox() {
			return LoggedInCheckBox;
		}
		public WebElement getActiMindLine() {
			return ActiMindLine;
		}
		public WebElement getLicenseLink() {
			return LicenseLink;
		}

		//Operational methods
		public void actiTimeValidLogin(String validUsername, String validPassword) throws InterruptedException {
			UsernameTB.sendKeys(validUsername);
			PasswordTB.sendKeys(validPassword);
			Thread.sleep(2000);
			loginButton.click();
		} 
		public void actiTimeInValidLogin(String inValidUsername,String inValidPassword) throws InterruptedException
		{
			UsernameTB.sendKeys(inValidUsername);
			Thread.sleep(2000);
			PasswordTB.sendKeys(inValidPassword);
			Thread.sleep(2000);
			loginButton.click();
			Thread.sleep(1000);
		}
	}
