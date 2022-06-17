package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBox extends TestBase {


    @Test
    void useYourBrainTest() {

        String firstName = "David";
        String lastName = "Kuznetsov";
        String UserNumber = "9876543211";
        String email = "DavidKuznetsov@gmail.com";
        String link = "src/test/resources/Greenshot.png";
        String address = "Gagarina 115";

        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setGender("Male")
                .setMaths("M")
                .setHobbie("Sports")
                .setDateOfBirth("9", "July", "1987")
                .setUserNumber(UserNumber)
                .uploadPicture(link)
                .setAddress(address)
                .scrollToClick()
                .setStateAndCity("NCR", "Delhi")
                .sendForm();


        registrationFormPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", "Male")
                .checkResult("Mobile", UserNumber)
                .checkResult("Date of Birth", "09 July,1987")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "Greenshot.png")
                .checkResult("Address", address)
                .checkResult("State and City", "NCR Delhi");
    }
}
