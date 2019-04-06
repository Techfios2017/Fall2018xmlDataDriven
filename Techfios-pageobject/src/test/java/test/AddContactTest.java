package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContact;
import page.HomePage;
import page.LoginPage;
import util.BrowserFactory;

public class AddContactTest {	

	
@Test
@Parameters({"Loginemail","password","Name","Company","Email","phone","address","City","State","Zip"})
public void AddingContact(String Loginemail,String password,String Name,String Company,String Email,String phone,String address, String City,String State,String Zip)throws InterruptedException{

	WebDriver driver = BrowserFactory.startBrowser("chrome", "http://techfios.com/test/billing/?ng=login/");	
	
	LoginPage logintotechfios= PageFactory.initElements(driver, LoginPage.class);

	logintotechfios.Login(Loginemail, password);
	
	HomePage home= PageFactory.initElements(driver, HomePage.class);
	
	home.NavigateToAddContact();
	
	AddContact contact=PageFactory.initElements(driver, AddContact.class);
	
	contact.FillingUpAdressForm(Name, Company, Email, phone, address, City, State, Zip);

	driver.close();
	
	driver.quit();
	
	
}

}
