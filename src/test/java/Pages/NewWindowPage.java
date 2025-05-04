package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowPage extends BaseTest {

    public NewWindowPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sampleHeading")
    public WebElement sampleHeading;
}
