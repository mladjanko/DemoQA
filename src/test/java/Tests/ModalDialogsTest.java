package Tests;

import Base.BaseTest;
import Pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ALERTS_FRAME_WINDOWS;
import static Helpers.URLs.HOMEPAGEURL;

public class ModalDialogsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        modalDialogsPage = new ModalDialogsPage();
        smallModalPage = new SmallModalPage();
        largeModalPage = new LargeModalPage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ALERTS_FRAME_WINDOWS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 17, 1));
    }

    @Test(priority = 10)
    public void testSmallModalPageIsShown() {
        WebElement modalDialogsPageTitle = modalDialogsPage.modalDialogsPageTitle;
        WebElement smallModalButton = modalDialogsPage.smallModalButton;
        WebElement smallModalTitle = smallModalPage.smallModalTitle;
        WebElement smallModalBody = smallModalPage.smallModalBody;
        WebElement smallModalCloseButton = smallModalPage.smallModalCloseButton;
        scrollToElement(smallModalButton);
        smallModalButton.click();
        waitUntilVisibilityOf(smallModalTitle);
        String expectedSmallModalTitleText = "Small Modal";
        String actualSmallModalTitleText = smallModalTitle.getText();
        Assert.assertEquals(actualSmallModalTitleText, expectedSmallModalTitleText, "Small modal page title does not match!");
        String expectedSmallModalBodyText = "This is a small modal. It has very less content";
        String actualSmallModalBodyText = smallModalBody.getText();
        Assert.assertEquals(actualSmallModalBodyText, expectedSmallModalBodyText, "Small modal page body text does not match!");
        scrollToElement(smallModalCloseButton);
        smallModalCloseButton.click();
        String expectedModalDialogsPageTitle = "Modal Dialogs";
        String actualModalDialogsPageTitle = modalDialogsPageTitle.getText();
        Assert.assertEquals(actualModalDialogsPageTitle, expectedModalDialogsPageTitle, "Small modal page was not closed!");
    }

    @Test(priority = 20)
    public void testLargeModalPageIsShown() {
        WebElement modalDialogsPageTitle = modalDialogsPage.modalDialogsPageTitle;
        WebElement largeModalButton = modalDialogsPage.largeModalButton;
        WebElement largeModalTitle = largeModalPage.largeModalTitle;
        WebElement largeModalBody = largeModalPage.largeModalBody;
        WebElement largeModalCloseButton = largeModalPage.largeModalCloseButton;
        scrollToElement(largeModalButton);
        largeModalButton.click();
        waitUntilVisibilityOf(largeModalTitle);
        String expectedLargeModalTitleText = "Large Modal";
        String actualLargeModalTitleText = largeModalTitle.getText();
        Assert.assertEquals(actualLargeModalTitleText, expectedLargeModalTitleText, "Large modal page title does not match!");
        String expectedLargeModalBodyText = "Lorem Ipsum has been the industry's standard dummy text";
        String actualLargeModalBodyText = largeModalBody.getText();
        Assert.assertTrue(actualLargeModalBodyText.contains(expectedLargeModalBodyText), "Large modal page text does not match!");
        scrollToElement(largeModalCloseButton);
        largeModalCloseButton.click();
        String expectedModalDialogsPageTitle = "Modal Dialogs";
        String actualModalDialogsPageTitle = modalDialogsPageTitle.getText();
        Assert.assertEquals(actualModalDialogsPageTitle, expectedModalDialogsPageTitle, "Large modal page was not closed!");
    }
}
