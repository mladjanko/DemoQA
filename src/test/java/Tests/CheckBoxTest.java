package Tests;

import Base.BaseTest;
import Pages.CheckBoxPage;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.CHECK_BOX_PAGE_URL;
import static Helpers.URLs.HOME_PAGE_URL;

public class CheckBoxTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        checkBoxPage = new CheckBoxPage();

        driver.navigate().to(HOME_PAGE_URL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 2, 1));

        String currentURL = driver.getCurrentUrl();
        assert currentURL != null;
        Assert.assertTrue(testedPageIsReached(currentURL, CHECK_BOX_PAGE_URL), "Tested page is not reached!");
    }

    @Test
    public void testIfCheckHomeWillCheckAll() {
        checkBoxPage.expandCheckBoxTree();
        waitUntilVisibilityOf(checkBoxPage.checkBoxList.getFirst());
        scrollToElement(checkBoxPage.uncheckedCheckboxList.getFirst());

        // Assert the number of unchecked boxes
        Assert.assertEquals(checkBoxPage.uncheckedCheckboxList.size(), 17);

        // Click the "Home" checkbox, which should check all checkboxes
        checkBoxPage.uncheckedCheckboxList.getFirst().click();

        // Assert that there are no unchecked boxes and all are checked
        Assert.assertEquals(checkBoxPage.uncheckedCheckboxList.size(), 0);
        Assert.assertEquals(checkBoxPage.checkedCheckboxList.size(), 17);
    }

    @Test
    public void testClickCustomCheckbox() {
        checkBoxPage.expandCheckBoxTree();
        waitUntilVisibilityOf(checkBoxPage.checkBoxList.getFirst());
        scrollToElement(checkBoxPage.uncheckedCheckboxList.getFirst());

        // Assert the number of unchecked boxes
        Assert.assertEquals(checkBoxPage.uncheckedCheckboxList.size(), 17);

        // Click "Angular" checkbox and assert the result
        scrollToElement(checkBoxPage.nodeTitleList.get(checkBoxPage.getNodeTitleIndex("Angular")));
        checkBoxPage.checkNode("Angular");
        Assert.assertTrue(checkBoxPage.result.getText().contains("angular"));

        // Click "General" checkbox and assert the result
        scrollToElement(checkBoxPage.nodeTitleList.get(checkBoxPage.getNodeTitleIndex("General")));
        checkBoxPage.checkNode("General");
        Assert.assertTrue(checkBoxPage.result.getText().contains("general"));
    }
}
