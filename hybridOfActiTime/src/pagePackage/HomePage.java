package pagePackage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	@FindBy(xpath="//a[.='Logout']") private WebElement logoutLink;
	@FindBy(id="SubmitTTButton") private WebElement saveLeaveTimeButton;
	@FindBy(xpath="//a[@class='content users']//img[@class='sizer']")private WebElement usersTab;
	@FindBy(name="usersSelector.selectdUser")private WebElement entertimeTrackDropDown;
	//initializations
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	// Utilization
	public WebElement getLogoutLink() {
		return logoutLink;
	}
	public WebElement getSaveLeaveTimeButton() {
		return saveLeaveTimeButton;
	}
	public WebElement getUsers() {
		return usersTab;
	}
	public WebElement getEntertimeTrackDropDown() {
		return entertimeTrackDropDown;
	}
	//Operational methods
	public void logOut() {
		logoutLink.click();
	}	
	public void clickOnUsers()
	{
		usersTab.click();
	}
	public void clickOnSaveLeaveTime()
	{
		saveLeaveTimeButton.click();	
	}

	public void selectUser(int index)
	{
		Select sel=new Select(entertimeTrackDropDown);
		sel.selectByIndex(index);
	}
	public void clickOnUser()
	{
		usersTab.click();
	}

}
