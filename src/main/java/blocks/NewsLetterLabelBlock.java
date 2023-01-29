package blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class NewsLetterLabelBlock {

  private static WebDriver driver;

  public NewsLetterLabelBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  private final By newsletterLabel = By.xpath("//p[@id='block-newsletter-label']");
  private final By newsletterInformation = By.xpath("//div[@class='col-xs-12']//p");
  private final By subscribeButton = By.xpath("//input[@value='Subscribe']");

  public String getTextNearTheEmailField() {
    BasePage.waitUntilVisible(newsletterLabel, 10);
    BasePage.scrollToElement(driver, newsletterLabel);
    String text = driver.findElement(newsletterLabel).getText();
    return text;
  }

  public String getTextUnderTheEmailField() {
    BasePage.waitUntilVisible(newsletterLabel, 10);
    BasePage.scrollToElement(driver, newsletterLabel);
    String text = driver.findElement(newsletterInformation).getText();
    return text;
  }

  public String getAttributeOnSubscribeButton() {
    BasePage.waitUntilVisible(newsletterLabel, 10);
    BasePage.scrollToElement(driver, newsletterLabel);
    String characters = driver.findElement(subscribeButton).getCssValue("text-transform");
    return characters;
  }
}
