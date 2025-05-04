package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicPropertiesPage extends BaseTest {

    public DynamicPropertiesPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(xpath = "/html/body/div[2]/div/div/div/div[2]/div[2]/p")
    WebElement randomIdText;

    public @FindBy(id = "enableAfter")
    WebElement willEnableButton;

    public @FindBy(id = "colorChange")
    WebElement colorChangeButton;

    public @FindBy(id = "visibleAfter")
    WebElement visibleAfterButton;
}
