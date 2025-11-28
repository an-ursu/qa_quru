package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class StudentRegistrationFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void registrationFormFullRequiredFieldsTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(randomUtils.firstName)
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
                .setCity(randomUtils.city)
                .setSubmit();

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

    }

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

