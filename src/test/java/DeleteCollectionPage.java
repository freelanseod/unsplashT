import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeleteCollectionPage extends LandingPage {

    public SelenideElement
            titleCollection = $(byText("Test collection")),
            editCollectionButton = $(byCssSelector("a[href*='edit_collection']")),
            deleteCollectionButton = $(byText("Delete Collection")),
            deleteButton = $(byText("Delete"));

    /*
    public void findCollection() {
        //найти коллекцию
        titleCollection.shouldBe(Condition.visible).click();
        //перейти на страницу редактирования
        editCollectionButton.waitUntil(Condition.visible,9000).click();
    }
*/
    public void clickOnTitleCollectionName(){
        //найти коллекцию
        titleCollection.shouldBe(Condition.visible).click();
    }

    public void clickOnEditCollectionButton() {
        //перейти на страницу редактирования
        editCollectionButton.waitUntil(Condition.visible,9000).click();
    }

    /*
    public void deleteCollection() {
        deleteCollectionButton.waitUntil(Condition.visible, 2000).click();
        deleteButton.waitUntil(Condition.visible, 5000).click();
    }
 */

    public void clickOnDeleteCollectionButton(){
        deleteCollectionButton.waitUntil(Condition.visible, 2000).click();
    }

    public void clickOnAgreeToDeleteButton(){
        deleteButton.waitUntil(Condition.visible, 5000).click();
    }

    public void checkThatCollectionIsDeleted(String name) {
        open("/@izyaz/collections");
        $(byText(name)).shouldBe(hidden);
  //      $(byTitle("Home — Unsplash")).click();
        homeButton.click();
    }

}
