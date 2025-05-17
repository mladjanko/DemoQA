package Tests;

import Base.BaseTest;
import Pages.DynamicPropertiesPage;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.DYNAMIC_PROPERTIES_PAGE_URL;
import static Helpers.URLs.HOME_PAGE_URL;

public class DynamicPropertiesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        dynamicPropertiesPage = new DynamicPropertiesPage();

        driver.navigate().to(HOME_PAGE_URL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 9, 1));

        String currentURL = driver.getCurrentUrl();
        assert currentURL != null;
        Assert.assertTrue(testedPageIsReached(currentURL, DYNAMIC_PROPERTIES_PAGE_URL), "Tested page is not reached!");
    }

    @Test(priority = 10)
    public void testIfRandomIdTextIsVisible() {
        WebElement randomIdText = dynamicPropertiesPage.randomIdText;
        scrollToElement(randomIdText);
        Assert.assertTrue(randomIdText.isDisplayed());
        Assert.assertTrue(randomIdText.getText().equalsIgnoreCase("This text has random Id"));
    }

    @Test(priority = 20)
    public void testWillEnableAfterFiveSeconds() {
        WebElement willEnableButton = dynamicPropertiesPage.willEnableButton;
        scrollToElement(willEnableButton);
        Assert.assertFalse(willEnableButton.isEnabled());
        waitUntilElementToBeClickable(willEnableButton);
        Assert.assertTrue((willEnableButton.isEnabled()));
    }

    @Test(priority = 30)
    public void testColorChange() {
        WebElement colorChangeButton = dynamicPropertiesPage.colorChangeButton;
        scrollToElement(colorChangeButton);
        String propertyName = "color";
        String expectedColor = "rgba(220, 53, 69, 1)";
        String actualColorBeforeChange = colorChangeButton.getCssValue(propertyName);
        Assert.assertNotEquals(actualColorBeforeChange, expectedColor, "The color is already the expected one before the change.");
        waitUntilCssPropertyValueChange(colorChangeButton, propertyName, expectedColor);
        String actualColorAfterChange = colorChangeButton.getCssValue(propertyName);
        Assert.assertEquals(actualColorAfterChange, expectedColor, "The color did not change to the expected color.");
    }

    @Test(priority = 40)
    public void testIfVisibleAfterFiveSeconds() {
        WebElement visibleAfterButton = dynamicPropertiesPage.visibleAfterButton;
        waitUntilVisibilityOf(visibleAfterButton);
        scrollToElement(visibleAfterButton);
        Assert.assertTrue(visibleAfterButton.isDisplayed(), "The element is not visible after 5 seconds.");
    }
}
