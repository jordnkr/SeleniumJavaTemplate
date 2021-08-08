package pages.hcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shared.utils.DriverUtils;

public class CashToClosePage extends HCCBasePage {
    private static final By cashToCloseFinalNumberText = By.id("cashToClose");

    public CashToClosePage(WebDriver driver) {
        super(driver);
        DriverUtils.waitForElement(driver, cashToCloseFinalNumberText);
    }

    public boolean isCashToCloseTextDisplayed() {
        return driver.findElement(cashToCloseFinalNumberText).isDisplayed();
    }
}
