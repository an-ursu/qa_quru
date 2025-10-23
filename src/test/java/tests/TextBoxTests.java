package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void setUp(){
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
    void fillFormTest() {

        open("https://demoqa.com/text-box");
        $("#userName").setValue("Kevin");
        $("#userEmail").setValue("kevin@pembrok.com");
        $("#currentAddress").setValue("Street 1");
        $("#permanentAddress").setValue("Street 2");
        $("#submit").click();


        $("#output").$("#name").shouldHave(text("Kevin"));
        $("#output").$("#email").shouldHave(text("kevin@pembrok.com"));
        $("#output").$("#currentAddress").shouldHave(text("Street 1"));
        $("#output").$("#permanentAddress").shouldHave(text("Street 2"));


    }
}

