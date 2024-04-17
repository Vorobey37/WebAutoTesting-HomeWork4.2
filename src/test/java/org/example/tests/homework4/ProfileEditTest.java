package org.example.tests.homework4;

import com.codeborne.selenide.Selenide;
import org.example.pom.LoginPage;
import org.example.pom.ProfilePage;
import org.example.pom.StudentPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class ProfileEditTest {

    private final String USERNAME = "GB202302c48fb20";
    private final String PASSWORD = "7abe49a426";
    private StudentPage studentPage;
    private ProfilePage profilePage;
    @BeforeEach
    public void setUp() throws MalformedURLException {

        Selenide.open("https://test-stand.gb.ru/login");
        LoginPage loginPage = Selenide.page(LoginPage.class);
        loginPage.login(USERNAME, PASSWORD);
        studentPage = Selenide.page(StudentPage.class);
        Selenide.sleep(2000);
    }

    @Test
    public void testEditProfile(){

        studentPage.openProfilePage();

        profilePage = Selenide.page(ProfilePage.class);
        String birthdate = "12.12.2012";
        profilePage.editBirthdateField(birthdate);
        String actualResult = profilePage.getBirthdateValue();

        Assertions.assertEquals(birthdate, actualResult);
    }
}
