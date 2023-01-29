package blocks;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

@Data
public class ProductBlock {

  private String discountAsString;
  private Double discountAsDouble;
  private WebElement wishList;
  private WebElement colorAsWebElement;
  private WebElement img;
  private WebElement nameAsWebElement;
  private String nameAsString;
  private String actualPriceAsString;
  private Double actualPriceAsDouble;
  private String regularPriceAsString;
  private Double regularPriceAsDouble;

  //div[@class='thumbnail-container reviews-loaded']

  public ProductBlock(WebElement container) {

    try {
      this.discountAsString = container.findElement(
              By.xpath(".//li[@class='product-flag discount']"))
          .getText();
      String discountNoAsString = StringUtils.substring(discountAsString, 1, 3);
      this.discountAsDouble = Double.parseDouble(discountNoAsString);
    } catch (NoSuchElementException e) {
      this.discountAsString = null;
      this.discountAsDouble = null;
    }

    try {
      this.wishList = container.findElement(By.xpath(
          ".//button[@class='wishlist-button-add']"));
    } catch (NoSuchElementException e) {
      this.wishList = null;
    }

    try {
      this.colorAsWebElement = container.findElement(By.xpath(
          ".//a[@class='color']"));
    } catch (NoSuchElementException e) {
      this.colorAsWebElement = null;
    }

    try {
      this.img = container.findElement(By.xpath(
          ".//img"));
    } catch (NoSuchElementException e) {
      this.img = null;
    }

    try {
      this.nameAsWebElement = container.findElement(By.xpath(
          ".//h3[@class='h3 product-title']"));
      this.nameAsString = nameAsWebElement.getText();
    } catch (NoSuchElementException e) {
      this.nameAsWebElement = null;
      this.nameAsString = null;
    }

    try {
      this.actualPriceAsString = container.findElement(By.xpath(".//span[@class='price']"))
          .getText();
      String priceActualNoAsDouble = StringUtils.substringAfterLast(actualPriceAsString, "€");
      this.actualPriceAsDouble = Double.parseDouble(priceActualNoAsDouble);
    } catch (NoSuchElementException e) {
      this.actualPriceAsString = null;
      this.actualPriceAsDouble = null;
    }

    try {
      this.regularPriceAsString = container.findElement(
          By.xpath(".//span[@class='regular-price']")).getText();
      String priceBeforeDiscountNoAsDouble = StringUtils.substringAfterLast(
          regularPriceAsString, "€");
      this.regularPriceAsDouble = Double.parseDouble(priceBeforeDiscountNoAsDouble);
    } catch (NoSuchElementException e) {
      this.regularPriceAsString = null;
      this.regularPriceAsDouble = null;
    }

  }
}
