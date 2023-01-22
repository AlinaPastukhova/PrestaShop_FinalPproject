package pages;

import blocks.NewsLetterLabelBlock;
import blocks.TopMenuBlock;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  protected static WebDriver driver;

  public static WebDriver getDriver() {
    return driver;
  }

  public static void setDriver(WebDriver webDriver) {
    driver = webDriver;
  }

  private NewsLetterLabelBlock newsLetterLabelBlock = new NewsLetterLabelBlock(getDriver());
  private TopMenuBlock topMenuBlock = new TopMenuBlock(getDriver());

  public NewsLetterLabelBlock getNewsLetterLabelBlock() {
    return newsLetterLabelBlock;
  }

  public TopMenuBlock getTopMenuBlock() {
    return topMenuBlock;
  }

  public static WebElement find(By locator) {
    return getDriver().findElement(locator);
  }

  public static void scrollToElement(WebDriver driver, By element) {
    ((JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
  }

  public static WebElement waitUntilVisible(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static boolean waitUntilInvisible(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.invisibilityOfElementLocated(locator));
  }

  public static WebElement waitUntilToBeClickable(By locator, int second) {
    return new WebDriverWait(driver, Duration.ofSeconds(second))
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

}
