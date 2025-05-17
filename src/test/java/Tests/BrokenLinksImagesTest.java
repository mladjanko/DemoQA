package Tests;

import Base.BaseTest;
import Pages.BrokenLinksImagesPage;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.BROKEN_LINKS_IMAGES_PAGE_URL;
import static Helpers.URLs.HOME_PAGE_URL;

public class BrokenLinksImagesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        brokenLinksImagesPage = new BrokenLinksImagesPage();

        driver.navigate().to(HOME_PAGE_URL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 7, 1));

        String currentURL = driver.getCurrentUrl();
        assert currentURL != null;
        Assert.assertTrue(testedPageIsReached(currentURL, BROKEN_LINKS_IMAGES_PAGE_URL), "Tested page is not reached!");
    }

    @Test(priority = 10)
    public void assertValidImage() {
        WebElement validImage = brokenLinksImagesPage.validImage;
        scrollToElement(validImage);
        Assert.assertTrue(validImage.isDisplayed());
    }

    @Test(priority = 20)
    public void assertBrokenImage() {
        WebElement brokenImage = brokenLinksImagesPage.brokenImage;
        scrollToElement(brokenImage);
        Assert.assertTrue(brokenImage.isDisplayed());
    }

    @Test(priority = 30)
    public void testClickOnValidLink() {
        WebElement validLink = brokenLinksImagesPage.validLink;
        scrollToElement(validLink);
        String currentUrlBeforeClick = driver.getCurrentUrl();
        validLink.click();
        String currentUrlAfterClick = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrlBeforeClick, currentUrlAfterClick);
        Assert.assertEquals(currentUrlAfterClick, HOME_PAGE_URL);
    }

    @Test(priority = 40)
    public void testClickOnBrokenLink() {
        WebElement brokenLink = brokenLinksImagesPage.brokenLink;
        scrollToElement(brokenLink);
        String currentUrlBeforeClick = driver.getCurrentUrl();
        brokenLink.click();
        String currentUrlAfterClick = driver.getCurrentUrl();
        String brokenLinkUrl = "https://the-internet.herokuapp.com/status_codes/500";
        Assert.assertNotEquals(currentUrlBeforeClick, currentUrlAfterClick);
        Assert.assertEquals(currentUrlAfterClick, brokenLinkUrl);
    }
}
