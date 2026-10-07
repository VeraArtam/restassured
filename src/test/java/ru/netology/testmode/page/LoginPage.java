package ru.netology.testmode.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement loginField = $("[data-test-id='login'] input");
    private SelenideElement passwordField = $("[data-test-id='password'] input");
    private SelenideElement loginButton = $("[data-test-id='action-login']");
    private SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public void fillLogin(String login) {
        loginField.setValue(login);
    }

    public void fillPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String login, String password) {
        fillLogin(login);
        fillPassword(password);
        clickLogin();
    }

    public void shouldShowError(String expectedText) {
        errorNotification.shouldBe(visible).shouldHave(text(expectedText));
    }
}