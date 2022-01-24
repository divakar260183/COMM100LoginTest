package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.LoginPage;


public class Base {
    public static WebDriver driver;
    LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);

}
