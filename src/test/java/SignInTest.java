import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;


public class SignInTest extends BaseTest {
    @BeforeMethod
    public void beforeEach(){
        open("/");
    }


    @Test
    public void userCanLogin() {
        LoginPage page = new LoginPage();
        page.clickOnLoginButton();
        page.fillUserInfoField("free-lanse516@list.ru", "");
        page.agreeToLoginButton();
        page.checkThatUserInSystem();
    }


    @Test
    public void userNotFound() {
        LoginPage page = new LoginPage();
        page.clickOnLoginButton();
        page.fillUserInfoField("16@list.ru", "111111");
        page.agreeToLoginButton();
        page.checkThatUserNotLogin();
    }
}
