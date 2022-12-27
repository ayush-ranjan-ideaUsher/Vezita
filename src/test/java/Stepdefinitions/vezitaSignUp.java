package Stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.SignUpPage;

public class vezitaSignUp {
	WebDriver driver=new ChromeDriver(); //To prevent NullPointerEcxeption for loginPage constructor
	WebDriverWait wait;
	String websiteUrl = "https://vezita.netlify.app/";
	
	SignUpPage signUpPagePOM = new SignUpPage(driver);

	@Given("Browser is still open")
	public void browser_is_still_open() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/ayush/eclipse-workspace/Vezita/src/test/resources/drivers/chromedriver.exe");
		//driver = new ChromeDriver();

		driver.navigate().to(websiteUrl);
		// driver.get(websiteUrl);
		driver.manage().window().maximize();
	}

	@And("User moved to login page")
	public void user_moved_to_login_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println(driver.getTitle());
	}

	@When("User move from login page to signup page")
	public void user_move_from_login_page_to_signup_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//a[normalize-space()='Signup']")).click();
	}

	@And("user inputs non registered {string} and {string}")
	public void user_inputs_non_registered_and(String string, String string2) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Login']")));
		// Write code here that turns the phrase above into concrete actions
		signUpPagePOM.signUpInput(string, string2);
		
//		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys(string);
//		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(string2);
	}

	@And("user input same {string} to confirm password field also select privacy checkbox")
	public void user_input_same_to_confirm_password_field_also_select_privacy_checkbox(String string) {
		// Write code here that turns the phrase above into concrete actions
		signUpPagePOM.checkButtonAndButtonPress();
	}

//	@And("user input same password to confirm password field also select privacy checkbox")
//	public void user_input_same_password_to_confirm_password_field_also_select_privacy_checkbox() {
//		driver.findElement(By.xpath("//input[@placeholder='Confirm password']"));
//		// Write code here that turns the phrase above into concrete actions
//	}

	@Then("user should get prompt")
	public void user_should_get_prompt() throws InterruptedException {
		driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
		// Write code here that turns the phrase above into concrete actions
		String signUpSuccessfulTest = null;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Login']")));
			signUpSuccessfulTest = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
		} catch (Exception e) {

		}

		if (signUpSuccessfulTest != null) {
			System.out.println("Signup registration was successful");
		} else
			System.out.println("Signup registration failed");
		
		Thread.sleep(5000);
		driver.quit();
	}

}
