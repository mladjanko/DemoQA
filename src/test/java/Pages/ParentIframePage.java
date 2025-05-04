package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParentIframePage extends BaseTest {

    public ParentIframePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "body")
    public WebElement parentIframeBody;

    @FindBy(xpath = "/html/body/iframe")
    public WebElement childIframe;
}
