package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import Pages.LinksPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.HOMEPAGEURL;

public class LinksPageTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        linksPage = new LinksPage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 6, 1));
    }

    @Test(priority = 10)
    public void testClickOnSimpleHomeLink() {
        WebElement simpleHomeLink = linksPage.simpleHomeLink;
        scrollToElement(simpleHomeLink);
        simpleHomeLink.click();
        ArrayList<String> browserTabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabList.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, HOMEPAGEURL);
    }

    @Test(priority = 20)
    public void testClickOnDynamicHomeLink() {
        WebElement dynamicHomeLink = linksPage.dynamicHomeLink;
        scrollToElement(dynamicHomeLink);
        dynamicHomeLink.click();
        ArrayList<String> browserTabList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserTabList.get(1));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, HOMEPAGEURL);
    }

    @Test(priority = 30)
    public void testClickOnCreatedLink() {
        WebElement createdLink = linksPage.createdLink;
        WebElement linkResponse = linksPage.linkResponse;
        scrollToElement(createdLink);
        createdLink.click();
        waitUntilVisibilityOf(linkResponse);
        String linkResponseText = linkResponse.getText();
        String expectedResponse = "Link has responded with staus 201 and status text Created";
        Assert.assertEquals(linkResponseText, expectedResponse);
    }

    @Test(priority = 40)
    public void testClickOnNoContentLink() {
        WebElement noContentLink = linksPage.noContentLink;
        WebElement linkResponse = linksPage.linkResponse;
        scrollToElement(noContentLink);
        noContentLink.click();
        waitUntilVisibilityOf(linkResponse);
        String linkResponseText = linkResponse.getText();
        String expectedResponse = "Link has responded with staus 204 and status text No Content";
        Assert.assertEquals(linkResponseText, expectedResponse);
    }

    @Test(priority = 50)
    public void testClickOnMovedLink() {
        WebElement movedLink = linksPage.movedLink;
        WebElement linkResponse = linksPage.linkResponse;
        scrollToElement(movedLink);
        movedLink.click();
        waitUntilVisibilityOf(linkResponse);
        String linkResponseText = linkResponse.getText();
        String expectedResponse = "Link has responded with staus 301 and status text Moved Permanently";
        Assert.assertEquals(linkResponseText, expectedResponse);
    }

    @Test(priority = 60)
    public void testClickOnBadRequestLink() {
        WebElement badRequestLink = linksPage.badRequestLink;
        WebElement linkResponse = linksPage.linkResponse;
        scrollToElement(badRequestLink);
        badRequestLink.click();
        waitUntilVisibilityOf(linkResponse);
        String linkResponseText = linkResponse.getText();
        String expectedResponse = "Link has responded with staus 400 and status text Bad Request";
        Assert.assertEquals(linkResponseText, expectedResponse);
    }

    @Test(priority = 70)
    public void testClickUnauthorizedLink() {
        WebElement unauthorizedLink = linksPage.unauthorizedLink;
        WebElement linkResponse = linksPage.linkResponse;
        scrollToElement(unauthorizedLink);
        unauthorizedLink.click();
        waitUntilVisibilityOf(linkResponse);
        String linkResponseText = linkResponse.getText();
        String expectedResponse = "Link has responded with staus 401 and status text Unauthorized";
        Assert.assertEquals(linkResponseText, expectedResponse);
    }

    @Test(priority = 80)
    public void testClickOnForbiddenLink() {
        WebElement forbiddenLink = linksPage.forbiddenLink;
        WebElement linkResponse = linksPage.linkResponse;
        scrollToElement(forbiddenLink);
        forbiddenLink.click();
        waitUntilVisibilityOf(linkResponse);
        String linkResponseText = linksPage.linkResponse.getText();
        String expectedResponse = "Link has responded with staus 403 and status text Forbidden";
        Assert.assertEquals(linkResponseText, expectedResponse);
    }

    @Test(priority = 90)
    public void testClickOnNotFoundLink() {
        WebElement notFoundLink = linksPage.notFoundLink;
        WebElement linkResponse = linksPage.linkResponse;
        scrollToElement(notFoundLink);
        notFoundLink.click();
        waitUntilVisibilityOf(linkResponse);
        String linkResponseText = linkResponse.getText();
        String expectedResponse = "Link has responded with staus 404 and status text Not Found";
        Assert.assertEquals(linkResponseText, expectedResponse);
    }
}
