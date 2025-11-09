package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class PictureComponent {
    public void uploadPicture(String value){
        $("#uploadPicture").uploadFromClasspath(value);
    }
}
