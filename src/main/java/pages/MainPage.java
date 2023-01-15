package pages;

import org.openqa.selenium.By;

public class MainPage extends BasePage {

  private final By loadingMessage = By.id("loadingMessage");
  private final By newsletterLabel = By.xpath("//p[@id='block-newsletter-label']");
  private final By newsletterInformation = By.xpath("//div[@class='col-xs-12']//p");
  private final By subscribeButton = By.xpath("//input[@value='Subscribe']");


  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    getDriver().switchTo().frame("framelive");
    waitUntilInvisible(loadingMessage, 10);
    return this;
  }

  public String getTextNearTheEmailField() {
    waitUntilVisible(newsletterLabel, 10);
    scrollToElement(driver, newsletterLabel);
    String text = find(newsletterLabel).getText();
    return text;
  }

  public String getTextUnderTheEmailField() {
    waitUntilVisible(newsletterInformation, 10);
    scrollToElement(driver, newsletterInformation);
    String text = find(newsletterInformation).getText();
    return text;
  }

  public String getRegisterOnSubscribeButton() {
    waitUntilVisible(subscribeButton, 10);
    scrollToElement(driver, subscribeButton);
    String characters = find(subscribeButton).getCssValue("text-transform");
    return characters;
  }

}
