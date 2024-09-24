package guru.qa.niffler.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
  private final SelenideElement
          usernameInput = $("input[name='username']"),
          passwordInput = $("input[name='password']"),
          submitButton = $("button[type='submit']"),
          createAccountButton = $(".form__register"),
          errorMessageText = $(".form__error");

  public MainPage login(String username, String password) {
    usernameInput.setValue(username);
    passwordInput.setValue(password);
    submitButton.click();
    return new MainPage();
  }

  public void openRegisterPage() {
    createAccountButton.click();
  }

  public LoginPage checkErrorAboutBadCredentialsIsDisplayed(String errorMessage) {
    errorMessageText.shouldBe(visible).shouldHave(text(errorMessage));
    return this;
  }

  public void checkUserStayOnLoginPageAfterLoginWithBadCredentials() {
    usernameInput.shouldBe(visible);
    passwordInput.shouldBe(visible);
    submitButton.shouldBe(visible);
  }
}
