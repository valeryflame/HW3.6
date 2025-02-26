package lesson3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Иванов");
        $("#userEmail").setValue("ivan@example.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#currentAddress").setValue("Street 1");
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1997");
        $(".react-datepicker__day--015").click();

        $("#uploadPicture").uploadFromClasspath("test-files/images.png");

        $("#submit").scrollIntoView(true).click();

        $(".modal-content").should(appear);
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
    }
}
