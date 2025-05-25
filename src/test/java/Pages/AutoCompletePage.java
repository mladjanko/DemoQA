package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AutoCompletePage extends BaseTest {
    public AutoCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "autoCompleteMultipleInput")
    public WebElement autoCompleteMultipleInput;

    @FindBy(id = "autoCompleteSingleContainer")
    public WebElement autoCompleteSingleInput;

    @FindBy(className = "auto-complete__menu")
    public List<WebElement> suggestionList;

    @FindBy(css = ".css-1rhbuit-multiValue")
    public List<WebElement> selectedColorsList;

    @FindBy(css = ".auto-complete__multi-value__remove")
    public List<WebElement> removeButtons;

    //---------------------------
    public List<WebElement> getSuggestions() {
        return suggestionList;
    }

    public List<WebElement> getSelectedColors() {
        return selectedColorsList;
    }

    public void enterText(WebElement inputBox, String text) {
        inputBox.clear();
        inputBox.sendKeys(text);
    }

    public void enterTextAndSelect(WebElement inputBox, String color) {
        inputBox.clear();
        inputBox.sendKeys(color);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        List<WebElement> suggestions = getSuggestions();
        wait.until(ExpectedConditions.visibilityOfAllElements(suggestions));
        suggestions.getFirst().click(); // assumes first suggestion is the match
    }

    public void removeSelectedColor(int index) {
        if (index < removeButtons.size()) {
            removeButtons.get(index).click();
        } else {
            throw new IllegalArgumentException("Index out of bounds for remove button list.");
        }
    }
}
