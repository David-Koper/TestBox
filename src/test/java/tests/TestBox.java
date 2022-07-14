package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.ResultsTableComponent;

import java.security.Provider;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

import utils.RandomGenerator;

@Tag("demoQA_tests")
public class TestBox extends TestBase {
    @Test
    void useYourBrainTest() {
        step("Filling in user data", () -> {
        registrationFormPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGender(testData.gender)
                .setSubjects(testData.subject)
                .setHobby(testData.hobby)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setUserNumber(testData.userNumber)
                .uploadPicture(testData.link)
                .setAddress(testData.currentAddress)
                //.scrollToClick()
                .setStateAndCity(testData.state, testData.city)
                .sendForm();
        });

        step("Checking the results", () -> {
        registrationFormPage
                .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.day+" "+testData.month+","+testData.year)
                .checkResult("Subjects", testData.subject)
                .checkResult("Hobbies", testData.hobby)
                .checkResult("Picture", testData.link)
                .checkResult("Address", testData.currentAddress)
                .checkResult("State and City", testData.state+" "+testData.city);
        });
    }
}
