package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;


public class StudentRegistrationFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    @Tag("demoqa")
    @Test
    void registrationFormFullRequiredFieldsTest() {

        step("Open page", () -> {
            registrationPage.openPage();
        });

        step("Remove banner",() ->{
            registrationPage.removeBanners();
        });

        step("Fill form on page", () -> {
            registrationPage.setFirstName(randomUtils.firstName)
                    .setLastName(randomUtils.lastName)
                    .setEmail(randomUtils.email)
                    .setGenter(randomUtils.gender)
                    .setUserPhoneNumber(randomUtils.phoneNumber)
                    .setDateOfBirthday(randomUtils.birthdayDay, randomUtils.birthdayMonth, randomUtils.birthdayYear)
                    .setSubjects(randomUtils.subjects)
                    .setHobbies(randomUtils.hobbies)
                    .setPicture(randomUtils.picture)
                    .setAddress(randomUtils.address)
                    .setState(randomUtils.state)
                    .setCity(randomUtils.city);

        });

        step("Submit", () -> {
            registrationPage.setSubmit();
        });

        step("Check result", () -> {
            registrationPage.checkResult(randomUtils.firstName + " " + randomUtils.lastName)
                    .checkResult(randomUtils.email)
                    .checkResult(randomUtils.gender)
                    .checkResult(randomUtils.phoneNumber)
                    .checkResult(randomUtils.birthdayDay + " " + randomUtils.birthdayMonth + "," + randomUtils.birthdayYear)
                    .checkResult(randomUtils.subjects)
                    .checkResult(randomUtils.hobbies)
                    .checkResult(randomUtils.picture)
                    .checkResult(randomUtils.address)
                    .checkResult(randomUtils.state + " " + randomUtils.city);
        });
    }

    @Deprecated
    @Test
    void registrationFormMinimalRequiredFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setEmail(randomUtils.email)
                .setGenter(randomUtils.gender)
                .setUserPhoneNumber(randomUtils.phoneNumber)
                .setSubmit();

        registrationPage.checkResult(randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult(randomUtils.email)
                .checkResult(randomUtils.gender)
                .checkResult(randomUtils.phoneNumber);

    }

    @Deprecated
    @Test
    void registrationFormNonRequiredFieldsTest() {
        registrationPage.openPage()
                .removeBanners()
                .setDateOfBirthday(randomUtils.birthdayDay, randomUtils.birthdayMonth, randomUtils.birthdayYear)
                .setSubjects(randomUtils.subjects)
                .setHobbies(randomUtils.hobbies)
                .setPicture(randomUtils.picture)
                .setAddress(randomUtils.address)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .setSubmit();

        registrationPage.checkNonValidation();

    }

}
