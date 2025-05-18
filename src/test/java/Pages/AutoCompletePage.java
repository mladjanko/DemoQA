package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoCompletePage extends BaseTest {
    public AutoCompletePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "autoCompleteMultipleInput")
    public WebElement autoCompleteMultipleInput;

    @FindBy(id = "autoCompleteSingleContainer")
    public WebElement autoCompleteSingleInput;

    //    @FindBy(css = "div.auto-complete__menu div")
    //    public List<WebElement> suggestionList;
    @FindBy(className = "auto-complete__menu")
    public List<WebElement> suggestionList;

    //---------------------------

    public void enterText(WebElement inputBox, String text) {
        inputBox.clear();
        inputBox.sendKeys(text);
    }

    public List<WebElement> getSuggestions() {
        return suggestionList;
    }
}
