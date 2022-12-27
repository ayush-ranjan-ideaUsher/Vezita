package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	By txt_email = By.xpath("//input[@placeholder='Enter your email']");
	By txt_password = By.xpath("//input[@placeholder='Enter your password']");
	By btn_loginBtn = By.xpath("//button[normalize-space()='Login']");
	
	//Class constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginValidUser(String email, String password) {
		driver.findElement(txt_email).sendKeys(email);
		driver.findElement(txt_password).sendKeys(password);

		driver.findElement(btn_loginBtn).click();
	}
}
