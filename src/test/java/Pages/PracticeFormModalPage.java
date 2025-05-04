package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PracticeFormModalPage extends BaseTest {

    public PracticeFormModalPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "td")
    public List<WebElement> cells;

    @FindBy(id = "closeLargeModal")
    public WebElement closeButton;
}
