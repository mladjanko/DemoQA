package Tests;

import Base.BaseTest;
import Pages.AutoCompletePage;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static Helpers.HomepageCards.WIDGETS;
import static Helpers.URLs.AUTO_COMPLETE_PAGE_URL;
import static Helpers.URLs.HOME_PAGE_URL;

public class AutoCompleteTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        autoCompletePage = new AutoCompletePage();

        driver.navigate().to(HOME_PAGE_URL);
        homepagePage.clickOnCard(WIDGETS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 20, 1));

        String currentURL = driver.getCurrentUrl();
        assert currentURL != null;
        Assert.assertTrue(testedPageIsReached(currentURL, AUTO_COMPLETE_PAGE_URL), "Tested page is not reached!");
    }

    @Test(priority = 10)
    public void testSuggestionsAppear() {
        WebElement autoCompleteMultipleInput = autoCompletePage.autoCompleteMultipleInput;
        autoCompletePage.enterText(autoCompleteMultipleInput, "q");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompletePage.getSuggestions()));

        List<WebElement> suggestions = autoCompletePage.getSuggestions();
        Assert.assertFalse(suggestions.isEmpty(), "No suggestions appeared after typing input.");
//        System.out.println(suggestions.size());
    }
}
