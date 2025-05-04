package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Frame1Page extends BaseTest {

    public Frame1Page() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "sampleHeading")
    public WebElement frameHeading;
}
