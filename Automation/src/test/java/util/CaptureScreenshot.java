package util;


import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Log4j2
public class CaptureScreenshot {

    public static void attachScreenshot(WebDriver driver, Scenario scenario){
        try {
            if(scenario==null){
                log.info("#Scenario is NULL");
            }

            if(driver==null){
                log.info("#Driver is NULL");
            }
            if(driver!=null && scenario!=null) {
                driver.wait(5000);
                final byte[] screenshot =
                        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
                log.info("#screenshot:length:" + screenshot.length);
                log.info("#Taking Screenshot completed" + scenario.getName());
            }

        }catch (Exception e) {
            log.error("ex:captureScreenshot:"+e);
        }finally {
            if(driver!=null) {
                driver.close();
            }
        }
    }



    public static void takeFullScreenShotAndAttachWithScenario(WebDriver driver,Scenario scenario){
        try {
            if(scenario==null){
                log.info("#Scenario is NULL");
            }
            if(driver==null){
                log.info("#Driver is NULL");
            }

            if(driver!=null && scenario!=null) {
                BufferedImage image  = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver).getImage();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image, "png", baos);
                baos.flush();
                byte[] imageInByte = baos.toByteArray();
                log.info("#Scenario name:"+scenario.getName());
                scenario.attach(imageInByte,"image/png",scenario.getName());
                baos.close();
                log.info("#Taking Screenshot completed" + scenario.getName());
            }
        }catch(Exception ex){
            log.error("Exception:takeFullScreenShot"+ex);
        }finally {
            if(driver!=null){
                driver.close();
            }
        }
    }

}
