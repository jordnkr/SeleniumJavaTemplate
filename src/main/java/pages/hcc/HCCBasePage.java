package pages.hcc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HCCBasePage extends BasePage {
    private static final By hccLogo = By.xpath("//a[@class='title']/b[text()='Home Cost Calculators']");

    public HCCBasePage(WebDriver driver) {
        super(driver);
    }
    public HCCHomePage clickHCCLogo() {
        driver.findElement(hccLogo).click();
        return new HCCHomePage(driver);
    }
}
