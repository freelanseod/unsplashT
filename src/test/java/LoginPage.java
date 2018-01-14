import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public class LoginPage extends LandingPage{

    public void clickOnLoginButton() {
        loginMainButton.click();
    }

    public void fillUserInfoField(String email, String password) {
        emailField.val(email);
        passwordField.val(password);
    }

    public void agreeToLoginButton() {
        loginButton.click();
    }

    public void checkThatUserInSystem() {
        homeButton.shouldBe(visible);
    }

    public void checkThatUserNotLogin(){
        //то есть что пользователь не залогинен
        backHomeButton.shouldBe(hidden);
        // отображается ошибка с верным текстом
        errorMessage.shouldBe(visible);
    }

}
