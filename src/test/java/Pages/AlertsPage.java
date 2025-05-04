package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage extends BaseTest {

    public AlertsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "alertButton")
    public WebElement alertClickMeButton;

    @FindBy(id = "timerAlertButton")
    public WebElement timerAlertClickMeButton;

    @FindBy(id = "confirmButton")
    public WebElement confirmBoxClickMeButton;

    @FindBy(id = "promtButton")
    public WebElement promptBoxClickMeButton;

    @FindBy(id = "confirmResult")
    public WebElement confirmResultText;

    @FindBy(id = "promptResult")
    public WebElement promptResultText;
}
