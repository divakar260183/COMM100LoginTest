package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.log4j.Logger;
import pageobjects.LoginPage;
import util.ReadData;
import util.WebDriverUtil;

public class StepDefinitions extends LoginPage {
    WebDriver driver;

    final static Logger logger = Logger.getLogger(StepDefinitions.class);



    @Before
    public void beforeTest() {
        driver = WebDriverUtil.getDriver();
    }

    @Given("^I navigate to login page$")
    public void iNavigateToLoginPage() throws InterruptedException {
        driver.findElement(loginLink).click();
        synchronized (driver)
        {
            driver.wait(5000);
        }
        Assert.assertEquals(driver.findElement(loginHeader).getText(),"User Sign In");
    }

    @Then("^I enter email address as \"([^\"]*)\"$")
    public void iEnterEmailAddressAs(String email) {

        driver.findElement(emailInput).sendKeys(email);
    }

    @And("^I enter password as \"([^\"]*)\"$")
    public void iEnterPasswordAs(String password)  {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @And("^I click on Sign In button$")
    public void iClickOnSignInButton() {
        driver.findElement(signInButton).click();
    }

    @Then("^I should see error message$")
    public void iShouldSeeErrorMessage() throws InterruptedException {
        synchronized (driver)
        {
            driver.wait(5000);
        }
        WebElement errorTitleElement = driver.findElement(errorTitle);
        WebElement errorMessageElement  = driver.findElement(errorMessage);
        logger.info("Error Title : " + errorTitleElement.getText());
        logger.info("Error Message : " + errorMessageElement.getText());
        ;
        Assert.assertTrue(errorTitleElement.getText().contains(ReadData.getValue("errorTitle")));
        Assert.assertEquals(errorMessageElement.getText(),ReadData.getValue("errorMessage"));
    }

    @Then("^I should see inline error messages for email and password$")
    public void iShouldSeeInlineErrorMessagesForEmailAndPassword() throws InterruptedException {
        synchronized (driver)
        {
            driver.wait(5000);
        }
        WebElement inlineEmailErrorElement = driver.findElement(inlineEmailError);
        WebElement inlinePasswordErrorElement = driver.findElement(inlinePasswordError);
        logger.info("Email Error : " + inlineEmailErrorElement.getText());
        logger.info("Password Error : " + inlinePasswordErrorElement.getText());

        Assert.assertEquals(inlineEmailErrorElement.getText(),ReadData.getValue("errorEmailEmpty"));
        Assert.assertEquals(inlinePasswordErrorElement.getText(),ReadData.getValue("errorPasswordEmpty"));
    }

    @Then("^I should see inline error messages for password$")
    public void iShouldSeeInlineErrorMessagesForPassword() throws InterruptedException {
        synchronized (driver)
        {
            driver.wait(5000);
        }
        WebElement inlinePasswordErrorElement = driver.findElement(inlinePasswordError);
        logger.info("Password Error : " + inlinePasswordErrorElement.getText());
        Assert.assertEquals(inlinePasswordErrorElement.getText(),ReadData.getValue("errorPasswordEmpty"));
    }

    @Then("^I should see inline error messages for email$")
    public void iShouldSeeInlineErrorMessagesForEmail() throws InterruptedException {
        synchronized (driver)
        {
            driver.wait(5000);
        }
        WebElement inlineEmailErrorElement = driver.findElement(inlineEmailError);
        logger.info("Email Error : " + inlineEmailErrorElement.getText());
        Assert.assertEquals(inlineEmailErrorElement.getText(),ReadData.getValue("errorEmailEmpty"));
    }

    @Then("^I should see inline error messages for invalid email$")
    public void iShouldSeeInlineErrorMessagesForInvalidEmail() throws InterruptedException {
        synchronized (driver)
        {
            driver.wait(5000);
        }
        WebElement inlineEmailErrorElement = driver.findElement(inlineEmailError);
        logger.info("Email Error : " + inlineEmailErrorElement.getText());
        Assert.assertEquals(inlineEmailErrorElement.getText(),ReadData.getValue("errorEmailInvalid"));
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
