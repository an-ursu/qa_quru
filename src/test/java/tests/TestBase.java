package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 40000;
        Configuration.pageLoadTimeout = 40000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
