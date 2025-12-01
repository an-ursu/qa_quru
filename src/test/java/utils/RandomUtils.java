package utils;


import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en"));

    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String phoneNumber;
    public String birthdayDay;
    public String birthdayMonth;
    public String birthdayYear;
    public String subjects;
    public String hobbies;
    public String picture;
    public String address;
    public String state;
    public String city;

    public RandomUtils() {
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.gender = faker.options().option("Female", "Male", "Other");
        this.phoneNumber = faker.phoneNumber().subscriberNumber(10);
        this.birthdayDay = String.valueOf(faker.number().numberBetween(1, 28));
        ;
        this.birthdayMonth = faker.options().option("January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December");

        this.birthdayYear = String.valueOf(faker.number().numberBetween(1996, 2025));

        this.subjects = faker.options().option("English", "Computer Science", "Arts");
        this.hobbies = faker.options().option("Sports", "Reading", "Music");
        this.picture = faker.options().option("test-image.mp4", "P12A4359.jpg", "DSC_6320.jpg");
        this.address = faker.address().streetAddress();
        this.state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
        this.city = choiceCityFromState(this.state);
    }

    String choiceCityFromState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }

}
