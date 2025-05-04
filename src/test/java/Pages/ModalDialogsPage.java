package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ModalDialogsPage extends BaseTest {

    public ModalDialogsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "text-center")
    public WebElement modalDialogsPageTitle;

    @FindBy(id = "showSmallModal")
    public WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    public WebElement largeModalButton;
}
