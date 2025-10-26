package tests;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXPathExamples {

    void CssXPath(){
        $("[data-testid=email]").setValue("1");
        $(by("data-testid","email")).setValue("2");
        $x("//*[@data-testid='email']").setValue("");


        $("[id=email]").setValue("1");
        $(by("id","email")).setValue("2");
        $(byId("email")).setValue("2");
        $("#email").setValue("3");
        $x("//*[@id='email']").setValue("");


        $("[name=email]").setValue("1");
        $(by("name","email")).setValue("2");
        $(byName("email")).setValue("2");
        $x("//*[@name='email']").setValue("");


        $("[class=input_text][class=login_form_input_box]").setValue("1");
        $(".input_text.login_form_input_box").setValue("3");
        $(".login_form_input_box").setValue("3");
        $(".input.input_text.login_form_input_box").setValue("3");
        $x("//input[@class='inputtext'][@class='login_form_input_box']").setValue("3");






    }
}
