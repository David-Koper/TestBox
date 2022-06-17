package pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderRadioButton = $("#genterWrapper");
    SelenideElement userNumberInput = $("#userNumber");
    SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    SelenideElement subjectInput = $("#subjectsInput");
    SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    SelenideElement uploadImage = $("#uploadPicture");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement stateCityWrapper = $("#stateCity-wrapper");
    SelenideElement citySelector = $("#city");
    SelenideElement submitButton = $("#submit");
    SelenideElement state = $("#state");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderRadioButton.$(byText("Male")).click();

        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
           emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String day, String month, String year) {
           dateOfBirthInput.click();
           calendarComponent.setDate(day, month, year);

        return this;
    }
    public RegistrationFormPage checkResult(String key, String value){
           resultsTableComponent.checkResult(key, value);

            return this;
        }

    public RegistrationFormPage setMaths(String value) {
           subjectInput.sendKeys(value);
           $(byText("Maths")).click();

            return this;
        }
    public RegistrationFormPage setHobbie(String value){
           hobbiesCheckBox.$(byText("Sports")).click();

            return this;
        }

    public RegistrationFormPage uploadPicture(String value){
           uploadImage.uploadFile(new File(value));

            return this;
        }

    public RegistrationFormPage setUserNumber(String value){
           userNumberInput.setValue(value);

            return this;
        }

    public RegistrationFormPage setAddress(String value){
           currentAddress.setValue(value);

            return this;
        }

    public RegistrationFormPage scrollToClick(){
           state.scrollTo().click();

            return this;
        }

    public RegistrationFormPage setStateAndCity(String state, String city){
            stateCityWrapper.$(Selectors.byText(state)).click();
            citySelector.click();
            stateCityWrapper.$(Selectors.byText(city)).click();

            return this;
        }

    public RegistrationFormPage sendForm(){
            submitButton.click();

            return this;
        }
    }
