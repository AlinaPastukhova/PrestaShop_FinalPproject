package pages;

import org.openqa.selenium.By;

public class LogAccountPage extends BasePage{

  private final By createAccountLink = By.xpath("//a[@data-link-action='display-register-form']");

  public RegisterAccountPage clickCreateAccountLink(){
    BasePage.waitUntilVisible(createAccountLink, 10);
    driver.findElement(createAccountLink).click();
    return new RegisterAccountPage();
  }

}
