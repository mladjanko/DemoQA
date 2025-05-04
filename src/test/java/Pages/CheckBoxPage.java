package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    public @FindBy(css = ".rct-collapse.rct-collapse-btn")
    List<WebElement> toggleButtonList;

    public @FindBy(className = "rct-checkbox")
    List<WebElement> checkBoxList;

    public @FindBy(className = "rct-title")
    List<WebElement> nodeTitleList;

    public @FindBy(css = ".rct-icon.rct-icon-uncheck")
    List<WebElement> uncheckedCheckboxList;

    public @FindBy(css = ".rct-icon.rct-icon-check")
    List<WebElement> checkedCheckboxList;

    public @FindBy(id = "result")
    WebElement result;

    //------------------------------------------

    public void expandCheckBoxTree() {
        for (int i = 0; i <= toggleButtonList.size() - 1; i++) {
            scrollToElement(toggleButtonList.get(i));
            toggleButtonList.get(i).click();
        }
    }

    public int getNodeTitleIndex(String nodeTitle) {
        int index = -1;
        for (int i = 0; i < nodeTitleList.size(); i++) {
            if (nodeTitleList.get(i).getText().equalsIgnoreCase(nodeTitle)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void checkNode(String nodeTitle) {
        checkBoxList.get(getNodeTitleIndex(nodeTitle)).click();
    }
}
