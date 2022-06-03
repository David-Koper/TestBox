package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestBox {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void useYourBrainTest(){
        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("David");
        $("#lastName").setValue("Kuznetsov");
        $("#userEmail").setValue("DavidKuznetsov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9876543211");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1987");
        $(byText("9")).click();
        $("#subjectsInput").sendKeys("Maths");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath ("Greenshot.png");
        $("#currentAddress-wrapper").click();
        $("#currentAddress").val("Gagarina 115");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$(".table-responsive tr").filterBy(text("Student Name")).shouldBe(texts("David"));
        $$(".table-responsive tr").filterBy(text("Student Email")).shouldBe(texts("DavidKuznetsov@gmail.com"));
        $$(".table-responsive tr").filterBy(text("Gender")).shouldBe(texts("Male"));
        $$(".table-responsive tr").filterBy(text("Mobile")).shouldBe(texts("9876543211"));
        $$(".table-responsive tr").filterBy(text("Date of Birth")).shouldBe(texts("09 July,1987"));
        $$(".table-responsive tr").filterBy(text("Subjects")).shouldBe(texts("Maths"));
        $$(".table-responsive tr").filterBy(text("Hobbies")).shouldBe(texts("Sports"));
        $$(".table-responsive tr").filterBy(text("Picture")).shouldBe(texts("Greenshot.png"));
        $$(".table-responsive tr").filterBy(text("Address")).shouldBe(texts("Gagarina 115"));
        $$(".table-responsive tr").filterBy(text("State and City")).shouldBe(texts("NCR Delhi"));

}
