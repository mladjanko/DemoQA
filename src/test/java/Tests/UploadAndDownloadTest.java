package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import Pages.UploadAndDownloadPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.HOMEPAGEURL;

public class UploadAndDownloadTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        uploadAndDownloadPage = new UploadAndDownloadPage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 8, 1));
    }

    @Test(priority = 10)
    public void testDownloadFileTest() throws InterruptedException {
        WebElement downloadButton = uploadAndDownloadPage.downloadButton;
        String downloadDirectory = "D:\\Downloads";
        String fileName = "sampleFile.jpeg";
        File downloadedFile = new File(Paths.get(downloadDirectory, fileName).toString());
        scrollToElement(downloadButton);
        downloadButton.click();
        Thread.sleep(3000);
        // Assert that the file exists in the download directory
        Assert.assertTrue(downloadedFile.exists(), "File not found: " + fileName);
    }

    @Test(priority = 20)
    public void testUploadFileTest() {
        WebElement chooseFileButton = uploadAndDownloadPage.chooseFileButton;
        WebElement uploadedFilePathMessage = uploadAndDownloadPage.uploadedFilePathMessage;
        File file = new File("yoda.jpg");
        String expectedPath = "C:\\fakepath\\" + file;
        scrollToElement(chooseFileButton);
        uploadAndDownloadPage.uploadFile(file.getAbsolutePath());
        Assert.assertEquals(uploadedFilePathMessage.getText(), expectedPath);
    }
}
