package pageobjects;

import jsonDataReader.ErrorMessages;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.FileReaderManager;

@SuppressWarnings("SynchronizeOnNonFinalField")
@Log4j2
public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath ="//*[@id='menu-item-5710']/a[contains(@href,'login')]")
    WebElement loginLink;

    @FindBy(xpath ="//*[@id='divLogin']/h1")
    WebElement loginHeader;

    @FindBy(id ="txtEmail")
    WebElement emailInput;

    @FindBy(id = "txtPassword")
    WebElement passwordInput;

    @FindBy(id ="lblLogin")
    WebElement signInButton;

    @FindBy(id ="ajaxErrorMsg")
    WebElement errorMessage;

    @FindBy(xpath = "//*[@id='ajaxError']//div[@class='dialogtitle']")
    WebElement errorTitle;

    @FindBy(xpath = "//*[@id='loginContent']//label[@class='error' and @for='txtEmail']")
    WebElement inlineEmailError;

    @FindBy(xpath = "//*[@id='loginContent']//label[@class='error' and @for='txtPassword']")
    WebElement inlinePasswordError;

    public void navigateToLoginPage() throws InterruptedException {
        loginLink.click();
        //noinspection SynchronizeOnNonFinalField
        synchronized (driver)
        {
            driver.wait(5000);
        }
        Assert.assertEquals(loginHeader.getText(),"User Sign In");
    }

    public void enterEmailAddressAs(final String email) {
        emailInput.sendKeys(email);
    }

    public void clearEmailAddress() {
        emailInput.clear();
    }

    public void clearPassword() {
        passwordInput.clear();
    }

    public void enterPassword(final String password){
        passwordInput.sendKeys(password);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public void validateErrorMessage() throws InterruptedException {
        ErrorMessages errorMessages = FileReaderManager.getInstance().getErrorMessageJsonReader().getErrorMessage();
        synchronized (driver)
        {
            driver.wait(5000);
        }
        log.info("Error Title : " + errorTitle.getText());
        log.info("Error Message : " + errorMessage.getText());
        Assert.assertTrue(errorTitle.getText().contains(errorMessages.errorTitle));

        Assert.assertEquals(errorMessage.getText(),errorMessages.errorMessage);
    }

    public void validateInlineErrorMessageForEmailAndPassword() throws InterruptedException {
        ErrorMessages errorMessages = FileReaderManager.getInstance().getErrorMessageJsonReader().getErrorMessage();
        synchronized (driver)
        {
            driver.wait(5000);
        }
        log.info("Email Error : " + inlineEmailError.getText());
        log.info("Password Error : " + inlinePasswordError.getText());

        Assert.assertEquals(inlineEmailError.getText(),errorMessages.errorEmailEmpty);
        Assert.assertEquals(inlinePasswordError.getText(),errorMessages.errorPasswordEmpty);
    }

    public void validateInlineErrorMessageForPassword() throws InterruptedException {
        ErrorMessages errorMessages = FileReaderManager.getInstance().getErrorMessageJsonReader().getErrorMessage();
        synchronized (driver)
        {
            driver.wait(5000);
        }
        log.info("Password Error : " + inlinePasswordError.getText());
        Assert.assertEquals(inlinePasswordError.getText(),errorMessages.errorPasswordEmpty);
    }

    public void validateInlineErrorMessageForEmailEmpty() throws InterruptedException {
        ErrorMessages errorMessages = FileReaderManager.getInstance().getErrorMessageJsonReader().getErrorMessage();
        synchronized (driver)
        {
            driver.wait(5000);
        }
        log.info("Email Error : " + inlineEmailError.getText());
        Assert.assertEquals(inlineEmailError.getText(),errorMessages.errorEmailEmpty);
    }

    public void validateInlineErrorMessageForInvalidEmail() throws InterruptedException {
        ErrorMessages errorMessages = FileReaderManager.getInstance().getErrorMessageJsonReader().getErrorMessage();
        synchronized (driver)
        {
            driver.wait(5000);
        }
        log.info("Email Error : " + inlineEmailError.getText());
        Assert.assertEquals(inlineEmailError.getText(),errorMessages.errorEmailInvalid);
    }
}