import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class AddCollectionTest extends BaseTest {

    @BeforeMethod
    public void loginRealUser() {
        open("/login");
        LoginPage page = new LoginPage();
        page.fillUserInfoField("izi_er@bk.ru", "");
        page.agreeToLoginButton();
        open("/@izyaz");
    }

    @Test
    public void uploadCollection() {
        AddCollectionPage collection = new AddCollectionPage();
        collection.makeAddCollectionButtonVisible();
        collection.clickOnNewCreateCollectionButton();
        collection.fillCollectionTitleField("Test collection");
        collection.fillCollectionDescriptionField("Test description");
        collection.selectedCollectionPrivacyCheckBox();
        collection.clickOnCreateCollectionButton();
        collection.checkThatCollectionIsCreated("Test collection", "Test description");
    }

}


