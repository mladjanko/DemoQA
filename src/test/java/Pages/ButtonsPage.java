package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage extends BaseTest {

    public ButtonsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickMeButton;

    @FindBy(id = "rightClickBtn")
    public WebElement rightClickMeButton;

    @FindBy(xpath = "//*[text()='Click Me']")
    public WebElement clickMeButton;

    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickMessage;

    @FindBy(id = "rightClickMessage")
    public WebElement rightClickMessage;

    @FindBy(id = "dynamicClickMessage")
    public WebElement dynamicClickMessage;
}
