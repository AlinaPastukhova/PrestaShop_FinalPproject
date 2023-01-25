package blocks;

import java.util.List;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

@Data
public class MainMenuBlock {

  private static WebDriver driver;

  public enum MainMenuCategories {
    CLOTHES,
    ACCESSORIES,
    ART;
  }

  public MainMenuBlock(WebDriver webDriver) {
    driver = webDriver;
  }

  // MainMenu
  private final By clothesButton = By.id("category-3");
  private final By accessoriesButton = By.id("category-6");
  private final By artButton = By.id("category-9");

  // SubMenu
  private final By clothesContainer = By.xpath("//li[@id='category-3']//li");
  private final By accessoriesContainer = By.xpath("//li[@id='category-6']//li");
  private final By artContainer = By.xpath("//li[@id='category-9']//li");

  public MainMenuBlock hoverToMainManuButton(MainMenuCategories categories) {
    switch (categories) {
      case CLOTHES:
        BasePage.hoverToButton(clothesButton);

        break;
      case ACCESSORIES:
        BasePage.hoverToButton(accessoriesButton);
        break;
      case ART:
        BasePage.hoverToButton(artButton);
        break;
      default:
        throw new IllegalStateException("Unexpected value " + categories);
    }
    return this;
  }

//  public MainMenuBlock hoverToClothesButton() {
//    BasePage.hoverToButton(clothesButton);
//    return this;
//  }

  public List<String> getNameOfClothesSubMenu() {
    return BasePage.getNameDropdownSubMenu(clothesContainer);
  }

//  public MainMenuBlock hoverToAccessoriesButton() {
//    BasePage.hoverToButton(accessoriesButton);
//    return this;
//  }

  public List<String> getNameOfAccessoriesSubMenu() {
    return BasePage.getNameDropdownSubMenu(accessoriesContainer);
  }

//  public MainMenuBlock hoverToArtButton() {
//    BasePage.hoverToButton(artButton);
//    return this;
//  }

  public List<String> getNameOfArtSubMenu() {
    return BasePage.getNameDropdownSubMenu(artContainer);
  }
}
