package Tests;

import Base.BaseTest;
import Pages.HomepagePage;
import Pages.LeftsidemenuPage;
import Pages.RegistrationFormPage;
import Pages.WebTablesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Helpers.HomepageCards.ELEMENTS;
import static Helpers.URLs.HOMEPAGEURL;

public class WebTablesTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        homepagePage = new HomepagePage();
        leftsidemenuPage = new LeftsidemenuPage();
        webTablesPage = new WebTablesPage();
        registrationFormPage = new RegistrationFormPage();

        driver.navigate().to(HOMEPAGEURL);
        homepagePage.clickOnCard(ELEMENTS);
        leftsidemenuPage.clickOnLeftMenuItem(excelReader.getStringData("Left Side Menu", 4, 1));
    }

    private void fillOutRegistrationForm(String firstName, String lastName, String email, String age, String salary, String department) {
        registrationFormPage.inputFirstName(firstName);
        registrationFormPage.inputLastName(lastName);
        registrationFormPage.inputEmail(email);
        registrationFormPage.inputAge(age);
        registrationFormPage.inputSalary(salary);
        registrationFormPage.inputDepartment(department);
        scrollToElement(registrationFormPage.submitButton);
    }

    private void assertRowData(int rowIndex, String firstName, String lastName, String age, String email, String salary, String department) {
        Assert.assertEquals(webTablesPage.cells.get(rowIndex * 7).getText(), firstName);
        Assert.assertEquals(webTablesPage.cells.get(rowIndex * 7 + 1).getText(), lastName);
        Assert.assertEquals(webTablesPage.cells.get(rowIndex * 7 + 2).getText(), age);
        Assert.assertEquals(webTablesPage.cells.get(rowIndex * 7 + 3).getText(), email);
        Assert.assertEquals(webTablesPage.cells.get(rowIndex * 7 + 4).getText(), salary);
        Assert.assertEquals(webTablesPage.cells.get(rowIndex * 7 + 5).getText(), department);
    }

    @Test
    public void testAddUsersFromExcel() {
        int expectedRows = excelReader.getIntegerData("Web Tables", 0, 1);
        Assert.assertEquals(webTablesPage.rowsFilled(), expectedRows);
        webTablesPage.removeAllRecords();
        Assert.assertTrue(webTablesPage.noRowsFoundAlert.isDisplayed());

        for (int i = 0; i < excelReader.getLastRow("Web Tables") - 2; i++) {
            scrollToElement(webTablesPage.addButton);
            webTablesPage.addButton.click();
            String firstName = excelReader.getStringData("Web Tables", i + 3, 0);
            String lastName = excelReader.getStringData("Web Tables", i + 3, 1);
            String email = excelReader.getStringData("Web Tables", i + 3, 2);
            String age = String.valueOf(excelReader.getIntegerData("Web Tables", i + 3, 3));
            String salary = String.valueOf(excelReader.getIntegerData("Web Tables", i + 3, 4));
            String department = excelReader.getStringData("Web Tables", i + 3, 5);

            fillOutRegistrationForm(firstName, lastName, email, age, salary, department);
            registrationFormPage.submitButton.click();


            // Verify the number of rows has increased
            Assert.assertEquals(webTablesPage.rowsFilled(), i + 1);

            // Verify the data in the table row
            assertRowData(i, firstName, lastName, age, email, salary, department);
        }
    }
}
