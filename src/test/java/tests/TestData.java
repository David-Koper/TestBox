package tests;

import com.github.javafaker.Faker;
import utils.RandomGenerator;

public class TestData {
    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userNumber = String.valueOf(faker.number().randomNumber(10, true));
    String email = faker.internet().emailAddress();
    String link = "Greenshot.png";
            //"src/test/resources/Greenshot.png";
    String currentAddress = faker.address().fullAddress();;
    String year = String.valueOf(faker.number().numberBetween(1900, 2022));
    String month = RandomGenerator.randomMonths();
    String gender = RandomGenerator.randomGender();
    //faker.demographic().sex();
    String subject = RandomGenerator.randomSubject();
    String hobby = RandomGenerator.randomHobby();
    String day = String.valueOf(faker.number().numberBetween(1,28));
    String state = "NCR" ;
    String city = "Delhi";
}
