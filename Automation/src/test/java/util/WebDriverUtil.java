package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {

    public static WebDriver getDriver() {

        WebDriver driver;
        String browser = Config.getConfigs().getValue("browser");

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
        driver.manage().window().maximize();
        driver.get(Config.getConfigs().getValue("url"));
        return driver;
    }
}
