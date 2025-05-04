package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "simpleLink")
    public WebElement simpleHomeLink;

    @FindBy(id = "dynamicLink")
    public WebElement dynamicHomeLink;

    @FindBy(id = "created")
    public WebElement createdLink;

    @FindBy(id = "no-content")
    public WebElement noContentLink;

    @FindBy(id = "moved")
    public WebElement movedLink;

    @FindBy(id = "bad-request")
    public WebElement badRequestLink;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedLink;

    @FindBy(id = "forbidden")
    public WebElement forbiddenLink;

    @FindBy(id = "invalid-url")
    public WebElement notFoundLink;

    @FindBy(id = "linkResponse")
    public WebElement linkResponse;
}
