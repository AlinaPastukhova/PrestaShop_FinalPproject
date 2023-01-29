package pages;

import blocks.ProductBlock;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriceDropPage extends BasePage {

  private final By priceDropContainer = By.xpath(
      "//div[@class='thumbnail-container reviews-loaded']");

  public List<ProductBlock> getAllProductsFromPriceDropPage() {
    waitUntilPresents(priceDropContainer, 10);
    scrollToElement(driver, priceDropContainer);
    List<ProductBlock> products = new ArrayList<>();
    List<WebElement> containers = getDriver().findElements(priceDropContainer);
    for (WebElement container : containers) {
      ProductBlock productsBlock = new ProductBlock(container);
      products.add(productsBlock);
    }
    return products;
  }

  public List<Double> getOldPriceOfProductsFromPriceDropPage(
      List<ProductBlock> priceDropProducts) {
    List<Double> products = new ArrayList<>();
    for (ProductBlock priceDropProduct : priceDropProducts) {
      Double priceBeforeDiscountAsDouble = priceDropProduct.getRegularPriceAsDouble();
      products.add(priceBeforeDiscountAsDouble);
    }
    return products;
  }

  public List<Double> getNewPriceOfProductsFromPriceDropPage(
      List<ProductBlock> priceDropProducts) {
    List<Double> products = new ArrayList<>();
    for (ProductBlock priceDropProduct : priceDropProducts) {
      Double priceActualAsDouble = priceDropProduct.getActualPriceAsDouble();
      products.add(priceActualAsDouble);
    }
    return products;
  }

  public List<Double> getExpectedPriceDiscountFromPriceDropPage(
      List<ProductBlock> priceDropProducts) {
    List<Double> products = new ArrayList<>();
    for (ProductBlock priceDropProduct : priceDropProducts) {
      Double discountPrice = priceDropProduct.getRegularPriceAsDouble()
          - (priceDropProduct.getRegularPriceAsDouble() / 100.0
          * priceDropProduct.getDiscountAsDouble());
      Double discountPriceTrim = Math.round(discountPrice * 100.0) / 100.0;
      products.add(discountPriceTrim);
    }
    return products;
  }
}

