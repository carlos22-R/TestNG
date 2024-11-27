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
  void clickOnXIcon() {

    String expectedUrl = "https://x.com/claroelsalvador";
    socialMediaIcons.clickOnXIcon();

    socialMediaIcons.switchToTab(1,driver);
    socialMediaIcons.waitForVisual(2000);
    driver.close();
    socialMediaIcons.switchToTab(0,driver);

    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

  }






}
