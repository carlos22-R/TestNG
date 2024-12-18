package com.claro.abstractcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class AbstractComponent {

  WebDriver driver;

  public AbstractComponent(WebDriver driver){

    this.driver = driver;
    PageFactory.initElements(driver, this);
  }


  public void waitForVisual(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public void waitTime(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public String switchToWindow(int index){
    Object[] windowHandles=driver.getWindowHandles().toArray();
    return driver.switchTo().window((String) windowHandles[index]).getCurrentUrl();
  }
  public void closeWindow(int index){
    Object[] windowHandles=driver.getWindowHandles().toArray();
    driver.switchTo().window((String) windowHandles[index]).close();
    driver.switchTo().window((String) windowHandles[index-1]);
  }

  public boolean ElementClick(WebElement element){
    try {

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(element));
      return true;
    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
      return false;
    }
  }
  public void viewElement(){
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
    WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("MoldalMolMain")));
    System.out.println(modal.getText());
  }
  public void closeLogin( WebElement modal){
    try {

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(modal));
      closeButton.click();
    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }
  public void scrollToElement(By locator){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));
  }
  public  void scrollToElement(WebElement element){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
  }

  public boolean navbarHover(By element,By submenu){
    try {

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement navbarElement = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
      Actions actions = new Actions(driver);
      actions.moveToElement(navbarElement).perform();
      WebElement submenuElement = wait.until(ExpectedConditions.elementToBeClickable(submenu));
      submenuElement.click();
      waitTime(3000);
      return true;
    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
      return false;
    }

  }

}
