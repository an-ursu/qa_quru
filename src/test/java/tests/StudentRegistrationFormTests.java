package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 40000;
        Configuration.pageLoadTimeout = 40000;
        Configuration.holdBrowserOpen = true;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void RegistrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Kevin");
        $("#lastName").setValue("Pembrok");
        $("#userEmail").setValue("kevin@pembrok.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("9261301265");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2024");
        $(".react-datepicker__month-select").selectOption("October");
        $$(".react-datepicker__day").findBy(exactText("26")).click();
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("images/test-image.mp4");
        $("#currentAddress").setValue("Random city, Street line 1");
        $("#state").click();
        $("#state input").setValue("Haryana").pressEnter();
        $("#city").click();
        $("#city input").setValue("Karnal").pressEnter();
        $("#submit").click();


        $(".table-responsive").shouldHave(
                text("Kevin Pembrok"),
                text("kevin@pembrok.com"),
                text("Male"),
                text("9261301265"),
                text("26 October,2024"),
                text("Hindi"),
                text("Music"),
                text("test-image.mp4"),
                text("Random city, Street line 1"),
                text("Haryana Karnal")
        );
    }
}
