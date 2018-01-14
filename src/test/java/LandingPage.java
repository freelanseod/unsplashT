import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LandingPage {
    public SelenideElement
    loginMainButton = $(byLinkText("Login")),
            emailField = $x("//*[@id='user_email']"),
            passwordField = $x("//*[@id='user_password']"),
            loginButton = $(byValue("Login")),
            homeButton = $(byTitle("Home — Unsplash")),
            errorMessage = $(byText("Invalid email or password.")),
            photoComponent = $("[data-test='photo-component']"),
            titleLine = $("[data-test='page-header-title']"),
            descriptionLine = $("h2"),
            backHomeButton=$("#back-home");


    public void photoComponent() {
        photoComponent.shouldBe(enabled);
    }

    public void titleLine() {
        titleLine.shouldBe(visible);
    }
    public void descriptionLine() {
        descriptionLine.shouldBe(visible);
    }
}