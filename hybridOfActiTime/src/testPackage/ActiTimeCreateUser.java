package testPackage;

import java.io.IOException;
import org.testng.annotations.Test;
import genericPackage.BaseTest;
import genericPackage.Flib;
import pagePackage.HomePage;
import pagePackage.LoginPage;
import pagePackage.UsersPage;

public class ActiTimeCreateUser extends BaseTest {
	@Test
	public void createValidUser() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		lp.actiTimeValidLogin(flib.readPropertyData(PROPERTY_PATH, "username"),flib.readPropertyData(PROPERTY_PATH, "password"));
		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.clickOnUser();
		Thread.sleep(2000);
		UsersPage up = new UsersPage();
		up.clickOnTab();
		up.validUsn(flib.readExcelData(EXCEL_PATH, "uservaliddata", 1, 0));
		up.validPass(flib.readExcelData(EXCEL_PATH, "uservaliddata", 1, 1));
		up.retypePassword(flib.readExcelData(EXCEL_PATH, "uservaliddata", 1, 1));
		up.firstName(flib.readExcelData(EXCEL_PATH, "uservaliddata", 1, 2));
		up.lastName(flib.readExcelData(EXCEL_PATH, "uservaliddata", 1, 3));
		up.clickOnCreateButton();
		Thread.sleep(2000);
		up.clickOnTab();
	}
}
