package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class testBox {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void useYourBrainTest(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("David");
        $("[id=lastName]").setValue("Kuznetsov");
        $("[id=userEmail]").setValue("DavidKuznetsov@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("987654321");
        $("#dateOfBirthInput").click();
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1987");
        $("[aria-label = 'Choose Thursday, July 9th, 1987']").click()
        $("#subjectsInput").setValue("Literature").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFile (new File("src/test/java/resources/Greenshot.png"));
        $("#currentAddress-wrapper").click();
        $("#currentAddress").val("Gagarina 115");
        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"),
                text("David"),
                text("DavidKuznetsov@gmail.com"), text("Male"), text("987654321"), text("Gagarina 115"),
                text("09 July,1987"), text("Literature"), text("Sports"),
                text("Screenshot_2.png"), text("Gagarina 115"), text("NCR Delhi"));
    }


}
