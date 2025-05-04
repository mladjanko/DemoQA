package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadAndDownloadPage extends BaseTest {

    public UploadAndDownloadPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "downloadButton")
    public WebElement downloadButton;

    @FindBy(id = "uploadFile")
    public WebElement chooseFileButton;

    @FindBy(id = "uploadedFilePath")
    public WebElement uploadedFilePathMessage;

    //-------------------

    public void uploadFile(String fileName) {
        chooseFileButton.sendKeys(fileName);
    }
}
