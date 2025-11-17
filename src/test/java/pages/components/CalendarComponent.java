package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {


    private SelenideElement yearInput = $(".react-datepicker__year-select"),
            monthInput = $(".react-datepicker__month-select");

    private ElementsCollection dayInput = $$(".react-datepicker__day");

    public void setDate(String day, String month, String year) {
        yearInput.selectOption(year);
        monthInput.selectOption(month);
        dayInput.findBy(exactText(day)).click();
    }
}
