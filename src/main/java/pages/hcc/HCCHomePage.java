package pages.hcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import shared.enums.TestEnvironment;
import shared.utils.DriverUtils;

public class HCCHomePage extends HCCBasePage {
    private static final By cashToCloseButton = By.xpath("//a[@href='./cashToCloseCalculator.html']");
    private static final By expectedPaymentsButton = By.xpath("//a[@href='./expectedPaymentsCalculator.html']");

    public HCCHomePage(WebDriver driver) {
        super(driver);
    }

    public HCCHomePage(WebDriver driver, TestEnvironment testEnvironment) {
        super(driver);
        if (testEnvironment == TestEnvironment.PROD) {
            driver.navigate().to("https://jordnkr.github.io/homeCostCalculator/index.html");
        }
        DriverUtils.waitForElement(driver, cashToCloseButton);
    }

    public CashToClosePage clickCashToCloseButton() {
        driver.findElement(cashToCloseButton).click();
        return new CashToClosePage(driver);
    }

    public ExpectedPaymentsPage clickExpectedPaymentsButton() {
        driver.findElement(expectedPaymentsButton).click();
        return new ExpectedPaymentsPage(driver);
    }
}
