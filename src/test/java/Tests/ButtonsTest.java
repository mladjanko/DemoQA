package Tests;

import Base.BaseTest;
import Pages.ButtonsPage;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.HOMEPAGEURL;

public class ButtonsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        buttonsPage = new ButtonsPage();
        actions = new Actions(driver);
        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 5, 1));
    }

    private void performAction(Actions action, WebElement button, WebElement message) {
        scrollToElement(button);
        action.perform();
        waitUntilVisibilityOf(message);
    }

    @Test(priority = 10)
    public void testClickDoubleClickMeButton() {
        WebElement doubleClickMeButton = buttonsPage.doubleClickMeButton;
        WebElement doubleClickMessage = buttonsPage.doubleClickMessage;
        Actions action = actions.doubleClick(doubleClickMeButton);
        String expectedDoubleClickMessage = "You have done a double click";
        performAction(action, doubleClickMeButton, doubleClickMessage);
        Assert.assertTrue(doubleClickMessage.isDisplayed());
        Assert.assertEquals(doubleClickMessage.getText(), expectedDoubleClickMessage);
    }

    @Test(priority = 20)
    public void testClickRightClickMeButton() {
        WebElement rightClickMeButton = buttonsPage.rightClickMeButton;
        WebElement rightClickMessage = buttonsPage.rightClickMessage;
        Actions action = actions.contextClick(rightClickMeButton);
        String expectedRightClickMessage = "You have done a right click";
        performAction(action, rightClickMeButton, rightClickMessage);
        Assert.assertTrue(rightClickMessage.isDisplayed());
        Assert.assertEquals(rightClickMessage.getText(), expectedRightClickMessage);
    }

    @Test(priority = 30)
    public void testClickSingleClickMeButton() {
        WebElement clickMeButton = buttonsPage.clickMeButton;
        WebElement dynamicClickMessage = buttonsPage.dynamicClickMessage;
        Actions action = actions.click(clickMeButton);
        String expectedDynamicClickMessage = "You have done a dynamic click";
        performAction(action, clickMeButton, dynamicClickMessage);
        Assert.assertTrue(dynamicClickMessage.isDisplayed());
        Assert.assertEquals(dynamicClickMessage.getText(), expectedDynamicClickMessage);
    }

    @Test(priority = 40)
    public void testPerformAllActions() {
        WebElement doubleClickMeButton = buttonsPage.doubleClickMeButton;
        WebElement doubleClickMessage = buttonsPage.doubleClickMessage;
        Actions action = actions.doubleClick(doubleClickMeButton);
        String expectedDoubleClickMessage = "You have done a double click";
        performAction(action, doubleClickMeButton, doubleClickMessage);
        Assert.assertTrue(doubleClickMessage.isDisplayed());
        Assert.assertEquals(doubleClickMessage.getText(), expectedDoubleClickMessage);

        WebElement rightClickMeButton = buttonsPage.rightClickMeButton;
        WebElement rightClickMessage = buttonsPage.rightClickMessage;
        action = actions.contextClick(rightClickMeButton);
        String expectedRightClickMessage = "You have done a right click";
        performAction(action, rightClickMeButton, rightClickMessage);
        Assert.assertTrue(rightClickMessage.isDisplayed());
        Assert.assertEquals(rightClickMessage.getText(), expectedRightClickMessage);

        WebElement clickMeButton = buttonsPage.clickMeButton;
        WebElement dynamicClickMessage = buttonsPage.dynamicClickMessage;
        action = actions.click(clickMeButton);
        String expectedDynamicClickMessage = "You have done a dynamic click";
        performAction(action, clickMeButton, dynamicClickMessage);
        Assert.assertTrue(dynamicClickMessage.isDisplayed());
        Assert.assertEquals(dynamicClickMessage.getText(), expectedDynamicClickMessage);
    }
}
