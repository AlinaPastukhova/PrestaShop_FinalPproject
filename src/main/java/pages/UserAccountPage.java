package pages;

import org.openqa.selenium.By;

public class UserAccountPage extends BasePage {

  private final By userAccountButton = By.xpath("//a[@class='account']//span");

  public String getUserName() {
    waitUntilVisible(userAccountButton, 10);
    String name = BasePage.find(userAccountButton).getText();
    return name;
  }

}
