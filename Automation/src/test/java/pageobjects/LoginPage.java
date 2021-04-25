package pageobjects;

import org.openqa.selenium.By;

public class LoginPage {
    public By loginLink = By.xpath("//*[@id='menu-item-9004111222094893']/a[contains(@href,'login')]");
    public By loginHeader = By.xpath("//*[@id='divLogin']/h1");
    public By emailInput = By.id("txtEmail");
    public By passwordInput = By.id("txtPassword");
    public By signInButton = By.id("lblLogin");
    public By errorMessage = By.id("ajaxErrorMsg");
    public By errorTitle = By.xpath("//*[@id='ajaxError']//div[@class='dialogtitle']");
    public By inlineEmailError = By.xpath("//*[@id='loginContent']//label[@class='error' and @for='txtEmail']");
    public By inlinePasswordError = By.xpath("//*[@id='loginContent']//label[@class='error' and @for='txtPassword']");
}
