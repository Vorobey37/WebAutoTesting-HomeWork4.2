package org.example.tests.homework4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.example.pom.LoginPage;
import org.example.pom.StudentPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class StudentChangeValuesTest {
    private final String USERNAME = "GB202302c48fb20";
    private final String PASSWORD = "7abe49a426";
    private StudentPage studentPage;

    @BeforeEach
    public void setUp() throws MalformedURLException {

        Selenide.open("https://test-stand.gb.ru/login");
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.login(USERNAME, PASSWORD);
        studentPage = Selenide.page(StudentPage.class);
        Selenide.sleep(2000);
    }
    @Test
    public void changeStudentParamTest(){

        String birthday = "21.12.2012";
        studentPage.editStudentParam(birthday);
        String expectedResult = "2012-12-21";
        String actualResult = studentPage.getStudentBirthdayField();
        Assertions.assertEquals(expectedResult, actualResult);

    }



    @AfterEach
    public void close(){
        WebDriverRunner.closeWebDriver();
    }
}
