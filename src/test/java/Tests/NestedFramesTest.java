package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ALERTS_FRAME_WINDOWS;
import static Helpers.URLs.HOMEPAGEURL;

public class NestedFramesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        nestedFramesPage = new NestedFramesPage();
        parentIframePage = new ParentIframePage();
        childIframePage = new ChildIframePage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ALERTS_FRAME_WINDOWS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 16, 1));
    }

    private void switchToFrame(WebElement iframe) {
        driver.switchTo().frame(iframe);
    }

    @Test(priority = 10)
    public void testIfParentIframeIsVisible() {
        WebElement parentIframe = nestedFramesPage.parentIframe;
        WebElement parentIframeBody = parentIframePage.parentIframeBody;
        Assert.assertTrue(parentIframe.isDisplayed(), "Parent iframe is not displayed!");
        switchToFrame(parentIframe);
        String expectedParentIframeBodyText = "Parent frame";
        String actualParentIframeBodyText = parentIframeBody.getText();
        Assert.assertEquals(actualParentIframeBodyText, expectedParentIframeBodyText, "Parent iframe body text does not match!");
    }

    @Test(priority = 20)
    public void testIfChildIframeIsVisible() {
        WebElement parentIframe = nestedFramesPage.parentIframe;
        WebElement childIframe = parentIframePage.childIframe;
        WebElement childIframeBody = childIframePage.childIframeBody;
        switchToFrame(parentIframe);
        Assert.assertTrue(childIframe.isDisplayed(), "Child iframe is not displayed!");
        switchToFrame(childIframe);
        String expectedChildIframeBodyText = "Child Iframe";
        String actualChildIframeBodyText = childIframeBody.getText();
        Assert.assertEquals(actualChildIframeBodyText, expectedChildIframeBodyText, "Child iframe body text does not match!");
    }

    @Test(priority = 30)
    public void testIfBothIframesAreVisible() {
        WebElement parentIframe = nestedFramesPage.parentIframe;
        WebElement parentIframeBody = parentIframePage.parentIframeBody;
        WebElement childIframe = parentIframePage.childIframe;
        WebElement childIframeBody = childIframePage.childIframeBody;
        Assert.assertTrue(parentIframe.isDisplayed(), "Parent iframe is not displayed!");
        switchToFrame(parentIframe);
        String expectedParentIframeBodyText = "Parent frame";
        String actualParentIframeBodyText = parentIframeBody.getText();
        Assert.assertEquals(actualParentIframeBodyText, expectedParentIframeBodyText, "Parent iframe body text does not match!");
        Assert.assertTrue(childIframe.isDisplayed(), "Child iframe is not displayed!");
        switchToFrame(childIframe);
        String expectedChildIframeBodyText = "Child Iframe";
        String actualChildIframeBodyText = childIframeBody.getText();
        Assert.assertEquals(actualChildIframeBodyText, expectedChildIframeBodyText, "Child iframe body text does not match!");
    }
}
