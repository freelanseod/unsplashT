import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;


public class UploadPhotoTest extends BaseTest {

    @BeforeMethod
    public void loginRealUser() {
    open("/login");
        LoginPage page = new LoginPage();
        page.fillUserInfoField("izi_er@bk.ru", "");
        page.agreeToLoginButton();
    }


    @Test
    public void uploadPhoto() {
        UploadPhotoPage photo = new UploadPhotoPage();
        photo.clickOnSubmitPhotoButton();
        photo.clickOnAddPhotoButton();
        photo.uploadFilePhoto();
        photo.addTagesToPhoto(new String[]{"zzz", "yyyy", "xxxx"});
        photo.writeStoryAboutPhoto("test title", "test story");
        photo.selectedNoLocationCheckBox();
        photo.clickOnSubmitButton();
        photo.checkThatPhotoIsUpload("Thank you");
    }

}
