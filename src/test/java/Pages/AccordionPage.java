package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccordionPage extends BaseTest {

    public AccordionPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-header")
    public List<WebElement> cardHeaderList;

    @FindBy(className = "card-body")
    public List<WebElement> cardBodyList;

    //-----------------------

    public void hideAllAccordionContent() {
        for (int i = 0; i < cardHeaderList.size(); i++) {
            if (cardBodyList.get(i).isDisplayed()) {
                cardHeaderList.get(i).click();
            }
        }
    }
}
