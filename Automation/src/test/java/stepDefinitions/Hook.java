package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import util.CaptureScreenshot;
import util.WebDriverUtil;

@Log4j2
public class Hook extends Base{

    @Before
    public void initialSetUp() {
        driver = WebDriverUtil.getDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if(driver !=null) {
            if(scenario.isFailed()) {
                CaptureScreenshot.attachScreenshot(driver, scenario);
            }else {
                CaptureScreenshot.takeFullScreenShotAndAttachWithScenario(driver,scenario);
            }
            driver.quit();
        }
    }

}
