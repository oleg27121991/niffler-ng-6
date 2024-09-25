package guru.qa.niffler.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
  private final ElementsCollection
          tableRows = $("#spendings tbody").$$("tr");

  private final SelenideElement
          spendingHistoryTable = $("#spendings"),
          spendingStatisticsCanvas = $("#stat"),
          accountMenuBtn = $("button[aria-label='Menu']"),
          profileLink = $("a[href='/profile']"),
          personIcon = $("[data-testid='PersonIcon']"),
          friendsLink = $("a[href='/people/friends']"),
          allPeopleLink = $("a[href='/people/all']");

  public EditSpendingPage editSpending(String spendingDescription) {
    tableRows.find(text(spendingDescription)).$$("td").get(5).click();
    return new EditSpendingPage();
  }

  public void checkThatTableContainsSpending(String spendingDescription) {
    tableRows.find(text(spendingDescription)).should(visible);
  }

  public void isSpendingStatisticsDisplayed() {
    spendingStatisticsCanvas.shouldBe(visible);
  }

  public MainPage isSpendingHistoryTableDisplayed() {
    spendingHistoryTable.shouldBe(visible);

    return this;
  }

  public ProfilePage openProfile() {
    accountMenuBtn.click();
    profileLink.click();
    return new ProfilePage();
  }

  public FriendsPage openFriends() {
    personIcon.click();
    friendsLink.click();
    return new FriendsPage();
  }

  public FriendsPage openAllPeople() {
    personIcon.click();
    allPeopleLink.click();
    return new FriendsPage();
  }
}
