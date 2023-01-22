package blocks;

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
  private final By languagesSelectDropdown = By.xpath(
      "//ul[@class='dropdown-menu hidden-sm-down']/li");
  private final By languageNameInSelectDropdown = By.xpath("//a[text()='Українська']");

  // Sign in Button
  private final By signInButton = By.xpath("//span[text()='Sign in']");


  public TopMenuBlock clickLanguageSelectorButton() {
    BasePage.waitUntilToBeClickable(languageSelectorButton, 10);
    driver.findElement(languageSelectorButton).click();
    return this;
  }

  public int getSizeLanguageSelectDropdown() {
    BasePage.waitUntilVisible(languagesSelectDropdown, 10);
    List<WebElement> dropDown = driver.findElements(languagesSelectDropdown);
    int size = dropDown.size();
    return size;
  }

  public String getLanguageInDropDown() {
    BasePage.waitUntilVisible(languagesSelectDropdown, 10);
    BasePage.scrollToElement(driver, languageNameInSelectDropdown);
    WebElement dropDown = driver.findElement(languageNameInSelectDropdown);
    String name = dropDown.getText();
    return name;
  }

  public LogAccountPage clickSignInButton(){
    BasePage.waitUntilVisible(signInButton, 10);
    driver.findElement(signInButton).click();
    return new LogAccountPage();
  }
}

