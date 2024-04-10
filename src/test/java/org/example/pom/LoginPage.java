package org.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriverWait wait;
    @FindBy(css="form#login input[type='text']")
    private WebElement userNameField;
    @FindBy(css="form#login input[type='password']")
    private WebElement passwordField;
    @FindBy(css="form#login button")
    private WebElement loginButton;
    @FindBy(css="div#app > main > div > div > div.error-block.svelte-uwkxn9 > p:nth-child(2)")
    private WebElement invalidField;

    public LoginPage(WebDriverWait wait, WebDriver driver) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password){
        setValueInUserNameField(userName);
        setValueInPasswordField(password);
        clickOnLoginButton();
    }

    public void setValueInUserNameField(String userName){
        wait.until(ExpectedConditions.visibilityOf(userNameField)).sendKeys(userName);
        //userNameField.sendKeys(userName);
    }

    public void setValueInPasswordField(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
       // passwordField.sendKeys(password);
    }

    public void clickOnLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }

    public WebElement getInvalidField() {
        return invalidField;
    }
}
