package blocks;

import java.util.List;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

@Data
public class MainMenuBlock {

  private static WebDriver driver;
  private static Actions actions;

  public MainMenuBlock(WebDriver webDriver) {
    driver = webDriver;
    actions = new Actions(driver);
  }

  // MainMenu
  private final By clothesButton = By.id("category-3");
  private final By accessoriesButton = By.id("category-6");
  private final By artButton = By.id("category-9");

  // SubMenu
  private final By clothesContainer = By.xpath("//li[@id='category-3']//li");
  private final By accessoriesContainer = By.xpath("//li[@id='category-6']//li");

  // ?????
  private final By artContainer = By.xpath("//li[@id='category-9']");

  private final By menDropdownSubMenu = By.xpath("//li[@id='category-4']//a");
  private final By womenDropdownSubMenu = By.xpath("//li[@id='category-5']//a");
  private final By stationeryDropdownSubMenu = By.xpath("//li[@id='category-7']//a");
  private final By homeAccessoriesDropdownSubMenu = By.xpath("//li[@id='category-8']//a");

  public MainMenuBlock hoverToClothesButton() {
    BasePage.waitUntilToBeClickable(clothesButton, 10);
    BasePage.hoverToButton(clothesButton);
    return this;
  }

  public List<String> getNameOfClothesSubMenu() {
    BasePage.waitUntilPresents(clothesContainer, 10);
    return BasePage.getNameDropdownSubMenu(clothesContainer);
  }

  public MainMenuBlock hoverToAccessoriesButton() {
    BasePage.waitUntilPresents(accessoriesButton, 10);
    BasePage.hoverToButton(accessoriesButton);
    return this;
  }

  public List<String> getNameOfAccessoriesSubMenu() {
    BasePage.waitUntilPresents(accessoriesContainer, 10);
    return BasePage.getNameDropdownSubMenu(accessoriesContainer);
  }

  public MainMenuBlock hoverToArtButton() {
    BasePage.waitUntilPresents(artButton, 10);
    BasePage.hoverToButton(artButton);
    return this;
  }

  public List<String> getNameOfArtSubMenu() {
    BasePage.waitUntilPresents(artContainer, 10);
    return BasePage.getNameDropdownSubMenu(artContainer);
  }


}
