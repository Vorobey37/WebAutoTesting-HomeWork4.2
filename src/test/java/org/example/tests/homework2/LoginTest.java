package org.example.tests.homework2;

import org.example.pom.LoginPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {
    private final String USERNAME = "GB202302c48fb20";
    private final String PASSWORD = "7abe49a426";
    private String pathToChromeDriver;
    private String testStandUrl;
    private WebDriver driver;
    private WebDriverWait wait;

    @Test
    public void loginWithoutValuesTest(){

        pathToChromeDriver = "src/main/resources/chromedriver.exe";
        System.setProperty("webChromeDriver", pathToChromeDriver);

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        testStandUrl = "https://test-stand.gb.ru/login";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(testStandUrl);

        LoginPage loginPage = new LoginPage(wait, driver);
        loginPage.login("", "");

        String actualResult = loginPage.getInvalidField().getText();

        Assertions.assertEquals("Invalid credentials.", actualResult);

        driver.quit();
    }


}
