package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import stepDefinitions.Base;

public class WebDriverUtil extends Base {

    public static WebDriver getDriver() {

        String browser = FileReaderManager.getInstance().getConfigReader().getBrowser();

        switch (browser) {
            case "Chrome": {
                driver = new ChromeDriver();
                break;
            }
            case "Firefox": {
                driver = new FirefoxDriver();
                break;
            }
            default: {
                driver=null;
                System.out.println("Not Valid browser");
                break;
            }
        }
        assert driver != null;
        driver.manage().window().maximize();
        return driver;
    }

    public static void launchURL() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getURL());
    }
}
