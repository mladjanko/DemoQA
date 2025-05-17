package Tests;

import Base.BaseTest;
import Pages.AlertsPage;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ALERTS_FRAME_WINDOWS;
import static Helpers.URLs.ALERTS_PAGE_URL;
import static Helpers.URLs.HOME_PAGE_URL;

public class AlertsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        alertsPage = new AlertsPage();

        driver.navigate().to(HOME_PAGE_URL);
        homepagePage.clickOnCard(ALERTS_FRAME_WINDOWS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 14, 1));

        String currentURL = driver.getCurrentUrl();
        assert currentURL != null;
        Assert.assertTrue(testedPageIsReached(currentURL, ALERTS_PAGE_URL), "Tested page is not reached!");
    }

    @Test(priority = 10)
    public void testClickOnAlertButton() {
        WebElement alertButton = alertsPage.alertClickMeButton;
        scrollToElement(alertButton);
        alertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "You clicked a button";
        String actualAlertText = alert.getText();
        Assert.assertEquals(actualAlertText, expectedAlertText, "Alert text does not match!");
        alert.accept();
    }

    @Test(priority = 20)
    public void testClickOnTimerAlertButton() {
        WebElement timerAlertButton = alertsPage.timerAlertClickMeButton;
        scrollToElement(timerAlertButton);
        timerAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "This alert appeared after 5 seconds";
        String actualAlertText = alert.getText();
        Assert.assertEquals(actualAlertText, expectedAlertText, "Timer alert text does not match!");
        alert.accept();
    }

    @Test(priority = 30)
    public void testClickOnConfirmBoxButtonWithOkRespond() {
        WebElement confirmBoxButton = alertsPage.confirmBoxClickMeButton;
        WebElement confirmResultText = alertsPage.confirmResultText;
        scrollToElement(confirmBoxButton);
        confirmBoxButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "Do you confirm action?";
        String actualAlertText = alert.getText();
        Assert.assertEquals(actualAlertText, expectedAlertText, "Confirm box text does not match!");
        alert.accept();
        waitUntilVisibilityOf(confirmResultText);
        String expectedConfirmResultText = "You selected Ok";
        String actualConfirmResultText = confirmResultText.getText();
        Assert.assertEquals(actualConfirmResultText, expectedConfirmResultText, "Confirm Result text does not match!");
    }

    @Test(priority = 40)
    public void testClickOnConfirmBoxButtonWithCancelRespond() {
        WebElement confirmBoxButton = alertsPage.confirmBoxClickMeButton;
        WebElement confirmResultText = alertsPage.confirmResultText;
        scrollToElement(confirmBoxButton);
        confirmBoxButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "Do you confirm action?";
        String actualAlertText = alert.getText();
        Assert.assertEquals(actualAlertText, expectedAlertText, "Confirm box text does not match!");
        alert.dismiss();
        waitUntilVisibilityOf(confirmResultText);
        String expectedConfirmResultText = "You selected Cancel";
        String actualConfirmResultText = confirmResultText.getText();
        Assert.assertEquals(actualConfirmResultText, expectedConfirmResultText, "Confirm Result text does not match!");
    }

    @Test(priority = 50)
    public void testClickOnPromptBoxButton() {
        WebElement promptBoxButton = alertsPage.promptBoxClickMeButton;
        WebElement promptResultText = alertsPage.promptResultText;
        scrollToElement(promptBoxButton);
        promptBoxButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "Please enter your name";
        String actualAlertText = alert.getText();
        Assert.assertEquals(actualAlertText, expectedAlertText, "Confirm box text does not match!");
        String name = "John Doe";
        alert.sendKeys(name);
        alert.accept();
        waitUntilVisibilityOf(promptResultText);
        String expectedConfirmResultText = "You entered " + name;
        String actualConfirmResultText = promptResultText.getText();
        Assert.assertEquals(actualConfirmResultText, expectedConfirmResultText, "Prompt box result text does not match!");
    }
}
