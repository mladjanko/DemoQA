package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "rt-tr-group")
    public List<WebElement> tableRows;

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(css = "span[title='Delete']")
    public WebElement deleteButton;

    @FindBy(className = "rt-td")
    public List<WebElement> cells;

    @FindBy(className = "rt-noData")
    public WebElement noRowsFoundAlert;

    //---------------------------

    public int rowsFilled() {
        int counter = 0;
        for (WebElement tableRow : tableRows) {
            if (!tableRow.getText().isBlank()) {
                counter++;
            }
        }
        return counter;
    }

    public void removeAllRecords() {
        while (rowsFilled() > 0) {
            scrollToElement(deleteButton);
            deleteButton.click();
        }
    }
}

