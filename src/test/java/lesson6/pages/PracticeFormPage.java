package lesson6.pages;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import lesson6.components.CalendarComponent;

public class PracticeFormPage {

    CalendarComponent calendar = new CalendarComponent();

    public PracticeFormPage setDateOfBirth(String month, String year, String day) {
        calendar.setDate(month, year, day);
        return this;
    }

    public PracticeFormPage openForm() {
        open("/automation-practice-form");
        return this;
    }

    public PracticeFormPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    public PracticeFormPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    public PracticeFormPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    public PracticeFormPage selectGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();
        return this;
    }

    public PracticeFormPage setPhoneNumber(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    public PracticeFormPage setAddress(String address) {
        $("#currentAddress").setValue(address);
        return this;
    }

    public PracticeFormPage selectHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();
        return this;
    }

    public PracticeFormPage selectSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }

    public PracticeFormPage selectState(String state) {
        $("#state").scrollIntoView(true).click();
        $("#stateCity-wrapper").$(byText(state)).click();
        return this;
    }

    public PracticeFormPage selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        return this;
    }

    public PracticeFormPage uploadPicture(String path) {
        $("#uploadPicture").uploadFromClasspath(path);
        return this;
    }

    public void submit() {
        $("#submit").scrollIntoView(true).click();
    }
}
