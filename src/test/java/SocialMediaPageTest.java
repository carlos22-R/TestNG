import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.SocialMediaIcons;

public class SocialMediaPageTest {
  private static final Logger logger = LoggerFactory.getLogger(SocialMediaPageTest.class);
  private WebDriver driver;
  private SocialMediaIcons socialMediaIcons;

  @BeforeClass
  public void setUp() {
    driver = new ChromeDriver();
    driver.get("https://www.claro.com.sv/personas/");

    socialMediaIcons = new SocialMediaIcons(driver);

    socialMediaIcons.closeCookieModal();

  }



  @Test
  void testXIcon() {
    socialMediaIcons.clickOnXIcon();

  }


  @AfterClass
  public void tearDown() {
    try {
      driver.quit();

    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }


  }




}
