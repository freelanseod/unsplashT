import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class DeleteCollectionTest extends BaseTest {

    @BeforeMethod
    public void createBeforeDeleting() {
        open("/login");
        LoginPage page = new LoginPage();
        page.fillUserInfoField("izi_er@bk.ru", "");
        page.agreeToLoginButton();
        open("/@izyaz");
        AddCollectionPage newcollection = new AddCollectionPage();
        newcollection.makeAddCollectionButtonVisible();
        newcollection.clickOnNewCreateCollectionButton();
        newcollection.fillCollectionTitleField("Test collection");
        newcollection.clickOnCreateCollectionButton();
        open("/@izyaz/collections");
        Configuration.timeout=1000;
    }


    @Test
    public void deleteCollection() {
        DeleteCollectionPage delete = new DeleteCollectionPage();
        delete.clickOnTitleCollectionName();
        delete.clickOnEditCollectionButton();
        delete.clickOnDeleteCollectionButton();
        delete.clickOnAgreeToDeleteButton();
        delete.checkThatCollectionIsDeleted("Test collection");
    }
}
