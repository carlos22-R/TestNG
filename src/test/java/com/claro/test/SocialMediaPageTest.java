package com.claro.test;

import com.claro.testcomponents.BaseTest;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.SocialMediaIcons;

public class SocialMediaPageTest extends BaseTest {

  SocialMediaIcons socialMediaIcons;

  WebDriver driver;

  @BeforeClass
  public void setup() throws IOException {

    driver = initializeDriver();
    driver.get("https://www.claro.com.sv/personas/");
    socialMediaIcons = new SocialMediaIcons(driver);

    socialMediaIcons.closeCookieModal();

  }


  @Test
  void goToSocialMediaPage() {
    /*
    String expectedUrl = "https://x.com/claroelsalvador";
    socialMediaIcons.clickOnXIcon();

    socialMediaIcons.switchToTab(1,driver);
    socialMediaIcons.waitForVisual(2000);
    driver.close();
    socialMediaIcons.switchToTab(0,driver);
*/

    socialMediaIcons.scrollToFooter();
    Assert.assertTrue(socialMediaIcons.iconsPresent());
    //Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

  }

  @Test
  void goToFacebook() {
    Assert.assertEquals(socialMediaIcons.clickOnFacebookIcon(),"https://www.facebook.com/claroelsalvador");
    socialMediaIcons.closeWindow(1);
  }

  @Test
  void goToTwitter() {
    Assert.assertEquals(socialMediaIcons.clickOnXIcon(),"https://x.com/claroelsalvador");
    socialMediaIcons.closeWindow(1);
  }

@Test
  void goToWhatsApp() {
  Assert.assertEquals(socialMediaIcons.clickOnWhatsAppIcon(),"https://api.whatsapp.com/send?phone=50360605555");
  socialMediaIcons.closeWindow(1);
}

  @Test
  void goToInstagram() {
    Assert.assertEquals(socialMediaIcons.clickOnInstagramIcon(),"https://www.instagram.com/claroelsalvador/");
    socialMediaIcons.closeWindow(1);
  }



}
