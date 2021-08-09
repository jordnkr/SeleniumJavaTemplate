package shared.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {
    /**
     * Waits for an element to be displayed. Defaults to a 10-second wait time.
     * @param driver - WebDriver object
     * @param by - element locator
     * @return the element, if it's found to be displayed within the wait time
     */
    public static WebElement waitForElement(WebDriver driver, By by) {
        return waitForElement(driver, by, 10);
    }

    /**
     * Waits for a specified amount of time for an element to be displayed.
     * @param driver - WebDriver object
     * @param by - element locator
     * @param timeoutInSeconds - amount of time, in seconds, to wait for the element to be displayed
     * @return the element, if it's found to be displayed within the wait time
     */
    public static WebElement waitForElement(WebDriver driver, By by, int timeoutInSeconds) {
        return new WebDriverWait(driver,timeoutInSeconds).until(ExpectedConditions.visibilityOf(driver.findElement(by)));
    }

    /**
     * Waits for an element to no longer be displayed. Defaults to a 10-second wait time.
     * @param driver - WebDriver object
     * @param by - element locator
     */
    public static void waitForElementNotDisplayed(WebDriver driver, By by) {
        waitForElementNotDisplayed(driver, by, 10);
    }

    /**
     * Waits for a specified amount of time for an element to no longer be displayed.
     * @param driver - WebDriver object
     * @param by - element locator
     * @param timeoutInSeconds - amount of time, in seconds, to wait for the element to no longer be displayed
     */
    public static void waitForElementNotDisplayed(WebDriver driver, By by, int timeoutInSeconds) {
        new WebDriverWait(driver,timeoutInSeconds).until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
    }

    /**
     * Clicks an element and then waits for it to become stale. Typically used when clicking something returns the same page object, rather than a different one. Defaults to a 10-second wait time.
     * @param driver - WebDriver object
     * @param by - element locator
     */
    public static void clickElementAndWaitToBeStale(WebDriver driver, By by) {
        clickElementAndWaitToBeStale(driver, by, 10);
    }

    /**
     * Clicks an element and then waits for it to become stale. Typically used when clicking something returns the same page object, rather than a different one.
     * @param driver - WebDriver object
     * @param by - element locator
     * @param timeoutInSeconds - amount of time, in seconds, to wait for the element to become stale
     */
    public static void clickElementAndWaitToBeStale(WebDriver driver, By by, int timeoutInSeconds) {
        WebElement element = driver.findElement(by);
        element.click();
        new WebDriverWait(driver,timeoutInSeconds).until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Waits for a specified amount of window handles to be displayed. Defaults to a 10-second wait time.
     * @param driver - WebDriver object
     * @param expectedWindowHandles - amount of windows handles to wait for
     */
    public static void waitForWindowHandles(WebDriver driver, int expectedWindowHandles) {
        waitForWindowHandles(driver, expectedWindowHandles, 10);
    }

    /**
     * Waits for a specified amount of window handles to be available.
     * @param driver - WebDriver object
     * @param expectedWindowHandles - amount of windows handles to wait for
     * @param timeoutInSeconds - amount of time to wait for the expected amount of window handles
     */
    public static void waitForWindowHandles(WebDriver driver, int expectedWindowHandles, int timeoutInSeconds) {
        new WebDriverWait(driver,timeoutInSeconds).until(d -> d.getWindowHandles().size() == expectedWindowHandles);
    }

    /**
     * Sets the value of an input text field. Clears the field before entering the specified text.
     * @param driver - WebDriver object
     * @param by - element locator
     * @param textValue - value to enter into the text field
     */
    public static void setTextField(WebDriver driver, By by, String textValue) {
        waitForElement(driver, by).clear();
        driver.findElement(by).sendKeys(textValue);
    }

    /**
     * Sets the 'selected' state of a checkbox.
     * @param driver - WebDriver object
     * @param by - element locator
     * @param checked - true if checkbox should be checked, false if it should be unchecked
     */
    public static void setCheckbox(WebDriver driver, By by, boolean checked) {
        WebElement element = driver.findElement(by);
        if ((checked && !element.isSelected()) || (!checked && element.isSelected()))
        {
            element.click();
        }
    }

    /**
     * Gets a select dropdown element. Allows chaining methods in page objects without needing to instantiate a new Select element each time.
     * @param driver - WebDriver object
     * @param by - element locator
     * @return Select object
     */
    public static Select getSelectElement(WebDriver driver, By by) {
        return new Select(waitForElement(driver, by));
    }

    /**
     * Checks if an element is displayed and has a timeout time. Defaults to a 10-second wait time.
     * @param driver - WebDriver object
     * @param by - element locator
     * @return true if element is displayed within the timeout time, false if not
     */
    public static boolean isElementDisplayed(WebDriver driver, By by) {
        return isElementDisplayed(driver, by, 10);
    }

    /**
     *  Checks if an element is displayed, allowing for a timeout value to be set
     * @param driver - WebDriver object
     * @param by - element locator
     * @param timeoutInSeconds - amount of time to wait for the element to be displayed
     * @return true if element is displayed within the timeout time, false if not
     */
    public static boolean isElementDisplayed(WebDriver driver, By by, int timeoutInSeconds) {
        try
        {
            waitForElement(driver, by, timeoutInSeconds);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
