package Tests;

import Base.BaseTest;
import Pages.AccordionPage;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static Helpers.HomepageCards.WIDGETS;
import static Helpers.URLs.ACCORDION_PAGE_URL;
import static Helpers.URLs.HOME_PAGE_URL;

public class AccordionTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        accordionPage = new AccordionPage();

        driver.navigate().to(HOME_PAGE_URL);
        homepagePage.clickOnCard(WIDGETS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 19, 1));

        String currentURL = driver.getCurrentUrl();
        assert currentURL != null;
        Assert.assertTrue(testedPageIsReached(currentURL, ACCORDION_PAGE_URL), "Tested page is not reached!");
    }

    private void testAllAccordionButtonsToggle(List<WebElement> cardHeaderList, List<WebElement> cardBodyList) {
        for (int i = 0; i < cardHeaderList.size(); i++) {
            scrollToElement(cardHeaderList.get(i));
            cardHeaderList.get(i).click();
            waitUntilVisibilityOf(cardBodyList.get(i));
            Assert.assertTrue(cardBodyList.get(i).isDisplayed());
            cardHeaderList.get(i).click();
            waitUntilInvisibilityOf(cardBodyList.get(i));
            Assert.assertFalse(cardBodyList.get(i).isDisplayed());
        }
    }

    @Test
    public void testAccordionCardsCanToggle() {
        List<WebElement> cardHeaderList = accordionPage.cardHeaderList;
        List<WebElement> cardBodyList = accordionPage.cardBodyList;
        accordionPage.hideAllAccordionContent();
        testAllAccordionButtonsToggle(cardHeaderList, cardBodyList);
    }
}
