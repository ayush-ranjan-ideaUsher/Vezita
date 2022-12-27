package Stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.doctorSetupPageOne;

public class DoctorSetupPageOneStepDefinition {
	WebDriver driver;
	WebDriverWait waitForElement;
	doctorSetupPageOne dtrSetupPageOne= new doctorSetupPageOne(driver);

	@Given("User already navigated to the doctor setup page")
	public void user_already_navigated_to_the_doctor_setup_page() {
		//URL verification
		
		vezitaLogin loginTry = new vezitaLogin(driver);
		loginTry.browser_is_open();
		loginTry.user_inputs_and("newregister2@yopmail.com", "1234578");
		loginTry.press_the_login_button();
	}

	@And("Continue button for Setup A is visible")
	public void continue_button_for_setup_a_is_visible() {
		waitForElement = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitForElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Continue']")));
	}

	@When("User presses the button")
	public void user_presses_the_button() {
		
		dtrSetupPageOne.buttonClick();
	}

	@Then("User should navigate to Basic details page")
	public void user_should_navigate_to_basic_details_page() {
		
	}

}
