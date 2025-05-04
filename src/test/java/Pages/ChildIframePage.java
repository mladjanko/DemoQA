package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChildIframePage extends BaseTest {

    public ChildIframePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "body")
    public WebElement childIframeBody;
}
