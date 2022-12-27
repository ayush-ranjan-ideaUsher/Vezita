package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
	
	WebDriver driver;
	By txt_email = By.xpath("//input[@placeholder='Enter your email']");
	By txt_passowrd = By.xpath("//input[@placeholder='Enter your password']");
	By txt_confirmPassword = By.xpath("//input[@placeholder='Confirm password']");
	By btn_privacyCheckBox = By.xpath("//input[@type='checkbox']");
	By btn_signUp = By.xpath("//button[normalize-space()='Signup']");

	//Class constructor
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void signUpInput (String email,String password) {
		driver.findElement(txt_email).sendKeys(email);
		driver.findElement(txt_passowrd).sendKeys(password);
		driver.findElement(txt_confirmPassword).sendKeys(password);
	}
	
	public void checkButtonAndButtonPress () {
		driver.findElement(btn_privacyCheckBox).click();
		driver.findElement(btn_signUp).click();
	}
}
