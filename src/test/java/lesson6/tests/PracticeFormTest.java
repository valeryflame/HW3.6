package lesson6.tests;

import com.github.javafaker.Faker;
import com.codeborne.selenide.Configuration;
import lesson6.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import lesson6.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Selenide.$;


public class PracticeFormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultTableComponent resultsTable = new ResultTableComponent();
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String phoneNumber = faker.number().digits(10);
    String address = faker.address().fullAddress();
    String gender = "Male";
    String hobby = "Music";
    String subject = "Math";
    String state = "NCR";
    String city = "Delhi";
    String month = "January";
    String year = "1997";
    String day = "15";
    String picture = "test-files/images.png";

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillAllFormTest() {
        practiceFormPage.openForm()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .selectHobby(hobby)
                .selectSubject(subject)
                .selectState(state)
                .selectCity(city)
                .setDateOfBirth(month, year, day)
                .uploadPicture(picture)
                .submit();

        resultsTable.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", "images.png")
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }


    @Test
    void fillMinimalFormTest() {
        practiceFormPage.openForm()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .selectGender(gender)
                .setPhoneNumber(phoneNumber)
                .submit();

        resultsTable.checkResult("Student Name", firstName + " " + lastName);
    }


    @Test
    void fillFormWithInvalidEmailTest() {
        practiceFormPage.openForm()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail("invalid-email")
                .selectGender(gender)
                .setPhoneNumber(phoneNumber)
                .submit();
    }
}

