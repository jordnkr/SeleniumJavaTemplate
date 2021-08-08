package shared.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {
    public static WebElement waitForElement(WebDriver driver, By by) {
        return waitForElement(driver, by, 10);
    }

    public static WebElement waitForElement(WebDriver driver, By by, int timeoutInSeconds) {
        return new WebDriverWait(driver,timeoutInSeconds).until(ExpectedConditions.visibilityOf(driver.findElement((by))));
    }
}
