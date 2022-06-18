package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.ResultsTableComponent;

import java.security.Provider;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import utils.RandomGenerator;
public class TestBox extends TestBase {

    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String UserNumber = String.valueOf(faker.number().randomNumber(10, true));
    String email = faker.internet().emailAddress();
    String link = "src/test/resources/Greenshot.png";
    String currentAddress = faker.address().fullAddress();;
    String Year = String.valueOf(faker.number().numberBetween(1900, 2022));
    String Month = RandomGenerator.randomMonths();
    String gender = RandomGenerator.randomGender();
            //faker.demographic().sex();
    String Subject = RandomGenerator.randomSubject();
    String hobby = RandomGenerator.randomHobby();
    String Day = String.valueOf(faker.number().numberBetween(1,28));
    @Test
    void useYourBrainTest() {



        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender(gender)
                .setSubjects(Subject)
                .setHobby(hobby)
                .setDateOfBirth(Day, Month, Year)
                .setUserNumber(UserNumber)
                .uploadPicture("src/test/resources/Greenshot.png")
                .setAddress(currentAddress)
                .scrollToClick()
                .setStateAndCity("NCR", "Delhi")
                .sendForm();


        registrationFormPage
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", UserNumber)
                .checkResult("Date of Birth", Day+" "+Month+","+Year)
                .checkResult("Subjects", Subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "Greenshot.png")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", "NCR Delhi");
    }
}
