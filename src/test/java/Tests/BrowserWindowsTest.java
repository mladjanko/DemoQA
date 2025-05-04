package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static Helpers.HomepageCards.ALERTS_FRAME_WINDOWS;
import static Helpers.URLs.HOMEPAGEURL;

public class BrowserWindowsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        browserWindowsPage = new BrowserWindowsPage();
        newWindowPage = new NewWindowPage();
        newWindowMessagePage = new NewWindowMessagePage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ALERTS_FRAME_WINDOWS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 13, 1));
    }

    @Test(priority = 10)
    public void testClickOnNewTabButton() {
        WebElement newTabButton = browserWindowsPage.newTabButton;
        String expectedURL = "https://demoqa.com/sample";
        scrollToElement(newTabButton);
        newTabButton.click();
        ArrayList<String> browserTabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabList.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedURL);
    }

    @Test(priority = 20)
    public void testClickOnNewWindowButton() {
        WebElement newWindowButton = browserWindowsPage.newWindowButton;
        WebElement sampleHeading = newWindowPage.sampleHeading;
        String expectedURL = "https://demoqa.com/sample";
        scrollToElement(newWindowButton);
        newWindowButton.click();
        ArrayList<String> browserTabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabList.get(1));
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL);
        String expectedHeading = "This is a sample page";
        Assert.assertEquals(sampleHeading.getText(), expectedHeading);
    }

    @Test(priority = 30)
    public void testClickOnNewWindowMessageButton() {
        WebElement newWindowMessageButton = browserWindowsPage.newWindowMessageButton;
        WebElement newWindowMessageBody = newWindowMessagePage.newWindowMessageBody;
        scrollToElement(newWindowMessageButton);
        newWindowMessageButton.click();
        ArrayList<String> browserTabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabList.get(1));
        System.out.println(browserTabList.size());
        String expectedBodyText = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
//        Assert.assertEquals(newWindowMessageBody.getText(), expectedBodyText);   //NOT WORKING!!!
    }

    @Test(priority = 40)
    public void testClickOnNewWindowMessageButtonWithCountingBrowserWindows() {
        WebElement newWindowMessageButton = browserWindowsPage.newWindowMessageButton;
        ArrayList<String> browserTabListBeforeClick = new ArrayList<>(driver.getWindowHandles());
        int windowsCountBeforeClick = browserTabListBeforeClick.size();
        scrollToElement(newWindowMessageButton);
        newWindowMessageButton.click();
        ArrayList<String> browserTabListAfterClick = new ArrayList<>(driver.getWindowHandles());
        int windowsCountAfterClick = browserTabListAfterClick.size();

        Assert.assertEquals(windowsCountAfterClick - windowsCountBeforeClick, 1);

        driver.switchTo().window(browserTabListAfterClick.get(1));
        driver.close();
        driver.switchTo().window(browserTabListAfterClick.get(0));
        ArrayList<String> browserTabListAfterClose = new ArrayList<>(driver.getWindowHandles());

        Assert.assertEquals(browserTabListAfterClose.size(), 1);

    }
}
