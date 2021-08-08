package pages.hcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shared.utils.DriverUtils;

public class ExpectedPaymentsPage extends HCCBasePage {
    private static final By monthlyPaymentsNumberText = By.id("monthlyPayment");

    public ExpectedPaymentsPage(WebDriver driver) {
        super(driver);
        DriverUtils.waitForElement(driver, monthlyPaymentsNumberText);
    }

    public boolean isMonthlyPaymentsTextDisplayed() {
        return driver.findElement(monthlyPaymentsNumberText).isDisplayed();
    }
}
