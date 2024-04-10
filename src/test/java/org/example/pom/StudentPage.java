package org.example.pom;

import org.example.pom.elements.StudentTableRow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalTime;
import java.util.List;

public class StudentPage {

    private final WebDriverWait wait;

    //private WebElement studentNameField;
    @FindBy(css="button#create-btn")
    private WebElement addStudentButton;
    @FindBy(css="#app > main > div > div > div.mdc-data-table > div.mdc-data-table__pagination > div > div.mdc-data-table__pagination-navigation > div")
    private WebElement quantityStudentField;
    //private WebElement basketButton;
    //private WebElement statusField;
    @FindBy(css="form#upsert-item > div:nth-child(1) > label > input")
    private WebElement firstNameField;
    @FindBy(css="form#upsert-item > div:nth-child(5) > label > input")
    private WebElement loginField;
    @FindBy(css="form#upsert-item > div.submit > button")
    private WebElement saveButton;
    @FindBy(css="div#app > main > div > div > div.mdc-dialog.mdc-dialog--open > div.mdc-dialog__container > div > div.form-modal-header.mdc-dialog__header > button")
    private WebElement closeButton;
    @FindBy(css="div#app > main > div > div > div.mdc-data-table > div.mdc-data-table__table-container > table > tbody > tr:nth-child(1)")
    private List<WebElement> rowsInStudentTable;
//#app > main > div > div > div.mdc-data-table > div.mdc-data-table__table-container > table > tbody

    public StudentPage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public WebElement getQuantityStudentField() {
        return wait.until(ExpectedConditions.visibilityOf(quantityStudentField));
    }

    public void addStudent(String loginAndName){

        addStudentButton.click();

        wait.until(ExpectedConditions.visibilityOf(firstNameField)).sendKeys(loginAndName);
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(loginAndName);

        wait.until(ExpectedConditions.visibilityOf(saveButton)).click();

        closeButton.click();
        wait.until(ExpectedConditions.visibilityOf(closeButton));
    }

    public String getStatusInStudentTableRow(String name){
        return getRowsInStudentTableByName(name).getStatus();
    }

    private StudentTableRow getRowsInStudentTableByName(String name) {
        return rowsInStudentTable.stream()
                .map(StudentTableRow::new)
                .filter(row -> row.getName().equals(name))
                .findFirst().orElseThrow();
    }
}
