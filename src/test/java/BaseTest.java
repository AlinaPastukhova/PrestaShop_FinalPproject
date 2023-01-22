import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

public class BaseTest {

  @BeforeMethod
  public void setUp() {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    BasePage.setDriver(driver);
  }


  @AfterMethod(alwaysRun = true)
  public void quiteDriver() {
    BasePage.getDriver().quit();
  }

}
