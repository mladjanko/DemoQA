package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftsidemenuPage extends BaseTest {

    public LeftsidemenuPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-light")
    public List<WebElement> leftSideMenuItemsList;

    //-----------------------

    public void clickOnLeftMenuItem(String leftSideMenuItem) {
        for (WebElement webElement : leftSideMenuItemsList) {
            scrollToElement(webElement);
            if (webElement.getText().equalsIgnoreCase(leftSideMenuItem)) {
                webElement.click();
                break;
            }
        }
    }
}
