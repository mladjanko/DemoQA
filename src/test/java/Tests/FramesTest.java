package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ALERTS_FRAME_WINDOWS;
import static Helpers.URLs.HOMEPAGEURL;

public class FramesTest extends BaseTest {

    @BeforeMethod
    public void pageSetup() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        framesPage = new FramesPage();
        frame1Page = new Frame1Page();
        frame2Page = new Frame2Page();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ALERTS_FRAME_WINDOWS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 15, 1));
    }

    public void assertIframeHeading(WebElement iframe, WebElement frameHeading, String expectedFrameHeadingText) {
        Assert.assertTrue(iframe.isDisplayed());
        Assert.assertTrue(iframe.isDisplayed(), iframe.getDomAttribute("id") + " iframe is not displayed!");
        driver.switchTo().frame(iframe);
        String actualIframeHeadingText = frameHeading.getText();
        Assert.assertEquals(actualIframeHeadingText, expectedFrameHeadingText, "Heading text does not match!");
    }

    @Test(priority = 10)
    public void testIfIframe1Exists() {
        WebElement iframe1 = framesPage.iframe1;
        WebElement frame1Heading = frame1Page.frameHeading;
        String expectedIframe1HeadingText = "This is a sample page";
        assertIframeHeading(iframe1, frame1Heading, expectedIframe1HeadingText);
    }

    @Test(priority = 20)
    public void testIfIframe2Exists() {
        WebElement iframe2 = framesPage.iframe2;
        WebElement frame2Heading = frame2Page.frameHeading;
        String expectedIframe2HeadingText = "This is a sample page";
        assertIframeHeading(iframe2, frame2Heading, expectedIframe2HeadingText);
    }

    @Test(priority = 30)
    public void testIfBothIframesExists() {
        WebElement iframe1 = framesPage.iframe1;
        WebElement frame1Heading = frame1Page.frameHeading;
        String expectedIframe1HeadingText = "This is a sample page";
        assertIframeHeading(iframe1, frame1Heading, expectedIframe1HeadingText);

        driver.switchTo().defaultContent();

        WebElement iframe2 = framesPage.iframe2;
        WebElement frame2Heading = frame2Page.frameHeading;
        String expectedIframe2HeadingText = "This is a sample page";
        assertIframeHeading(iframe2, frame2Heading, expectedIframe2HeadingText);
    }
}
