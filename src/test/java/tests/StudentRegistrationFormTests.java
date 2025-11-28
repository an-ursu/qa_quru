package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 40000;
        Configuration.pageLoadTimeout = 40000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void registrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Kevin");
        $("#lastName").setValue("Pembrok");
        $("#userEmail").setValue("kevin@pembrok.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("9261301265");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2024");
        $(".react-datepicker__month-select").selectOption("October");
        $$(".react-datepicker__day").findBy(exactText("26")).click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("test-image.mp4");
        $("#currentAddress").setValue("Random city, Street line 1");
        $("#stateCity-wrapper").$("#state").click();
        $(byText("Haryana")).click();
        $("#stateCity-wrapper").$("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();


        $(".modal-body").shouldHave(text("Kevin Pembrok"));
        $(".modal-body").shouldHave(text("kevin@pembrok.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("9261301265"));
        $(".modal-body").shouldHave(text("26 October,2024"));
        $(".modal-body").shouldHave(text("Hindi"));
        $(".modal-body").shouldHave(text("Music"));
        $(".modal-body").shouldHave(text("test-image.mp4"));
        $(".modal-body").shouldHave(text("Random city, Street line 1"));
        $(".modal-body").shouldHave(text("Haryana Karnal"));

    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
