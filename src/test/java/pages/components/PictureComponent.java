package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PictureComponent {

    private SelenideElement uploadPictureInput = $("#uploadPicture");

    public void uploadPicture(String value){
        uploadPictureInput.uploadFromClasspath(value);
    }
}
