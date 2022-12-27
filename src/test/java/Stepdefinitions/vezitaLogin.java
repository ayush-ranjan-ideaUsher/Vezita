package Stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class vezitaLogin {

	WebDriver driver = new ChromeDriver(); //To prevent NullPointerEcxeption for loginPage constructor
	String websiteUrl = "https://vezita.netlify.app/";
//	String email = "vezitadocter@yopmail.com";
//	String password = "12345678";

	
	public vezitaLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//Calling loginPage class and creating object.
	LoginPage login =new LoginPage(driver);
	@Given("^Browser is open$")
	public void browser_is_open() {
		// Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ayush\\eclipse-workspace\\Vezita\\src\\test\\resources\\drivers\\chromedriver.exe");

		driver.navigate().to(websiteUrl);
		// driver.get(websiteUrl);
		driver.manage().window().maximize();
		System.out.println("Given method");
	}

	@And("^user has provided the url of login page$")
	public void user_has_provided_the_url_of_login_page() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Verify given url");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		String urlGiven = driver.getCurrentUrl();
		System.out.println(urlGiven.contentEquals(websiteUrl));

	}

	@When("User inputs {string} and {string}")
	public void user_inputs_and(String email, String password) {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Providing input to the fields");
		
		login.loginValidUser(email, password);

		//		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys(email);
//		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(password);

	}

//	@When("^User inputs \\\"(.*)\\\" and \\\"(.*)\\$")
//	public void user_inputs_email_and_password(String email, String password) {
//		// Write code here that turns the phrase above into concrete actions
//		System.out.println("Providing input to the fields");
//		driver.findElement(By.xpath("//input[@placeholder='Enter your email']")).sendKeys(email);
//		driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(password);

//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@And("^Press the login button$")
	public void press_the_login_button() {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("Login button press");
		driver.findElement(By.cssSelector(".btn.btn-primary.mt-7.text-white.loginSetup_login-btn__mw4To")).click();

	}

	@Then("^User should navigate to profile verification page$")
	public void user_should_navigate_to_dashboard_page() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		// System.out.println("Profile verification page");
		Thread.sleep(2000);
		String pageHeading = null;

		try {
			pageHeading = driver.findElement(By.xpath("//h1[normalize-space()='Profile is under verification']"))
					.getText();

		} catch (NoSuchElementException e) {

		}

		if (pageHeading != null) {

			if (pageHeading.contentEquals("Profile is under verification")) {
				System.out.println("Successfully moved to next page");
			} else
				System.out.println("This method failed");
		} else {
			System.out.println("Unable to grab page heading");
		}
	}
}
