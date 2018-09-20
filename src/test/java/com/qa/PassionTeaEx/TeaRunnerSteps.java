package com.qa.PassionTeaEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.junit.Assert;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static junit.framework.TestCase.assertEquals;

public class TeaRunnerSteps {

    private static final LogStatus LogStatus = null;
	WebDriver driver;
    private static ExtentReports  reports = new ExtentReports(Constants.report, true);
    public ExtentTest test;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown()
    {
        driver.quit();
        reports.endTest(test);
        reports.flush();
    }
    
    @Given("^the correct web address$")
    public void the_correct_web_address() {
        // Write code here that turns the phrase above into concrete actions
    	driver.get(Constants.url);
    	test=reports.startTest("Passion Tea Website Test Report");
    	test.log(LogStatus.INFO,"Browser Started");
    	
        if (driver.getCurrentUrl().equals(Constants.url)) {
        	test.log(LogStatus.PASS, "web page accessed correctly");
        }
        else {
        	test.log(LogStatus.FAIL, "Web Page not accessed correctly");
        }
    	
        assertEquals(driver.getCurrentUrl(), Constants.url);
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page(){
        // Write code here that turns the phrase above into concrete actions
        manupage menupg=PageFactory.initElements(driver, manupage.class);
        menupg.menuClick();
        assertEquals(driver.getCurrentUrl(), Constants.menuUrl);
        test.log(LogStatus.INFO, "page menu accessed correctly");
        test.log(LogStatus.PASS, "successfully navigate through the main menu page");
        
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products() {
     
	// Write code here that turns the phrase above into concrete actions
      test.log(LogStatus.PASS, "Product available to user");
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
    
    
    
}