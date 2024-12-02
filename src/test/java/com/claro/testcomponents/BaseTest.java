package com.claro.testcomponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

public class BaseTest {

  Properties properties;
  String browser;
  WebDriver driver;

  public WebDriver initializeDriver() throws IOException {


    browser = getProperties("browser");

    if (browser.equals("chrome")){
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();

    } else if (browser.equals("firefox")) {
      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();

    }

    driver.manage().window().maximize();

    return driver;
  }


  public String getProperties(String key) {

    properties = new Properties();
    try {
      FileInputStream file = new FileInputStream("src/main/resources/GlobalData.properties");
      properties.load(file);
    } catch (Exception e) {
      System.out.println("Error cannot read properties file: " + e.getMessage());
    }

    return properties.getProperty(key);
  }








}
