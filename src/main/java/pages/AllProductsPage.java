package pages;

import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllProductsPage extends BasePage {

  private final By sortButton = By.xpath("//button[@class='btn-unstyle select-title']");
  private final By sortFromAToZButton = By.xpath("//a[contains(text(), 'Name, A to Z')]");
  private final By sortFromZToAButton = By.xpath("//a[contains(text(), 'Name, Z to A')]");
  private final By sortFromLowToHighPriceButton = By.xpath(
      "//a[contains(text(), 'Price, low to high')]");
  private final By sortFromHighToLowPriceButton = By.xpath(
      "//a[contains(text(), 'Price, high to low')]");

  private static final By allProductsContainer = By
      .xpath("//div[@class='thumbnail-container reviews-loaded']");


  public AllProductsPage clickSortButton() {
    waitUntilVisible(sortButton, 10);
    scrollToElement(driver, sortButton);
    find(sortButton).click();
    return this;
  }

  public AllProductsPage clickSortFromAToZButton() {
    waitUntilVisible(sortFromAToZButton, 10);
    scrollToElement(driver, sortFromAToZButton);
    find(sortFromAToZButton).click();
    return this;
  }

  public List<ProductBlock> getAllProductsFromAllProductsPage() {
    waitUntilVisible(allProductsContainer, 10);
    scrollToElement(driver, allProductsContainer);
    waitRefreshed(allProductsContainer, 10);
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(allProductsContainer);
    for (WebElement container : containers) {
      ProductBlock productsBlock = new ProductBlock(container);
      products.add(productsBlock);
    }
    return products;
  }

  // Sort products as 'Name, A to Z'
  public List<ProductBlock> getSortProductsFromAToZ(
      List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort(Comparator.comparing(ProductBlock::getNameAsString));
    return products;
  }

  public AllProductsPage clickSortFromZToAButton() {
    waitUntilVisible(sortFromZToAButton, 10);
    scrollToElement(driver, sortFromZToAButton);
    find(sortFromZToAButton).click();
    return this;
  }

  // Sort products as 'Name, Z to A'
  public List<ProductBlock> getSortProductsFromZToA(
      List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort((o1, o2) -> o2.getNameAsString().compareTo(o1.getNameAsString()));
    return products;
  }

  public AllProductsPage clickSortFromLowToHighPriceButton() {
    waitUntilVisible(sortFromLowToHighPriceButton, 10);
    scrollToElement(driver, sortFromLowToHighPriceButton);
    find(sortFromLowToHighPriceButton).click();
    return this;
  }

  // Sort products as 'Price, low to high'
  public List<ProductBlock> getSortProductsFromLowToHighPrice(List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort(Comparator.comparing(ProductBlock::getNameAsString));
    return products;
  }

  public AllProductsPage clickSortFromHighToLowPriceButton() {
    waitUntilVisible(sortFromHighToLowPriceButton, 10);
    scrollToElement(driver, sortFromHighToLowPriceButton);
    find(sortFromHighToLowPriceButton).click();
    return this;
  }

  // Sort products as 'Price, high to low'
  public List<ProductBlock> getSortFromHighToLowPrice(List<ProductBlock> getAllProductsFromAllProductsPage) {
    List<ProductBlock> products = new ArrayList<>(getAllProductsFromAllProductsPage);
    products.sort((o1, o2) -> o2.getActualPriceAsDouble().compareTo(o1.getActualPriceAsDouble()));
    return products;
  }





}
