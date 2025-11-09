package pages.components;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    public void checkResult(String value){
        $(".modal-body").shouldHave(text(value));
    }

    public void checkNonValidation(){
        $("#userForm").shouldHave(cssClass("was-validated"));
    }
}
