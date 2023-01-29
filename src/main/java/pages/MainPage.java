package pages;

import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

  private final By loadingMessage = By.id("loadingMessage");
  private final By productsContainer = By.xpath(
      "//div[@class='thumbnail-container reviews-loaded']");
  private final By priceDropLink = By.xpath("//a[@id='link-product-page-prices-drop-1']");
  private final By allProductsLink = By.xpath(
      "//a[@class='all-product-link float-xs-left float-md-right h4']");


  public MainPage openMainPage() {
    getDriver().get("https://demo.prestashop.com/");
    getDriver().switchTo().frame("framelive");
    waitUntilInvisible(loadingMessage, 10);
    return this;
  }

  public List<ProductBlock> getAllProductsFromMainPage() {
    waitUntilPresents(productsContainer, 10);
    scrollToElement(driver, productsContainer);
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(productsContainer);
    for (WebElement container : containers) {
      ProductBlock productsBlock = new ProductBlock(container);
      products.add(productsBlock);
    }
    return products;
  }

  public List<String> getNamesOfPopularProductsFromMainPage(List<ProductBlock> popularProducts) {
    List<String> products = new ArrayList<>();
    for (ProductBlock popularProduct : popularProducts) {
      String nameAsString = popularProduct.getNameAsString();
      products.add(nameAsString);
    }
    return products;
  }

  public List<Double> getPriceOfPopularProductsFromMainPage(List<ProductBlock> popularProducts) {
    List<Double> products = new ArrayList<>();
    for (ProductBlock popularProduct : popularProducts) {
      Double priceActualAsDouble = popularProduct.getActualPriceAsDouble();
      products.add(priceActualAsDouble);
    }
    return products;
  }

  public PriceDropPage clickPriceDropLink() {
    waitUntilVisible(priceDropLink, 10);
    scrollToElement(driver, priceDropLink);
    find(priceDropLink).click();
    return new PriceDropPage();
  }

  public AllProductsPage clickAllProductsLink() {
    waitUntilVisible(allProductsLink, 10);
    scrollToElement(driver, allProductsLink);
    find(allProductsLink).click();
    return new AllProductsPage();
  }

}

