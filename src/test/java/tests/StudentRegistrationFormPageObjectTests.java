package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class StudentRegistrationFormPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void registrationFormFullRequiredFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Kevin")
                .setLastName("Pembrok")
                .setEmail("kevin@pembrok.com")
                .setGenter("Male")
                .setUserPhoneNumber("9261301265")
                .setDateOfBirthday("26", "October", "2024")
                .setSubjects("Hindi")
                .setHobbies("Music")
                .setPicture("images/test-image.mp4")
                .setAddress("Random city, Street line 1")
                .setState("Haryana")
                .setCity("Karnal")
                .setSubmit();

        registrationPage.checkResult("Kevin Pembrok")
                .checkResult("kevin@pembrok.com")
                .checkResult("Male")
                .checkResult("9261301265")
                .checkResult("26 October,2024")
                .checkResult("Hindi")
                .checkResult("Music")
                .checkResult("test-image.mp4")
                .checkResult("Random city, Street line 1")
                .checkResult("Haryana Karnal");

    }

    @Test
    void registrationFormMinimalRequiredFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Kevin")
                .setLastName("Pembrok")
                .setEmail("kevin@pembrok.com")
                .setGenter("Male")
                .setUserPhoneNumber("9261301265")
                .setSubmit();

        registrationPage.checkResult("Kevin Pembrok")
                .checkResult("kevin@pembrok.com")
                .checkResult("Male")
                .checkResult("9261301265");

    }

    @Test
    void registrationFormNonRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setDateOfBirthday("26", "October", "2024")
                .setSubjects("Hindi")
                .setHobbies("Music")
                .setPicture("images/test-image.mp4")
                .setAddress("Random city, Street line 1")
                .setState("Haryana")
                .setCity("Karnal")
                .setSubmit();

        registrationPage.checkNonValidation();

    }

}
