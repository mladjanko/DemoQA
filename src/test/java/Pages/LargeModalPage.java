package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LargeModalPage extends BaseTest {

    public LargeModalPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    public WebElement largeModalTitle;

    @FindBy(className = "modal-body")
    public WebElement largeModalBody;

    @FindBy(id = "closeLargeModal")
    public WebElement largeModalCloseButton;
}
