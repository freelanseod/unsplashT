import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class AddCollectionPage extends LandingPage{

    public SelenideElement
        //    photoComponent = $("[data-test='photo-component']"),
            addCollectionButton = $(byTitle("Add to collection")),
            createNewCollectionButton = $(withText("Create a new collection")),
            titleField = $(byId("collection_title")),
            descriptionField = $(byId("collection_description")),
            privacyCollectionCheckbox = $(byId("collection_privacy")),
            createCollectionButton = $(withText("Create collection")),
            elementFromCollection = $(byCssSelector("a[href*='/test-collection/']"));
      //      titleLine = $("[data-test='page-header-title']"),
          //  descriptionLine = $("h2");


    public void makeAddCollectionButtonVisible() {
        //наведение курсора для доступности кнопки создания коллекции
        photoComponent.click();
        addCollectionButton.waitUntil(Condition.visible, 10000).click();
    }

    public void clickOnNewCreateCollectionButton() {
        createNewCollectionButton.click();
    }

    public void fillCollectionTitleField(String name) {
        titleField.setValue(name);
    }

    public void fillCollectionDescriptionField(String description) {
        descriptionField.setValue(description);
    }

    public void selectedCollectionPrivacyCheckBox() {
        privacyCollectionCheckbox.setSelected(true);
    }

    public void clickOnCreateCollectionButton() {
        createCollectionButton.click();
    }

    public void checkThatCollectionIsCreated(String name, String description) {
       String nameCollection = "/test-collection/";
        open("/@izyaz/collections");
        elementFromCollection.click();
        titleLine.shouldHave(text(name));
        descriptionLine.shouldHave(text(description));
    }

}
