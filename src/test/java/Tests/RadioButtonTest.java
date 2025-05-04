package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import Pages.RadioButtonPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.HOMEPAGEURL;

public class RadioButtonTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        radioButtonPage = new RadioButtonPage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 3, 1));
    }

    private void selectRadioButton(String radioButtonName) {
        scrollToElement(radioButtonPage.radioButtonList.getFirst());
        radioButtonPage.clickRadioButton(radioButtonName);
    }

    @Test(priority = 10)
    public void testClickOnYesRadioButtonTest() {
        selectRadioButton(excelReader.getStringData("Radio Button", 0, 0));
        waitUntilVisibilityOf(radioButtonPage.textSuccess.getFirst());

        // Verify if the success message is displayed
        Assert.assertTrue(radioButtonPage.youHaveSelectedText.isDisplayed());
        Assert.assertTrue(radioButtonPage.textSuccess.getFirst().getText().equalsIgnoreCase("yes"),
                "Success message should be 'Yes' when 'Yes' is selected.");
    }

    @Test(priority = 20)
    public void testClickOnImpressiveRadioButton() {
        selectRadioButton(excelReader.getStringData("Radio Button", 1, 0));
        waitUntilVisibilityOf(radioButtonPage.textSuccess.getFirst());

        // Verify if the success message is displayed
        Assert.assertTrue(radioButtonPage.youHaveSelectedText.isDisplayed());
        Assert.assertTrue(radioButtonPage.textSuccess.getFirst().getText().equalsIgnoreCase("impressive"),
                "Success message should be 'Impressive' when 'Impressive' is selected.");
    }

    @Test(priority = 30)
    public void testClickOnNoRadioButton() {
        // Clicking on 'No' radio button, assert that the success message is empty
        selectRadioButton(excelReader.getStringData("Radio Button", 2, 0));
        Assert.assertTrue(radioButtonPage.textSuccess.isEmpty(), "Success message should be empty when 'No' is selected.");
    }
}
