package com.claro.test;

import com.claro.testcomponents.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.PlanInternet;
import pages.SocialMediaIcons;

import java.io.IOException;

public class PlanInternetTest extends BaseTest {
    WebDriver driver;
    PlanInternet planInternet;
    @BeforeClass
    public void setup() throws IOException {

        driver = initializeDriver();
        driver.get("https://www.claro.com.sv/personas/");
        //socialMediaIcons = new SocialMediaIcons(driver);
        planInternet = new PlanInternet(driver);
        planInternet.closeCookieModal();
        //socialMediaIcons.closeCookieModal();

    }
    @Test
    void testPageInit(){
        planInternet.navbarNavigate();
    }
}
