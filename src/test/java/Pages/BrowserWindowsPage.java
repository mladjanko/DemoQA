package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserWindowsPage extends BaseTest {

    public BrowserWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    @FindBy(id = "messageWindowButton")
    public WebElement newWindowMessageButton;
}
