package org.example.pom;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    @FindBy(css="div#app > main > div > div > div.mdc-layout-grid > div > div:nth-child(1) > div > div > div > div.mdc-card__actions > div > button.material-icons.mdc-icon-button.mdc-icon-button--display-flex.mdc-card__action.mdc-card__action--icon.mdc-ripple-upgraded--unbounded.mdc-ripple-upgraded")
    private SelenideElement editButton;
    @FindBy(css="div#app > main > div > div > div.mdc-layout-grid > div > div:nth-child(2) > div > div:nth-child(2) > div.content.svelte-vyyzan")
    private SelenideElement birthdateField;
    @FindBy(css="form#update-item > div:nth-child(3) > label > input")
    private SelenideElement birthdateEditField;
    @FindBy(css="form#update-item > div.submit.svelte-vyyzan > button")
    private SelenideElement saveButton;
    @FindBy(css="div#app > main > div > div > div.mdc-dialog.mdc-dialog--open > div.mdc-dialog__container > div > div.form-modal-header.mdc-dialog__header > button")
    private SelenideElement closeButton;


    public void editBirthdateField(String birthdate){
        editButton.shouldBe(visible).click();
        birthdateEditField.shouldBe(visible).setValue(birthdate);
        saveButton.shouldBe(visible).click();
        closeButton.shouldBe(visible).click();
        Selenide.sleep(2000);
    }

    public String getBirthdateValue(){
        return birthdateField.shouldBe(visible).getText();
    }

}
