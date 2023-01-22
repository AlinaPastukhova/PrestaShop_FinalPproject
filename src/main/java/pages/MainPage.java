package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

  private final By loadingMessage = By.id("loadingMessage");

  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    getDriver().switchTo().frame("framelive");
    waitUntilInvisible(loadingMessage, 10);
    return new MainPage();
  }

}
