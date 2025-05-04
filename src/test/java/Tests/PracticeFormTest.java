package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import Pages.PracticeFormModalPage;
import Pages.PracticeFormPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static Helpers.HomepageCards.FORMS;
import static Helpers.URLs.HOMEPAGEURL;

public class PracticeFormTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        practiceFormPage = new PracticeFormPage();
        practiceFormModalPage = new PracticeFormModalPage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(FORMS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 11, 1));
    }

    private void fillOutPracticeForm(String firstName, String lastName, String userEmail, String gender, String mobileNumber,
                                     String[] dateOfBirth, String[] subjects, String[] hobbies, File file, String currentStreet,
                                     String state, String city) {
        practiceFormPage.inputFirstName(firstName);
        practiceFormPage.inputLastName(lastName);
        practiceFormPage.inputUserEmail(userEmail);
        practiceFormPage.selectGender(gender);
        practiceFormPage.inputMobileNumber(mobileNumber);
        practiceFormPage.inputUserDateOfBirth(dateOfBirth);
        practiceFormPage.inputSubjects(subjects);
        practiceFormPage.uploadPicture(file.getAbsolutePath());
        practiceFormPage.selectHobbies(hobbies);
        practiceFormPage.inputCurrentAddress(currentStreet);
        practiceFormPage.selectStateDropdown(state);
        practiceFormPage.selectCityDropdown(city);
        scrollToElement(practiceFormPage.submitButton);
        practiceFormPage.clickSubmitButton();
    }

    @Test
    public void testPracticeForm() throws InterruptedException {
        List<WebElement> practiceFormModalPageCells = practiceFormModalPage.cells;
        WebElement practiceFormModalPageCloseButton = practiceFormModalPage.closeButton;
        String firstName = "John";
        String lastName = "Doe";
        String userEmail = "john.doe@mail.com";
        String gender = "Other";
        String mobileNumber = "1234567890";
        String[] dateOfBirth = {"15", "September", "1986"};
        String[] subjects = {"Math", "Computer Science", "Art", "Hist", "r"};
        String[] hobbies = {"Music", "Sports"};
        File file = new File("yoda.jpg");
        String currentStreet = "Street no1";
        String state = "Rajasthan", city = "Jaipur";
        fillOutPracticeForm(firstName, lastName, userEmail, gender, mobileNumber, dateOfBirth, subjects, hobbies,
                file, currentStreet, state, city);

        Assert.assertEquals(practiceFormModalPageCells.get(1).getText(), firstName + " " + lastName);
        Assert.assertEquals(practiceFormModalPageCells.get(5).getText(), gender);
        Assert.assertEquals(practiceFormModalPageCells.get(7).getText(), mobileNumber);
        scrollToElement(practiceFormModalPageCloseButton);
        Assert.assertTrue(practiceFormModalPageCloseButton.isEnabled());
        Thread.sleep(10000);
        practiceFormModalPageCloseButton.click();
    }
}
