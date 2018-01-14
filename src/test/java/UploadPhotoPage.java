import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class UploadPhotoPage extends LandingPage {

    public SelenideElement
            submitPhotoButton =$(byText("Submit a photo")),
            addPhotoButton=$(byText("Add a photo")),
            uploadFile = $("#file"),
            tags = $(".ui-autocomplete-input"),
            nextButton = $(byValue("Next")),
            titleField = $(".js-uploader-input-autofocus"),
            storyField = $(byName("story_attributes[description]")),
            locationCheckbox = $(byValue("1")),
            agreeUpload = $(byValue("Submit")),
            successUploadText = $("h1");
            //photoComponent = $("[data-test='photo-component']");

/*
    public void uploadPhoto(){
        submitPhotoButton.click();
        addPhotoButton.click();
        //загрузка самого файла на сайт
        File file = new File("src/test/111.jpg");
        uploadFile.uploadFile(file);
    }
*/

    public void clickOnSubmitPhotoButton() {
        submitPhotoButton.click();
    }

    public void clickOnAddPhotoButton() {
        addPhotoButton.click();
    }

    public void uploadFilePhoto() {
        //загрузка самого файла на сайт
        File file = new File("src/test/111.jpg");
        uploadFile.uploadFile(file);
    }
    
        public void addTagesToPhoto(String[] tagPhoto) {
        // добавление тегов
        for (int i = 0; i < tagPhoto.length; i++) {
            tags.waitUntil(Condition.visible, 20000).setValue(tagPhoto[i]).pressEnter();
        }
        // ждем пока фото загрузится
        nextButton.waitUntil(Condition.visible, 20000).click();
        // пропускаем  EXIF information
        nextButton.click();
        }

        public void writeStoryAboutPhoto(String title, String story) {
       // прописываем название и описание для фото
        titleField.val(title);
        storyField.val(story);
        nextButton.click();
        }

        public void selectedNoLocationCheckBox() {
            //не указываем локацию фото
            locationCheckbox.shouldBe(Condition.visible).setSelected(true);
            nextButton.waitUntil(Condition.visible, 30000).click();
        }

        public void clickOnSubmitButton() {
            //последний шаг на загрузке фото
            agreeUpload.waitUntil(Condition.visible, 30000).click();
        }

        public void checkThatPhotoIsUpload(String upload) {
        successUploadText.shouldBe(visible).shouldHave(text(upload));
        open("/@izyaz");
        photoComponent.click();
        }

}
