package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RadioButtonPage extends BaseTest {

    public RadioButtonPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='radio']")
    public List<WebElement> radioButtonList;

    @FindBy(className = "custom-control-label")
    public List<WebElement> radioButtonLabelList;

    @FindBy(className = "mt-3")
    public WebElement youHaveSelectedText;

    @FindBy(className = "text-success")
    public List<WebElement> textSuccess;

    //----------------------

    public void clickRadioButton(String option) {
        for (int i = 0; i <= radioButtonLabelList.size() - 1; i++) {
            if (radioButtonLabelList.get(i).getText().equalsIgnoreCase(option)) {
                clickElementJS(radioButtonList.get(i));
                break;
            }
        }
    }
}
