package tests.hcc;

import org.junit.Assert;
import org.junit.Test;
import pages.hcc.CashToClosePage;
import pages.hcc.ExpectedPaymentsPage;
import pages.hcc.HCCHomePage;
import tests.BaseTest;

public class HomePageButtonTests extends BaseTest {

    @Test
    public void CashToCloseButton() {
        HCCHomePage hccHomePage = new HCCHomePage(driver, testEnvironment);
        CashToClosePage cashToClosePage = hccHomePage.clickCashToCloseButton();
        Assert.assertTrue(cashToClosePage.isCashToCloseTextDisplayed());
    }

    @Test
    public void ExpectedPaymentsButton() {
        HCCHomePage hccHomePage = new HCCHomePage(driver, testEnvironment);
        ExpectedPaymentsPage expectedPaymentsPage = hccHomePage.clickExpectedPaymentsButton();
        Assert.assertTrue(expectedPaymentsPage.isMonthlyPaymentsTextDisplayed());
    }
}
