package pagePackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {
	//@FindBy(xpath="//a[@class='content users']/descendant:://img[@class='sizer']")
	@FindBy(xpath="//a[@class='content users']//img[@class='sizer']")private WebElement usersTab;
@FindBy(xpath="//input[@type='button' and (@value='Create New User')]") private WebElement createUser;
@FindBy(name="username") private WebElement usnTextBox;
@FindBy(name="passwordText") private WebElement passTextBox;
@FindBy(name="passwordTextRetype") private WebElement retypePassTextBox;
@FindBy(name="firstName") private WebElement firstTextBox;
@FindBy(name="lastName") private WebElement lastTextBox;
@FindBy(xpath="//input(@type='submit' and (.='')]") private WebElement createUserButton;
@FindBy(name="//input[ (@value='      Cancel      ')]") private WebElement cancelButton;
public WebElement getUsersTab() {
	return usersTab;
}
public WebElement getCreateUser() {
	return createUser;
}
public WebElement getUsnTextBox() {
	return usnTextBox;
}
public WebElement getPassTextBox() {
	return passTextBox;
}
public WebElement getRetypePassTextBox() {
	return retypePassTextBox;
}
public WebElement getFirstTextBox() {
	return firstTextBox;
}
public WebElement getLastTextBox() {
	return lastTextBox;
}
public WebElement getcreateUserButton() {
	return createUserButton;
}
public WebElement getCancelButton() {
	return cancelButton;
}

//operational methods;
public void validUsn(String validUser)
{
	getUsnTextBox().sendKeys(validUser);
}
public void validPass(String validPassword)
{
getPassTextBox().sendKeys(validPassword);	
}
public void firstName(String fname) {
	firstTextBox.sendKeys(fname);
}
public void lastName(String lname)
{
lastTextBox.sendKeys(lname);	
}
public void clickOnCreateButton()
{
createUserButton.click();
}
public void clickOnTab()
{
	createUser.click();
	}
public void retypePassword(String re)
{
	retypePassTextBox.sendKeys(re);
	}
}

