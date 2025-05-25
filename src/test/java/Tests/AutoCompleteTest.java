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
        autoCompletePage.enterText(autoCompleteMultipleInput, "a");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompletePage.getSuggestions()));

        List<WebElement> suggestions = autoCompletePage.getSuggestions();
        Assert.assertFalse(suggestions.isEmpty(), "No suggestions appeared after typing input.");
    }

    @Test(priority = 20)
    public void testNoSuggestionsAppear() {
        WebElement autoCompleteMultipleInput = autoCompletePage.autoCompleteMultipleInput;
        autoCompletePage.enterText(autoCompleteMultipleInput, "zz");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(autoCompletePage.getSuggestions()));
        } catch (Exception ignored) {
            // No suggestions appeared, which is expected
        }
        List<WebElement> suggestions = autoCompletePage.getSuggestions();
        Assert.assertTrue(suggestions.isEmpty(), "Suggestions appeared after typing input.");
    }

    @Test(priority = 30)
    public void testColorsAreInputted() {
        WebElement autoCompleteMultipleInput = autoCompletePage.autoCompleteMultipleInput;

        // Input 3 colors
        autoCompletePage.enterTextAndSelect(autoCompleteMultipleInput, "red");
        autoCompletePage.enterTextAndSelect(autoCompleteMultipleInput, "blue");
        autoCompletePage.enterTextAndSelect(autoCompleteMultipleInput, "green");

        // Get the list of colors that were inputted
        List<WebElement> selectedColors = autoCompletePage.getSelectedColors();

        // Assert that exactly 3 colors were inputted
        Assert.assertEquals(selectedColors.size(), 3, "Number of inputted colors is not equal to 3.");

        System.out.println("Selected colors:");
        for (WebElement color : selectedColors) {
            System.out.println("- " + color.getText());
        }
    }

    @Test(priority = 40)
    public void testRemoveColor() {
        WebElement autoCompleteMultipleInput = autoCompletePage.autoCompleteMultipleInput;

        // Input 3 colors
        autoCompletePage.enterTextAndSelect(autoCompleteMultipleInput, "red");
        autoCompletePage.enterTextAndSelect(autoCompleteMultipleInput, "blue");
        autoCompletePage.enterTextAndSelect(autoCompleteMultipleInput, "green");

        // Get the list of colors that were inputted
        List<WebElement> selectedColors = autoCompletePage.getSelectedColors();

        // Assert that exactly 3 colors were inputted
        Assert.assertEquals(selectedColors.size(), 3, "Expected 3 colors before removal.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElements(autoCompletePage.getSelectedColors()));
        // Remove selected color
        autoCompletePage.removeSelectedColor(0); // index of the color to remove

        // Get the updated list of selected colors and assert that exactly 2 colors remain
        List<WebElement> updatedColors = autoCompletePage.getSelectedColors();
        Assert.assertEquals(updatedColors.size(), 2, "Expected 2 colors after removal.");
    }

}
