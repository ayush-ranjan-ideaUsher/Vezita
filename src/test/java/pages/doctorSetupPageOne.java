package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class doctorSetupPageOne {

	WebDriver driver;
	String url = "https://vezita.netlify.app/doctorsetup";
	By btn_continue =By.xpath("//button[normalize-space()='Continue']");
	
	public doctorSetupPageOne(WebDriver driver) {
		this.driver = driver;
	}
	
	public void buttonClick() {
		driver.findElement(btn_continue).click();
	}
	
}
