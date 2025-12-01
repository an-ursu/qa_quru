package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private final SelenideElement checkResultForm = $(".modal-body"),
            checkNonValidationForm = $("#userForm");

    public void checkResult(String value) {
        checkResultForm.shouldHave(text(value));
    }

    public void checkNonValidation() {
        checkNonValidationForm.shouldHave(cssClass("was-validated"));
    }
}
