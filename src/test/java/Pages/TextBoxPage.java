package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement userNameField;

    @FindBy(id = "userEmail")
    public WebElement userEmailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "output")
    public WebElement outputTextBox;
}
