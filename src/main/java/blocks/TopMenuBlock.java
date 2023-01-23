package blocks;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.LogAccountPage;

public class TopMenuBlock {

  private static WebDriver driver;

  public TopMenuBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  // Language Button
  private final By languageSelectorButton = By.xpath(
      "//div[@class='language-selector dropdown js-dropdown']//button");
  private final By languagesContainer = By.xpath(
      "//ul[@class='dropdown-menu hidden-sm-down']/li");

  // Sign in Button
  private final By signInButton = By.xpath("//span[text()='Sign in']");


  public TopMenuBlock clickLanguageSelectorButton() {
    BasePage.waitUntilToBeClickable(languageSelectorButton, 10);
    driver.findElement(languageSelectorButton).click();
    return this;
  }

  public List<String> getNamesOfLanguages() {
    List<String> namesOfLanguages = new ArrayList<>();
    List<WebElement> elements = driver.findElements(languagesContainer);
    for (WebElement element : elements) {
      String names = element.getText();
      namesOfLanguages.add(names);
    }
    return namesOfLanguages;
  }

  public LogAccountPage clickSignInButton() {
    BasePage.waitUntilVisible(signInButton, 10);
    driver.findElement(signInButton).click();
    return new LogAccountPage();
  }
}

