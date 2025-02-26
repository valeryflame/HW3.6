package lesson6.tests;

import com.codeborne.selenide.Configuration;
import lesson6.pages.PracticeFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import lesson6.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    ResultTableComponent resultsTable = new ResultTableComponent();

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillAllFormTest() {
        practiceFormPage.openForm()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setEmail("ivan@example.com")
                .selectGender("Male")
                .setPhoneNumber("1234567890")
                .setAddress("Street 1")
                .selectHobby("Music")
                .selectSubject("Math")
                .selectState("NCR")
                .selectCity("Delhi")
                .setDateOfBirth("January", "1997", "15")
                .uploadPicture("test-files/images.png")
                .submit();

        resultsTable.checkResult("Student Name", "Иван Иванов");
    }

    @Test
    void fillMinimalFormTest() {
        practiceFormPage.openForm()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setEmail("ivan@example.com")
                .selectGender("Male")
                .setPhoneNumber("1234567890")
                .submit();

        resultsTable.checkResult("Student Name", "Иван Иванов");
    }

    @Test
    void fillFormWithInvalidEmailTest() {
        practiceFormPage.openForm()
                .setFirstName("Иван")
                .setLastName("Иванов")
                .setEmail("invalid-email")
                .selectGender("Male")
                .setPhoneNumber("1234567890")
                .submit();
    }
}

