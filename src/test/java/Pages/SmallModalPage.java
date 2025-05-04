package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmallModalPage extends BaseTest {

    public SmallModalPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "example-modal-sizes-title-sm")
    public WebElement smallModalTitle;

    @FindBy(className = "modal-body")
    public WebElement smallModalBody;

    @FindBy(id = "closeSmallModal")
    public WebElement smallModalCloseButton;
}
