package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowMessagePage extends BaseTest {

    public NewWindowMessagePage() {
        PageFactory.initElements(driver, this);
    }

//    @FindBy(xpath = "/html/body/text()")
//    public WebElement newWindowMessageBody;

    @FindBy(tagName = "body")
    public WebElement newWindowMessageBody;
}
